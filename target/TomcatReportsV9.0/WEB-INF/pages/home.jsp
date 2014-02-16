<%--
  User: Ivaykin Timofey
  Date: 2/12/14
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Домашняя страница</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<header>
    <h1>TomcatReportsV9.0</h1>
    <h2>Ивайкин Т.С., ПО(м)-21</h2>

</header>

<nav class="panel">
    ${message}<br/>
    <a href="${pageContext.request.contextPath}/discipline/create.html">Добавить новую дисциплину</a><br/>
    <a href="${pageContext.request.contextPath}/discipline/list.html">Список дисциплин</a><br/>

    <br/>

    <a href="${pageContext.request.contextPath}/teacher/create.html">Добавить преподавателя</a><br/>
    <a href="${pageContext.request.contextPath}/teacher/list.html">Список преподавателей</a><br/>
</nav>
<main class="panel">
    <iframe scrolling="no" src="${pageContext.request.contextPath}/discipline/list.html" seamless/>
</main>

</body>
</html>