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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Update Emploee</title>
</head>
<body>
<h1>
    Emploee operations
</h1>
<h4>
    Update emploee in <c:out value="${departmentName}"/> department
</h4>
<p><a href="/main" data-toggle="tooltip"
      title="back to home page">Home</a></p>
<c:if test="${not empty serviceException.message}">
    <div class="alert alert-danger">
        <strong><c:out value="${serviceException.message}"/></strong>
    </div>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="/updateEmploee" method="post">
                <legend>Update emploee:</legend>
                <div class="form-group">
                    <input type="hidden" name="id" value="<c:out value ='${emploee.id}'/>"/>
                    <input type="hidden" name="departmentId" value="<c:out value ='${departmentId}'/>"/>
                    <input type="hidden" name="olddepartmentId" value="<c:out value ='${emploee.departmentId}'/>"/>
                </div>
                <div class="form-group">
                    Emploee name:
                    <input class="form-control" data-toggle="tooltip"
                           data-placement="bottom" title="enter only letters 3-10 chars,first letter in uppercase" id="8"
                           type="text" name="name" value="<c:out value ='${emploee.name}'/>"/>
                    <label class="text-warning" for="8"><c:out value='${errors["name"]}'/></label>
                </div>
                <div class="form-group">
                    Emploee surname:
                    <input class="form-control" id="9" data-toggle="tooltip"
                           data-placement="bottom" title="enter only letters 3-12 chars,first letter in uppercase" type="text"
                           name="surname" value="<c:out value ='${emploee.surname}'/>"/>
                    <label class="text-warning" for="9"><c:out value='${errors["surname"]}'/></label>
                </div>
                <div class="form-group">
                    Emploee birthdate:
                    <c:if test="${null or empty errors}">
                        <input class="form-control" data-toggle="tooltip" data-placement="bottom"
                               title="enter date in format DD.MM.YYYY" id="10" type="text" name="birthDate"
                               value="<fmt:formatDate pattern = "dd.MM.yyyy" value = "${emploee.birthDate}" />"/>
                    </c:if>
                    <c:if test="${ not empty errors}">
                        <input class="form-control" data-toggle="tooltip" data-placement="bottom"
                               title="enter date in format DD.MM.YYYY" id="10" type="text" name="birthDate"
                               value="<c:out value ='${emploee.birthDate}'/>"/>
                    </c:if>
                    <label class="text-warning" for="10"><c:out value='${errors["birthDate"]}'/></label>
                </div>
                <div class="form-group">
                    Emploee salary:
                    <input class="form-control" data-toggle="tooltip" data-placement="bottom"
                           title="1-9 character,only numbers" id="11" type="text" name="salary"
                           value="<c:out value ='${emploee.salary}'/>"/>
                    <label class="text-warning" for="11"><c:out value='${errors["salary"]}'/></label>
                </div>
                <div class="form-group">
                    Email:
                    <input class="form-control" data-toggle="tooltip" data-placement="bottom" title="enter email in format"
                           id="12" type="text" name="email" value="<c:out value ='${emploee.email}'/>"/>
                    <label class="text-warning" for="12"> <c:out value='${errors["email"]}'/><c:out
                            value='${errors["emailUsed"]}'/></label>
                </div>
                <div class="form-group">
                    <label for="13">Choose Department:</label>
                    <select class="form-control" id="13" name="departmentName">
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
                </div>
                <button class="btn btn-primary" type="submit" value="Update">Update</button>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
    <div class="row">
        <div class="col-md-5"></div>
        <div class="col-md-2">
            <form style="display: inline-block" action="/listEmploee" method="post">
                <input type="hidden" name="departmentName" value="<c:out value="${departmentName}"/>"/>
                <input type="hidden" name="departmentId" value="<c:out value ='${departmentId}'/>"/>
                <button class="btn btn-primary" type="submit" value="Back to department">Back to department</button>
            </form>
        </div>
        <div class="col-md-5"></div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
</body>
</html>
