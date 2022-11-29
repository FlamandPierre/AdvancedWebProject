<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <c:forEach items="${categories}" var="category">
        <h1 id="${category.getLabel()}" class="category">${category.getLabel()}</h1>
    </c:forEach>
</body>
</html>