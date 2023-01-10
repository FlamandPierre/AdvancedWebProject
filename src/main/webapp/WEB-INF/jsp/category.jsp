<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${label}</title>
        <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
    </head>
    <body class="mainContainer">
        <div class="homeBoardGames">
            <c:forEach items="${category.getBoardGames()}" var="boardGame">
                <div class="homeItemContainer">
                    <p class="homeItemName">Nom : ${boardGame.getName()}</p>
                    <p class="homeItemPrice">Prix : ${boardGame.getPrice()} €</p>
                    <a class="homeItemButtonLink" href="<spring:url value="/item?name=${boardGame.getName()}"/>">
                        <div class="homeItemButton">
                            <p class="homeItemButtonTitle">Détails</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
