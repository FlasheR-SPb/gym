<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <title>GOLD'S GYM</title>
    <link rel="stylesheet" href="css/style.css">
 </head>
 <body>
     <center>
	<a href="index.jsp"><img src="img/logo.png" width="300px"></img></a>
	<h1 style="color:#FAD61E; font-family:Arial; padding-bottom:10px;">бунд б йкса</h1>
 <%@page import="javax.naming.*, gym.*" %>
 <%@ page errorPage="error.jsp"%>
 <%!
    VisitSessionBeanRemote ejbRef;
 %>
    <%
        InitialContext ic = new InitialContext();
        ejbRef = (VisitSessionBeanRemote)ic.lookup("gym.VisitSessionBeanRemote");
        String message = (String)ejbRef.visit(Integer.parseInt(request.getParameter("id")));
    %>
    <h2 style="color:#FAD61E; font-family:Arial;"><%=message %></h2>
    </center>
 </body>
</html>