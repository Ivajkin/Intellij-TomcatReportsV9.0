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

<body class="invisibleBackground">

<div class="panel">
    <header>
        <h1>Отчет</h1>
    </header>

    <main>
        <p>Здесь вы можете открыть отчет преподавателя кафедры за семестр.</p>

        <form:form method="POST" action="/report/list" commandName="reportSelectForm">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>

                <tr>
                    <td>Поток:</td>
                    <td><form:select path="sem">
                        <form:option value="NONE" label="--- выберите ---" />
                        <form:options items="${semesterList}" />
                    </form:select>
                    </td>
                    <td><form:errors path="sem" cssClass="error" /></td>
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


    </main>
</div>

</body>
</html>