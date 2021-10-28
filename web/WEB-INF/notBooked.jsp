<%-- 
    Document   : notBooked
    Created on : Apr 17, 2019, 8:12:22 PM
    Author     : KiaraVaz
--%>

<%-- Kiara Vaz, April 22nd 2019
This is the what is displayed when the user  signs up for a lesson that isn't available and has been booked by someone else
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="indexcss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1 class="center"> The time slot you picked is unavailable; please try another time slot</h1>
        <form class="center" method="POST" action="pickTeacher2">
                <button  class="button1"  class="center" type ="submit">Try Again</button>
            </form>
    </body>
</html>
