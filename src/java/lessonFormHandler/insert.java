/*Kiara Vaz. April 22. This file containes all my methods to insert into the data base. 
The check methods checks to see if there is something in that cell of the database 
and the change methods changes the values in the corrosponding database to 
indicate that the cell is unavailable */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lessonFormHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KiaraVaz
 */
public class insert
{

    String booked;
    //JavaSqlDb dbSQLobj = new JavaSqlDb("lessonDb");
    Connection myDbConn;
    String connectionURL;

    String dbQuery1;
    String dbQuery2;
    String dbQuery4;
    String dbQuery5;
    String dbQuery6;
    String dbQuery7;
    String dbQuery3;
    LoginBean loginBObj = new LoginBean();
    int bool;

    boolean[][] monday = new boolean[1][6];

//method that inserts the values into the database table
    //constructor
    public insert()
    {
        this.connectionURL = "jdbc:mysql://localhost:3306/" + "lessonDb";
        this.dbQuery1 = "";
        this.dbQuery2 = "SELECT * FROM BoolV WHERE ID =?";
        this.dbQuery4 = "SELECT * FROM BoolD WHERE ID =?";
        this.dbQuery5 = "SELECT * FROM BoolG WHERE ID =?";
        this.dbQuery6 = "SELECT * FROM BoolMP WHERE ID =?";
        this.dbQuery7 = "SELECT * FROM BoolP WHERE ID =?";
        this.dbQuery3 = "";
    }

    //Voice methods enters student into the database 
    public String insertVoice(bookBean jspAction)
    {

        String day = jspAction.getDay();
        String time = jspAction.getTime();
        String name = jspAction.getName();

        insert objInsert = new insert();
        //checks to see if cell is available in corrosponding database 
        bool = objInsert.CheckV(day, time);
        try
        {

            if (time.equals("4pm"))
            {
                dbQuery1 = "UPDATE Voice SET 4pm =? WHERE Daily=?";
            } else if (time.equals("430pm"))
            {
                dbQuery1 = "UPDATE Voice SET 430pm =? WHERE Daily=?";
            } else if (time.equals("5pm"))
            {
                dbQuery1 = "UPDATE Voice SET 5pm =? WHERE Daily=?";
            } else if (time.equals("530pm"))
            {
                dbQuery1 = "UPDATE Voice SET 530pm =? WHERE Daily=?";
            } else if (time.equals("6pm"))
            {
                dbQuery1 = "UPDATE Voice SET 6pm =? WHERE Daily=?";
            } else if (time.equals("630pm"))
            {
                dbQuery1 = "UPDATE Voice SET 630pm =? WHERE Daily=?";
            }
        } catch (NullPointerException p)
        {
            System.out.println("Forgot to click soemthing");
        }


        if (bool == 0)
        {
            try
            {//Prepared Statement
                Class.forName("com.mysql.jdbc.Driver");
                myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                ps.setString(1, name);
                ps.setString(2, day);
                ps.executeUpdate();
                myDbConn.close();
                bool = 1;
                //changes value in corrosponding db to indicate that cell is taken
                objInsert.ChangeV(time, day);
                booked = "insert";

            } catch (SQLException r)
            {
                System.out.println("ERROR Sql ");
            } catch (ClassNotFoundException n)
            {
                System.out.println("ERROR Class not found");

        }
        }else
        {

            System.out.println("3");
            booked = "noInsert";
            System.out.println(booked);
        }
        System.out.println("Return");
        System.out.println(booked);
        return booked;

    }

    //method to check whether the lesson is available
    public int CheckV(String day, String time)
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("3");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
            System.out.println("4");
            ps.setString(1, day);
            ResultSet rs = ps.executeQuery();
            System.out.println("5");

