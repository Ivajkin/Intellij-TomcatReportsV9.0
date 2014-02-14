<%--
  User: Ivaykin Timofey
  Date: 2/12/14
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Домашняя страница</title>
</head>
<body>
<h1>Домашняя страница</h1>
<p>
    ${message}<br/>
    <a href="${pageContext.request.contextPath}/discipline/create.html">Добавить новый элемент</a><br/>
    <a href="${pageContext.request.contextPath}/discipline/list.html">Список дисциплин</a><br/>
</p>
</body>
</html>