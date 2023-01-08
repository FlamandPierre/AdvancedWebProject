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
                    <th>Supprimer</th>
                </tr>
                <c:forEach items="${order.items.values()}" var="item">
                    <tr>
                        <td>${item.boardgame.name}</td>
                        <td>${item.boardgame.price} €</td>
                        <td>
                            <form:form method="POST" action="/checkout/changeQuantity" modelAttribute="checkoutItem">
                                <form:input path="boardgame.name" value="${item.boardgame.name}" class="d-none"/>
                                <form:input path="quantity" value="${item.quantity}" onchange="submit()" type="number"/>
                            </form:form>
                        </td>
                        <td>${item.price} €</td>
                        <td><a href="<spring:url value="/checkout/delete/${item.boardgame.name}"/>">Supprimer</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>Total</td>
                    <td></td>
                    <td></td>
                    <td>${order.getTotal()} €</td>
                    <td></td>
                </tr>
            </table>
            <c:choose>
                <c:when test="${!order.getItems().isEmpty()}">
                    <a href="<spring:url value="/payment"/>">
                        <div class="checkoutPurchase">
                            <p class="checkoutPurchasePara">Procéder au paiement</p>
                        </div>
                    </a>
                </c:when>
                <c:otherwise>
                    <div class="checkoutPurchase checkoutPurchaseNotActive">
                        <p class="checkoutPurchasePara">Panier vide</p>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
