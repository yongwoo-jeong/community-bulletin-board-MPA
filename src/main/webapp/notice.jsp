<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="component/title.jsp">
    <jsp:param name="titleValue" value='공지사항' />
  </jsp:include>
  <link rel="stylesheet" href="/css/index.css" />
</head>
<body>
<jsp:include page="component/navigation.jsp"></jsp:include>
<main>
<%--TODO 리스트 / 갤러리형 컴포넌트로 불러와서 파라미터 값에 따라 보여주기/숨기기  --%>
  <table style="border-collapse: collapse">
    <tr>
      <th>카테고리</th>
      <th>첨부파일</th>
      <th>제목</th>
      <th>글쓴이</th>
      <th>조회수</th>
      <th>등록일</th>
      <th>수정일</th>
    </tr>
    <tr>
      <td>카테고리</td>
      <td>✉︎</td>
      <td>제목</td>
      <td>글쓴이</td>
      <td>조회수</td>
      <td>등록일</td>
      <td>수정일</td>
    </tr>
  </table>
</main>
<script src="js/navigation.js"></script>
</body>
</html>
