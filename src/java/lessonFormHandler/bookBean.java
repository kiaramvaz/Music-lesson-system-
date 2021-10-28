/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Kiara Vaz, April 22nd 2019. Get and set methods for day, time and name which the user inputs.
package lessonFormHandler;

/**
 *
 * @author KiaraVaz
 */
public class bookBean
{
    private String name;
    private String day;
    private String time;

  //constructor
    public bookBean()
    {
        this.name = "";
        this.day = "";
        this.time = "";
    }
            
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
    
}