            while (rs.next())
            {
                if (time.equals("4pm"))
                {
                    bool = Integer.parseInt(rs.getString("4pm"));
                } else if (time.equals("430pm"))
                {
                    bool = Integer.parseInt(rs.getString("430pm"));
                } else if (time.equals("5pm"))
                {
                    bool = Integer.parseInt(rs.getString("5pm"));
                } else if (time.equals("530pm"))
                {
                    bool = Integer.parseInt(rs.getString("530pm"));
                } else if (time.equals("6pm"))
                {
                    bool = Integer.parseInt(rs.getString("6pm"));
                } else if (time.equals("630pm"))
                {
                    bool = Integer.parseInt(rs.getString("630pm"));
                }
                System.out.println(bool + "this is boolshit");
            }
            myDbConn.close();
        } catch (SQLException r)
        {
            System.out.println("ERROR SQL");
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }catch (NullPointerException p)
        {
            System.out.println("Forgot to click soemthing");
        }

        return bool;
    }
//method to make lesson in the datable unavailable

    public void ChangeV(String time, String Day)
    {
        if (time.equals("4pm"))
        {
            dbQuery3 = "UPDATE BoolV SET 4pm =1 WHERE ID=?";
        } else if (time.equals("430pm"))
        {
            dbQuery3 = "UPDATE BoolV SET 430pm =1 WHERE ID=?";
        } else if (time.equals("5pm"))
        {
            dbQuery3 = "UPDATE BoolV SET 5pm =1 WHERE ID=?";
        } else if (time.equals("530pm"))
        {
            dbQuery3 = "UPDATE BoolV SET 530pm =1 WHERE ID=?";
        } else if (time.equals("6pm"))
        {
            dbQuery3 = "UPDATE BoolV SET 6pm =1 WHERE ID=?";
        } else if (time.equals("630pm"))
        {
            dbQuery3 = "UPDATE BoolV SET 630pm =1 WHERE ID=?";
        }
        try
        {//Prepared Statement
            int one = 1;
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("4");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            //ps.setInt(1, one);
            ps.setString(1, Day);
            ps.executeUpdate();
            myDbConn.close();
        } catch (SQLException r)
        {
            System.out.println("Error: Did not insert2");
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

    }

    //drum methods enters student into the database 
    //inserts name into database
    public String insertDrum(bookBean jspAction)
    {
        String day = jspAction.getDay();
        String time = jspAction.getTime();
        String name = jspAction.getName();

        LoginBean getSetObj = new LoginBean();
        String username = getSetObj.getMyUsername();
        insert objInsert = new insert();
        //checks to see if cell is available in corrosponding database
        bool = objInsert.CheckD(day, time);
        System.out.println(name);

        if (time.equals("4pm"))
        {
            dbQuery1 = "UPDATE Drum SET 4pm =? WHERE Daily=?";
        } else if (time.equals("430pm"))
        {
            dbQuery1 = "UPDATE Drum SET 430pm =? WHERE Daily=?";
        } else if (time.equals("5pm"))
        {
            dbQuery1 = "UPDATE Drum SET 5pm =? WHERE Daily=?";
        } else if (time.equals("530pm"))
        {
            dbQuery1 = "UPDATE Drum SET 530pm =? WHERE Daily=?";
        } else if (time.equals("6pm"))
        {
            dbQuery1 = "UPDATE Drum SET 6pm =? WHERE Daily=?";
        } else if (time.equals("630pm"))
        {
            dbQuery1 = "UPDATE Drum SET 630pm =? WHERE Daily=?";
        }

        if (bool == 0)
        {
            try
            {//Prepared Statement
                Class.forName("com.mysql.jdbc.Driver");
                myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
                System.out.println("1");
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                ps.setString(1, name);
                ps.setString(2, day);
                ps.executeUpdate();
                myDbConn.close();
                bool = 1;
                System.out.println("2");
                //changes value in corrosponding db to indicate that cell is taken
                objInsert.ChangeD(time, day);
                booked = "insert";
            } catch (SQLException r)
            {
                System.out.println("ERROR");
            } catch (ClassNotFoundException n)
            {
                System.out.println("ERROR Class not found");
            }

        } else
        {

            System.out.println("3");
            booked = "noInsert";
            System.out.println(booked);
        }
        return booked;

    }

    //method to check whether the lesson is available
    public int CheckD(String day, String time)
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("3");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery4);
            System.out.println("4");
            ps.setString(1, day);
            ResultSet rs = ps.executeQuery();
            System.out.println("5");

            while (rs.next())
            {
                if (time.equals("4pm"))
                {
                    bool = Integer.parseInt(rs.getString("4pm"));
                } else if (time.equals("430pm"))
                {
                    bool = Integer.parseInt(rs.getString("430pm"));
                } else if (time.equals("5pm"))
                {
                    bool = Integer.parseInt(rs.getString("5pm"));
                } else if (time.equals("530pm"))
                {
                    bool = Integer.parseInt(rs.getString("530pm"));
                } else if (time.equals("6pm"))
                {
                    bool = Integer.parseInt(rs.getString("6pm"));
                } else if (time.equals("630pm"))
                {
                }
                System.out.println(bool + "this is boolshit");
            }
            myDbConn.close();
        } catch (SQLException r)
        {
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

        return bool;
    }
