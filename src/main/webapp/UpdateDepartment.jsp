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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Update Department</title>
</head>
<body>
<div>
    <a href="/main">Back</a>

</div>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="/updateDepartment" method="post">
            <legend>Update Department:</legend>
            <div class="form-group">
                Department name:
                <input class="form-control" type="hidden" name="id" value="<c:out value ='${department.id}'/>"/>
                <input class="form-control" data-toggle="tooltip"
                       data-placement="bottom" title="enter only letters 3-10 chars,first letter in uppercase"
                       type="text" name="name" id="1" value="<c:out value ='${department.name}'/>"/>
                <input class="form-control" type="hidden" name="countEmploees"
                       value="<c:out value ='${department.countEmploees}'/>"/>
                <label class="text-warning" for="1"><c:out value='${errors["name"]}'/><c:out
                        value='${errors["nameUsed"]}'/></label>
            </div>
            <button class="btn btn-primary" type="submit" value="Update">Update</button>
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