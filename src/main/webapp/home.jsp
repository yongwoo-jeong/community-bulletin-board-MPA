<%@ page import="com.mpa.bbs.util.ClientUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="component/title.jsp">
        <jsp:param name="titleValue" value="종합 게시판 - 홈" />
    </jsp:include>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" type="text/css">
</head>
<body>
<jsp:include page="component/navigation.jsp"></jsp:include>
<br/>
<main class="board mx-lg-2">
   <div class="row">
       <section class="board__notice col col-lg">
           <div onclick="location.href='<%=ClientUtil.getUrls().get("NOTICE")%>'" class="section__header bg-secondary text-white h3 ps-2">공지사항</div>
           <div class="article-list__container">
               <table>
                   <tr>
                       <td>
                           <div class="article__info">작성자 조회수 시간</div>
                           <div role="button" class="article__title pointer text-decoration-underline">제목 미리보기</div>
                       </td>
                   </tr>
               </table>
           </div>
       </section>
       <section class="board__general col">
           <div class="section__header">자유게시판</div>
       </section>
   </div>
    <div class="row">
        <section class="board__library col">
            <div class="section__header">자료실</div>
        </section>
        <section class="board__gallery col">
            <div class="section__header">갤러리</div>
        </section>
    </div>
</main>
<footer></footer>
<br/>
<script src="./js/navigation.js"></script>
</body>
</html>