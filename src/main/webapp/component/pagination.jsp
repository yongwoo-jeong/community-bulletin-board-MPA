<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pagination">
    <% Integer currentPage = (Integer) request.getAttribute("currentPage");
	   Integer articleCount = (Integer) request.getAttribute("articleCount");
       Integer pageCount = articleCount /10 +1 ; %>

    <% for (int i = 1; i <= pageCount; i++) { %>
        <a class="page-item" href=javascript:paging(<%=i%>) <%=(i == currentPage) ? "style='color:red'" : "" %> ><%=i%></a>
    <% } %>
</div>

<script src="js/pagination.js"></script>
