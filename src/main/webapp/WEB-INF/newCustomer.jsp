<%-- 
    Document   : newCustomer
    Created on : Sep 25, 2019, 10:17:29 PM
    Author     : Vasanth Pranavan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spark Sports Online Store</title>
    </head>
    <body>
        <h1>Welcome to Spark Sports Online Store </h1>
        <h2>New Customers here!</h2>

        <c:if test="${not empty requestScope.mistakes}">
            <c:forEach items="${requestScope.mistakes}" var="mistake">
                <p>There is a validation issue with ${mistake.propertyPath}.  The message is ${mistake.message}</p>
            </c:forEach>
        </c:if>

        <form style="margin:0 auto;width:75%;text-align:left" action="/vselvam1-fp/customer" method="post">
            <div>
                <label for="fName">First Name</label></br>

                <input value="${requestScope.customer.fName}"type="text" id="fName" name="fName"></br>

                <label for="lName">Last Name</label></br>
                <input value="${requestScope.customer.lName}" type="text" id="lName" name="lName"></br>

                <label  for="age">Customer Age</label></br>
                <input value="${requestScope.customer.age}" type="text" id="age" name="age"></br>

                <label for="mail">Email ID</label></br>
                <input value="${requestScope.customer.mail}" type="text" id="mail" name="mail">
            </div> 
            </br>
            <div class="button">
                <button type="submit">New Customer</button>
            </div>
        </form>
    </body>
</html>
