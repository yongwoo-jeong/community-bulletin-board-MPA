<%@ page import="com.mpa.bbs.vo.ArticleVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%
        ArticleVO article = (ArticleVO) request.getAttribute("targetArticle");
		String username = request.getParameter("username");
        Integer boardId = article.getBoardId();
        Integer articleId = article.getId();
    %>
    <form method="post" action=/comment.new?board=<%=boardId%>&id=<%=articleId%> name="uploadComment">
        <input name="content" class="comment_input" type="text" placeholder="댓글을 입력해주세요" />
        <input name="username" type="hidden" value=<%=username%> />
        <input type="submit" class="save_button" value="저장" />
    </form>
</div>