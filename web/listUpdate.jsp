<%-- 
    Document   : listUpdate
    Created on : Jul 4, 2022, 4:26:16 PM
    Author     : ASUS
--%>
<%@page import="java.util.Date"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="duyvt.DTO.CoursesDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <%@include file="header.jsp" %>
        <%            if (isAdmin) {

                int i = (int) session.getAttribute("i");
                Date s = (Date) session.getAttribute("date");
                String u = (String) session.getAttribute("u");

                int endPU = (int) request.getAttribute("endPU");
                List<CoursesDTO> list = (List<CoursesDTO>) request.getAttribute("listAU");
                if (list != null) {
        %>
        <div style="overflow-x:auto;">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Image</th>
                        <th scope="col">Description</th>
                        <th scope="col">Tuition fee</th>
                        <th scope="col">Start date</th>
                        <th scope="col">End date</th>
                        <th scope="col">Category</th>
                        <th scope="col">Status</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Update</th>
                    </tr>
                </thead>
                <tbody>
                    <% int count = 0;%>
                    <%

                        for (CoursesDTO dto : list) {


                    %>
                <form action="MainController" method="POST">
                    <tr>
    <!--                        <td><%=++count%></td>-->

                        <th scope="row" style="padding: "><input type="hidden" name="txtID" value="<%= dto.getID()%>" /> <%= dto.getID()%></th>
                        <td><input type="text" name="txtName" value="<%= dto.getName()%>" /></td>
                        <td><input type="text" name="txtImgPath" value="<%= dto.getImgPath()%>" /><img style='width: 200px; height: 200px;' src="<%= dto.getImgPath()%>"/></td>
                        <td><input type="text" name="txtDescription" value="<%= dto.getDescription()%>" /></td>
                        <td><input type="text" name="txtTuitionFee" value="<%= dto.getTuitionFee()%>" /></td>
                        <td><input type="text" name="txtStartDate" value="<%= dto.getStartDate()%>" /></td>
                        <td><input type="text" name="txtEndDate" value="<%= dto.getEndDate()%>" /></td>
                        <td>
                            <select name="category">
                                <option value="Guitar"
                                        <%if (dto.getCategory().equalsIgnoreCase("Guitar")) {
                                        %>selected="selected" <%
                                            }
                                        %>
                                        >Guitar</option>
                                <option value="Piano"
                                        <%if (dto.getCategory().equalsIgnoreCase("Piano")) {
                                        %>selected="selected" <%
                                            }
                                        %>
                                        >Piano</option>
                                <option value="Drawing"
                                        <%if (dto.getCategory().equalsIgnoreCase("Drawing")) {
                                        %>selected="selected" <%
                                            }
                                        %>
                                        >Drawing</option>
                            </select>
                        </td>
                        <td>
                            <select name="status">
                                <option value="true"
                                        <%if (dto.isStatus() == true) {
                                        %>selected="selected" <%
                                            }
                                        %>
                                        >Active</option>
                                <option value="false"
                                        <%if (dto.isStatus() == false) {
                                        %>selected="selected" <%
                                            }

                                        %>
                                        >Inactive</option>
                            </select>                      
                        <td><input type="text" name="txtQuantity" value="<%= dto.getQuantity()%>" /></td>
                        <td> <input type="submit" name="btAction" value="Update" /> </td>
                    <input type="hidden" name="index" value="<%= i%>" />
                    </tr>

                </form>
                <%}%>
                <%

                    if (s != null) {
                %>
                <font color="red">Last update date: <%= s%></font>
                <br>
                <font color="red">Last update user: <%= u%></font>
                <br>
                <%

                    }
                %>
                </tbody>
            </table>

            <%}%>
        </div>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <%
                    if (i > 1) {
                %><li class="page-item"><a class="page-link" href="MainController?btAction=CoursesUpdate&Indexx=${i-1}">Previous</a></li><%
                    }
                    %>
                    <c:forEach begin="1" end="${endPU}" var="i">

                    <li class="page-item"><a class="page-link" href="MainController?btAction=CoursesUpdate&Indexx=${i}">${i}</a></li>

                </c:forEach>
                <%
                    if (i < endPU) {
                %><li class="page-item"><a class="page-link" href="MainController?btAction=CoursesUpdate&Indexx=${i+1}">Next</a></li><%
                    }
                    %>

            </ul>
        </nav>
        <%
        } else {
        %> <h1 style="color: red; text-align: center;">You are not ADMIN. Can not do this function!</h1> <%
            }
        %>
        <%@include file="footer.jsp" %> 



    </body>
</html>
