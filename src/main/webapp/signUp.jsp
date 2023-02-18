<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2023/02/10
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%--TODO 프론트 input form 검증--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/index.css" />
    <jsp:include page="component/title.jsp">
        <jsp:param name="titleValue" value='<%=URLEncoder.encode("회원가입", "UTF-8") %>' />
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
<script src="js/signUp.js" type="module"></script>
<script src="js/navigation.js"></script>
</body>
</html>
