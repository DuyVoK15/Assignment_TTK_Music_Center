/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.controllers;

import duyvt.DAO.AccountsDAO;
import duyvt.DTO.AccountsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class MainController extends HttpServlet {

    private String INDEXPAGE = "index.jsp";
    private String LOGINCONTROLLER = "LoginController";
    private String LOGOUTCONTROLLER = "LogoutController";
    private String SEARCHCONTROLLER = "SearchController";
    private String LISTCONTROLLER = "ListController";
    private String NULLCONTROLLER = "NullController";
    private String SHOWLISTUPDATECONTROLLER = "ShowListUpdateController";
    private String UPDATECONTROLLER = "UpdateController";
    private String CREATECONTROLLER = "CreateController";
    private String ADDCOURSESTOCARDCONTROLLER = "AddCoursesToCartController";
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String button = request.getParameter("btAction");
            String url = INDEXPAGE;
            
            
            
                       
                        
            
            if (button == null) {
                
            } else if (button.equals("Login")) {
                url = LOGINCONTROLLER;
            } else if (button.equals("Logout")) {
                url = LOGOUTCONTROLLER;
            } else if (button.equals("Search")) {
                url = SEARCHCONTROLLER;
            } else if (button.equals("Courses")) {
                url = LISTCONTROLLER;
            } else if (button.equals("CoursesUpdate")) {
                url = SHOWLISTUPDATECONTROLLER;
            } else if (button.equals("Update")) {
                url = UPDATECONTROLLER;
            } else if (button.equals("Create")) {
                url = CREATECONTROLLER;
            } else if (button.equals("Add to cart")) {
                url = ADDCOURSESTOCARDCONTROLLER;
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
