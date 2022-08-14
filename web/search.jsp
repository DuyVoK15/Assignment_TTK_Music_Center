<%-- 
    Document   : search
    Created on : Jul 2, 2022, 2:15:08 PM
    Author     : ASUS
--%>

<%@page import="duyvt.DAO.CoursesDAO"%>
<%@page import="java.util.List"%>
<%@page import="duyvt.DTO.CoursesDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List course</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>

        <%@include file="header.jsp" %>

        <%            // get isAdmin = ?
            String s = (String) request.getAttribute("a");
            String textS = (String) request.getAttribute("textS");
            int indexS = (int) request.getAttribute("indexS");
            int endS = (int) request.getAttribute("endS");
            %><h4>You are on page: <%= indexS%></h4><%
        %>
        <h1>Courses</h1>
        
        <div>Search: <%= s%></div>
        <%
//            String searchValue = request.getParameter("txtSearch");
            List<CoursesDTO> list = (List<CoursesDTO>) request.getAttribute("coursesList");
            if (list != null || textS != null) {
        %>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Name</th>
                    <th scope="col">Image</th>
                    <th scope="col">Description</th>
                    <th scope="col">Tuition fee</th>
                    <th scope="col">Start date</th>
                    <th scope="col">End date</th>
                    <th scope="col">Category</th>
                    <th scope="col">Status</th>
                    <th scope="col">Quantity</th> 
                    <%if(!isAdmin){ %><th scope="col">Action</th>  <%}%>
                </tr>
            </thead>

            <tbody>
                <%
                    int count = 0;
                    for (CoursesDTO dto : list) {
                %>              

                <tr>
                    <th scope="row"><%= ++count%></th>
                    <td><%= dto.getName()%></td>
                    <td><img style='width: 200px; height: 200px;' src="<%= dto.getImgPath()%>"/></td>
                    <td><%= dto.getDescription()%></td>
                    <td><%= dto.getTuitionFee()%></td>
                    <td><%= dto.getStartDate()%></td>
                    <td><%= dto.getEndDate()%></td>
                    <td><%= dto.getCategory()%></td>
                    <td>
                        <%
                            String status = "";
                            if (dto.isStatus()) {
                                status = "Active";
                            } else {
                                status = "Inactive";
                            }
                        %>
                        <%= status%>
                    </td>
                    <td><%= dto.getQuantity()%></th>  
                    <%if(!isAdmin){ %><td> <a class="btn btn-primary" href="MainController?btAction=AddS&codeS=<%=dto.getID()%>">Add to cart</a> </td><%}%>
                </tr>

                <%
                    }
                %>
            </tbody>
        </table>
            <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <%
                if (indexS > 1) {
            %><li class="page-item"><a class="page-link" href="MainController?btAction=Search&searchBy=${a}&txtSearch=${textS}&IndexS=${indexS-1}">Previous</a></li><%
                }
                %>

            <c:forEach begin="1" end="${endS}" var="i">

                <li class="page-item"><a class="page-link" href="MainController?btAction=Search&searchBy=${a}&txtSearch=${textS}&IndexS=${i}">${i}</a></li>


            </c:forEach>
            <%
                if (indexS < endS) {
            %><li class="page-item"><a class="page-link" href="MainController?btAction=Search&searchBy=${a}&txtSearch=${textS}&IndexS=${indexS+1}">Next</a></li><%
                }
                %>

        </ul>
    </nav>
        <%
        } else {
        %>
        <h1>No match record!</h1>
        <%
            }
        %>
        <!--        <a href="index.jsp">Back</a>-->

        <%@include file="footer.jsp" %>

    </body>
</html>
