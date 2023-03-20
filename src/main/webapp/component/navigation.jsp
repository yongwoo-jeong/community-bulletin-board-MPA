<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mpa.bbs.vo.UserVO" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.Bool" %>
<%@ page import="com.mpa.bbs.controller.URL" %>
<%
    Boolean isLogin = (Boolean) session.getAttribute("isLoginUser");
    String loginAccount = (String) session.getAttribute("loginUserAccount");
	String loginUserName = (String) session.getAttribute("loginUserName");
%>

<nav>
    <div>
        <div>
            <a class="nav__anchor" href=<%=URL.HOME.getUrl()%>>홈</a>
        </div>
        <div>
            <a class="nav__anchor" href=<%=URL.NOTICE.getUrl()%>>공지사항</a>
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

                <% if (isLogin == null || !isLogin){%>
                    <a class="nav__anchor" href=<%=URL.LOGIN.getUrl()%>>로그인</a>
                    <a class="nav__anchor" href=<%=URL.SIGNUP%>>회원가입</a>
                <% } else { %>
                    <a>환영합니다 <%=loginUserName%>님</a>
                    <a>|</a>
                    <a href="<%=URL.EDIT_PROFILE%>?id=<%=loginUserName%>">프로필 수정</a>
                    <a>|</a>
                    <a class="nav__anchor" href="<%=URL.LOGOUT.getUrl()%>?id=<%=loginAccount%>">로그아웃</a>
            <%}%>
        </div>
    </div>
</nav>