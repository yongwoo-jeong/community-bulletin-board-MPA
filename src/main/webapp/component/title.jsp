<%@ page import="java.net.URLDecoder" %>

<title><%=URLDecoder.decode(request.getParameter("titleValue"), "UTF-8")%></title>