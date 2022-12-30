<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
    <!--<link type="text/css" href="<spring:url value='/css/styles.css' />"
          rel="Stylesheet">-->
</head>
<body>
    <section class="header">

    </section>
    <section>
        <tiles:insertAttribute name="main-content"/>
    </section>
    <section class="footer">

    </section>
</body>
</html>