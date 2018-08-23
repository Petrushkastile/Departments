<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 17.08.2018
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<H1>OOPS Something went wrong</H1>
<div>
    <%=exception.getMessage()%>
</div>
<div>


</div>
</body>
</html>
