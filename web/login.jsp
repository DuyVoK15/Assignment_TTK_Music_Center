<%-- 
    Document   : login
    Created on : Jul 1, 2022, 1:21:50 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>

        <%@include file="header.jsp" %>


        <h1>Login</h1>
        <form action="MainController" method="POST">
            <div class="container mt-5 mb-5 d-flex justify-content-center">
                <div class="card px-1 py-4">
                    <div class="card-body">
                        <h4>Login</h4>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="txtUserID" placeholder="Enter userID"> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="password" name="txtPassword" placeholder="Enter password"> 
                                </div>
                            </div>
                        </div>
                                 
                        <input class="btn btn-primary btn-block confirm-button" type="submit" value="Login" name="btAction">
                    </div>
                </div>
            </div>
        </form>
        <hr>
        <a href="index.jsp">Back to home</a>

        <%@include file="footer.jsp" %>

    </body>
</html>
