<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="engine.jsp"> <input type="button" value="engine" />
	</a>
	<br>
	<br>
	<br>
	<a href="transmission.jsp"> <input type="button"
		value="transmission" />
	</a>
	<br>
	<br>
	<br>
	<a href="carbody.jsp"> <input type="button" value="carbody" />
	</a>
	<form action="/CarServlet">
		<h1>Cars information</h1>
		<table>
			<tr>
				<td>Car id</td>
				<td><input type="text" name="id" value="${car.id}"></td>
			</tr>
			<tr>
				<td>Car id</td>
				<td><input type="text" name="id" value="${car.name}"></td>
			</tr>
			<tr>
				<td>Car name</td>
				<td><input type="text" name="carBody" value="${car.carBody}">
				</td>
			</tr>
			<tr>
				<td>Car engine</td>
				<td><input type="text" name="engine" value="${car.engine}">
				</td>
			</tr>
			<tr>
				<td>Car engine</td>
				<td><input type="text" name="engine"
					value="${car.transmission}"></td>
			</tr>
			<tr>
				<td>Car transmission</td>
				<td><input type="text" name="transmission"
					value="${car.transmission}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="action"
					value="create" /> <input type="submit" name="action"
					value="update" /> <input type="submit" name="action"
					value="delete" /> <input type="submit" name="action"
					value="getById" /></td>
			</tr>
		</table>
	</form>
	<br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>engine</th>
			<th>transmission</th>
			<th>body</th>
		</tr>
		<c:forEach items="${car.getAll}" var="car">
			<tr>
				<td></td>
				<td>${car.id}</td>
				<td>${car.name}</td>
				<td>${car.engine}</td>
				<td>${car.transmission}</td>
				<td>${car.carBody}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>