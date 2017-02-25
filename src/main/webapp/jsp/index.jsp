<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html; UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Monster to data</title>
</head>
<body>
<form action="insert.do">
    <input name="id" type="number" size="8"> ID <br>
    <input name="name" type="text" size="20"> Name <br>
    <input name="level" type="number" size="5"> Level <br>
    <input name="health" type="number" size="7"> Health <br>
    <input name="mana" type="number" size="7"> Mana <br>
    <input type="submit">
</form>
<br>
<form action="remove.do" method="get">
    <ul>
        <c:forEach var="item" items="${monsters}">
            <li>
                <input type="checkbox" name="remove" value="${item.id}">
                ID:${item.id}
                <i>${item.name}</i>
                lvl:${item.level}
                HP:${item.health}
                MP${item.mana}
            </li>
        </c:forEach>
    </ul>
    <c:if test="${fn:length(monsters) > 0}">
        <input type="submit" value="remove">
    </c:if>
</form>
</body>
</html>