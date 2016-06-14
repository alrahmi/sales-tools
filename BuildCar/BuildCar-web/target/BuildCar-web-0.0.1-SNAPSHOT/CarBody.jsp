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
	<form action="/EngineServlet">
		<h1>CarBodys information</h1>
		<table>
			<tr>
				<td>Carbody id</td>
				<td><input type="text" name="id" value="${body.id}"></td>
			</tr>
			<tr>
				<td>Carbody type</td>
				<td><input type="text" name="type" value="${body.type}">
				</td>
			</tr>
			<tr>
				<td>Carbody color</td>
				<td><input type="text" name="color" value="${body.color}">
				</td>
			</tr>
			<tr>
				<td>Carbody CountOfDoors</td>
				<td><input type="text" name="countOfDoors"
					value="${body.countOfDoors}"></td>
			</tr>
			<tr>
				<td>Carbody VIN</td>
				<td><input type="text" name="VIN" value="${body.VIN}">
				</td>
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
			<th>type</th>
			<th>color</th>
			<th>countOfDoors</th>
			<th>VIN</th>
		</tr>
		<c:forEach items="${body.getAll}" var="body">
			<tr>
				<td>${body.id}</td>
				<td>${body.type}</td>
				<td>${body.color}</td>
				<td>${body.countOfDoores}</td>
				<td>${body.VIN}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>