<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign in and Sign up - Single Form</title>
<link type="text/css" rel="stylesheet" href="assets/bower_components/Materialize/dist/css/materialize.min.css" media="screen,projection" />
<link type="text/css" rel="stylesheet" href="assets/css/style.css" />
<link type="text/css" rel="stylesheet" href="assets/css/style-new.css" />
<link type="text/css" rel="stylesheet" href="assets/css/custom.css" />
</head>
<body>
	<div class="cont_principal">
		<div class="cont_centrar">
			<div class="cont_login">
				<form action='<c:url value="/login"></c:url>' method='POST'>
					<div class="cont_tabs_login">
						<ul class='ul_tabs'>
							<li class="active">
								<a href="#" onclick="sign_in()">SIGN IN</a>
								<span class="linea_bajo_nom"></span>
							</li>
							<li>
								<a href="#up" onclick="sign_up()">SIGN UP</a>
								<span class="linea_bajo_nom"></span>
							</li>
						</ul>
					</div>
					<div class="cont_text_inputs">
						<input type="text" class="input_form_sign " placeholder="FIRST NAME" name="firstName" />
						<input type="text" class="input_form_sign " placeholder="LAST NAME" name="lastName" />

						<input type="text" class="input_form_sign d_block active_inp" placeholder="EMAIL" name="email" />

						<input type="password" class="input_form_sign d_block  active_inp" placeholder="PASSWORD" name="password" />
						<input type="password" class="input_form_sign" placeholder="CONFIRM PASSWORD" name="rePassword" />

						<a href="void:javascript(0)" class="link_forgot_pass d_block">Forgot Password ?</a>
					</div>
					<div class="cont_btn">
						<button class="btn_sign">SIGN IN</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="assets/js/login.js"></script>
	<script type="text/javascript" src="assets/bower_components/Materialize/dist/js/materialize.min.js"></script>
</body>
</html>
