<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Company</title>
</head>
<body>

<h2 align="center">Departments</h2>
<div align="center">
    <table border="1" cellpadding="4">
        <caption><h3>List of Departments</h3></caption>
        <tr>
            <th>Id</th>
            <th>Department name</th>
            <th>Count emploees</th>
            <th width="350px" >Actions</th>
        </tr>
        <c:forEach var="department" items="${departments}">
            <tr>
                <td><c:out value="${department.id}"/></td>
                <td><c:out value="${department.name}"/></td>
                <td><c:out value="${department.countEmploees}"/></td>
                <td>
                    <form style="display: inline-block" action="/showFormUpdateDepartment" method="post">
                        <input type="hidden" name="updateId" value="<c:out value="${department.id}"/>"/>
                        <input type="submit" value="Update"/>
                    </form>
                    <form style="display: inline-block" action="/deleteDepartment" method="post">
                        <input type="hidden" name="deleteId" value="<c:out value="${department.id}"/>"/>
                        <input type="submit" value="Delete"/>
                    </form>
                    <form style="display: inline-block" action="/listEmploee" method="post">
                        <input type="hidden" name="departmentName" value="<c:out value="${department.name}"/>"/>
                        <input type="hidden" name="departmentId" value="<c:out value="${department.id}"/>"/>
                        <input type="submit" value="Emploees"/>
                    </form>
                    <form style="display: inline-block" action="/showFormAddEmploee" method="post">
                        <input type="hidden" name="departmentName" value="<c:out value="${department.name}"/>"/>
                        <input type="hidden" name="departmentId" value="<c:out value="${department.id}"/>"/>
                        <input type="submit" value="Add Emploee"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="/newDepartmentForm" method="get">
        <input type="submit" value="Create new department" >
    </form>
    <form action="/allEmploees" method="get">
        <input type="submit" value="Show company emploees" >
    </form>
</div>

</body>
</html>
