<%@ page import="com.mpa.bbs.util.ClientUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <form method="post" enctype="multipart/form-data" action=<%=ClientUtil.getUrls().get("NEW_NOTICE")%>>
        <table style="border-collapse: collapse">
            <tr>
                <th>카테고리*</th>
                <td>
                    <%--                <label for="category"></label>--%>
                    <%--                <select name="categoryId" id="category">--%>
                    <%--                    <% String[] categories = (String[]) request.getAttribute("categories");--%>
                    <%--					for (String category : categories) { %>--%>
                    <%--						<option><%=category%></option>--%>
                    <%--                    <%}%>--%>
                    <%--                </select>--%>
                </td>
            </tr>
            <tr>
                <th>작성자*</th>
                <td>
                    <input type="text" name="writer" />
                </td>
            </tr>
            <tr>
                <th>제목*</th>
                <td>
                    <input name="title" type="text" />
                </td>
            </tr>
            <tr>
                <th>내용*</th>
                <td>
                    <input name="content" type="text" />
                </td>
            </tr>
            <tr>
                <th>파일 첨부</th>
                <td>
                    <input type="file" name="file1" />
                    <input type="file" name="file2"/>
                    <input type="file" name="file3"/>
                </td>
            </tr>
        </table>
        <div>
            <input type="submit" />
        </div>
    </form>
</main>
</body>
</html>
