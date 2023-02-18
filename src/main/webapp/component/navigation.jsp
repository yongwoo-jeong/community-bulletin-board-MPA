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
            <%  String loggedInUser = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("loginAccount") && cookie.getValue() != null) {
                            loggedInUser = cookie.getValue();
                        }
                    }
                }
            if (loggedInUser==null){%>
            <a class="nav__anchor" href="/login">로그인</a>
            <a class="nav__anchor" href="/signup">회원가입</a>
            <% } else { %>
            <a>환영합니다 <%=loggedInUser%>님</a>
            <a>|</a>
            <a href="/edit-profile?id=<%=loggedInUser%>">프로필 수정</a>
            <a>|</a>
            <a class="nav__anchor" href="/logout?id=<%=loggedInUser%>">로그아웃</a>
            <%}%>
        </div>
    </div>
</nav>
