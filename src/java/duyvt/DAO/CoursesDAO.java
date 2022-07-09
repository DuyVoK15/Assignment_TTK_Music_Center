/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.DAO;

import duyvt.DTO.CoursesDTO;
import static duyvt.convert.FormattingDate.StringToDate;
import duyvt.utils.DBUtils;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class CoursesDAO {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    List<CoursesDTO> listCourses;

    public List<CoursesDTO> getListCourses() {
        return listCourses;
    }

    public List<CoursesDTO> readCourses(int index) throws NamingException, SQLException {
        List<CoursesDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT * FROM [dbo].[duyvt.se150730.Courses]\n"
                    + "WHERE status = 1 AND quantity > 0\n"
                    + "ORDER BY startDate\n"
                    + "OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY;";
            //3. Create repare statement
            stm = con.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 4);
            //4. Execute query
            rs = stm.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String imgPath = rs.getString("imgPath");
                String description = rs.getString("description");
                int tuitionFee = rs.getInt("tuitionFee");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String category = rs.getString("category");
                boolean status = rs.getBoolean("status");
                int quantity = rs.getInt("quantity");
                CoursesDTO dto = new CoursesDTO(ID, name, imgPath, description, tuitionFee, startDate, endDate, category, status, quantity);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(dto);
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
    
    public List<CoursesDTO> manageViewCourses(int index) throws NamingException, SQLException {
        List<CoursesDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT * FROM [dbo].[duyvt.se150730.Courses]\n"                   
                    + "ORDER BY startDate\n"
                    + "OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY;";
            //3. Create repare statement
            stm = con.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 4);
            //4. Execute query
            rs = stm.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String imgPath = rs.getString("imgPath");
                String description = rs.getString("description");
                int tuitionFee = rs.getInt("tuitionFee");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String category = rs.getString("category");
                boolean status = rs.getBoolean("status");
                int quantity = rs.getInt("quantity");
                CoursesDTO dto = new CoursesDTO(ID, name, imgPath, description, tuitionFee, startDate, endDate, category, status, quantity);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(dto);
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

    public void searchCourses(String textSearch, String searchBy) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT TOP(20) ID, name, imgPath, description, tuitionFee, startDate, endDate, category, status, quantity\n"
                    + "FROM [dbo].[duyvt.se150730.Courses]\n";

            if (searchBy.equalsIgnoreCase("byName")) {
                sql = sql + "WHERE name LIKE ? AND status = 1 AND quantity > 0\n"
                        + "ORDER BY startDate";
            } else {
                sql = sql + "WHERE category LIKE ? AND status = 1 AND quantity > 0\n"
                        + "ORDER BY startDate";
            }
            //3. Create repare statement
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + textSearch + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String imgPath = rs.getString("imgPath");
                String description = rs.getString("description");
                int tuitionFee = rs.getInt("tuitionFee");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String category = rs.getString("category");
                boolean status = rs.getBoolean("status");
                int quantity = rs.getInt("quantity");
                CoursesDTO dto = new CoursesDTO(ID, name, imgPath, description, tuitionFee, startDate, endDate, category, status, quantity);
                if (listCourses == null) {
                    listCourses = new ArrayList<>();
                }
                listCourses.add(dto);
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
    }

    public int getTotalCoursesManage() throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT COUNT(*) FROM [dbo].[duyvt.se150730.Courses]";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
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
        return 0;
    }
    
    public int getTotalCoursesView() throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT COUNT(*) FROM [dbo].[duyvt.se150730.Courses]\n"
                    + "WHERE status = 1 AND quantity > 0";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
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
        return 0;
    }
    
    public boolean updateCourses(int ID, String name, String imgPath, String description, int tuitionFee, Date startDate, Date endDate, String category, boolean status, int quantity) throws SQLException, NamingException, ParseException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //Open connection 
            con = DBUtils.makeConnection();
            //2.Tao chuoi ket noi/Create sql string
            String sql = "UPDATE [dbo].[duyvt.se150730.Courses]\n"
                    + "SET [name] = ?, [imgPath] = ?, [description] = ?, [tuitionFee] = ?, startDate =?, endDate =?, [category] = ?, [status]= ?, [quantity] = ?\n"
                    + "WHERE ID = ?";
            //3.Prepared stm
            stm = con.prepareStatement(sql);
            // thêm
            stm.setString(1, name);
            stm.setString(2, imgPath);
            stm.setString(3, description);
            stm.setInt(4, tuitionFee);
            stm.setDate(5, new java.sql.Date(startDate.getTime()));
            stm.setDate(6, new java.sql.Date(endDate.getTime()));
            stm.setString(7, category);
            stm.setBoolean(8, status);
            stm.setInt(9, quantity);
            stm.setInt(10, ID);
            //4.Excecute query
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }

        } finally {
            if (stm != null) {
                con.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;

    }
    
    public boolean createCourses(int ID, String name, String imgPath, String description, int tuitionFee, Date startDate, Date endDate, String category, boolean status, int quantity) throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "INSERT INTO [dbo].[duyvt.se150730.Courses]\n"
                    + "(ID, name, imgPath, description, tuitionFee, startDate, endDate, category, status, quantity)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            //3. Create repare statement
            stm = con.prepareStatement(sql);
            stm.setInt(1, ID);
            stm.setString(2, name);
            stm.setString(3, imgPath);
            stm.setString(4, description);
            stm.setInt(5, tuitionFee);
            stm.setDate(6, new java.sql.Date(startDate.getTime()));
            stm.setDate(7, new java.sql.Date(endDate.getTime()));
            stm.setString(8, category);
            stm.setBoolean(9, status);
            stm.setInt(10, quantity);
            
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }
        } finally {
            if (stm != null) {
                con.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;

    }
    
    public CoursesDTO findCourseID(int ID) throws SQLException, NamingException {
        CoursesDTO dto = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            con = DBUtils.makeConnection();
            //2. Create SQL string
            String sql = "SELECT ID, name, imgPath, description, tuitionFee, startDate, endDate, category, status, quantity\n"
                    + "FROM [dbo].[duyvt.se150730.Courses]\n"
                    + "WHERE ID = ?";

            
            //3. Create repare statement
            stm = con.prepareStatement(sql);
            stm.setInt(1, ID);
            rs = stm.executeQuery();
            while (rs.next()) {
                int cID = rs.getInt("ID");
                String name = rs.getString("name");
                String imgPath = rs.getString("imgPath");
                String description = rs.getString("description");
                int tuitionFee = rs.getInt("tuitionFee");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String category = rs.getString("category");
                boolean status = rs.getBoolean("status");
                int quantity = rs.getInt("quantity");
                dto = new CoursesDTO(ID, name, imgPath, description, tuitionFee, startDate, endDate, category, status, quantity);
                return dto;
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
        return dto;
    }
    
}
