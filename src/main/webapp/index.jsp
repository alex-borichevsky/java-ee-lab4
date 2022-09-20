<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"></script>

</head>

<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class=" mx-auto navbar-brand" href="#"><fmt:message key="label.main"/></a>
    </div>
</nav>
<div content="container-lg">
    <div class="row mt-5">
        <div class="col-4"></div>
        <div class="col-4 d-flex justify-content-center">
            <form>
                <button type="submit" class="btn btn-primary" name="action" value="count"> Count</button>
                <c:if test="${count !=null}">
                    <p class="text-center text-success">${count}</p>
                </c:if>
            </form>
        </div>
        <div class="col-4"></div>
    </div>
    <a href="${pageContext.servletContext.contextPath}/start?lang=ru">Русский</a>
    <a href="${pageContext.servletContext.contextPath}/start">English</a>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <td><fmt:message key="column.id"/></td>
                <td>First name</td>
                <td>Last name</td>
                <td>Course</td>
                <td>Group</td>
                <td>isVillager</td>
                <td>AvgMark</td>
            </tr>
            </thead>
            <jsp:useBean id="students" scope="request" type="java.util.List"/>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.firstname}</td>
                    <td>${student.lastname}</td>
                    <td>${student.course}</td>
                    <td>${student.group}</td>
                    <c:if test="${student.villager == true}">
                        <td><input type="checkbox" checked disabled></td>
                    </c:if>
                    <c:if test="${student.villager == false}">
                        <td><input type="checkbox" disabled></td>
                    </c:if>
                    <td>${student.avgMark}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>