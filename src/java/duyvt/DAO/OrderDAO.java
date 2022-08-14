/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.DAO;

import duyvt.DTO.OrderDTO;
import duyvt.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class OrderDAO {

    public boolean insertOrder(OrderDTO model) throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "INSERT INTO [dbo].[duyvt.se150730.Order] (orderID,userID,courseID,orderDate,orderQuantity,total)\n"
                    + "VALUES (?,?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, model.getOrderID());
            stm.setString(2, model.getUserID());
            stm.setInt(3, model.getCourseID());
            stm.setDate(4, new java.sql.Date(model.getDate().getTime()));
            stm.setInt(5, model.getQuantity());
            stm.setDouble(6, model.getTotal());
            stm.executeUpdate();
            result = true;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return result;
    }

    public static int setOrderID() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 1;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT * FROM [dbo].[duyvt.se150730.Order]\n"
                    + "ORDER BY orderID";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            int temp = 0;
            while (rs.next()) {
                if (result != rs.getInt("orderID")) {
                    return result;
                } else {
                    result++;
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return result;
    }

    public List<OrderDTO> listOrders() throws SQLException, NamingException {
        List<OrderDTO> list = new ArrayList<>();
        OrderDTO orderDTO = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
       
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT * FROM [dbo].[duyvt.se150730.Order]";
            stm = con.prepareStatement(sql);
//            stm.setString(1, userID);
            rs = stm.executeQuery();
            
            while (rs.next()) {
                orderDTO = new OrderDTO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getInt(5),rs.getDouble(6));
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(orderDTO);
            }
            

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return list;
    }
}
