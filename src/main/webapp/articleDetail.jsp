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
    // 대상 게시글
    ArticleVO article = (ArticleVO) request.getAttribute("targetArticle");
    // 첨부된 파일리스트
    List<FileVO> fileList = (List<FileVO>) request.getAttribute("fileList");
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
            <a href=${pageContext.request.contextPath}/download?board=notice&uuid=<%=file.getUuid()%>>
                <%=file.getNameOriginal()%>
            </a>
        </div>
        <% }%>
    </div>
    <jsp:include page="component/comment.jsp" ></jsp:include>
    <div class="button_set_container"></div>
</div>
</body>
</html>
