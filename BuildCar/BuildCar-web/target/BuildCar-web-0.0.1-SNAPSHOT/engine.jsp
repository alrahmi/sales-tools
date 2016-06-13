<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/EngineServlet">
	<h1>Engines information</h1>
	<table>
		<tr>
			<td>Engines id</td>
			<td><input type="text" name="engine id"  value="${engine.id}">
			</td>
		</tr>
		<tr>
			<td>Engines type</td>
			<td><input type="text" name="engine type" value="${engine.type}">
			</td>
		</tr>
		<tr>
			<td>Engines volume</td>
			<td><input type="text" name="engine id" value="${engine.volume}">
			</td>
		</tr>
		<tr>
			<td>Engines power</td>
			<td><input type="text" name="engine id" value="${engine.power}">
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="action"
				value="create" /> <input type="submit" name="action" value="update" />
				<input type="submit" name="action" value="delete" /> <input
				type="submit" name="action" value="getById" /></td>
		</tr>
	</table>
	</form>
	<br>
	<table border="1">
		<tr>
		<th>ID</th>
		<th>type</th>
		<th>volume</th>
		<th>power</th>
		<th>serialNumber</th>
		</tr>
		<c:forEach items="getAll" var="engine">
			<tr>
				<td>${engine.id}</td>
				<td>${engine.type}</td>
				<td>${engine.volume}</td>
				<td>${engine.power}</td>
				<td>${engine.serialNumber}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>