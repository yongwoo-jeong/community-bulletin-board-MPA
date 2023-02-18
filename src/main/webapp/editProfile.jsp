<%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2023/02/18
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="component/navigation.jsp"></jsp:include>
<main>
  <div>
    <jsp:include page="component/userInfoForm.jsp">
      <jsp:param name="state" value="edit"/>
    </jsp:include>
  </div>
</main>
</body>
</html>
