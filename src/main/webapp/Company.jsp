<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Company</title>
</head>
<body>
<c:if test="${not empty serviceException.message}">
<div class="alert alert-danger">
    <strong><c:out value="${serviceException.message}"/></strong>
</div>
</c:if>
<c:if test="${not empty departments }">
    <h2 align="center">Departments</h2>
    <div class="col-md-2"></div>
    <div align="center" class="col-md-8">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Department name</th>
                <th>Count emploees</th>
                <th width="350px">Actions</th>
            </tr>
            <c:forEach var="department" items="${departments}">
                <tr>
                    <td><c:out value="${department.id}"/></td>
                    <td><c:out value="${department.name}"/></td>
                    <td><c:out value="${department.countEmploees}"/></td>
                    <td>
                        <form style="display: inline-block" action="/showFormUpdateDepartment" method="post">
                            <input type="hidden" name="updateId" value="<c:out value="${department.id}"/>"/>
                            <button class="btn btn-success" type="submit" value="Update">Update</button>
                        </form>
                        <form style="display: inline-block" action="/deleteDepartment" method="post">
                            <input type="hidden" name="deleteId" value="<c:out value="${department.id}"/>"/>
                            <button class="btn btn-danger" type="submit" value="Delete">Delete</button>
                        </form>
                        <form style="display: inline-block" action="/listEmploee" method="post">
                            <input type="hidden" name="departmentName" value="<c:out value="${department.name}"/>"/>
                            <input type="hidden" name="departmentId" value="<c:out value="${department.id}"/>"/>
                            <button class="btn btn-info" type="submit" value="Emploees">Emploees</button>
                        </form>
                        <form style="display: inline-block" action="/showFormAddEmploee" method="post">
                            <input type="hidden" name="departmentName" value="<c:out value="${department.name}"/>"/>
                            <input type="hidden" name="departmentId" value="<c:out value="${department.id}"/>"/>
                            <button class="btn btn-primary" type="submit" value="Add Emploee">Add emploee</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-2"></div>
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-2">
            <form action="/newDepartmentForm" method="get">
                <button class="btn btn-primary" type="submit" value="Create new department">Create new department</button>
            </form>
        </div>
        <div class="col-md-2">
            <form action="/allEmploees" method="get">
                <button class="btn btn-primary"type="submit" value="Show company emploees">Show company emploees</button>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</c:if>
</body>
</html>
