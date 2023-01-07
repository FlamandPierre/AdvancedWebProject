<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Baxydia - Panier</title>
        <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
    </head>
    <body class="mainContainer">
        <div class="checkoutIntroduction">
            <p class="checkoutTitle">Panier</p>
        </div>
        <div class="checkoutBasket">
            <p class="checkoutBasketTitle">Votre liste d'article(s) : </p>
            <table class="checkoutTable">
                <tr>
                    <th>Nom</th>
                    <th>Prix unitaire</th>
                    <th>Quantité</th>
                    <th>Prix</th>
                </tr>
                <c:forEach items="${order.getItems().values()}}" var="item">
                    <tr>
                        <td>${item.price}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
    </body>
</html>
