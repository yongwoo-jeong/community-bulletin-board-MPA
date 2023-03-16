<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mpa.bbs.util.ClientUtil" %>
<%@ page import="com.mpa.bbs.vo.ArticleVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mpa.bbs.vo.UserVO" %>
<%
  List<ArticleVO> articleList = (List<ArticleVO>) request.getAttribute("articleList");
  List<Integer> articleListFileAttached = (List<Integer>) request.getAttribute("articleListFileAttached");
  Boolean isLoginUser = (Boolean) session.getAttribute("isLogin");
  String loginUserName = (String) session.getAttribute("loginUserName");
%>
<html>
<head>
  <jsp:include page="component/title-red-theme.jsp">
    <jsp:param name="titleValue" value='공지사항' />
  </jsp:include>
  <link rel="stylesheet" href="/css/index.css" />
</head>
<body>
<jsp:include page="component/navigation.jsp"></jsp:include>
<main>
<jsp:include page="core-table-style2.jsp"></jsp:include>
</main>
<jsp:include page="component/pagination.jsp"></jsp:include>

<% if (isLoginUser) {%>
<div class="border-1" role="button" onclick="location.href='<%=ClientUtil.getUrls().get("NEW_NOTICE")%>'">글쓰기</div>
<% } %>

<script src="js/navigation.js"></script>
</body>
</html>
