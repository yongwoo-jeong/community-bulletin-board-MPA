<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="version.mpa.bbs.util.ViewUtil" %>

<nav>
    <div>
        <div>
            <a class="nav__anchor" href=<%=ViewUtil.getUrls().get("HOME")%>>홈</a>
        </div>
        <div>
            <a class="nav__anchor" href=<%=ViewUtil.getUrls().get("NOTICE")%>>공지사항</a>
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
            <%  String loggedInUser = (String) session.getAttribute("loginUsername");
                if (loggedInUser==null){%>
                    <a class="nav__anchor" href=<%=ViewUtil.getUrls().get("LOG_IN")%>>로그인</a>
                    <a class="nav__anchor" href=<%=ViewUtil.getUrls().get("SIGN_UP")%>>회원가입</a>
                <% } else { %>
                    <a>환영합니다 <%=loggedInUser%>님</a>
                    <a>|</a>
                    <a href="<%=ViewUtil.getUrls().get("EDIT_PROFILE")%>?id=<%=loggedInUser%>">프로필 수정</a>
                    <a>|</a>
                    <a class="nav__anchor" href="<%=ViewUtil.getUrls().get("LOG_OUT")%>?id=<%=loggedInUser%>">로그아웃</a>
            <%}%>
        </div>
    </div>
</nav>