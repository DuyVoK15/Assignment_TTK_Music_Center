/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.controllers;

import duyvt.DAO.CoursesDAO;
import duyvt.DTO.CartDTO;
import duyvt.DTO.CoursesDTO;
import static duyvt.controllers.AddCoursesToCartController.listCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class AddWithSearchController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
//        CoursesDTO dto = new CoursesDTO();
//        CoursesDAO dao = new CoursesDAO();
//        CartDTO cart = new CartDTO();
//        String indexPage = request.getParameter("Index");
//            if(indexPage == null){
//                indexPage = "1";
//            }
//            int index = Integer.parseInt(indexPage);
//        int codeS = Integer.parseInt(request.getParameter("codeS"));
//        dto = dao.findCourseID(codeS);
//        
//        if (dto != null) {
//            cart.setCourses(dto);
//            cart.setQuantity(1);
//           
//            listCart.add(cart);
//        }
        
        try (PrintWriter out = response.getWriter()) {
            CoursesDTO dto = null;
            CoursesDAO dao = new CoursesDAO();
            CartDTO cart = new CartDTO();
//        String indexPage = request.getParameter("Index");
//        if (indexPage == null) {
//            indexPage = "1";
//        }
//        int index = Integer.parseInt(indexPage);
            int code = Integer.parseInt(request.getParameter("codeS"));
            dto = dao.findCourseID(code);
            HttpSession session = request.getSession();
            List<CartDTO> listCartSession = (List<CartDTO>) session.getAttribute("listCartSession");
            int index = (int) session.getAttribute("indexSearchSession");
            String textSearch = (String) session.getAttribute("textSearchSession");
            String searchBy = (String) session.getAttribute("searchBySession");
            cart.setCourses(dto);
            cart.setQuantity(1);

            if (listCartSession == null) {
                listCart.add(cart);
                session.setAttribute("listCartSession", listCart);
                response.sendRedirect("MainController?btAction=Search&searchBy="+searchBy+"&txtSearch="+textSearch+"&IndexS="+index);
            } else {
                listCart = listCartSession;
                boolean exist = false;
                for (CartDTO c : listCartSession) {
                    if (c.getCourses().getID() == code) {
                        int quantity = c.getQuantity();
                        c.setQuantity(quantity+1);
                        exist = true;
                        response.sendRedirect("MainController?btAction=Search&searchBy="+searchBy+"&txtSearch="+textSearch+"&IndexS="+index);
                        //out.print("<h3 style='color: crimson; text-align: center;'>Item already exist in Cart. Please check your Cart <a href='MainController?btAction=ViewCart'>here</a><h3> ");
                    }
                    
                }
                if (!exist) {
                    listCart.add(cart);
                    response.sendRedirect("MainController?btAction=Search&searchBy="+searchBy+"&txtSearch="+textSearch+"&IndexS="+index);
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
            Logger.getLogger(AddWithSearchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AddWithSearchController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddWithSearchController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AddWithSearchController.class.getName()).log(Level.SEVERE, null, ex);
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
