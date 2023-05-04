package nagarro.training.ecommerce.controller;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import nagarro.training.ecommerce.entities.OutputChoiceType;
import nagarro.training.ecommerce.entities.Tshirt;
import nagarro.training.ecommerce.services.imp.SearchItemServiceImp;

@Controller
public class SearchController {

	static List<Tshirt> searcheditemsList = new ArrayList<Tshirt>();

	@RequestMapping("/searchproduct")
	public void searchproduct(@RequestParam("color") String color, @RequestParam("gender") String gender,
			@RequestParam("preference") String preference, @RequestParam("size") String size, HttpServletRequest req,
			HttpServletResponse res) throws IOException {

		SearchItemServiceImp searchItemServiceImp = new SearchItemServiceImp();
		searcheditemsList = searchItemServiceImp.findTshirt(color, gender, size);
		sortlsiTshirts(searcheditemsList, preference);
		res.sendRedirect("SearchPage.jsp");
		
	}

	public static List<Tshirt> getSearcheditemsList() {
		return searcheditemsList;
	}

	private void sortlsiTshirts(List<Tshirt> items, String choice) {
		OutputChoiceType sel = OutputChoiceType.Price;
		try {
			sel = OutputChoiceType.valueOf(choice);
		} catch (IllegalArgumentException e) {
			System.out.println("Please, Select from the given options \n");
		}
		if (sel == OutputChoiceType.Price) {
			Collections.sort(items, new Comparator<Tshirt>() {
				
				public int compare(Tshirt o1, Tshirt o2) {
					if (o1.getPrice() > o2.getPrice())
						return -1;
					else if (o1.getPrice() < o2.getPrice())
						return 1;
					return 0;
				}
			});
		} else if (sel == OutputChoiceType.Rating) {
			Collections.sort(items, new Comparator<Tshirt>() {
				
				public int compare(Tshirt o1, Tshirt o2) {
					if (o1.getRating() > o2.getRating())
						return -1;
					else if (o1.getRating() < o2.getRating())
						return 1;
					return 0;
				}
			});
		} else if (sel == OutputChoiceType.Both) {
			Collections.sort(items, new Comparator<Tshirt>() {
				
				public int compare(Tshirt o1, Tshirt o2) {
					if ((o1.getRating() + o1.getPrice()) / 2 > (o2.getRating() + o2.getPrice()) / 2)
						return -1;
					else if ((o1.getRating() + o1.getPrice()) / 2 < (o2.getRating() + o2.getPrice()) / 2)
						return 1;
					return 0;
				}
			});
		}

	}

}
