<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 17.08.2018
  Time: 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Update Department</title>
</head>
<body>
<div>
    <a href="/main">Back</a>

</div>
<div align="center">
    <form action="/updateDepartment" method="post">

        <fieldset>
            <legend>Update Department:</legend>
            Department name:<br>
            <input type="hidden" name="id" value="<c:out value ='${department.id}'/>"/>
            <input required type="text" name="name" value="<c:out value ='${department.name}'/>"/>
            <input type="hidden" name="countEmploees" value="<c:out value ='${department.countEmploees}'/>"/>
            <input type="submit" value="Update"/>
        </fieldset>
    </form>

</div>
</body>
</html>