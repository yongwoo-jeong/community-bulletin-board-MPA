<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>

<%--<title><%=URLDecoder.decode(request.getParameter("titleValue"), "UTF-8")%></title>--%>
<nav>
    <div>
        <div>
            <a class="nav__anchor" href="/home">홈</a>
        </div>
        <div>
            <a class="nav__anchor" href="/notice">공지사항</a>
        </div>
        <div>
            <a class="nav__anchor" href="/general">자유게시판</a>
        </div>
        <div>
            <a class="nav__anchor" href="/gallery">갤러리</a>
        </div>
    </div>
    <div>
        <div>
            <a class="nav__anchor" href="/login">로그인</a>
            <a class="nav__anchor" href="/signup">회원가입</a>
        </div>
    </div>
</nav>
