<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 16.08.2018
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add Department</title>
</head>
<body>
<div>
    <a href="/main">Back</a>

</div>
<div>
    <form action="/addDepartment" method="post">
        <fieldset>
            <legend>New Department:</legend>
            Department name:<br>

            <input required type="text" name="name" value="<c:out value ='${department.name}'/>"/>
            <input type="submit" value="Add"/>
        </fieldset>
    </form>
</div>
</body>
</html>
