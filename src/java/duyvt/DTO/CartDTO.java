/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.DTO;

/**
 *
 * @author ASUS
 */
public class CartDTO {
    private CoursesDTO courses;
    private int quantity;

    public CoursesDTO getCourses() {
        return courses;
    }

    public void setCourses(CoursesDTO courses) {
        this.courses = courses;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartDTO() {
    }

    public CartDTO(CoursesDTO courses, int quantity) {
        this.courses = courses;
        this.quantity = quantity;
        
    }
    
    
}
