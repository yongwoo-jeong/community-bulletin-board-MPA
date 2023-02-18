<%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2023/02/18
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <td class="">비밀번호와 동일하게 설정</td>
    </tr>
    <tr class="nameRow">
      <th>이름</th>
      <td><input type="text" name="name"/></td>
      <td class="">한글 3~4자</td>
    </tr>
    <tr class="emailRow">
      <th>이메일</th>
      <td><input type="email" name="email"/></td>
      <td class="">올바른 이메일 형식</td>
    </tr>
  </table>
  <input type="submit" value="완료" />
</form>
