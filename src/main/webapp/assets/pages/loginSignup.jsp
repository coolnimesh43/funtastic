<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in and Sign up - Single Form</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style-new.css">
<link rel="stylesheet" href="css/custom.css">
<link type="text/css" rel="stylesheet" href="assets/bower_components/Materialize/dist/css/materialize.min.css" media="screen,projection" />
</head>
<body>
	<div class="cont_principal">
		<div class="cont_centrar">
			<div class="cont_login">
				<form action="">
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
						<input type="text" class="input_form_sign " placeholder="NAME" name="name_us" />

						<input type="text" class="input_form_sign d_block active_inp" placeholder="EMAIL" name="emauil_us" />

						<input type="password" class="input_form_sign d_block  active_inp" placeholder="PASSWORD" name="pass_us" />
						<input type="password" class="input_form_sign" placeholder="CONFIRM PASSWORD" name="conf_pass_us" />

						<a href="#" class="link_forgot_pass d_block">Forgot Password ?</a>
						<div class="terms_and_cons d_none">
							<p>
								<input type="checkbox" name="terms_and_cons" />
								<label for="terms_and_cons">Accept Terms and Conditions.</label>
							</p>

						</div>
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
