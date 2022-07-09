/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.DTO;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class OrderDTO extends CoursesDTO{   
    private int orderID;
    private String userID;
    private Date date;
    private int quantity;
    private double total;

    public OrderDTO() {
    }

    public OrderDTO(CoursesDTO courses, int orderID, String userID, Date date, int quantity, double total) {       
        this.orderID = orderID;
        this.userID = userID;
        this.date = date;
        this.quantity = quantity;
        this.total = total;
    }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
