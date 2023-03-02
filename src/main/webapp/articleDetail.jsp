<%@ page import="com.mpa.bbs.vo.ArticleVO" %>
<%@ page import="com.mpa.bbs.vo.FileVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mpa.bbs.vo.CommentVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArticleVO article = (ArticleVO) request.getAttribute("targetArticle");
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
<%--    <div class="file_container">--%>
<%--        <%--%>
<%--            List<FileVO> FileList = (List<FileVO>) request.getAttribute("fileList");--%>
<%--            for (FileVO file : FileList){--%>
<%--        %>--%>
<%--        <div class="file">--%>
<%--            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">--%>
<%--                <path stroke-linecap="round" stroke-linejoin="round" d="M3 16.5v2.25A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75V16.5M16.5 12L12 16.5m0 0L7.5 12m4.5 4.5V3" />--%>
<%--            </svg>--%>
<%--            <a href=/download?fileId=<%=file.getUuid()%>>--%>
<%--                <%=file.getNameOriginal()%>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--        <% }%>--%>
<%--    </div>--%>
<%--    <div class="comments_container">--%>
<%--        <%--%>
<%--            List<CommentVO> commentList = (List<CommentVO>) request.getAttribute("commentList");--%>
<%--            for (CommentVO comment : commentList){--%>
<%--        %>--%>
<%--        <div class="comment_row">--%>
<%--            <div class="comment_date"><%=comment.getCreated()%></div>--%>
<%--            <div><%=comment.getContent()%></div>--%>
<%--        </div>--%>
<%--        <% } %>--%>
        <div>
            <form method="post" action=/addComment?<%=request.getQueryString()%> name="uploadComment">
                <input name="content" class="comment_input" type="text" placeholder="댓글을 입력해주세요" />
                <input type="submit" class="save_button" value="저장" />
            </form>
        </div>
    </div>
    <div class="button_set_container">
    </div>
</div>
</body>
</html>
