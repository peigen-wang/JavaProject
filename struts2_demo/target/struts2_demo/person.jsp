<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: peigen
  Date: 2020/3/12
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人人</title>
</head>
<body>
<s:form action="personAction" method="POST">
    <s:textfield name="name" label="姓名"></s:textfield>
    <s:radio list="#{1:'男',0:'女'}" name="sex" label="性别"></s:radio>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>
