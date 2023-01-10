<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<html>
<head>
    <title>Compte</title>
</head>
<body class="mainContainer">
<div class="customerData">
    <p>Pseudo: ${currentUser.username}</p>
    <p>Nom : ${currentUser.firstname}</p>
    <p>Prénom : ${currentUser.lastname}</p>
    <p>Adresse : ${currentUser.address}</p>
    <p>Numéro de téléphone : ${currentUser.phoneNumber}</p>
</div>

<div>
    <p>Vous avez : ${currentUser.loyaltyPoints} points</p>
</div>

</body>
</html>

