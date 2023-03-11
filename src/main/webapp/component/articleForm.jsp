<%@ page import="com.mpa.bbs.util.ClientUtil" %>
<%@ page import="com.mpa.bbs.vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // GET 요청 들어온 주소 그대로 POST 요청
  String getURI = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
%>
<form method="post" enctype="multipart/form-data" action=<%=getURI%>>
  <table style="border-collapse: collapse">
    <tr>
      <th>제목*</th>
      <td>
        <input name="title" type="text" />
      </td>
      <td>4~30자</td>
    </tr>
    <tr>
      <th>내용*</th>
      <td>
        <input name="content" type="text" />
      </td>
      <td>10~2000자</td>
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