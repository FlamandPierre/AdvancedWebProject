<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="login" /></title>
    </head>
    <body class="mainContainer">
        <h1><spring:message code="login" /></h1>
            <form:form
            method="post"
            action=""
            modelAttribute="user">
                <br>
                    <form:input path="username" placeholder="email" type="text"/>
                    <form:errors path="username"/>
                <br>
                    <form:input path="password" placeholder="password" type="password"/>
                    <form:errors path="password"/>
                <br>
                <form:button><spring:message code="login" /></form:button>
            </form:form>
    </body>
</html>
