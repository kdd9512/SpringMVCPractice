<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 커스텀 폼 태그를 이용하기 위한 taglib 을 추가한다. --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>TEST3</title>
</head>
<body>
    <h1>TEST3</h1>
    <img src="h.jpg"/>
</body>


<%--
    Model 역시 HttpServletRequest 와 마찬가지로 request 에 데이터를 담아 전송하기 떄문에
    데이터를 불러올 때에는, requestScope.데이터명 으로 불러온다.
--%>
<%--<div>--%>
<%--    <span>${requestScope.data1}년</span>--%>
<%--    <span>11월 21일</span>--%>
<%--    <span>${requestScope.data2}은 오랜 지병이었던 고혈압으로 쓰러졌다.</span>--%>
<%--</div>--%>


<%-- Custom Form Tag 예제--%>

<%-- test3 은 @ModelAttribute 로 Command Object의 이름을 testBean 으로 지정했으므로
     modelAttribute 에는 당연히 dataBean 이 아닌, testBean 을 입력해야 한다.

--%>
<%--<form:form modelAttribute="testBean" action="result">--%>
    <%-- <input id="user_name" name="user_name"
                type="text" value="AppliScopeBean 에서 입력했던 그 값"/> 의 형태가
         자동으로 만들어진다.
   --%>
<%--    이름 : <form:input path="user_name"/><br/>--%>
<%--    ID : <form:input path="user_id"/><br/>--%>

    <%-- ** 이 방법을 사용하면 페이지 소스 확인 시
         비밀번호가 노출될 우려가 있기 때문에 기본적으로
         password 는 값이 존재하더라도 넘어오지 않는다.
     --%>
    <%--    비밀번호 : <form:password path="user_pw"/><br/>--%>

    <%-- 굳이 입력되어 있는걸 필요로 한다면 이하와 같이 코드를 수정한다.
         단 페이지 소스 확인 시, 비밀번호가 노출된다.
    --%>
<%--    비밀번호 : <form:password path="user_pw" showPassword="true"/><br/>--%>
<%--    우편번호 : <form:input path="user_postcode"/><br/>--%>
<%--    주소1 : <form:input path="user_add1"/><br/>--%>
<%--    주소2 : <form:input path="user_add2"/><br/>--%>
<%--    <button type="submit">submit</button>--%>
<%--</form:form>--%>

</html>
