//Kiara Vaz, April 22nd 2019
//get and set methods for my usernamed and password.

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lessonFormHandler;

import java.sql.Connection;

/**
 *
 * @author KiaraVaz
 */


public class LoginBean {
    String myPassword;
    String myUsername;

    public String getMyPassword()
    {
        return myPassword;
    }

    public void setMyPassword(String myPassword)
    {
        this.myPassword = myPassword;
    }

    public String getMyUsername()
    {
        return myUsername;
    }

    public void setMyUsername(String myUsername)
    {
        this.myUsername = myUsername;
    }
    
}




