<%-- 
    Document   : shoppingList
    Created on : Oct 16, 2022, 10:23:47 AM
    Author     : ilyes
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} <a href="ShoppingList?action=logout">Logout</a><br>
        <h2>List</h2>
        <form action="ShoppingList?action=add" method="post">
            Add item: <input type="text" name="item"><input type="submit" value="Add"><br>
        </form>
        <c:if test="${list != null}">
            <form action="ShoppingList?action=delete" method="post">
                <c:forEach var="item" items="${list}"> 
                    <input type="radio" name="choice" value="${item}"> ${item} <br>
                </c:forEach>
                <input type="submit" value="Delete">
            </form>
        </c:if>
    </body>
</html>
