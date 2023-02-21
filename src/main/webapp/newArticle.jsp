<%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2023/02/21
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <table style="border-collapse: collapse">
        <tr>
            <th>카테고리*</th>
            <td>
                <label for="category"></label>
                <select name="categoryId" id="category" @change="selectCategory">
                    <option></option>
                </select>
            </td>
        </tr>
        <tr>
            <th>작성자*</th>
            <td>
                <input />
            </td>
        </tr>
        <tr>
            <th>비밀번호*</th>
            <td>
                <input type="password" placeholder="비밀번호" />
                <input type="password" placeholder="비밀번호 확인" />
            </td>
        </tr>
        <tr>
            <th>제목*</th>
            <td>
                <input />
            </td>
        </tr>
        <tr>
            <th>내용*</th>
            <td>
                <input />
            </td>
        </tr>
        <tr>
            <th>파일 첨부</th>
            <td>
                <input type="file" id="file1" />
                <input type="file" id="file2" />
                <input type="file" id="file3" />
            </td>
        </tr>
    </table>
</main>
</body>
</html>
