<%-- 
    Document   : errorPage
    Created on : Apr 25, 2019, 2:37:23 PM
    Author     : KiaraVaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true"%>
<!DOCTYPE html>

<link rel="stylesheet" type="text/css" href="indexcss.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="center">Make sure you have inputed all the values. Also 
        make sure that no strange characters are inputed (characters and numbers only)
        and that your input is under 20 characters :)</h1>
        <form class="center" method="POST" action="index.html">
                <button  class="button1" class="center" type ="submit">Try Again</button>
            </form>
    </body>
</html>
