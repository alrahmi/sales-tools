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
	<form action="/TransmissionServlet">
		<h1>Transmissions information</h1>
		<table>
			<tr>
				<td>transmission id</td>
				<td><input type="text" name="carBody id" value="${body.id}">
				</td>
			</tr>
			<tr>
				<td>transmission type</td>
				<td><input type="text" name="carBody type" value="${body.type}">
				</td>
			</tr>
			<tr>
				<td>transmission color</td>
				<td><input type="text" name="carBody id" value="${body.serialNumber}">
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
			<th>serialNumber</th>
		</tr>
		<c:forEach items="${transmission.getAll}" var="transmission">
			<tr>
				<td>${transmission.id}</td>
				<td>${transmission.type}</td>
				<td>${transmission.serialNumber}</td>
			</tr>
		</c:forEach>
	</table>
</body>