//method to make lesson in the datable unavailable

    public void ChangeD(String time, String Day)
    {
        if (time.equals("4pm"))
        {
            dbQuery3 = "UPDATE BoolD SET 4pm =1 WHERE ID=?";
        } else if (time.equals("430pm"))
        {
            dbQuery3 = "UPDATE BoolD SET 430pm =1 WHERE ID=?";
        } else if (time.equals("5pm"))
        {
            dbQuery3 = "UPDATE BoolD SET 5pm =1 WHERE ID=?";
        } else if (time.equals("530pm"))
        {
            dbQuery3 = "UPDATE BoolD SET 530pm =1 WHERE ID=?";
        } else if (time.equals("6pm"))
        {
            dbQuery3 = "UPDATE BoolD SET 6pm =1 WHERE ID=?";
        } else if (time.equals("630pm"))
        {
            dbQuery3 = "UPDATE BoolD SET 630pm =1 WHERE ID=?";
        }
        try
        {//Prepared Statement
            int one = 1;
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("4");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            //ps.setInt(1, one);
            ps.setString(1, Day);
            ps.executeUpdate();
            myDbConn.close();
        } catch (SQLException r)
        {
            System.out.println("Error: Did not insert2");
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

    }

    //Guitar Methods enters student into the database 
    //inserts name into database
    public String insertGuitar(bookBean jspAction)
    {
        String day = jspAction.getDay();
        String time = jspAction.getTime();
        String name = jspAction.getName();

        LoginBean getSetObj = new LoginBean();
        String username = getSetObj.getMyUsername();
        insert objInsert = new insert();
        //checks to see if cell is available in corrosponding databass
        bool = objInsert.CheckG(day, time);
        System.out.println(name);

        if (time.equals("4pm"))
        {
            dbQuery1 = "UPDATE Guitar SET 4pm =? WHERE Daily=?";
        } else if (time.equals("430pm"))
        {
            dbQuery1 = "UPDATE Guitar SET 430pm =? WHERE Daily=?";
        } else if (time.equals("5pm"))
        {
            dbQuery1 = "UPDATE Guitar SET 5pm =? WHERE Daily=?";
        } else if (time.equals("530pm"))
        {
            dbQuery1 = "UPDATE Guitar SET 530pm =? WHERE Daily=?";
        } else if (time.equals("6pm"))
        {
            dbQuery1 = "UPDATE Guitar SET 6pm =? WHERE Daily=?";
        } else if (time.equals("630pm"))
        {
            dbQuery1 = "UPDATE Guitar SET 630pm =? WHERE Daily=?";
        }

        if (bool == 0)
        {
            try
            {//Prepared Statement
                Class.forName("com.mysql.jdbc.Driver");
                myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
                System.out.println("1");
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                ps.setString(1, name);
                ps.setString(2, day);
                ps.executeUpdate();
                myDbConn.close();
                bool = 1;
                System.out.println("2");
                //changes value in corrosponding db to indicate that cell is taken
                objInsert.ChangeG(time, day);
                booked = "insert";
            } catch (SQLException r)
            {
                System.out.println("ERROR");
            } catch (ClassNotFoundException n)
            {
                System.out.println("ERROR Class not found");
            }

        } else
        {

            System.out.println("3");
            booked = "noInsert";
            System.out.println(booked);
        }
        return booked;

    }

    //method to check whether the lesson is available
    public int CheckG(String day, String time)
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("3");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery5);
            System.out.println("4");
            ps.setString(1, day);
            ResultSet rs = ps.executeQuery();
            System.out.println("5");

            while (rs.next())
            {
                if (time.equals("4pm"))
                {
                    bool = Integer.parseInt(rs.getString("4pm"));
                } else if (time.equals("430pm"))
                {
                    bool = Integer.parseInt(rs.getString("430pm"));
                } else if (time.equals("5pm"))
                {
                    bool = Integer.parseInt(rs.getString("5pm"));
                } else if (time.equals("530pm"))
                {
                    bool = Integer.parseInt(rs.getString("530pm"));
                } else if (time.equals("6pm"))
                {
                    bool = Integer.parseInt(rs.getString("6pm"));
                } else if (time.equals("630pm"))
                {
                }
                System.out.println(bool + "this is boolshit");
            }
            myDbConn.close();
        } catch (SQLException r)
        {
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

        return bool;
    }
