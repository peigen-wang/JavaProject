<%--
  Created by IntelliJ IDEA.
  User: peigen
  Date: 2020/3/7
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<h2>
    欢迎光临，<br>
    您是本站的第【<%=application.getAttribute("count")%>】${count}位访客！
</h2>

<form method="post" action="upload" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="file1"/>
    <br/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
