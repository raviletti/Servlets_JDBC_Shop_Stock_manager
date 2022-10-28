<%--
  Created by IntelliJ IDEA.
  User: ravil
  Date: 17.09.2022
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Goods Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: black">
        <div>
            <a href="/Homepage" class="navbar-brand"> Good Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="/Stockmanager"
                   class="nav-link">Stock Manager</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${fan != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${fan == null}">
                <form action="create" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${fan != null}">
                                Edit Good
                            </c:if>
                            <c:if test="${fan == null}">
                                Add New Good
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${fan != null}">
                        <input type="hidden" name="id" value="<c:out value='${fan.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Model Name</label> <input type="text"
                                                        value="<c:out value='${fan.modelName}' />" class="form-control"
                                                        name="modelName" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Producer</label> <input type="text"
                                                         value="<c:out value='${fan.producerName}' />" class="form-control"
                                                         name="producerName">
                    </fieldset>

                        <fieldset class="form-group">
                            <label>Quantity</label> <input type="text"
                                                               value="<c:out value='${fan.quantity}' />" class="form-control"
                                                               name="quantity">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Value</label> <input type="text"
                                                               value="<c:out value='${fan.volume}' />" class="form-control"
                                                               name="volume">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Weight</label> <input type="text"
                                                               value="<c:out value='${fan.weight}' />" class="form-control"
                                                               name="weight">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Count in order</label> <input type="text"
                                                               value="<c:out value='${fan.inOrder}' />" class="form-control"
                                                               name="inOrder">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Description</label> <input type="text"
                                                               value="<c:out value='${fan.description}' />" class="form-control"
                                                               name="description">
                        </fieldset>

                    <button type="submit" class="btn btn-outline-dark">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>