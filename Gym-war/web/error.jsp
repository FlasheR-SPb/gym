<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" %>
<html>
    <head>
        <title>GOLD'S GYM</title>
		<link rel="stylesheet" href="css/style.css">
    </head>
    <body>
	<center>
            <a href="index.jsp"><img src="img/logo.png" width="300px" /></a>
            <h1 style="color:#FAD61E; font-family:Arial;">й янфюкемхч, бнгмхйкю ньхайю!</h1>
            <p>${pageContext.errorData.throwable.message}</p>
            <img src="img/error.jpg" width="300px" style="padding-left: 500px; padding-top: 210px"></img>
        </center>
    </body>
</html>