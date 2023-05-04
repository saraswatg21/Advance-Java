package nagarro.training.ecommerce.controller;

import java.io.IOException;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import nagarro.training.ecommerce.dao.UsersDao;
import nagarro.training.ecommerce.entities.Users;

@Controller
public class AuthController {

	UsersDao usersDao = new UsersDao();

	@RequestMapping("/LogIn")
	public void LogIn(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Users user = usersDao.get();

		if (user.getName().equals(username) && user.getPassword().equals(password)) {

			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("username", user.getName());
			res.sendRedirect("SearchPage.jsp");
		} else {
			res.sendRedirect("index.jsp");
		}

	}

	@RequestMapping("/Logout")
	public void Logout(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession session = req.getSession();
		session.removeAttribute("username");
		session.invalidate();
		res.sendRedirect("index.jsp");
	}
}