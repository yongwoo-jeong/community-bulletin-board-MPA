<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="component/title.jsp">
        <jsp:param name="titleValue" value='<%=URLEncoder.encode("종합 게시판 - 홈", "UTF-8") %>' />
    </jsp:include>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" type="text/css">
</head>
<body>
<jsp:include page="component/navigation.jsp"></jsp:include>
<br/>

<main class="board">

<%--    <% String headerTitle = "홈페이지";%>--%>
    <section class="board__notice">
        <div class="section__header">공지사항</div>
        <div class="article-list__container">
            <table>
                <tr>
                    <td>
                        <div class="article__info">작성자 조회수 시간</div>
                        <div class="article__title">제목 미리보기</div>
                    </td>
                </tr>
            </table>
        </div>
    </section>
    <section class="board__general">
        <div class="section__header">자유게시판</div>
    </section>
    <section class="board__library">
        <div class="section__header">자료실</div>
    </section>
    <section class="board__gallery">
        <div class="section__header">갤러리</div>
    </section>
</main>
<footer></footer>
<br/>
<script src="./js/navigation.js"></script>
<script src="./js/home.js"></script>
</body>
</html>