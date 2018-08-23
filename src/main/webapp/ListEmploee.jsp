<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 17.08.2018
  Time: 16:41
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
    <title>Department emploees</title>
</head>
<body>
<c:if test="${not empty serviceException.message}">
    <div class="alert alert-danger">
        <strong><c:out value="${serviceException.message}"/></strong>
    </div>
</c:if>
<h2 align="center">Emploees</h2>
<p><a href="/main">Home</a></p>


<div class="container">
    <c:if test="${empty emploees}">
        <div align="center">
            <h2><c:out value="${message}"></c:out></h2>
        </div>
    </c:if>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <c:if test="${not empty emploees }">
                <table class="table">
                    <caption><h3>List emploees of <c:out value="${departmentName}"/> department</h3></caption>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Date of birth</th>
                        <th>Salary</th>
                        <th>Email</th>
                        <th width="200px">Actions</th>
                    </tr>
                    <c:forEach var="emploee" items="${emploees}">
                        <tr>
                            <td><c:out value="${emploee.id}"/></td>
                            <td><c:out value="${emploee.name}"/></td>
                            <td><c:out value="${emploee.surname}"/></td>
                            <td><c:out value="${emploee.birthDate}"/></td>
                            <td><c:out value="${emploee.salary}"/></td>
                            <td><c:out value="${emploee.email}"/></td>
                            <td>
                                <form style="display: inline-block" action="/showFormUpdateEmploee" method="post">
                                    <input type="hidden" name="updateId" value="<c:out value="${emploee.id}"/>"/>
                                    <input type="hidden" name="departmentId" value="<c:out value="${departmentId}"/>"/>
                                    <input type="hidden" name="departmentName"
                                           value="<c:out value="${departmentName}"/>"/>
                                    <button class="btn btn-primary" type="submit" value="Update">Update</button>
                                </form>
                                <form style="display: inline-block" action="/deleteEmploee" method="post">
                                    <input type="hidden" name="departmentId" value="<c:out value="${departmentId}"/>"/>
                                    <input type="hidden" name="departmentName"
                                           value="<c:out value="${departmentName}"/>"/>
                                    <input type="hidden" name="deleteId" value="<c:out value="${emploee.id}"/>"/>
                                    <button class="btn btn-danger" type="submit" value="Delete">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

        </div>
        <div class="col-md-2"></div>

    </div>
    <div class="row">
        <div class="col-md-5"></div>
        <div class="col-md-2">
            <form action="/showFormAddEmploee" method="post">
                <input type="hidden" name="departmentId" value="<c:out value="${departmentId}"/>"/>
                <input type="hidden" name="departmentName" value="<c:out value="${departmentName}"/>"/>
                <button class="btn btn-primary" type="submit" value="Add new emploee">Add</button>
            </form>
        </div>
        <div class="col-md-5"></div>
    </div>
</div>
</body>
</html>
