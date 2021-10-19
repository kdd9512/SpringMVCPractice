<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>test1</title>
</head>
<body>
  <h1>TEST1</h1>
  <img src="img/f.jpg"/>
<div>
    <a href="/">HOME</a>
    <a href="t1/sub1">sub 이동</a>
    <a href="t2">t2 이동.</a>
</div>

  <%--
      Properties & Message
      properties 에 작성한 값을 JSP 에서 사용하고자 한다면, MessageSource 객체를 이용하여 properties 파일을
      등록 하는 것으로 properties 파일을 Message 로 등록할 필요가 있다.
      이를 JSP 내에서 활용하려면 custom tag 가 필요한데, 이하의 taglib 을 추가한다.
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  --%>
  <h2>prop1.data1 : <spring:message code="prop1.data1"/></h2>
  <h2>prop1.data2 : <spring:message code="prop1.data2"/></h2>

</body>
</html>
