<%@ page import="java.net.URLEncoder" %>
<%@ page import="com.mpa.bbs.util.ClientUtil" %>
<%@ page import="com.mpa.bbs.vo.ArticleVO" %>
<%@ page import="java.util.List" %>
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
      <th>첨부파일</th>
      <th>제목</th>
      <th>글쓴이</th>
      <th>조회수</th>
      <th>등록일</th>
      <th>수정일</th>
    </tr>
    <% List<ArticleVO> articleList = (List<ArticleVO>) request.getAttribute("articleList");
      for (ArticleVO article : articleList) { %>
    <tr>
      <td>✉︎</td>
      <td><%=article.getTitle()%></td>
      <td><%=article.getWriter()%></td>
      <td><%=article.getView()%></td>
      <td><%=article.getCreated()%></td>
      <td><%=article.getUpdated()!=null ? article.getUpdated() : "-"%></td>
    </tr>
      <% } %>
  </table>
</main>
<jsp:include page="component/pagination.jsp"></jsp:include>
<div class="border-1" role="button" onclick="location.href='<%=ClientUtil.getUrls().get("NOTICE")%><%=ClientUtil.getActionUri().get("NEW")%>'" >글쓰기</div>
<script src="js/navigation.js"></script>
</body>
</html>
