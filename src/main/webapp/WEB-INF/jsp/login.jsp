<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body class="mainContainer">
        <h1>Connexion</h1>
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
                <form:button>Login</form:button>
            </form:form>
    </body>
</html>
