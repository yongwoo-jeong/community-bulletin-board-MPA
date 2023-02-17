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
            <form method="post" action="${pageContext.request.contextPath}/signup">
                <table style="border-collapse: collapse">
                    <caption></caption>
                    <tr class="accountRow">
                        <th>아이디</th>
                        <td><input type="text" name="account"/></td>
                        <td class="">영어 소문자,숫자(5~9자)</td>
                    </tr>
                    <tr class="passwordRow">
                        <th>비밀번호</th>
                        <td><input type="password" name="password"/></td>
                        <td class="">영어 특수문자(`~!@#$%^&*),소문자,숫자(6~15자)</td>
                    </tr>
                    <tr class="passwordConfirmRow">
                        <th>비밀번호 확인</th>
                        <td><input type="password" name="passwordConfirm"/></td>
                    </tr>
                    <tr class="nameRow">
                        <th>이름</th>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr class="emailRow">
                        <th>이메일</th>
                        <td><input type="email" name="email"/></td>
                    </tr>
                </table>
                <input type="submit" value="완료" />
            </form>
        </div>
    </main>
<script src="js/signUp.js" type="module"></script>
<script src="js/navigation.js"></script>
</body>
</html>
