<%--
  Created by IntelliJ IDEA.
  User: ravil
  Date: 26.08.2022
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>

<body>
<form action="/Calculator" method="POST">
    NumberOne: <input name="NumberOne" value="0" />
    <br><br>
    Operation: <select name="operation">
    <option>+</option>
    <option>-</option>
    <option>/</option>
    <option>*</option>
</select>
    <br><br>
    NumberTwo: <input name="NumberTwo" value="0" />
    <br><br>
    <input type="submit" />

</form>
<a href="/Homepage"><button style="font-size:17px">Home<i class="material-icons">home</i></button></a>
</body>
</html>
