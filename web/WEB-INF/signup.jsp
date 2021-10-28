<%-- 
    Document   : signup
    Created on : Apr 3, 2019, 10:37:06 AM
    Author     : KiaraVaz
--%>
<%-- This is the what is displayed when the user succesfully signs up 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="indexcss.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class="navBar">
            <li> <form method="POST" action="index" >
                    <button id="navBarButton"type="submit">Logout</button>
                </form> </li>
            <li> <form method="POST" action="aboutPage" >
                    <button id="navBarButton"type="submit">About</button>
                </form> </li>
            
        </ul>
        <h1 class="center" >You have successfully signed up!</h1>
        
        <%-- sends the user back to login page
        --%>
        <form class="center" method="GET" action="index.html">
                <button class="button1" class="center" type="submit">Go back and login</button>
            </form>
    </body>
</html>
