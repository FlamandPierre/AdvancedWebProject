<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
  <head>
    <title>Baxidia - ${item.name}</title>
    <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
  </head>
  <body class="mainContainer">
    <div class="itemContainer">
      <p class="itemName">Nom de l'article : ${item.name}</p>
      <p class="itemDescriptionTitle">Description de l'article :</p>
      <p class="itemDescription">${item.description}</p>
      <p class="itemPriceTitle">Prix de l'article :</p>
      <p class="itemPrice">${item.unitPrice} €</p>
      <div class="itemForm">
        <form:form method="POST" action="/Baxydia/item/addItem" modelAttribute="newItem">
          <form:input path="item.id" type="hidden" value="${item.id}" />
          <form:input path="item.name" type="hidden" value="${item.name}" />
          <form:input path="item.description" type="hidden" value="${item.description}" />
          <form:input path="item.unitPrice" type="hidden" value="${item.unitPrice}" />
          <form:input path="item.categoryId" type="hidden" value="${item.categoryId}" />
          <form:label path="quantity">Quantité d'article</form:label>
          <br/>
          <form:input path="quantity" class="itemNumberInput" value="1" type="number" />
          <form:errors path="quantity" class="errorMessage" /><br/>
          <form:button type="submit" class="itemFormSubmit"><span class="itemAddButton">Ajouter au panier</span></form:button>
        </form:form>
      </div>
    </div>
  </body>
</html>
