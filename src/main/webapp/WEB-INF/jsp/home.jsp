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
                <h1 id="${category.getLabel()}" class="homeSection">${category.getLabel()}</h1>
            </c:forEach>
        </div>
    </body>
</html>