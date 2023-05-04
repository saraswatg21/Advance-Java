<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="org.jfree.data.general.DefaultPieDataset" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.servlet.*" %>
<%@page import="nagarro.training.ecommerce.services.imp.*"%>
<%@page import="nagarro.training.ecommerce.controller.SearchController"%>
<%@page import="java.util.List"%>
<%@page import="nagarro.training.ecommerce.entities.Tshirt"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title>Search Page</title>
<style>
<%@include file="Styles/HomePage.css"%>
</style>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		}
		StoreDataInDbServiceImp serviceImp = new StoreDataInDbServiceImp();
		serviceImp.start();
	%>
	<div style="width: 100%; display: flex; align-items: center">
		<h2 align="center"
			style="display: flex; flex-grow: 1; justify-content: center;">Product
			Management Tool</h2>
		<div style="display: flex; gap: 5px; align-items: center">
			<b> Hi ${username} </b>
			<form action="Logout">
				<input type="submit" value="Logout" style="margin-left: 5px" />
			</form>
		</div>
	</div>
	<div>
		<form action="searchproduct" method="post">
			<table>
				<caption>
					<b>Enter Product details to search in the stock</b>
				</caption>
				<tr>
					<td><b>Color</b></td>
					<td><input type="text" name="color" required /></td>
				</tr>
				<tr>
					<td><b>Gender</b></td>
					<td><input type="text" name="gender" required /></td>
				</tr>
				<tr>
					<td><b>Size</b></td>
					<td><input type="text" name="size" required /></td>
				</tr>
				<tr>
					<td><b>Output Preference</b></td>
					<td><input type="text" name="preference" required /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search" style="width: 100px" /></td>
				</tr>
			</table>
		</form>

	</div>
	<div>
		<table class="displayitems">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Color</th>
					<th>Gender</th>
					<th>Size</th>
					<th>Price</th>
					<th>Rating</th>
					<th>Available</th>
				</tr>
			</thead>
			<%
				List<Tshirt> list = SearchController.getSearcheditemsList();
				for (Tshirt tshirt : list) {
			%>
			<tr>
				<td><%=tshirt.getId()%></td>
				<td><%=tshirt.getName()%></td>
				<td><%=tshirt.getColour()%></td>
				<td><%=tshirt.getGender()%></td>
				<td><%=tshirt.getSize()%></td>
				<td><%=tshirt.getPrice()%></td>
				<td><%=tshirt.getRating()%></td>
				<td><%=tshirt.getAvailable()%></td>


			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>