<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Baxydia</title>
        <link type="text/css" href="<spring:url value='/css/styles.css'/>" rel="Stylesheet">
    </head>
    <body class="mainContainer">
        <div class="homeIntroduction">
            <p class="homeFirstPara"><spring:message code="textHome" /></p>
        </div>
        <div class="homeCategory">
            <p class="homeCategoryTitle"><spring:message code="categories" /> :</p>
            <c:forEach items="${categories}" var="category">
                <a id="${category.getLabel()}"
                   class="homeItemButtonLink"
                   href="<spring:url value="/category/${category.getLabel()}"/>">
                    <div class="homeItemButton">
                        <c:forEach items="${translations}" var="translation">
                            <c:if test="${translation.getCategoryLabel() == category.getLabel()}">
                                <h1>${translation.getCategoryName()}</h1>
                            </c:if>
                        </c:forEach>
                    </div>
                </a>
            </c:forEach>
        </div>
    </body>
</html>