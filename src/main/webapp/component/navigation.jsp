<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mpa.bbs.util.ClientUtil" %>
<%
    String loginUsername = (String) session.getAttribute("loginUsername");
    String loginAccount = (String) session.getAttribute("loginAccount");
%>

<nav>
    <div>
        <div>
            <a class="nav__anchor" href=<%=ClientUtil.getUrls().get("HOME")%>>홈</a>
        </div>
        <div>
            <a class="nav__anchor" href=<%=ClientUtil.getUrls().get("NOTICE")%>>공지사항</a>
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

                <% if (loginUsername ==null){%>
                    <a class="nav__anchor" href=<%=ClientUtil.getUrls().get("LOG_IN")%>>로그인</a>
                    <a class="nav__anchor" href=<%=ClientUtil.getUrls().get("SIGN_UP")%>>회원가입</a>
                <% } else { %>
                    <a>환영합니다 <%=loginUsername%>님</a>
                    <a>|</a>
                    <a href="<%=ClientUtil.getUrls().get("EDIT_PROFILE")%>?id=<%=loginUsername%>">프로필 수정</a>
                    <a>|</a>
                    <a class="nav__anchor" href="<%=ClientUtil.getUrls().get("LOG_OUT")%>?id=<%=loginAccount%>">로그아웃</a>
            <%}%>
        </div>
    </div>
</nav>