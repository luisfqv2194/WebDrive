<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        
        <h1>Login</h1>
        
        
        <form action="login.htm" method="post">
            <input type="text" name="txtUsername" /> Username<br /><br />
            <input type="password" name="txtPassword" /> Password<br /><br />
            <input type="submit" value="Sign In" />
        </form>
        <h3 style="color: #ff0033" >${err}</h3>
        
    </body>
</html>
