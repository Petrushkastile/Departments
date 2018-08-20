<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 17.08.2018
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Company emploees</title>
</head>
<body>
<h2 align="center">Company Emploees</h2>
<div align="center">
    <table border="1" cellpadding="7">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Date of birth</th>
            <th>Salary</th>
            <th>Email</th>
            <th>Department</th>
        </tr>
        <c:forEach var="emploee" items="${emploees}">
            <tr>
                <td><c:out value="${emploee.emploeeId}"/></td>
                <td><c:out value="${emploee.emploeeName}"/></td>
                <td><c:out value="${emploee.emploeeSurname}"/></td>
                <td><c:out value="${emploee.emploeeBirth}"/></td>
                <td><c:out value="${emploee.salary}"/></td>
                <td><c:out value="${emploee.email}"/></td>
                <td><c:out value="${emploee.departmentName}"/></td>
            </tr>
        </c:forEach>
    </table>
    <form action="/main" method="get">
        <input type="submit" value="Ok" >
    </form>

</div>
</body>
</html>
