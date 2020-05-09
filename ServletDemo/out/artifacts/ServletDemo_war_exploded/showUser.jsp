<%--
  Created by IntelliJ IDEA.
  User: peigen
  Date: 2020/3/8
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.listener.*" %>
<%@ page import="com.listener.UserInfoList" %>
<%@ page import="com.listener.MyContentListener" %>
<%@ page import="java.util.Vector" %>
<%
    UserInfoList list = UserInfoList.getInstance();
    MyContentListener ml = new MyContentListener();
    String name = request.getParameter("user");
    ml.setUser(name);
    session.setAttribute("list", list);
    list.addUserInfo(ml.getUser());
    session.setMaxInactiveInterval(10);
%>
<html>
<head>
    <title>监听在线人数</title>
</head>
<body>
<textarea rows="8" cols="20"></textarea>
<%
    Vector vector = list.getlist();
    if (vector != null && vector.size() > 0) {
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.elementAt(i));
        }
    }
%>
</body>
</html>
