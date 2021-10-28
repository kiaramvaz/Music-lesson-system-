<%-- 
    Document   : book
    Created on : Apr 9, 2019, 11:17:53 AM
    Author     : KiaraVaz
--%>
<%-- Kiara Vaz, April 22nd 2019
This is the what is displayed when the user succesfully signs up for a lesson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="indexcss.css">

        <title>JSP Page</title>
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
        <h1 class="center"> You have booked successfully</h1>
        <form class="center" method="POST" action="pickTeacher2">
            <button  class="button1" class="center" type ="submit">Book another lesson!</button>
        </form>
    </body>
</html>
