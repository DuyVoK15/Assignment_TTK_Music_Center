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
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>Create course</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%            if (isAdmin) {
        %>
        <h1>New course</h1>
        <form action="MainController" method="POST">
<!--            <label> ID: </label>
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
            <input type="text" name="ctxtQuantity"> <br>-->
            
            <div class="container mt-5 mb-5 d-flex justify-content-center">
                <div class="card px-1 py-4">
                    <div class="card-body">
                        <h4>Login</h4>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="ctxtID" placeholder="Enter ID..."> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="ctxtName" placeholder="Enter name..."> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="ctxtImgPath" placeholder="Enter image link..."> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="ctxtDescription" placeholder="Enter description..."> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="ctxtTuitionFee" placeholder="Enter tuition fee..."> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="date" name="ctxtStartDate"> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="date" name="ctxtEndDate"> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="ctxtCategory" placeholder="Enter category..."> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label> Status: active (Default)</label><input class="form-control" type="hidden" name="ctxtStatus" value="true"> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="ctxtQuantity" placeholder="Enter quantity..."> 
                                </div>
                            </div>
                        </div>
                                 
                        <input class="btn btn-primary btn-block confirm-button" type="submit" value="Create" name="btAction">
                    </div>
                </div>
            </div>

            
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
