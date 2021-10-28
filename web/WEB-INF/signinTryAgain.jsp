<%-- 
    Document   : signinTryAgain
    Created on : Apr 11, 2019, 2:21:11 PM
    Author     : KiaraVaz
--%>
<%-- Kiara Vaz, April 22nd 2019
This is the what is displayed when the user tries to login with the wrong username/password
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
        <h1 class="center"> This username/password already exists; try again! </h1>
        <%-- sends the user back to login page to try again
        --%>
        <form class="center" method="GET" action="index.html">
            <button class="button1" type="submit">Back</button>
        </form>
    </body>
</html>
