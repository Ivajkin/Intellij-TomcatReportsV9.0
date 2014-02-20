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
        <h1>Отчет</h1>
    </header>

    <main>
        <p>Здесь вы можете открыть отчет преподавателя кафедры за семестр, добавлять записи.</p>

        <form:form method="POST" commandName="customerForm">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>

                <tr>
                    <td>Поток:</td>
                    <td><form:select path="semester">
                        <form:option value="NONE" label="--- выберите ---" />
                        <form:options items="${semesterList}" />
                    </form:select>
                    </td>
                    <td><form:errors path="country" cssClass="error" /></td>
                </tr>
                <tr>
                    department
                    teacher
                </tr>

                <tr>
                    <td colspan="3">Дальше <input type="submit" /></td>
                </tr>
            </table>
        </form:form>

        <div class="iDemandPancakeTableStyle">
            <table border="1px" cellpadding="0" cellspacing="0" >
                <thead>
                <tr>
                    <th>Поток</th>
                    <th>Дисциплина</th>
                    <th>Тестовые данные (data__test)</th>
                    <th>действия</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="reportEntry" items="${reportEntries}">
                    <tr>
                        <td>
                            ${reportEntry.flow.name}
                        </td>
                        <td>
                            ${reportEntry.disc.name}
                        </td>
                        <td>
                            ${reportEntry.data__test}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/report/delete/${dictionaryItem.id}.html">Удалить (-)</a><br/>
                            <a href="${pageContext.request.contextPath}/report/edit/${dictionaryItem.id}.html">Изменить</a><br/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <button>Сформировать отчет <!-- TODO: сформировать отчет JasperReports --> </button>

    </main>
</div>

</body>
</html>