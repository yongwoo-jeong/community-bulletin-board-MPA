<%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2023/02/10
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <header>회원가입</header>
    <main>
        <div>
            <form method="post" action="${pageContext.request.contextPath}/signup">
                <table style="border-collapse: collapse">
                    <caption></caption>
                    <tr>
                        <th>아이디</th>
                        <td><input type="text" name="account"/></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인</th>
                        <td><input type="password" name="passwordConfirm"/></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="email" name="email"/></td>
                    </tr>
                </table>
                <input type="submit" value="완료" />
            </form>
        </div>
    </main>
</body>
</html>
