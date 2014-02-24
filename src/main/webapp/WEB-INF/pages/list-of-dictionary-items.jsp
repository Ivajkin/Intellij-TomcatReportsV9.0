<%--
  User: Ivaykin Timofey
  Date: 2/12/14
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Список дисциплин</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body class="invisibleBackground">

<div class="panel">
    <header>
        <h1>${panelHeaderInfo}</h1>
    </header>

    <main>
        <p>${panelDescriptionInfo}</p>
        <div class="iDemandPancakeTableStyle">
            <table border="1px" cellpadding="0" cellspacing="0" >
                <thead>
                <tr>
                    <!--<th width="10%">id</th>--><th>наименование</th><!--<th width="10%">rating</th>-->
                    <th>действия</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dictionaryItem" items="${dictionaryItems}">
                    <tr>
                        <td>
                            ${dictionaryItem.name}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}${dictionaryTypePath}/delete/${dictionaryItem.id}.html">Удалить (-)</a><br/>
                            <a href="${pageContext.request.contextPath}${dictionaryTypePath}/edit/${dictionaryItem.id}.html">Изменить</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>



    </main>
</div>

</body>
</html>