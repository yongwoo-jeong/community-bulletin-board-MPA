<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mpa.bbs.util.ClientUtil" %>
<%@ page import="com.mpa.bbs.vo.ArticleVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mpa.bbs.vo.UserVO" %>
<%
  List<ArticleVO> articleList = (List<ArticleVO>) request.getAttribute("articleList");
  List<Integer> articleListFileAttached = (List<Integer>) request.getAttribute("articleListFileAttached");
  UserVO loginAccount = (UserVO) session.getAttribute("loginUser");
%>
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
  <span>총 <%=request.getAttribute("articleCount")%>건</span>
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
      <% for (ArticleVO article : articleList) { %>
    <tr>
      <%-- 파일 첨부 게시글 ID 리스트에 포함될 경우 아이콘 표시      --%>
      <% if (articleListFileAttached.contains(article.getId())){ %>
      <td>💾</td>
      <% } else  { %>
      <td></td>
      <% } %>
      <td><a href="/noticeDetail?id=<%=article.getId()%>"><%=article.getTitle()%></a></td>
      <td><%=article.getWriter()%></td>
      <td><%=article.getView()%></td>
      <td><%=article.getCreated()%></td>
      <td><%=article.getUpdated()!=null ? article.getUpdated() : "-"%></td>
    </tr>
      <% } %>
  </table>
</main>
<jsp:include page="component/pagination.jsp"></jsp:include>

<% if (loginAccount != null) {%>
<div class="border-1" role="button" onclick="location.href='<%=ClientUtil.getUrls().get("NEW_NOTICE")%>'">글쓰기</div>
<% } %>

<script src="js/navigation.js"></script>
</body>
</html>
