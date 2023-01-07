<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
    </head>
    <body>
        <section class="header">
            <div class="headerContent">
                <a class="headerLeft" href="<spring:url value="/"/>">Baxydia</a>
                <a href="<spring:url value="/checkout"/>">
                    <img class="headerMiddle" src="<spring:url value="/images/basketlogo.png"/>" alt="BasketImg">
                </a>
                <a class="headerLogin" href="<spring:url value="/login"/>">Login</a>
                <a class="headerRegister" href="<spring:url value="/signUp"/>">Register</a>
            </div>
        </section>
        <section>
            <tiles:insertAttribute name="main-content"/>
        </section>
        <section class="footer">
            <p>footer to implement</p>
            <p>©Baxydia 2023</p>
        </section>
    </body>
</html>