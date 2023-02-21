<%@ page import="java.net.URLEncoder" %><%--
<%--TODO 프론트 input form 검증--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/index.css" />
    <jsp:include page="component/title.jsp">
        <jsp:param name="titleValue" value='회원가입' />
    </jsp:include>
</head>
<body>
<jsp:include page="component/navigation.jsp"></jsp:include>
    <main>
        <div>
            <jsp:include page="component/userInfoForm.jsp">
                <jsp:param name="state" value="create"/>
            </jsp:include>
        </div>
    </main>

<%--TODO 가입 / 수정 URL 가져와서 다른 자바스크립트 파일 가져오기--%>
<script src="js/signUp.js" type="module"></script>
<script src="js/navigation.js"></script>
</body>
</html>
