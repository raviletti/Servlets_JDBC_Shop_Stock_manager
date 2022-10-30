<%@ page import="model.Cart" %>
<%@ page import="model.Fan" %>
<%@ page import="java.util.List" %><%--
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
<%--	<jsp:include page="/Shop/testbuy.jsp" />--%>
</header>
<br>

<div class="row">
	<div class="container">
		<h3 class="text-center">Cart</h3>
		<hr>
		<br>
		<table class="table table-bordered">
			<thead>
			<tr>
				<th>Model</th>
				<th>Producer</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Total</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="fan" items="${fanList}">
				<tr>
					<td><c:out value="${fan.modelName}" /></td>
					<td><c:out value="${fan.producerName}" /></td>
					<td><c:out value="${fan.quantity}" /></td>
					<td><c:out value="${fan.price}" /></td>
					<td><c:out value="${fan.price*fan.quantity}" /></td>

					<td> <a href="Cart/delete?model=<c:out value='${fan.modelName}' />&producer=<c:out value='${fan.producerName}' />">Delete</a></td>
				</tr>
			</c:forEach>
			<!-- } -->
			</tbody>

		</table>

		<%Cart cart = (Cart) session.getAttribute("cart"); %>
		<c:if test="${cart == null }">
			<p>Cart is empty!</p>
			<jsp:include page="/contact.jsp" />
		</c:if>

		<c:if test="${cart != null && cart.isCartEmpty()}">
			<p>Cart is empty!</p>
			<jsp:include page="/contact.jsp" />
		</c:if>
		<c:if test="${cart != null && !cart.isCartEmpty()}">
			<%="Total: " + cart.getSum()%>
			<jsp:include page="/Shop/BuyForm.jsp" />
		</c:if>



	</div>
</div>



</body>
</html>
