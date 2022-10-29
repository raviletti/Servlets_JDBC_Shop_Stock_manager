<%--
  Created by IntelliJ IDEA.
  User: ravil
  Date: 16.09.2022
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Cart</title>
	<link rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		  crossorigin="anonymous">
</head>
<body>

<header>

	<jsp:include page="/Header.jsp" />
	<jsp:include page="/contact.jsp" />
</header>
<br>

<div class="row">
	<div class="container">
		<h3 class="text-center">List of Goods</h3>
		<hr>
		<br>
		<table class="table table-bordered">
			<thead>
			<tr>
				<th>ID</th>
				<th>Model</th>
				<th>Producer</th>
				<th>Quantity</th>
				<th>Volume (for piece)</th>
				<th>Weight (for piece)</th>
				<th>In order</th>
				<th>Free stock</th>
				<th>Description</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="fan" items="${listFan}">
				<tr>
					<td><c:out value="${fan.id}" /></td>
					<td><c:out value="${fan.modelName}" /></td>
					<td><c:out value="${fan.producerName}" /></td>
					<td><c:out value="${fan.quantity}" /></td>
					<td><c:out value="${fan.volume}" /></td>
					<td><c:out value="${fan.weight}" /></td>
					<td><c:out value="${fan.inOrder}" /></td>
					<td><c:out value="${fan.freeStock}" /></td>
					<td><c:out value="${fan.description}" /></td>
					<td><a href="Stockmanager/edit?id=<c:out value='${fan.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="Stockmanager/delete?id=<c:out value='${fan.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
			<!-- } -->
			</tbody>

		</table>
	</div>
</div>
</body>
</html>
