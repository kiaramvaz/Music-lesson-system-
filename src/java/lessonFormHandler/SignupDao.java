/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Kiara Vaz, April 22nd 2019. This class contains the sign up method. 
package lessonFormHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KiaraVaz
 */
public class SignupDao
{

    public static boolean signup(LoginBean jspAction)
    {
        Connection con = null;
        String dbName = "lessonDb";
        String connectionURl = "jdbc:mysql://localhost:3306/" + dbName;
        boolean status = false;

        try
        {
            //inserts the username and password into the database
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(connectionURl, "root", "mysql1");
            System.out.println("Con");
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO loginTable VALUES (?,?)");
            System.out.println("Statement");

            ps.setString(1, jspAction.getMyUsername());
            ps.setString(2, jspAction.getMyPassword());
            
            System.out.println("Set");
            ps.executeUpdate();
            System.out.println("Execute");
            con.close();

            status = true;

//            ResultSet rs = ps.executeQuery();
//            con.close();
        } catch (Exception e)
        {
            status = false;

        }
        return status;
    }
//
//    public static void main(String[] args) {
//        LoginBean loginBeanObj = new LoginBean("kiara123", "hello");
//        SignupDao signupbeanObj = new SignupDao();
//        try {
//            SignupDao.signup(loginBeanObj.getMyUsername(), loginBeanObj.getMyPassword());
//
//            //signup("zeyneb", "isgreat");
//        } catch (SQLException ex) {
//            System.out.println("ERROR");
//        }
//    }
}
