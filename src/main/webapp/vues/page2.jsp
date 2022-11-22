<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Liste de produits</h1>

<table border="1">
<c:forEach items="${liste }" var="c">
<tr>
<td>${c.id }</td>
<td>${c.titre }</td>
<td>${c.prix }</td>
<td>${c.cat.titre }</td>

</tr>
</c:forEach>
</table>
</body>
</html>