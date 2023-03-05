<%@ page import="com.mpa.bbs.vo.ArticleVO" %>
<%@ page import="com.mpa.bbs.vo.FileVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mpa.bbs.vo.CommentVO" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
</head>
<body>
<jsp:include page="component/navigation.jsp"></jsp:include>
<br/>
<%
    ArticleVO article = (ArticleVO) request.getAttribute("targetArticle");
	List<FileVO> fileList = (List<FileVO>) request.getAttribute("fileList");
    String loggedInUser = (String) session.getAttribute("loginUsername");
%>
<div class="container">
    <header class="header">게시판 - 보기</header>
    <div class="writer_time_row">
        <div class="writer_div">
            <span><%=article.getWriter()%></span>
        </div>
        <div>
            <span>등록일시</span>
            <% if (article.getUpdated() == null){%>
            <span><%=article.getCreated()%></span>
            <%} else {%>
            <span><%=article.getCreated()%></span>
            <span>수정일시</span>
            <span><%=article.getUpdated()%></span>
            <%}%>
        </div>
    </div>
    <div class="title_row">
        <div>
            <span>공지사항</span>
            <span><%=article.getTitle()%></span>
        </div>
        <div class="view">
            <span>조회수: </span>
            <span><%=article.getView()%></span>
        </div>
    </div>
    <div class="post_container">
        <p><%=article.getContent()%></p>
    </div>
    <div class="file_container">
        <%
            for (FileVO file : fileList){
        %>
        <div class="file">
            <a>💾</a>
            <a href=/download?board=notice&uuid=<%=file.getUuid()%>>
                <%=file.getNameOriginal()%>
            </a>
        </div>
        <% }%>
    </div>
    <div class="comments_container">
        <%
            List<CommentVO> commentList = (List<CommentVO>) request.getAttribute("commentList");
            for (CommentVO comment : commentList){
        %>
        <div class="comment_row">
            <div class="comment_date"><%=comment.getCreated()%></div>
            <div><%=comment.getContent()%></div>
        </div>
        <% } %>
            <% if (Objects.equals(loggedInUser, null)) {%>
            <div>댓글을 다려면 로그인 해야합니다.</div>
        <% } else { %>
            <jsp:include page="component/commentForm.jsp">
                <jsp:param name="username" value='<%=loggedInUser%>'/>
            </jsp:include>
        <% } %>
    </div>
    <div class="button_set_container">
    </div>
</div>
</body>
</html>
