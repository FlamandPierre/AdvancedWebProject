<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign up</title>
    </head>
    <body class="mainContainer">
        <h1>Sign up</h1>
        <form:form id="signUp"
                   method="POST"
                   action="/Baxydia/signUp/send"
                   modelAttribute="userForm">
            <form:label path="username">Email : </form:label>
            <form:input path="username" type="text"/>
            <form:errors path="username"/>
            <br>
            <form:label path="password">Password : </form:label>
            <form:input path="password" type="password"/>
            <form:errors path="password"/>
            <br>
            <form:label path="passwordConfirmation">Password confirmation : </form:label>
            <form:input path="passwordConfirmation" type="password"/>
            <form:errors path="passwordConfirmation"/>
            <br>
            <form:label path="firstname">Firstname : </form:label>
            <form:input path="firstname" type="text"/>
            <form:errors path="firstname"/>
            <br>
            <form:label path="lastname">Lastname : </form:label>
            <form:input path="lastname" type="text"/>
            <form:errors path="lastname"/>
            <br>
            <form:label path="address">Address : </form:label>
            <form:input path="address" type="text"/>
            <form:errors path="address"/>
            <br>
            <form:label path="phoneNumber">Phone number : </form:label>
            <form:input path="phoneNumber" type="text"/>
            <form:errors path="phoneNumber"/>
            <br>
            <form:label path="birthdate">Birthdate : </form:label>
            <form:input path="birthdate" type="date"/>
            <form:errors path="birthdate"/>
            <br>
            <form:button>Submit</form:button>
        </form:form>
    </body>
</html>
