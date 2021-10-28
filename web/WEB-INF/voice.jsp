<%-- 
    Document   : voice
    Created on : Mar 18, 2019, 2:35:26 PM
    Author     : KiaraVaz
--%>

<%-- Kiara Vaz, April 22nd 2019
This where the user picks the day and time of theyre voice lessons
--%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="radioButton.css">
        <link rel="stylesheet" type="text/css" href="indexcss.css">
        <title> Voice Lessons</title>
    </head>
    <body>
        <%-- Navigation Bar --> Takes user to different parts of the application
        --%>
        <ul class="navBar">
            <li> <form method="POST" action="index" >
                    <button id="navBarButton"type="submit">Logout</button>
                </form> </li>
            <li> <form method="POST" action="aboutPage" >
                    <button id="navBarButton"type="submit">About</button>
                </form> </li>
            <li> <form method="POST" action="pickTeacher2" >
                    <button id="navBarButton"type="submit">Home</button>
                </form> </li>
        </ul>
        <h1 class="center">Voice Lesson Scheduling</h1>
        <div class="center" class="row" >
            <div class="inputGroup" >
                <%-- User Input
                --%>
                <form class="form" action="VBook" method="POST">
                    Name: <input class= "center" type="text" name="name"/><br/>
                    Day:
                    </br>
                    
                    Monday<input type="radio" name="day" value="Monday">
                    Tuesday <input type="radio" name="day" value="Tuesday"> 
                    Wednesday <input type="radio" name="day" value="Wednesday">
                    Thursday<input  type="radio" name="day" value="Thursday">
                    Friday <input type="radio" name="day" value="Friday"> 
                   
                    </br>
                    </br>

                    Time:
                    </br>
                    4pm <input type="radio" name="time" value="4pm"> 
                    4:30pm <input type="radio" name="time" value="430pm"> 
                    5pm <input type="radio" name="time" value="5pm">
                    5:30pm <input type="radio" name="time" value="530pm"> 
                    6pm <input type="radio" name="time" value="6pm"> 
                    6:30pm <input type="radio" name="time" value="630pm"> 
                    </br>
                    <input class="button2" type="submit" value="Submit">
                </form>


            </div>
        </div>
    </body>
</html>
