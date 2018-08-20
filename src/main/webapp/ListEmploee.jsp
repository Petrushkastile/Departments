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
    <title>Department emploees</title>
</head>
<body>
<h2 align="center">Emploees</h2>
<p><a href="/main">Home</a></p>

<c:if test="${empty emploees}">
    <div align="center">
        <h2><c:out value="${message}"></c:out> </h2>
    </div>
</c:if>
<div align="center">
    <c:if test="${not empty emploees }">
        <table border="1" cellpadding="7">
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
                            <input type="hidden" name="departmentId" value="<c:out value="${departmentId}"/>"  />
                            <input type="hidden" name="departmentName" value="<c:out value="${departmentName}"/>"  />
                            <input type="submit" value="Update"/>
                        </form>
                        <form style="display: inline-block" action="/deleteEmploee" method="post">
                            <input type="hidden" name="departmentId" value="<c:out value="${departmentId}"/>"/>
                            <input type="hidden" name="departmentName" value="<c:out value="${departmentName}"/>"  />
                            <input type="hidden" name="deleteId" value="<c:out value="${emploee.id}"/>"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </c:if>

    <form action="/showFormAddEmploee" method="post">
        <input type="hidden" name="departmentId" value="<c:out value="${departmentId}"/>"  />
        <input type="hidden" name="departmentName" value="<c:out value="${departmentName}"/>"  />
        <input type="submit" value="Add new emploee" >
    </form>

</div>
</body>
</html>
