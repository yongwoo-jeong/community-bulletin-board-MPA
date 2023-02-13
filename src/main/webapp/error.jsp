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
  <%=request.getAttribute("error")%>
</body>
</html>
