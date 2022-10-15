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
    <title>Warehouse</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
<%--    <nav class="navbar navbar-expand-md navbar-dark"--%>
<%--         style="background-color: black">--%>
<%--        <div>--%>
<%--            <a href=/Homepage class="navbar-brand"> Goods--%>
<%--                Management App </a>--%>
<%--        </div>--%>

<%--        <ul class="navbar-nav">--%>
<%--            <li><a href="<%=request.getContextPath()%>/Warehouse"--%>
<%--                   class="nav-link">Warehouse</a></li>--%>
<%--        </ul>--%>
<%--    </nav>--%>

    <jsp:include page="/Header.jsp" />
    <jsp:include page="/contact.jsp" />
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Goods</h3>
        <hr>
        <div class="container text-left">

            <a href="Warehouse/new" class="btn btn-outline-dark">Add
                New Good</a>
        </div>
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
                    <td><a href="Warehouse/edit?id=<c:out value='${fan.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="Warehouse/delete?id=<c:out value='${fan.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
