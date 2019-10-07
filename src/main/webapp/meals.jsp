<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 05.10.2019
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <h1 style="text-align: center; margin-top: 50px; margin-bottom: 30px">Meal list</h1>
</head>
<body>
<table border="1" align="center" style="margin-top: 10px" class="table">
    <thead class="tableHead" style="background-color: lightgray">
    <tr>
        <th scope="col" width="50">ID</th>
        <th scope="col" width="150">Date/time</th>
        <th scope="col" width="150">Description</th>
        <th scope="col" width="150">Calories</th>
        <th scope="col"width="75">Edit</th>
        <th scope="col"width="75">Delete</th>
    </tr>
    </thead>
    <tbody id="mainTable">
    <c:forEach items="${mealList}" var="ml">
        <tr style = "background-color:  ${ml.excess ? 'lightpink' : 'lime'}")>
            <td><c:out value=" "></c:out></td>
            <td><c:out value="${dtf.format(ml.dateTime)}"></c:out></td>
            <td><c:out value="${ml.description}"></c:out></td>
            <td><c:out value="${ml.calories}"></c:out></td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3><a href="index.html">Home</a></h3>
</body>
</html>
