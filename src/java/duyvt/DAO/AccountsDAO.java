/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.DAO;

import duyvt.DTO.AccountsDTO;
import duyvt.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class AccountsDAO {
    AccountsDTO acc;
    public AccountsDTO getAccounts(){
        return acc;
    }
    public boolean checkLogin(String userID, String password) throws
            SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT * FROM [dbo].[duyvt.se150730.Accounts] WHERE userID = ? and password = ? ";
            //3. Create repare statement
            stm = con.prepareStatement(sql);
            stm.setString(1, userID);
            stm.setString(2, password);
            //4. Execute query
            rs = stm.executeQuery();
            if (rs.next()) {
                String user = rs.getString(1);
                String pass = rs.getString(2);
                String fullname = rs.getString(3);
                boolean isAdmin = rs.getBoolean(4);
                acc = new AccountsDTO(user, pass, fullname, isAdmin);
                
                return true;
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
        return false;
    }
    
    public boolean checkRole(String userID, String password) throws
            SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT * FROM [dbo].[duyvt.se150730.Accounts] WHERE userID = ? and password = ? ";
            //3. Create repare statement
            stm = con.prepareStatement(sql);
            stm.setString(1, userID);
            stm.setString(2, password);
            //4. Execute query
            rs = stm.executeQuery();
            boolean isAdmin = rs.getBoolean("isAdmin");
            if(isAdmin){
                return true;
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
        return false;
    }
    
    
}
