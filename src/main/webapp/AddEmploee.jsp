<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 17.08.2018
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Emploee</title>
</head>
<body>
<h1>
    Emploee operations
</h1>
<p><a href="/main">Home</a></p>
<h4>
    Adding emploee to <c:out value="${departmentName}"/> department
</h4>

    <div>
        <c:out value="${message}"/>
    </div>

<form action="/addEmploee" method="post">
    <fieldset>
        <legend>Add emploee:</legend>
        <p>
            Emploee name:
        </p>
        <p>
            <input id="1" type="text" name="name"
                   value="<c:out value ='${emploee["name"]}'/>"/>
            <label for="1"><c:out value='${errors["name"]}'/></label>
        </p>
        <p>
            Emploee surname:
        </p>
        <p>
            <input id="2" required type="text" name="surname"
                   value="<c:out value ='${emploee["surname"]}'/>"/>
            <label for="2"><c:out value='${errors["surname"]}'/></label>
        </p>

        <p>
            Emploee birthdate(DD.MM.YYYY):
        </p>
        <p>
            <input id="3" type="text" name="birthDate"
                   value="<c:out value ='${emploee["birthdate"]}'/>"/>
            <label for="3"><c:out value='${errors["birthdate"]}'/></label>
        </p>

        <p>
            Emploee salary(1-9 character,only numbers):
        </p>
        <p>
            <input id="4" type="text" name="salary"
                   value="<c:out value ='${emploee["salary"]}'/>"/>
            <label for="4"><c:out value='${errors["salary"]}'/></label>
        </p>
        <p>
            Email:
        </p>
        <p>
            <input id="5" type="text" name="email" value="<c:out value ='${emploee["email"]}'/>"/>
            <label for="5"> <c:out value='${errors["email"]}'/><c:out value='${errors["emailUsed"]}'/></label>
        </p>
        <p>
            <input type="hidden" name="departmentId" value="<c:out value ='${departmentId}'/>"/>
        </p>
        <p>
            <input type="hidden" name="departmentName" value="<c:out value ='${departmentName}'/>"/>
        </p>
        <div>
            <input type="submit" value="Add"/>
        </div>
    </fieldset>
</form>

<form style="display: inline-block" action="/listEmploee" method="post">
    <input type="hidden" name="departmentName" value="<c:out value="${departmentName}"/>"/>
    <input type="hidden" name="departmentId" value="<c:out value="${departmentId}"/>"/>
    <input type="submit" value="Back to department"/>
</form>


</body>
</html>
