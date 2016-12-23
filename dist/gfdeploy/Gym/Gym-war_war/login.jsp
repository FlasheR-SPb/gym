<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>GOLD'S GYM</title>
	<link rel="stylesheet" href="css/style.css">
    </head>
    <body>
	<center>
		<a href="index.jsp"><img src="img/logo.png" width="300px"></img></a>
		<h1 style="color:#FAD61E; font-family:Arial; padding-bottom:10px;">ВХОД В КЛУБ</h1>
	</center>
	<div class="styled-select" style="display: inline-block; margin-right: 30px;">
		<form name="contact_form" action="login_handler.jsp" method="GET">
                	<p>Введите Ваш Идентификатор:</p>
			<p>ID: <input type="text" name="id" value="" /></p>
			<input id="subm" type="submit" value="Login!"/>
		</form>
	</div>
	<div style="display: inline-block; position:absolute; padding-left: 100px;"><img src="img/animal.jpg" width="500" /></div>
    </body>
</html>