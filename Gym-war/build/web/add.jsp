<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>GOLD'S GYM</title>
		<link rel="stylesheet" href="css/style.css">
		                <script type='text/javascript'>
                        <!-- 
                        function showhideBlocks(val){
                                if (val == 0){
                                    document.getElementById('i1').style.display='none';
                                    document.getElementById('i2').style.display='none';
                                    document.getElementById('i3').style.display='none'; 
                                }
                                else{
                                   document.getElementById('i1').style.display='none';
                                   document.getElementById('i2').style.display='none';
                                   document.getElementById('i3').style.display='none';    
                                   document.getElementById('i'+val).style.display='block';  
                                } 	
                        }
						
						function calc() {
							
							var x = document.getElementById("items").selectedIndex;
							var val = document.getElementsByTagName("option")[x].value;
							
							var time1 = document.getElementById("time_type1").selectedIndex;
							var time2 = document.getElementById("time_type2").selectedIndex;
							var nov = document.getElementById("num_of_visits").selectedIndex + 1;
							var price = 0;
							
						
							if (val == 3) {
									price = 35000;
							}
							else if (val == 1) {
									
								price = 700;
								
								if (time1 == 0) {price = price - 200;}
								else if (time1 == 1) {price = price - 100;}
									
								price = price * nov;
							}
							else if (val == 2) {
								price = 700;
								
								if (time2 == 0) {price = price - 200;}
								else if (time2 == 1) {price = price - 100;}
								
								price = price * 10;
							}
							
							result.innerHTML = price;
							
							if (document.contact_form.firstName.value == "" || document.contact_form.firstName.value == "" || document.contact_form.email.value == "" || price == 0) {
								msg.innerHTML = "�� ��� ���� ���������";
							}
							else {
								document.getElementById("subm").disabled=false;
								msg.innerHTML = "";
                                                                if (val == 3) {
									document.contact_form.num.value = "-6";
									document.contact_form.time_type.value = "2";
								}
								else if (val == 1) {
									document.contact_form.num.value = nov;
									document.contact_form.time_type.value = time1;
								}
								else if (val == 2) {
									document.contact_form.num.value = "-12";
									document.contact_form.time_type.value = time2;
								}
							}
						}
						
                        -->
                </script>
    </head>
    <body>
		<center>
			<a href="index.jsp"><img src="img/logo.png" width="300px"></img></a>
			<h1 style="color:#FAD61E; font-family:Arial; padding-bottom:10px;">���������� ����������</h1>
                </center>
			<div class="styled-select">
					<form name="contact_form" action="add_handler.jsp" method="POST">
					<p>���: <input style="margin-left:46px;" type="text" name="firstName" value="" /></p>
					<p>�������: <input type="text" name="lastName" value="" /></p>
                                        <p>E-mail: <input style="margin-left:28px;" type="text" name="email" value="" /></p>
					<p>�������� ���� ��������� �����:</p>
					<select id="items" onchange="showhideBlocks(this.value)">
							<option value="0">����
							<option value="1">������� ���������
							<option value="2">��������� �� 12 ���������
							<option value="3">����������� ���������
					</select>
					<div id="i1">
						<p>�������� ���������� ���������:</p>
						<select id="num_of_visits">
							<option value="1">1
							<option value="2">2
							<option value="3">3
							<option value="4">4
							<option value="5">5
							<option value="6">6
						<select><br>
						<p>�������� ����� ���������:</p>
						<select id="time_type1">
							<option value="0">� 9:00 �� 16:00
							<option value="1">� 16:00 �� 23:00
							<option value="2">���� ����
						<select>
					</div>
					<div id="i2">
                                                <p>�� ����� 3 ��������� � ������*</p>
						<p>�������� ����� ���������:</p>
						<select id="time_type2">
							<option value="0">� 9:00 �� 16:00
							<option value="1">� 16:00 �� 23:00
							<option value="2">���� ����
						<select>
					</div>
                                        <div id="i3"><p><b>������ ��������</b> � ������� ��������!</p></div>
					<p>��������� ����������: <span id="result">0</span> ������</p>
					<p><span id="msg"></span></p>
                                        <input type="hidden" name = "num" value="">
					<input type="hidden" name = "time_type" value="">
					<input id="price" type="button" value="���������� ���������!" onclick="calc()"/><input id="subm" type="submit" value="��������!" disabled onclick="check()"/>
					
					</form>
			</div>

    </body>
</html>