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
            <p class="homeFirstPara">En famille ou entre amis, tout le monde aime les jeux de sociétés.</p>
        </div>
        <div class="homeCategory">
            <p class="homeCategoryTitle">Catégories :</p>
            <c:forEach items="${categories}" var="category">
                <a id="${category.getLabel()}"
                   class="homeItemButtonLink"
                   href="<spring:url value="/category/${category.getLabel()}"/>">
                    <div class="homeItemButton">
                        <h1>${category.getLabel()}</h1>
                    </div>
                </a>
            </c:forEach>
        </div>
    </body>
</html>