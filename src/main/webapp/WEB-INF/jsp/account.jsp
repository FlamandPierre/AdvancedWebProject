<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<html>
<head>
    <title><spring:message code="account" /></title>
</head>
<body class="mainContainer">
<div class="customerData">
    <p><spring:message code="pseudo" /> : ${currentUser.username}</p>
    <p><spring:message code="firstname" /> : ${currentUser.firstname}</p>
    <p><spring:message code="lastname" /> : ${currentUser.lastname}</p>
    <p><spring:message code="address" /> : ${currentUser.address}</p>
    <p><spring:message code="phoneNumber" /> : ${currentUser.phoneNumber}</p>
</div>

<div>
    <p><spring:message code="loyalityPoints" /> ${currentUser.loyaltyPoints} <spring:message code="points" /></p>
</div>

</body>
</html>

