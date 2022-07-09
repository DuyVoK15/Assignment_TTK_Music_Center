<%-- 
    Document   : viewcart
    Created on : Jul 8, 2022, 11:07:37 PM
    Author     : ASUS
--%>

<%@page import="duyvt.controllers.AddCoursesToCartController"%>
<%@page import="duyvt.DTO.CartDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <%@include file="header.jsp" %>
        <%
            double sum = 0;
            double sumTotal = 0;
            double discount = 0;
            List<CartDTO> listCartSession = null;
            if (session.getAttribute("listCartSession") != null) {
                listCartSession = (List<CartDTO>) session.getAttribute("listCartSession");
            }
            if (listCartSession != null) {
                sum = (double) session.getAttribute("sum");
                discount = (double) session.getAttribute("discount");
                sumTotal = (double) session.getAttribute("sumTotal");

        %>       
        <div class="container px-3 my-5 clearfix">
            <!-- Shopping cart table -->
            <div class="card">
                <div class="card-header">
                    <h2>Shopping Cart</h2>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered m-0">
                            <thead>
                                <tr>
                                    <th class="text-center py-3 px-4" scope="col">No .</th>
                                    <th class="text-center py-3 px-4" scope="col">Name</th>
                                    <th class="text-center py-3 px-4" scope="col">Amount</th>
                                    <th class="text-center py-3 px-4" scope="col">Tuition fee</th>                  
                                    <th class="text-center py-3 px-4" scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%                    for (int i = 0; i < listCartSession.size(); i++) {
                                        CartDTO dto = listCartSession.get(i);
                                %>



                                <tr class="align-middle p-4">
                                    <th class="align-middle p-4" scope="row"><%= i%></th>
                                    <td class="align-middle p-4"><%= dto.getCourses().getName()%></td>
                            <form action="MainController" method="POST">
                                <td class="align-middle p-4"><input type="text" name="txtQuantityItem" value="<%= dto.getQuantity()%>" /> 
                                    <input type="hidden" name="idid" value="<%= dto.getCourses().getID()%>">
                                    <button class="btn btn-dark btn-sm-1" type="submit" name="btAction" value="UpdateItemQuantity" >Update amount</button> </td>
                            </form>

                            <td class="align-middle p-4"><%= dto.getCourses().getTuitionFee()%></td>           
                            <td class="align-middle p-4"><a onclick="return confirm('Are you sure to delete this item?')" class="btn btn-primary" href="MainController?btAction=DeleteCart&deleteID=<%=i%>">Delete</a></td>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                    <!-- / Shopping cart table -->
                    <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                        <div class="mt-4">
                            <label class="text-muted font-weight-normal">Promocode</label>
                            <input type="text" placeholder="ABC" class="form-control">
                        </div>
                        <div class="d-flex">
                            <div class="text-right mt-4 mr-5">
                                <label class="text-muted font-weight-normal m-0">Price</label>
                                <div class="text-large"><strong>$ <%=sumTotal%></strong></div>
                            </div>
                            <div class="text-right mt-4 mr-5">
                                <label class="text-muted font-weight-normal m-0">Discount</label>
                                <div class="text-large"><strong>$ <%=discount%></strong></div>
                            </div>
                            <div class="text-right mt-4">
                                <label class="text-light bg-dark font-weight-bold m-0">Total price</label>
                                <div class="text-large"><strong><h3>$ <%=sum%></h3></strong></div>
                            </div>

                        </div>
                    </div>

                    <div class="float-right">
                        <a class="btn btn-lg btn-default md-btn-flat mt-2 mr-3" href="index.jsp">Home</a>
                        <a class="btn btn-lg btn-secondary md-btn-flat mt-2 mr-3" href="MainController?btAction=Courses">Back to shopping</a>
                        <a class="btn btn-lg btn-primary mt-2" href="MainController?btAction=Confirm">Confirm</a>
                    </div>

                </div>
            </div>
        </div>
        <%} else {
        %><h2>NO ITEM. Let buy something! <a href="MainController?btAction=Courses">here</a></h2><%
    }%>
<%@include file="footer.jsp" %>
    </body>
</html>
