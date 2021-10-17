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
<%--<h2>sessBean1.data1 : ${requestScope.sessBean1.data1}</h2>--%>
<%--<h2>sessBean1.data2 : ${requestScope.sessBean1.data2}</h2>--%>

<%--<h2>sessBean2.data3 : ${sessionScope.sessBean2.data3}</h2>--%>
<%--<h2>sessBean2.data4 : ${sessionScope.sessBean2.data4}</h2>--%>

<%--<h2>sessBean3.data5 : ${requestScope.sessBean3.data5}</h2>--%>
<%--<h2>sessBean3.data6 : ${requestScope.sessBean3.data6}</h2>--%>

<%--<h2>sessBean4.data7 : ${requestScope.sessBean4.data7}</h2>--%>
<%--<h2>sessBean4.data8 : ${requestScope.sessBean4.data8}</h2>--%>



<%-- ApplicationScopeXml 예제 --%>

<%--
    applicationScope 는 서버 가동 시, 데이터를 주입하는 역할"만" 하며
    해당 영역에 데이터를 저장하거나 하지 않기 때문에,
    applicationScope 영역에서 Bean 내의 데이터를 찾아도 출력되지 않는다.
    데이터를 저장하고 싶다면 Model 클래스를 이용하여 데이터를 담아서 requestScope 영역에서 찾거나
    이전 applicationScope 예제에서 이용했던 HttpServletRequest 의 ServletContext 를 이용해야 한다.
--%>
<h2>appBean.data1 : ${requestScope.appBean.data1}</h2>
<h2>appBean.data2 : ${requestScope.appBean.data2}</h2>

<%--
    이하 두 줄은 이름을 직접 지정하여 주입했으므로, applicationScope 영역에 저장된다.
    이 경우는 applicationScope 영역에서 찾아야 한다.
 --%>
<h2>appBean2.data3 : ${applicationScope.appBean2.data3}</h2>
<h2>appBean2.data4 : ${applicationScope.appBean2.data4}</h2>

<%-- component 를 이용하여 bean 을 주입. --%>
<h2>appBean3.data5 : ${requestScope.appBean3.data5}</h2>
<h2>appBean3.data6 : ${requestScope.appBean3.data6}</h2>

<%--
    이름을 이용한 주입이지만, requestScope 때와 같이 XML 로 bean 을 "직접 설정"하고
    이름으로(byName) 주입한 것이 아니므로, Model 로 데이터를 담고 requestScope 에서 찾아야 한다.
--%>
<h2>appBean4.data7 : ${requestScope.appBean4.data7}</h2>
<h2>appBean4.data8 : ${requestScope.appBean4.data8}</h2>




</body>
</html>
