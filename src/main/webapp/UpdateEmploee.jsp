<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 19.08.2018
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<head>
    <title>Update Emploee</title>
</head>
<body>
<h1>
    Emploee operations
</h1>
<h4>
    Update emploee in <c:out value="${departmentName}"/> department
</h4>
<div>
    <c:out value="${message}"/>
</div>
<form action="/updateEmploee" method="post">
    <fieldset>
        <legend>Update emploee:</legend>
        <input type="hidden" name="id" value="<c:out value ='${emploee.id}'/>"/>
        <input type="hidden" name="departmentId" value="<c:out value ='${departmentId}'/>"/>
        <input type="hidden" name="olddepartmentId" value="<c:out value ='${emploee.departmentId}'/>"/>
        <p>
            Emploee name:
        <p>
        <p>
            <input id="8" type="text" name="name" value="<c:out value ='${emploee.name}'/>"/>
            <label for="8"><c:out value='${errors["name"]}'/></label>
        </p>
        <p>
            Emploee surname:
        </p>
        <p>
            <input id="9" type="text" name="surname" value="<c:out value ='${emploee.surname}'/>"/>
            <label for="9"><c:out value='${errors["surname"]}'/></label>
        </p>
        <p>
            Emploee birthdate(DD.MM.YYYY):
        </p>
        <p>
            <c:if test="${null or empty errors}">
                <input id="10" type="text" name="birthDate"
                       value="<fmt:formatDate pattern = "dd.MM.yyyy" value = "${emploee.birthDate}" />"/>
            </c:if>
            <c:if test="${ not empty errors}">
                <input id="10" type="text" name="birthDate" value="<c:out value ='${emploee.birthDate}'/>"/>
            </c:if>
            <label for="10"><c:out value='${errors["birthDate"]}'/></label>
        </p>
        <p>
            Emploee salary(1-9 character,only numbers):
        </p>
        <p>
            <input id="11" type="text" name="salary" value="<c:out value ='${emploee.salary}'/>"/>
            <label for="11"><c:out value='${errors["salary"]}'/></label>
        </p>
        <p>
            <input id="12" type="text" name="email" value="<c:out value ='${emploee.email}'/>"/>
            <label for="12"> <c:out value='${errors["email"]}'/><c:out value='${errors["emailUsed"]}'/></label>
        </p>
        <p>
            Choose Department:
        </p>
        <p>
            <select name="departmentName">
                <c:forEach var="department" items="${departments}">
                    <c:if test="${emploee.departmentId == department.id}">
                        <option selected>
                            <c:out value='${department.name}'/>
                        </option>
                    </c:if>
                    <c:if test="${emploee.departmentId != department.id}">
                        <option>
                            <c:out value='${department.name}'/>
                        </option>
                    </c:if>
                </c:forEach>
            </select>
        </p>
        <input type="submit" value="Update"/>
    </fieldset>
</form>
</body>
</html>
