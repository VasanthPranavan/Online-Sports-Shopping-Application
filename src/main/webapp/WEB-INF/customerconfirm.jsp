<%-- 
    Document   : customerconfirm
    Created on : Sep 26, 2019, 2:23:02 AM
    Author     : Vasanth Pranavan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Success Page</title>
    </head>
    <body>
        <h1>You have successfully registered </h1>
        <ul>

            <li>${requestScope.customer.fName}</li>
            <li>${requestScope.customer.lName}</li>
            <li>${requestScope.customer.age}</li>
            <li>${requestScope.customer.mail}</li>

        </ul>
    </body>
</html>
