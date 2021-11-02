<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>read data</h1>
  <c:forEach var="obj" items="${list}">
    ${obj.data1}<br/>
    ${obj.data2}<br/>
    ${obj.data3}<br/>
  </c:forEach>
</body>
</html>
