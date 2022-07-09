/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.controllers;

import duyvt.DAO.AccountsDAO;
import duyvt.DAO.CoursesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UpdateController extends HttpServlet {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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
            int ID = Integer.parseInt(request.getParameter("txtID"));
            String name = request.getParameter("txtName");
            String imgPath = request.getParameter("txtImgPath");
            String description = request.getParameter("txtDescription");
            int tuitionFee = Integer.parseInt(request.getParameter("txtTuitionFee"));
            Date startDate =  formatter.parse(request.getParameter("txtStartDate"));
            Date endDate =  formatter.parse(request.getParameter("txtEndDate"));
            String category = request.getParameter("category");
            boolean statusStr = Boolean.parseBoolean(request.getParameter("status"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            
            String indexPage = request.getParameter("index");
            if(indexPage == null){
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            
            Date date = new Date();
            
            
            CoursesDAO dao = new CoursesDAO();
            String url = "MainController?btAction=CoursesUpdate";
            boolean update = dao.updateCourses(ID, name, imgPath, description, tuitionFee, startDate,endDate, category, statusStr, quantity);
            
            
            
            if (update) {
                url = "MainController?btAction=CoursesUpdate&Indexx="+index;
                
                
            } 
            HttpSession session = request.getSession(true);
            session.setAttribute("date", date);
            response.sendRedirect(url);
            
        } catch (SQLException e){
            response.sendRedirect("errorUpdate.html");
        } catch (ParseException e){
            response.sendRedirect("errorUpdate.html");
        } catch (NamingException e){
            response.sendRedirect("errorUpdate.html");
        } catch (NumberFormatException e){
            response.sendRedirect("errorUpdate.html");
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
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
