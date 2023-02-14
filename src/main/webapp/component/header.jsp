<%@ page import="java.net.URLDecoder" %>

<%=URLDecoder.decode(request.getParameter("headerValue"), "UTF-8")%>