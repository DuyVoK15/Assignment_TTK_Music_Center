<%-- 
    Document   : list
    Created on : Jul 3, 2022, 2:38:49 PM
    Author     : ASUS
--%>
<%@page import="duyvt.DTO.CoursesDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>

        <%@include file="header.jsp" %>

        <%            List<CoursesDTO> list = (List<CoursesDTO>) request.getAttribute("listA");
            int indexP = (int) request.getAttribute("indexP");
            int endP = (int) request.getAttribute("endP");
            if (list != null) {
        %>
        <table class="table">
            <thead>
                <tr>
                    <!--                    <th>No.</th>-->
                    <th scope="col">Name</th>
                    <th scope="col">Image</th>
                    <th scope="col">Description</th>
                    <th scope="col">Tuition fee</th>
                    <th scope="col">Start date</th>
                    <th scope="col">End date</th>
                    <th scope="col">Category</th>
                    <th scope="col">Status</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Action</th>
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
                    <th scope="row"><%=dto.getName()%></th>
                    <td><img style='width: 200px; height: 200px;' src="<%= dto.getImgPath()%>"/></td>
                    <td><%= dto.getDescription()%></td>
                    <td><%= dto.getTuitionFee()%></td>
                    <td><%= dto.getStartDate()%></td>
                    <td><%= dto.getEndDate()%></td>
                    <td><%= dto.getCategory()%></td>
                    <td>
                        <%
                            if (dto.isStatus()) {
                        %>Active<%
                        } else {
                        %>Inactive<%
                            }
                        %>
                    </td>
                    <td><%= dto.getQuantity()%></td>
                    <td> <input type="submit" name="btAction" value="Add to cart" /> </td>
                </tr>
            </form>
            <%}%>
        </tbody>
    </table>
    <%}%>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <%
                if (indexP > 1) {
            %><li class="page-item"><a class="page-link" href="MainController?btAction=Courses&Index=${indexP-1}">Previous</a></li><%
                }
                %>

            <c:forEach begin="1" end="${endP}" var="i">

                <li class="page-item"><a class="page-link" href="MainController?btAction=Courses&Index=${i}">${i}</a></li>


            </c:forEach>
            <%
                if (indexP < endP) {
            %><li class="page-item"><a class="page-link" href="MainController?btAction=Courses&Index=${indexP+1}">Next</a></li><%
                }
                %>

        </ul>
    </nav>
    <footer><%@include file="footer.jsp" %></footer>  


</body>
</html>
