<%--
  User: Ivaykin Timofey
  Date: 2/20/14
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body class="invisibleBackground">

<div class="panel">
    <header>
        <h1>Создать запись отчета</h1>
    </header>

    <main>
        <p>Здесь вы можете добавлять записи в отчет преподавателя кафедры за семестр.</p>

        <form:form method="POST" action="${pageContext.request.contextPath}/report/create/process" commandName="reportSelectForm">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>

                <tr>
                    <td>Семестр:</td>
                    <td><form:select path="sem.id">
                        <form:option value="NONE" label="--- выберите ---" />
                        <form:options items="${semesterList}" itemValue="id" itemLabel="name" />
                    </form:select>
                    </td>
                    <td><form:errors path="sem" cssClass="error" /></td>
                </tr>

                <tr>
                    <td>Кафедра:</td>
                    <td><form:select path="dept.id">
                        <form:option value="NONE" label="--- выберите ---" />
                        <form:options items="${departmentList}" itemValue="id" itemLabel="name" />
                    </form:select>
                    </td>
                    <td><form:errors path="dept" cssClass="error" /></td>
                </tr>

                <tr>
                    <td>Преподаватель:</td>
                    <td><form:select path="teacher.id">
                        <form:option value="NONE" label="--- выберите ---" />
                        <form:options items="${teacherList}" itemValue="id" itemLabel="name" />
                    </form:select>
                    </td>
                    <td><form:errors path="teacher" cssClass="error" /></td>
                </tr>

                <tr>
                    <td>Дисциплина:</td>
                    <td><form:select path="disc.id">
                        <form:option value="NONE" label="--- выберите ---" />
                        <form:options items="${disciplineList}" itemValue="id" itemLabel="name" />
                    </form:select>
                    </td>
                    <td><form:errors path="disc" cssClass="error" /></td>
                </tr>

                <tr>
                    <td>Поток:</td>
                    <td><form:select path="flow.id">
                        <form:option value="NONE" label="--- выберите ---" />
                        <form:options items="${flowList}" itemValue="id" itemLabel="name" />
                    </form:select>
                    </td>
                    <td><form:errors path="flow" cssClass="error" /></td>
                </tr>

                <tr>
                    <td>data__test:</td>
                    <td><form:input path="data__test"></form:input>
                    </td>
                    <td><form:errors path="data__test" cssClass="error" /></td>
                </tr>

                <tr>
                    <td colspan="3">Добавить: <input type="submit" /></td>
                </tr>
            </table>
        </form:form>


    </main>
</div>

</body>
</html>