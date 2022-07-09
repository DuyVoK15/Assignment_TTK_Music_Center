<%-- 
    Document   : header
    Created on : Jul 3, 2022, 5:42:17 PM
    Author     : ASUS
--%>

<%@page import="duyvt.DTO.CartDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="mystyle.css" type="text/css" />
        <title>Header</title>
    </head>
    <body>
        <%

            boolean isAdmin = false;
            if (session.getAttribute("isAdminResult") != null) {
                isAdmin = (boolean) session.getAttribute("isAdminResult");
            }
            if (isAdmin) {
        %>
        <!--ADMIN PAGE-->
        <header>
            <nav class="navbar navbar-dark bg-dark">
                <a class="navbar-brand" href="index.jsp"><img style="height: 70px; width: 70px; border-radius: 40px;" class="image" src="img/logo.jpg"></a>
                <ul class="navbar-nav mr-auto" style="flex-direction: row;">
                    <li class="nav-item active" style="margin-left: 30px"><a class="nav-link" href="index.jsp"><h4>Home</h4></a></li>
                    <li class="nav-item" style="margin-left: 30px"><a class="nav-link" href="login.jsp" ><h4>Login</h4></a></li>
                    <li class="nav-item" style="margin-left: 30px"><a class="nav-link"  href="MainController?btAction=CoursesUpdate" ><h4>Update courses</h4></a></li>
                    <li class="nav-item" style="margin-left: 30px"><a class="nav-link"  href="listCreate.jsp"><h4>Create courses</h4></a></li>
                    <li class="nav-item" style="margin-left: 30px"><a class="nav-link"  href="MainController?btAction=Logout"><h4>Logout</h4></a></li>
                </ul>
                <form class="form-inline" action="MainController" method="POST" class="formsearch">
                    <input class="form-control mr-sm-2" type="text" name="txtSearch" placeholder="Search....">
                    <select style="padding: 6px 0px; margin-right: 10px; border-radius: 4px;" name="searchBy">
                        <option value="byName">By name</option>
                        <option value="byCategory">By category</option>
                    </select>
                    <input class="btn btn-outline-info my-2 my-sm-0" type="submit" value="Search" name="btAction" >
                </form>
            </nav>
        </header>  

        <%
        } else {
            List<CartDTO> listCartSession = null;

        %>

        <!--User and no login page-->
        <header>
            <nav class="navbar navbar-dark bg-dark">
                <a class="navbar-brand" href="index.jsp"><img style="height: 70px; width: 70px; border-radius: 40px;" class="image" src="img/logo.jpg"></a>

                <ul class="navbar-nav mr-auto" style="flex-direction: row;">
                    <li class="nav-item active" style="margin-left: 30px"><a class="nav-link" href="index.jsp"><h4>Home</h4></a></li>
                    <li class="nav-item" style="margin-left: 30px"><a class="nav-link" href="login.jsp" ><h4>Login</h4></a></li>            
                    <li class="nav-item" style="margin-left: 30px"><a class="nav-link" href="MainController?btAction=Courses" ><h4>Courses</h4></a></li>   
                    <li class="nav-item" style="margin-left: 30px"><a class="nav-link" href="MainController?btAction=ViewCart" ><h4>View cart<span class="badge badge-danger">
                                    <%                                    if (session.getAttribute("listCartSession") != null) {
                                            listCartSession = (List<CartDTO>) session.getAttribute("listCartSession");
                                    %><%=listCartSession.size()%><%
                                    } else {
                                    %><%= 0%><%
                                           }
                                    %>


                                </span></h4></a></li>   
                                <%
                                    boolean haveLogin = false;
                                    if (session.getAttribute("haveLogin") != null) {
                                        haveLogin = (boolean) session.getAttribute("haveLogin");
                                    }
                                    if (haveLogin) {
                                %><li class="nav-item" style="margin-left: 30px"><a class="nav-link" href="MainController?btAction=Logout"><h4>Logout</h4></a></li><%
                                    }
                        %>

                </ul>

                <form class="form-inline" action="MainController" method="POST" class="formsearch">
                    <input class="form-control mr-sm-2" type="text" name="txtSearch" placeholder="Search....">
                    <select style="padding: 6px 0px; margin-right: 10px; border-radius: 4px;" name="searchBy">
                        <option value="byName">By name</option>
                        <option value="byCategory">By category</option>
                    </select>
                    <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search" name="btAction" >
                </form>
            </nav>
        </header>
        <%
            }

        %>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
