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
    <script type="text/javascript" src="${pageContext.request.contextPath}/module/jquery-2.1.0.min.js"></script>
</head>
<body>
<header class="mainheader">
    <h1>TomcatReportsV9.0</h1>
    <h2>Ивайкин Т.С., ПО(м)-21</h2>

</header>

<nav class="panel main">
    <header>
        <h1>Таблицы</h1>
    </header>

    <main>
    </main>
</nav>

<main class="main">
    <iframe id="listPanelFrame" scrolling="no" src="${pageContext.request.contextPath}/discipline/list.html" seamless>
        <!-- //required for browser compatibility -->
    </iframe>
</main>

<section class="main">
    <iframe id="actionPanelFrame" scrolling="no" src="${pageContext.request.contextPath}/discipline/create.html" seamless>
        <!-- //required for browser compatibility -->
    </iframe>
</section>

<footer class="panel">
    ${message}
</footer>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>