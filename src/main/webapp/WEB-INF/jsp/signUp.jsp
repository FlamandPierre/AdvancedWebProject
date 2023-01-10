<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="signUp" /></title>
    </head>
    <body class="mainContainer">
        <h1>Sign up</h1>
        <form:form id="signUp"
                   method="POST"
                   action="/Baxydia/signUp/send"
                   modelAttribute="userForm">
            <form:label path="username"><spring:message code="pseudo" /> : </form:label>
            <form:input path="username" type="text"/>
            <form:errors path="username"/>
            <br>
            <form:label path="password"><spring:message code="password" /> : </form:label>
            <form:input path="password" type="password"/>
            <form:errors path="password"/>
            <br>
            <form:label path="passwordConfirmation"><spring:message code="passwordConfirm" /> : </form:label>
            <form:input path="passwordConfirmation" type="password"/>
            <form:errors path="passwordConfirmation"/>
            <br>
            <form:label path="firstname"><spring:message code="firstname" /> : </form:label>
            <form:input path="firstname" type="text"/>
            <form:errors path="firstname"/>
            <br>
            <form:label path="lastname"><spring:message code="lastname" /> : </form:label>
            <form:input path="lastname" type="text"/>
            <form:errors path="lastname"/>
            <br>
            <form:label path="address"><spring:message code="address" /> : </form:label>
            <form:input path="address" type="text"/>
            <form:errors path="address"/>
            <br>
            <form:label path="phoneNumber"><spring:message code="phoneNumber" /> : </form:label>
            <form:input path="phoneNumber" type="text"/>
            <form:errors path="phoneNumber"/>
            <br>
            <form:label path="birthdate"><spring:message code="birthdate" /> : </form:label>
            <form:input path="birthdate" type="date"/>
            <form:errors path="birthdate"/>
            <br>
            <form:button><spring:message code="submit" /></form:button>
        </form:form>
    </body>
</html>
