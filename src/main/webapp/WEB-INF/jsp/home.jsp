<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Baxydia</title>
        <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
    </head>
    <body class="mainContainer">
        <c:forEach items="${categories}" var="category">
            <h1 id="${category.getLabel()}" class="section">${category.getLabel()}</h1>
        </c:forEach>
    </body>
</html>