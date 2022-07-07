<%-- 
    Document   : index.jsp
    Created on : Jul 1, 2022, 9:59:19 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TTK Piano Music Center</title>
        <link rel="stylesheet" href="mystyle.css" type="text/css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%            String username = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String temp = cookie.getName();
                    if (!temp.equals("JSESSIONID")) {
                        username = temp;
                    }
                }
                if (!username.equals("")) {
        %>

        <font color="red">Welcome, <%=username%></font>

        <%
//                } else {
//                    <font color="red">You haven't logged in!</font>
                }
            }
        %>
        <div class="container" style="margin-top: 40px">
            <div class="row">
                <div class="col-sm-6" style="text-align: center;">
                    <h2 style="color: #ff3a94;">TTK PIANO MUSIC CENTER</h2>
                    <hr>
                    <img src="img/logo.jpg" style="height: 500px; margin-top: 10px">
                </div>
                <div class="col-sm-6" style="text-align: center;">
                    <div style="margin-top: 30px"></div>
                    <p>This is a place where music and painting subjects such as piano, guitar, and drawing are taught. A training center for passionate students who want to try their hand at western instruments such as piano and guitar. Here, you will be able to try yourself from basic to advanced, with a clear roadmap and especially affordable tuition, only from 1,000,000 VND for 3 months of basic learning. The instructors here are all highly qualified and experienced, so please feel free to come to our center to study. In addition to musical instruments, our center also provides training in drawing from basic to advanced levels, in addition to drawing on paper, there are also drawing courses on the computer software that is Adobe Illustrator, helping you to master the art of drawing. can enhance creativity and create amazing pictures.</p>
                    <br><h2>Passion for success. Good luck.</h2>
                </div>         
            </div>
        </div>
        <%@include file="footer.jsp" %>
        
    </body>
</html>
