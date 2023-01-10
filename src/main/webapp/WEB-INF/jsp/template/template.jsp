<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
        <spring:url var="localeFr" value="">
            <spring:param name="locale" value="fr"/>
        </spring:url>
        <spring:url var="localeEn" value="">
            <spring:param name="locale" value="en"/>
        </spring:url>
    </head>
    <body>
        <section class="header">
            <div class="headerContent">
                <a class="headerLeft" href="<spring:url value="/home"/>">Baxydia</a>
                <a href="${localeFr}">
                    <img class="headerBtn" alt="fr" src='<spring:url value="/images/localeFr.png" />'>
                </a>
                <a href="${localeEn}">
                    <img class="headerBtn" alt="fr" src='<spring:url value="/images/localeEn.png" />'>
                </a>
                <sec:authorize access="isAuthenticated()">
                    <a class="headerLogin"><spring:message code="welcome" /> ${currentUser.firstname}</a>
                </sec:authorize>
                <a href="<spring:url value="/checkout"/>">
                    <img class="headerMiddle" src="<spring:url value="/images/basketlogo.png"/>" alt="BasketImg">
                </a>
                <sec:authorize access="!isAuthenticated()">
                    <a class="headerLogin" href="<spring:url value="/login"/>"><spring:message code="login" /></a>
                    <a class="headerRegister" href="<spring:url value="/signUp"/>"><spring:message code="signUp" /></a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <a class="headerLogin" href="<spring:url value="/account"/>"><spring:message code="account" /></a>
                    <a class="headerLogin" href="<spring:url value="/logout"/>"><spring:message code="logout" /></a>
                </sec:authorize>
            </div>
        </section>
        <section>
            <tiles:insertAttribute name="main-content"/>
        </section>
        <section class="footer">
            <p>©Baxydia 2023</p>
            <a href="<spring:url value="/about_us"/>"><spring:message code="moreAboutUs"/></a>
        </section>
    </body>
</html>