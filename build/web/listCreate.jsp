<%-- 
    Document   : listCreate
    Created on : Jul 6, 2022, 1:29:17 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%            if (isAdmin) {
        %>
        <h1>New course</h1>
        <form action="MainController" method="POST">
            <label> ID: </label>
            <input type="text" name="ctxtID"> <br>
            <label> Name: </label>
            <input type="text" name="ctxtName"> <br>
            <label> Image path: </label>
            <input type="text" name="ctxtImgPath"> <br>
            <label> Description: </label>
            <input type="text" name="ctxtDescription"> <br>
            <label> Tuition fee: </label>
            <input type="text" name="ctxtTuitionFee"> <br>
            <label> Start date: </label>
            <input type="date" name="ctxtStartDate"> <br>
            <label> End date: </label>
            <input type="date" name="ctxtEndDate"> <br>
            <label> Category: </label>
            <input type="text" name="ctxtCategory"> <br>
            <label> Status: active (Default)</label>
            <input type="hidden" name="ctxtStatus" value="true"> <br>
            <label> Quantity: </label>
            <input type="text" name="ctxtQuantity"> <br>


            <input type="submit" value="Create" name="btAction">
        </form>
        <hr>
        <a href="index.jsp">Back to home</a>
        <%
        } else {
        %> <h1 style="color: red; text-align: center;">You are not ADMIN. Can not do this function!</h1> <%
        }
        %>
        <%@include file="footer.jsp" %>
    </body>
</html>
