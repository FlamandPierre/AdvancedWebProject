<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Baxydia - <spring:message code="cart" /></title>
        <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
    </head>
    <body class="mainContainer">
        <div class="checkoutIntroduction">
            <p class="checkoutTitle"><spring:message code="cart" /></p>
        </div>
        <p class="checkoutSuccessMessage">${successMessage}</p>
        <p class="checkoutCancelMessage">${cancelMessage}</p>
        <div class="checkoutBasket">
            <p class="checkoutBasketTitle"><spring:message code="textCart" /></p>
            <table class="checkoutTable">
                <tr>
                    <th><spring:message code="name" /></th>
                    <th><spring:message code="unitPrice" /></th>
                    <th><spring:message code="quantity" /></th>
                    <th><spring:message code="price" /></th>
                    <th><spring:message code="delete" /></th>
                </tr>
                <c:forEach items="${cart.items.values()}" var="item">
                    <tr>
                        <td>${item.item.name}</td>
                        <td>${item.item.unitPrice} €</td>
                        <td>
                            <form:form method="POST" action="/Baxydia/checkout/changeQuantity" modelAttribute="orderLine">
                                <form:input path="item.name" type="hidden" value="${item.item.name}"/>
                                <form:input path="quantity" class="checkoutChangeQuantity" value="${item.quantity}" onchange="submit()" type="number"/>
                            </form:form>
                        </td>
                        <td>${item.getTotal()} €</td>
                        <td><a href="<spring:url value="/checkout/delete/${item.item.name}"/>"><spring:message code="delete" /></a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><spring:message code="total" /></td>
                    <td></td>
                    <td></td>
                    <td>${cart.getTotal()} €</td>
                    <td></td>
                </tr>
            </table>
            <c:choose>
                <c:when test="${!cart.getItems().isEmpty()}">
                    <a href="<spring:url value="/payment"/>" class="checkoutLink">
                        <div class="checkoutPurchase">
                            <p class="checkoutPurchasePara"><spring:message code="payButton" /></p>
                        </div>
                    </a>
                </c:when>
                <c:otherwise>
                    <div class="checkoutPurchase checkoutPurchaseNotActive">
                        <p class="checkoutPurchasePara"><spring:message code="emptyCart" /></p>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
