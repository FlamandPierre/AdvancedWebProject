<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<!DOCTYPE html>
<html>
<head>
  <title>Baxydia - <spring:message code="payment" /></title>
  <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
</head>
  <body class="mainContainer">
    <p class="paymentPrice">Prix à payer : ${total} €</p>
    <div class="paymentPayButton">
      <form method="post" action="https://www.sandbox.paypal.com/cgi-bin/webscr" >
        <input type="hidden" name="business" value="sb-bxsaa1146424@business.example.com" />
        <input type="hidden" name="cert_id" value="AevWULr5xlcSLo4qZ3ztMqkbZQqkPHF0FAoo0aSmbSesIQnFyDCDVZgSunroygQ5_bXlauESAInzRmkq" />
        <input type="hidden" name="cmd" value="_xclick" />
        <input type="hidden" name="amount" value="${total}" />
        <input type="hidden" name="item_name" value="Board games" />
        <input type="hidden" name="currency_code" value="EUR" />
        <input type="hidden" name="lc" value="fr_FR" />
        <input type="hidden" name="cancel_return" value="http://localhost:8082/Baxydia/payment/cancelled" />
        <input type="hidden" name="return" value="http://localhost:8082/Baxydia/payment/success" />
        <input type="image" src="https://www.paypalobjects.com/fr_FR/BE/i/btn/btn_paynowCC_LG.gif" border="0" name="submit">
      </form>
    </div>
  </body>
</html>
