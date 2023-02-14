<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2023/02/07
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="component/title.jsp">
        <jsp:param name="titleValue" value='<%=URLEncoder.encode("로그인 페이지", "UTF-8") %>' />
    </jsp:include>
</head>
<body>
<div>
    <div class="form-container">
        <form>
            <input type="text" placeholder="아이디"/>
            <input type="password" placeholder="비밀번호"/>
            <input type="submit"/>
        </form>
    </div>
    <div class="button-container">
        <div onclick="location.href='/join'">회원가입</div>
        <div>아이디 찾기</div>
        <div>비밀번호 찾기</div>
    </div>
</div>
</body>
</html>
