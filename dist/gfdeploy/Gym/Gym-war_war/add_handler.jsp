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
                        <%@page import="javax.naming.*, gym.*" %>
                        <%@ page errorPage="error.jsp"%>
                        <%!
                           UserSessionBeanRemote ejbRef;
                        %>
                        
                           <%
                               InitialContext ic = new InitialContext();
                               ejbRef = (UserSessionBeanRemote)ic.lookup("gym.UserSessionBeanRemote");
                               ejbRef.addAll(Integer.parseInt(request.getParameter("num")), Integer.parseInt(request.getParameter("time_type")), request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"));
                           
                               int id = ((Users)ejbRef.getUser(request.getParameter("firstName"), request.getParameter("lastName"))).getIdSub();
                           %>
                           <h1 style="color:#FAD61E; font-family:Arial;">Уважаемый, <%=request.getParameter("firstName") %> <%=request.getParameter("lastName") %>! <br>
                               Идентификатор Вашего абонемента: <b><%=id %></b><br>
                               Используйте его для входа в клуб</h1><br>
                           <a href='login.jsp' class="rollover2"></a>
			
        </center>
    </body>
</html>