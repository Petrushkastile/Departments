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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Company emploees</title>
</head>
<body>
<c:if test="${not empty serviceException.message}">
    <div class="alert alert-danger">
        <strong><c:out value="${serviceException.message}"/></strong>
    </div>
</c:if>
<p><a href="/main">Home</a></p>
<div class="container">
    <c:if test="${  empty  emploees}">
        <h4 class="text-warning">There are no employees in the company</h4>
    </c:if>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <c:if test="${not empty emploees}">
                <table class="table">
                    <caption class="text-primary"><h3>Company Emploees:</h3></caption>
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
                    <button class="btn btn-primary" type="submit" value="Ok">Ok</button>
                </form>
            </c:if>
        </div>
        <div class="col-md-2"></div>
    </div>

</div>

</body>
</html>
