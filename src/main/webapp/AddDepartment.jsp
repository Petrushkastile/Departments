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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <title>Add Department</title>
</head>
<body>
<div>
    <a href="/main">Back</a>
</div>
<c:if test="${not empty serviceException.message}">
    <div class="alert alert-danger">
        <strong><c:out value="${serviceException.message}"/></strong>
    </div>
</c:if>

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="/addDepartment" method="post">
            <legend>New Department:</legend>
            <div class="form-group">
                Department name:
                <input class="form-control" data-toggle="tooltip"
                       data-placement="bottom" title="enter only letters 3-10 chars,first letter in uppercase" id="1" required type="text" name="name" value="<c:out value ='${department["name"]}'/>"/>
                <label class="text-warning" for="1"><c:out value='${errors["name"]}'/><c:out
                        value='${errors["nameUsed"]}'/></label>

            </div>
            <button class="btn btn-primary" type="submit" value="Add">Add</button>
        </form>
    </div>
    <div class="col-md-4"></div>

</div>
<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
</body>
</html>
