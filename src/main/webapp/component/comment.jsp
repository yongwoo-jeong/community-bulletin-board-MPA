<%@ page import="com.mpa.bbs.vo.ArticleVO" %>
<%@ page import="com.mpa.bbs.vo.CommentVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 댓글 대상 게시글
    ArticleVO article = (ArticleVO) request.getAttribute("targetArticle");
    // 게시판 타입
    Integer boardId = article.getBoardId();
    Integer articleId = article.getId();
    // 로그인 유저명
    String loggedInUser = (String) session.getAttribute("loginUsername");
%>
<div class="comments_container">
    <%
        List<CommentVO> commentList = (List<CommentVO>) request.getAttribute("commentList");
        for (CommentVO comment : commentList) {
    %>
    <div class="comment_row">
        <div class="comment_date"><%=comment.getCreated()%>
        </div>
        <div><%=comment.getContent()%>
        </div>
    </div>
    <% } %>
    <% if (Objects.equals(loggedInUser, null)) {%>
    <input type="text" disabled placeholder="먼저 로그인 해야합니다" />
    <% } else { %>
    <div>
        <form method="post" action=/comment.new?board=<%=boardId%>&id=<%=articleId%>
              name="uploadComment">
            <input name="content" class="comment_input" type="text" placeholder="댓글을 입력해주세요"/>
            <input name="username" type="hidden" value=<%=loggedInUser%>/>
            <input type="submit" class="save_button" value="저장"/>
        </form>
    </div>
</div>
<% } %>