//method to make lesson in the datable unavailable

    public void ChangeG(String time, String Day)
    {
        if (time.equals("4pm"))
        {
            dbQuery3 = "UPDATE BoolG SET 4pm =1 WHERE ID=?";
        } else if (time.equals("430pm"))
        {
            dbQuery3 = "UPDATE BoolG SET 430pm =1 WHERE ID=?";
        } else if (time.equals("5pm"))
        {
            dbQuery3 = "UPDATE BoolG SET 5pm =1 WHERE ID=?";
        } else if (time.equals("530pm"))
        {
            dbQuery3 = "UPDATE BoolG SET 530pm =1 WHERE ID=?";
        } else if (time.equals("6pm"))
        {
            dbQuery3 = "UPDATE BoolG SET 6pm =1 WHERE ID=?";
        } else if (time.equals("630pm"))
        {
            dbQuery3 = "UPDATE BoolG SET 630pm =1 WHERE ID=?";
        }

        try
        {//Prepared Statement
            int one = 1;
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("4");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            //ps.setInt(1, one);
            ps.setString(1, Day);
            ps.executeUpdate();
            myDbConn.close();
        } catch (SQLException r)
        {
            System.out.println("Error: Did not insert2");
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

    }

    //Music Production Methods enters student into the database 
    //inserts name into database
    public String insertMProduction(bookBean jspAction)
    {
        String day = jspAction.getDay();
        String time = jspAction.getTime();
        String name = jspAction.getName();

        LoginBean getSetObj = new LoginBean();
        String username = getSetObj.getMyUsername();
        insert objInsert = new insert();
        //checks to see if cell is available in corrosponding database
        bool = objInsert.CheckMP(day, time);
        System.out.println(name);

        if (time.equals("4pm"))
        {
            dbQuery1 = "UPDATE MusicProduction SET 4pm =? WHERE Daily=?";
        } else if (time.equals("430pm"))
        {
            dbQuery1 = "UPDATE MusicProduction SET 430pm =? WHERE Daily=?";
        } else if (time.equals("5pm"))
        {
            dbQuery1 = "UPDATE MusicProduction SET 5pm =? WHERE Daily=?";
        } else if (time.equals("530pm"))
        {
            dbQuery1 = "UPDATE MusicProduction SET 530pm =? WHERE Daily=?";
        } else if (time.equals("6pm"))
        {
            dbQuery1 = "UPDATE MusicProduction SET 6pm =? WHERE Daily=?";
        } else if (time.equals("630pm"))
        {
            dbQuery1 = "UPDATE MusicProduction SET 630pm =? WHERE Daily=?";
        }

        if (bool == 0)
        {
            try
            {//Prepared Statement
                Class.forName("com.mysql.jdbc.Driver");
                myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
                System.out.println("1");
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                ps.setString(1, name);
                ps.setString(2, day);
                ps.executeUpdate();
                myDbConn.close();
                bool = 1;
                System.out.println("2");
                //changes value in corrosponding db to indicate that cell is taken
                objInsert.ChangeMP(time, day);
                booked = "insert";
            } catch (SQLException r)
            {
                System.out.println("ERROR");
            } catch (ClassNotFoundException n)
            {
                System.out.println("ERROR Class not found");
            }

        } else
        {

            System.out.println("3");
            booked = "noInsert";
            System.out.println(booked);
        }
        return booked;

    }

    //method to check whether the lesson is available
    public int CheckMP(String day, String time)
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("3");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery6);
            System.out.println("4");
            ps.setString(1, day);
            ResultSet rs = ps.executeQuery();
            System.out.println("5");

            while (rs.next())
            {
                if (time.equals("4pm"))
                {
                    bool = Integer.parseInt(rs.getString("4pm"));
                } else if (time.equals("430pm"))
                {
                    bool = Integer.parseInt(rs.getString("430pm"));
                } else if (time.equals("5pm"))
                {
                    bool = Integer.parseInt(rs.getString("5pm"));
                } else if (time.equals("530pm"))
                {
                    bool = Integer.parseInt(rs.getString("530pm"));
                } else if (time.equals("6pm"))
                {
                    bool = Integer.parseInt(rs.getString("6pm"));
                } else if (time.equals("630pm"))
                {
                }
                System.out.println(bool + "this is boolshit");
            }
            myDbConn.close();
        } catch (SQLException r)
        {
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

        return bool;
    }
