<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>RESULT</title>
</head>
<body>
<%-- 예제 결과출력을 위한 페이지 --%>
<%--<h1>result</h1>--%>
<%--<h2>reqBean1.data1 : ${requestScope.reqBean1.data1}</h2>--%>
<%--<h2>reqBean1.data2 : ${requestScope.reqBean1.data2}</h2>--%>

<%--<h2>reqBean2.data3 : ${requestScope.reqBean2.data3}</h2>--%>
<%--<h2>reqBean2.data4 : ${requestScope.reqBean2.data4}</h2>--%>

<%--<h2>reqBean3.data5 : ${requestScope.reqBean3.data5}</h2>--%>
<%--<h2>reqBean3.data6 : ${requestScope.reqBean3.data6}</h2>--%>

<%--<h2>reqBean4.data7 : ${requestScope.reqBean4.data7}</h2>--%>
<%--<h2>reqBean4.data8 : ${requestScope.reqBean4.data8}</h2>--%>


<%--
    ** @SessionScope 는 브라우저에서 최초의 요청이 발생하면 단 한번만 Bean 을 주입시키는 역할만 할 뿐
    데이터를 저장해주지 않으므로, 데이터를 저장하고 싶다면 Model 클래스를 이용하여 데이터를 담아야 한다.
--%>
<h1>result</h1>

<%-- 이하의 코드는 데이터를 출력하지 못한다. --%>
<%--<h2>sessBean1.data1 : ${sessionScope.sessBean1.data1}</h2>--%>
<%--<h2>sessBean1.data2 : ${sessionScope.sessBean1.data2}</h2>--%>
<%--<h2>sessBean2.data3 : ${sessionScope.sessBean2.data3}</h2>--%>
<%--<h2>sessBean2.data4 : ${sessionScope.sessBean2.data4}</h2>--%>


<%-- Model 을 이용하여 데이터를 저장했으므로 requestScope 를 이용하여 데이터를 불러와야 한다. --%>
<h2>sessBean1.data1 : ${requestScope.sessBean1.data1}</h2>
<h2>sessBean1.data2 : ${requestScope.sessBean1.data2}</h2>

<h2>sessBean2.data3 : ${sessionScope.sessBean2.data3}</h2>
<h2>sessBean2.data4 : ${sessionScope.sessBean2.data4}</h2>

<h2>sessBean3.data5 : ${requestScope.sessBean3.data5}</h2>
<h2>sessBean3.data6 : ${requestScope.sessBean3.data6}</h2>

<h2>sessBean4.data7 : ${requestScope.sessBean4.data7}</h2>
<h2>sessBean4.data8 : ${requestScope.sessBean4.data8}</h2>


</body>
</html>
