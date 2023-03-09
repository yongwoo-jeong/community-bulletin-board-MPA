<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="component/title.jsp">
        <jsp:param name="titleValue" value='로그인 페이지' />
    </jsp:include>
    <link rel="stylesheet" href="/css/index.css" />
</head>
<body>
<jsp:include page="component/navigation.jsp"></jsp:include>
<div>
    <div class="form-container">
        <form method="post" action="/login">
            <input name="account" type="text" placeholder="아이디"/>
            <input name="password" type="password" placeholder="비밀번호"/>
            <input name="prevPage" type="hidden" value=<%=request.getAttribute("prevPage")%>>
            <input value="로그인" type="submit"/>
        </form>
    </div>
    <div class="button-container">
        <div onclick="location.href='/signup'">회원가입</div>
        <div>아이디 찾기</div>
        <div>비밀번호 찾기</div>
    </div>
</div>
<script src="js/navigation.js"></script>
</body>
</html>
