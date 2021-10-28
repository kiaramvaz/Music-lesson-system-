<%-- 
    Document   : pickTeacher
    Created on : Mar 18, 2019, 2:23:10 PM
    Author     : KiaraVaz
--%>

<%--Kiara Vaz, April 22nd 2019
User picks what type of music lessons in this page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<link rel="stylesheet" type="text/css" href="indexcss.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- Navigation Bar --> Takes user to different parts of the application
        --%>
        <ul class="navBar">
            <li> <form method="GET" action="index.html" >
                <button id="navBarButton"type="submit">Logout</button>
            </form> </li>
            <li> <form method="GET" action="aboutPage.html" >
                <button id="navBarButton"type="submit">About</button>
            </form> </li>
            <li> <form method="POST" action="pickTeacher2" >
                <button id="navBarButton"type="submit">Home</button>
            </form> </li>
        </ul>
        <h1 class="center">Pick the type of lesson!</h1>
        <div>  
            <%--user picks the kind of lesson he wants
        --%>
            <form method="POST" action="voice">
                <button class= "classbutton" type="submit">Voice</button>
            </form>
            <form method="POST" action="drum">
                <button  class= "classbutton"type="submit">Drum</button>
            </form>
            <form method="POST" action="piano">
                <button class= "classbutton" type="submit">Piano</button>
            </form>
            <form method="POST" action="production">
                <button class= "classbutton" type="submit">Production</button>
            </form>
            <form method="POST" action="guitar">
                <button class= "classbutton" type="submit">Guitar</button>
            </form>
        </div>
        
        <div>
            
</div>
    </body>
</html>
