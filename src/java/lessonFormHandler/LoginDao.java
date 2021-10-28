/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Kiara Vaz, April 22nd 2019. This class contains the login method. 
package lessonFormHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author KiaraVaz
 */
public class LoginDao {
    public static boolean validate(LoginBean jspAction){
        Connection con=null;
        String DbName = "lessonDb";
        String connectionURL="jdbc:mysql://localhost:3306/" + DbName;
        boolean status=false;
        try{
            //checks to see whether username and password exists in order to let the user through 
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(connectionURL, "root","mysql1");
            PreparedStatement ps= con.prepareStatement(
                    "SELECT * FROM loginTable WHERE Username=? and Password=?");
            
            ps.setString(1, jspAction.getMyUsername());
            ps.setString(2, jspAction.getMyPassword());
            
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        }
        catch (Exception e){   
    }
         return status;
}





//    public static void main(String[] args) {
//        String username = "123";
//        String password = "123";
//        LoginDao LoginObj = new LoginDao();
//        LoginBean obj = new LoginBean();
//        LoginObj.validate(obj);
//        
//    }
}
