<%-- 
    Document   : homepage
    Created on : Nov 9, 2017, 12:31:27 PM
    Author     : XPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome back, ${username}</h1>
        <form action="home.htm" method="post" >
            <button name="username" >${username}${var1}</button>
            
        </form>
        
    </body>
</html>
