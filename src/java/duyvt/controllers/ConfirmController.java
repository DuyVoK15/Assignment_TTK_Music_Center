/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.controllers;

import duyvt.DAO.CoursesDAO;
import duyvt.DAO.OrderDAO;
import duyvt.DTO.CartDTO;
import duyvt.DTO.CoursesDTO;
import duyvt.DTO.OrderDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class ConfirmController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            HttpSession session = request.getSession();
            List<CartDTO> listCartSession = (List<CartDTO>) session.getAttribute("listCartSession");
            String userID = (String) session.getAttribute("u");
            boolean check = true;
            if (listCartSession != null) {
                for (CartDTO c : listCartSession) {
                    if (c.getCourses().getQuantity() <= c.getQuantity()) {
                        check = false;
                        break;
                    }
                }
                for (CartDTO c : listCartSession) {
                    if (c.getCourses().getQuantity() <= c.getQuantity()) {
                        out.print("The <strong>" + c.getCourses().getName() + "</strong> course is out of stock! or you buy overload courses of the store!<a href='MainController?btAction=ViewCart'>Try again!</a><br>");
                    }
                }
            }
            if (listCartSession != null && userID != null) {
                for (CartDTO c : listCartSession) {
                    OrderDTO dto = new OrderDTO();
                    dto.setOrderID(OrderDAO.setOrderID());
                    dto.setUserID(userID);
                    dto.setCourseID(c.getCourses().getID());
                    dto.setDate(new java.sql.Date(date.getTime()));
                    dto.setQuantity(c.getQuantity());
                    dto.setTotal(c.getCourses().getTuitionFee() * c.getQuantity());

                    OrderDAO dao = new OrderDAO();
                    boolean result = false;

                    if (c.getCourses().getQuantity() >= c.getQuantity() && check == true) {
                        result = dao.insertOrder(dto);
                    }

                    if (result) {
                        CoursesDAO coursesDAO = new CoursesDAO();
                        boolean rs = coursesDAO.updateQuantityCourse(c.getCourses().getID(), c.getCourses().getQuantity() - c.getQuantity());
                    }

                }
                if (check) {
                    listCartSession.clear();
                    out.print("You order success! <a href='index.jsp'>Come back home</a>");
                }
            } else {
                if (userID == null) {
                    response.sendRedirect("login.jsp");
                } else {
                    response.sendRedirect("MainController?btAction=ViewCart");
                }

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
