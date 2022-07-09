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

/**
 *
 * @author ASUS
 */
public class OrderDAO {

    public boolean insertOrder(OrderDTO model) {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "INSERT INTO [dbo].[duyvt.se150730.Order] (orderID,userID,orderDate,orderQuantity,total)\n"
                    + "VALUES (?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, model.getOrderID());
            stm.setString(2, model.getUserID());
            stm.setDate(3, new java.sql.Date(model.getDate().getTime()));
            stm.setInt(4, model.getQuantity());
            stm.setDouble(5, model.getTotal());
            stm.executeUpdate();
            result = true;
        } catch (Exception e) {
        }

        return result;
    }
}
