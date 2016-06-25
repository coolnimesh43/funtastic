<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard</title>

<!-- Add to homescreen for Chrome on Android -->
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192" href="images/android-desktop.png">

<!-- Add to homescreen for Safari on iOS -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Material Design Lite">
<link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

<!-- Tile icon for Win8 (144x144 + tile color) -->
<meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
<meta name="msapplication-TileColor" content="#3372DF">

<link rel="shortcut icon" href="assets/images/favicon.png">

<!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
<!--
    <link rel="canonical" href="http://www.example.com/">
    -->
<link href="assets/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/bower_components/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="assets/bower_components/Materialize/dist/css/materialize.min.css" media="screen,projection" />
<link href="assets/css/material.min.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/styles.css" rel="stylesheet">
<link href="assets/css/custom.css" rel="stylesheet">
<style>
#view-source {
	position: fixed;
	display: block;
	right: 0;
	bottom: 0;
	margin-right: 40px;
	margin-bottom: 40px;
	z-index: 900;
}
</style>
</head>
<body>
	<div class="mdl-layout__container">
		<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

			<header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600" id="conversation-title"> </header>
			<!-- Add the conversation title here -->


			<div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
				<header class="demo-drawer-header" id="header-user-info">

					<!-- Add user info here  -->


				</header>
				<nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800" id="active-conversations">

					<!-- Active conversations here -->

				</nav>
			</div>
			<main class="mdl-layout__content mdl-color--grey-100">
			<div class="mdl-grid demo-content">
				<div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">

					<div class="col-md-8" id="chatResponseBlock"></div>

				</div>
			</div>
			</main>
		</div>
	</div>
	<%@ include file="/WEB-INF/templates/_chat.jsp"%>
	<%@ include file="/WEB-INF/templates/_conversationTitle.jsp"%>
	<%@ include file="/WEB-INF/templates/_userInfo.jsp"%>
	<%@ include file="/WEB-INF/templates/_activeConversation.jsp"%>
	<script type="text/javascript" src="assets/bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="assets/bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="assets/bower_components/Materialize/dist/js/materialize.js"></script>
	<script type="text/javascript" src="assets/bower_components/handlebars/handlebars.js"></script>
	<script type="text/javascript" src="assets/js/jquery.common.js"></script>
	<script type="text/javascript" src="assets/js/handlebarHelper.js"></script>
	<script type="text/javascript" src="assets/js/smiley-slider.js"></script>
	<script type="text/javascript" src="assets/js/dashboard.js"></script>
	<script type="text/javascript" src="assets/js/chatFunctions.js"></script>
	<script type="text/javascript" src="assets/js/jquery.chatOption.js"></script>
</body>
</html>
