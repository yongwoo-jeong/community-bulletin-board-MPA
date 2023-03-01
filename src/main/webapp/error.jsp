<%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2023/02/13
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>에러 페이지</title>
</head>
<body>
<div>
    <a>에러가 발생했습니다</a>
    <% String error = (String) request.getAttribute("errorMessage");
        if (error!= null) {%>
    <a><%=request.getAttribute("javax.servlet.error.message")%></a>
    <% } else {  %>
    <a>알 수 없는 에러가 발생하였습니다.</a>
    <% } %>
</div>
<div>
    <a href="/home">홈으로 돌아가기</a>
    <a href="">이전페이지로 돌아가기</a>
</div>
</body>
</html>
