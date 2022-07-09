/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.DAO;

import duyvt.DTO.CartDTO;
import duyvt.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CartDAO {

    public double getTotalCartPrice(List<CartDTO> listCard) {
        double sum = 0;
        double sumTotal = 0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            if (listCard.size() > 0) {
                for (CartDTO c : listCard) {
                    String sql = "SELECT tuitionFee\n"
                            + "from [dbo].[duyvt.se150730.Courses] \n"
                            + "WHERE ID = ?";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, c.getCourses().getID());
                    rs = stm.executeQuery();
                    
                    while(rs.next()){
                        sum+=rs.getDouble("tuitionFee")*c.getQuantity();
                        
                    }
                    sumTotal = sum - sum*0.1;
                }
            }

        } catch (Exception e) {
        }

        return sumTotal;

    }
    public double getTotalCartDiscount(List<CartDTO> listCard) {
        double sum = 0;
        double discountTotal = 0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            if (listCard.size() > 0) {
                for (CartDTO c : listCard) {
                    String sql = "SELECT tuitionFee\n"
                            + "from [dbo].[duyvt.se150730.Courses] \n"
                            + "WHERE ID = ?";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, c.getCourses().getID());
                    rs = stm.executeQuery();
                    
                    while(rs.next()){
                        sum+=rs.getDouble("tuitionFee")*c.getQuantity();
                        
                    }
                    discountTotal = sum*0.1;
                }
            }

        } catch (Exception e) {
        }

        return discountTotal;

    }
    
    public double getTotal(List<CartDTO> listCard) {
        double sum = 0;      
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            if (listCard.size() > 0) {
                for (CartDTO c : listCard) {
                    String sql = "SELECT tuitionFee\n"
                            + "from [dbo].[duyvt.se150730.Courses] \n"
                            + "WHERE ID = ?";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, c.getCourses().getID());
                    rs = stm.executeQuery();
                    
                    while(rs.next()){
                        sum+=rs.getDouble("tuitionFee")*c.getQuantity();
                        
                    }                 
                }
            }

        } catch (Exception e) {
        }

        return sum;

    }
}