//method to make lesson in the datable unavailable

    public void ChangeMP(String time, String Day)
    {
        if (time.equals("4pm"))
        {
            dbQuery3 = "UPDATE BoolMP SET 4pm =1 WHERE ID=?";
        } else if (time.equals("430pm"))
        {
            dbQuery3 = "UPDATE BoolMP SET 430pm =1 WHERE ID=?";
        } else if (time.equals("5pm"))
        {
            dbQuery3 = "UPDATE BoolMP SET 5pm =1 WHERE ID=?";
        } else if (time.equals("530pm"))
        {
            dbQuery3 = "UPDATE BoolMP SET 530pm =1 WHERE ID=?";
        } else if (time.equals("6pm"))
        {
            dbQuery3 = "UPDATE BoolMP SET 6pm =1 WHERE ID=?";
        } else if (time.equals("630pm"))
        {
            dbQuery3 = "UPDATE BoolMP SET 630pm =1 WHERE ID=?";
        }

        try
        {//Prepared Statement
            int one = 1;
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("4");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            //ps.setInt(1, one);
            ps.setString(1, Day);
            ps.executeUpdate();
            myDbConn.close();
        } catch (SQLException r)
        {
            System.out.println("Error: Did not insert2");
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

    }

    //Piano Methods- enters student into the database 
    //inserts name into database
    public String insertPiano(bookBean jspAction)
    {

        String day = jspAction.getDay();
        String time = jspAction.getTime();
        String name = jspAction.getName();

        insert objInsert = new insert();
        //checks to see if cell is available in corrosponding database 
        bool = objInsert.CheckP(day, time);

        if (time.equals("4pm"))
        {
            dbQuery1 = "UPDATE Piano SET 4pm =? WHERE Daily=?";
        } else if (time.equals("430pm"))
        {
            dbQuery1 = "UPDATE Piano SET 430pm =? WHERE Daily=?";
        } else if (time.equals("5pm"))
        {
            dbQuery1 = "UPDATE Piano SET 5pm =? WHERE Daily=?";
        } else if (time.equals("530pm"))
        {
            dbQuery1 = "UPDATE Piano SET 530pm =? WHERE Daily=?";
        } else if (time.equals("6pm"))
        {
            dbQuery1 = "UPDATE Piano SET 6pm =? WHERE Daily=?";
        } else if (time.equals("630pm"))
        {
            dbQuery1 = "UPDATE Piano SET 630pm =? WHERE Daily=?";
        }
        System.out.println(dbQuery1);

        System.out.println(bool);
        if (bool == 0)
        {
            try
            {//Prepared Statement
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("11");
                myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
                System.out.println("22");
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                System.out.println("33");
                ps.setString(1, name);
                System.out.println("44");
                ps.setString(2, day);
                System.out.println("55");
                ps.executeUpdate();
                System.out.println("66");
                myDbConn.close();
                bool = 1;
                //changes value in corrosponding db to indicate that cell is taken
                objInsert.ChangeP(time, day);
                System.out.println("Changeds");
                booked = "insert";

            } catch (SQLException r)
            {
                System.out.println("ERROR Sql ");
            } catch (ClassNotFoundException n)
            {
                System.out.println("ERROR Class not found");
            }

        } else
        {

            System.out.println("3");
            booked = "noInsert";
            System.out.println(booked);
        }
        System.out.println("Return");
        System.out.println(booked);
        return booked;

    }

    //method to check whether the lesson is available
    public int CheckP(String day, String time)
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("3");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery7);
            System.out.println("4");
            ps.setString(1, day);
            ResultSet rs = ps.executeQuery();
            System.out.println("5");

            while (rs.next())
            {
                if (time.equals("4pm"))
                {
                    bool = Integer.parseInt(rs.getString("4pm"));
                } else if (time.equals("430pm"))
                {
                    bool = Integer.parseInt(rs.getString("430pm"));
                } else if (time.equals("5pm"))
                {
                    bool = Integer.parseInt(rs.getString("5pm"));
                } else if (time.equals("530pm"))
                {
                    bool = Integer.parseInt(rs.getString("530pm"));
                } else if (time.equals("6pm"))
                {
                    bool = Integer.parseInt(rs.getString("6pm"));
                } else if (time.equals("630pm"))
                {
                }
                System.out.println(bool + "this is boolshit");
            }
            myDbConn.close();
        } catch (SQLException r)
        {
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

        return bool;
    }
