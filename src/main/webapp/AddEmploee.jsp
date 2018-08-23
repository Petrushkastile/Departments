<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 17.08.2018
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Add Emploee</title>
</head>
<body>

<h1>
    Emploee operations
</h1>
<p><a href="/main" data-toggle="tooltip"
      title="back to home page">Home</a></p>
<c:if test="${not empty serviceException.message}">
    <div class="alert alert-danger">
        <strong><c:out value="${serviceException.message}"/></strong>
    </div>
</c:if>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="/addEmploee" method="post">
            <legend>Adding emploee to <c:out value="${departmentName}"/> department</legend>
            <div class="form-group">
                Emploee name:
                <input class="form-control" data-toggle="tooltip"
                       data-placement="bottom" title="enter only letters 3-10 chars,first letter in uppercase" id="1"
                       type="text" name="name"
                       value="<c:out value ='${emploee["name"]}'/>"/>
                <label class="text-warning" for="1"><c:out value='${errors["name"]}'/></label>
            </div>
            <div class="form-group">
                Emploee surname:
                <input class="form-control" data-toggle="tooltip"
                       data-placement="bottom" title="enter only letters 3-12 chars,first letter in uppercase" id="2"
                       required type="text"
                       name="surname"
                       value="<c:out value ='${emploee["surname"]}'/>"/>
                <label class="text-warning" for="2"><c:out value='${errors["surname"]}'/></label>
            </div>
            <div class="form-group">
                <p>Emploee birthdate:</p>
                <c:if test="${empty errors}">
                    <input id="3" data-toggle="tooltip" data-placement="bottom" title="enter date in format DD.MM.YYYY"
                           class="form-control" type="text" name="birthDate"
                           value="<fmt:formatDate pattern = "dd.MM.yyyy" value = '${emploee["birthDate"]}' />"/>
                </c:if>
                <c:if test="${not empty errors}">
                    <input id="3" data-toggle="tooltip" data-placement="bottom" title="enter date in format DD.MM.YYYY"
                           class="form-control" type="text" name="birthDate"
                           value="<c:out value ='${emploee["birthDate"]}'/>"/>
                </c:if>
                <label class="text-warning" for="3"><c:out value='${errors["birthDate"]}'/></label>
            </div>
            <div class="form-group">
                Emploee salary:
                <input class="form-control" data-toggle="tooltip" data-placement="bottom"
                       title="1-9 character,only numbers" id="4" type="text" name="salary"
                       value="<c:out value ='${emploee["salary"]}'/>"/>
                <label class="text-warning" for="4"><c:out value='${errors["salary"]}'/></label>
            </div>
            <div class="form-group">
                Email:
                <input class="form-control" id="5" type="text" name="email"
                       value="<c:out value ='${emploee["email"]}'/>"/>
                <label class="text-warning" for="5"> <c:out value='${errors["email"]}'/><c:out
                        value='${errors["emailUsed"]}'/></label>
            </div>
            <div class="form-group">
                <input class="form-control" type="hidden" name="departmentId"
                       value="<c:out value ='${departmentId}'/>"/>
                <input class="form-control" type="hidden" name="departmentName"
                       value="<c:out value ='${departmentName}'/>"/>
            </div>
            <button class="btn btn-primary" type="submit" value="Add">Add</button>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
<div class="row">
    <div class="col-md-5"></div>
    <div class="col-md-2">
        <form style="display: inline-block" action="/listEmploee" method="post">
            <input type="hidden" name="departmentName" value="<c:out value="${departmentName}"/>"/>
            <input type="hidden" name="departmentId" value="<c:out value="${departmentId}"/>"/>
            <button class="btn btn-primary" type="submit" value="Back to department">Back to department</button>
        </form>
    </div>
    <div class="col-md-5"></div>
</div>
<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
</body>
</html>
