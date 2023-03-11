<%@ page import="com.mpa.bbs.util.ClientUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="component/title.jsp">
        <jsp:param name="titleValue" value="새 게시글" />
    </jsp:include>
</head>
<body>
<main>
<jsp:include page="component/articleForm.jsp"></jsp:include>
<script src="js/articleForm.js" type="module"></script>
</main>
</body>
</html>