//method to make lesson in the datable unavailable

    public void ChangeP(String time, String Day)
    {
        if (time.equals("4pm"))
        {
            dbQuery3 = "UPDATE BoolP SET 4pm =1 WHERE ID=?";
        } else if (time.equals("430pm"))
        {
            dbQuery3 = "UPDATE BoolP SET 430pm =1 WHERE ID=?";
        } else if (time.equals("5pm"))
        {
            dbQuery3 = "UPDATE BoolP SET 5pm =1 WHERE ID=?";
        } else if (time.equals("530pm"))
        {
            dbQuery3 = "UPDATE BoolP SET 530pm =1 WHERE ID=?";
        } else if (time.equals("6pm"))
        {
            dbQuery3 = "UPDATE BoolP SET 6pm =1 WHERE ID=?";
        } else if (time.equals("630pm"))
        {
            dbQuery3 = "UPDATE BoolP SET 630pm =1 WHERE ID=?";
        }
        try
        {//Prepared Statement

            Class.forName("com.mysql.jdbc.Driver");
            myDbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            System.out.println("4");
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            //ps.setInt(1, one);
            ps.setString(1, Day);
            ps.executeUpdate();
            myDbConn.close();
        } catch (SQLException r)
        {
            System.out.println("Error: Did not insert2");
        } catch (ClassNotFoundException n)
        {
            System.out.println("ERROR Class not found");
        }

    }

//    public static void main(String[] args)
//    {
//        bookBean bookBObj = new bookBean();
//
//        insert objInsert = new insert();
//        int bool;
//        String username = "ki";
//        String time = "630pm";
//        String day = "Tuesday";
//
//        bookBObj.setTime(time);
//        bookBObj.setDay(day);
//        bookBObj.setName(username);
//
//        String booked = objInsert.insertVoice(bookBObj);
//        System.out.println(booked);
//
////        if (be.equals("insert")){
////                System.out.println("yeet " + be);  
////            }
////        
////        else if (be.equals("noInsert")){
////                 System.out.println("NONO");  
////        }  
//    }
//
}
