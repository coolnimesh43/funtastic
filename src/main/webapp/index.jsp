<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat Room</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<link href="assets/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/bower_components/font-awesome/css/font-awesome.css" rel="stylesheet">
	<link href="assets/css/style.css" rel="stylesheet">
	<link href="assets/css/custom.css" rel="stylesheet">
	<div class="container bootstrap snippet">
		<div class="row">
			<div class="header-block col-md-12">
				<div class="header-option-left col-md-6"></div>
				<div class="header-option-right col-md-6">
					<a class="collapse-expand" href="javascript:void(0);">>></a>
				</div>
			</div>
			<div class="col-md-4" id="chatUserBlock"></div>
			<!-- selected chat -->
			<div class="col-md-8" id="chatResponseBlock"></div>
			<div class="bg-white slide-block slide-properties hide"
				id="chatOptionsBlock"></div>
			<div class="container bootstrap snippet">
				<div class="row">
					<div class="col-md-4" id="chatUserBlock"></div>
				</div>
			</div>
			<button data-target="modal1" class="btn modal-trigger">Modal</button>
			<button data-target="modal2" class="btn modal-trigger">Modal</button>

			<!-- Modal Structure -->
			<div id="modal2" class="modal bottom-sheet">
				<div class="modal-content">
					<ul id="gif-div" class="collection">
					</ul>
				</div>
			</div>

			<!-- Modal Structure -->
			<div id="modal1" class="modal bottom-sheet">
				<div class="modal-content">
					<ul id="meme-div" class="collection">
					</ul>
				</div>
			</div>

		</div>
	</div>
	<%@ include file="/WEB-INF/templates/_chat.jsp"%>
	<script type="text/javascript"
		src="assets/bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="assets/bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="assets/bower_components/handlebars/handlebars.js"></script>
	<script type="text/javascript"
		src="assets/bower_components/Materialize/dist/js/materialize.min.js"></script>
	<script src="//cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.common.js"></script>
	<script type="text/javascript" src="assets/js/handlebarHelper.js"></script>
	<script type="text/javascript" src="assets/js/jquery.chatOption.js"></script>
	<script type="text/javascript" src="assets/js/websocketFunctions.js"></script>
	<script type="text/javascript" src="assets/js/chatFunctions.js"></script>
</body>
</html>