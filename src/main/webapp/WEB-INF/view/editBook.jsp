<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
</head>
<body>
<h1>${headerMessage}</h1>

<form:form method="POST" action="editBook" modelAttribute="book">

    <form:hidden path="id" />
    <table>
        <tr>
            <td><form:label path="bookName">Book Name</form:label></td>
            <td><form:input path="bookName"/></td>
        </tr>
        <tr>
            <td><form:label path="authorName">Author Name</form:label></td>
            <td><form:input path="authorName"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>