/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyvt.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class FormattingDate {
    public static Date StringToDate(String dob) throws ParseException {
      //Instantiating the SimpleDateFormat class
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
      //Parsing the given String to Date object
      Date date = (Date) formatter.parse(dob);
//      System.out.println("Date object value: "+date);
      return date;
   }
    public static void main(String[] args) throws ParseException {
        String s = "2022/12/01";
        Date date = FormattingDate.StringToDate(s);
        System.out.println(date);
    }
}
