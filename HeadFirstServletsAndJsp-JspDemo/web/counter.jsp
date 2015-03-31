<%@ page import="chapter6.Counter" %>
<%--
  Created by IntelliJ IDEA.
  User: wyzhangdongsheng1
  Date: 2014/9/23
  Time: 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head
<body>
    Counter:<%
        out.println(chapter6.Counter.getCount());
    %>
<%=Counter.getCount()%>
</body>
</html>
