<%-- 
    Document   : vieworder
    Created on : Jul 12, 2022, 1:09:24 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Order</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%            if (isAdmin) {
                    int count = 0;
                    if(haveLogin){
            %>
            
            <table class="table">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Order ID</th>
                        <th>Course ID</th>
                        <th>Purchase date</th>
                        <th>Quantity</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listO}" var="o">
                    <tr>
                        <td><%=++count%></td>
                        <td>${o.getOrderID()}</td>
                        <td>${o.getCourseID()}</td>
                        <td>${o.getDate()}</td>
                        <td>${o.getQuantity()}</td>
                        <td>${o.getTotal()}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%} else{
%><h1 style="color: red; text-align: center;">You must login! <a href="login.jsp">Do you want to login?</a></h1><%
}%>
            
            
        <%} else {
        %><h1 style="color: red; text-align: center;">You can not do this function!</h1><%
    }%>

        <%@include file="footer.jsp" %>
    </body>
</html>
