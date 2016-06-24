<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<link href="assets/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/bower_components/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/custom.css" rel="stylesheet">
<div class="container bootstrap snippet">
    <div class="row">
		<div class="col-md-4" id="chatUserBlock">
		</div>
        
        <!-- selected chat -->
    	<div class="col-md-8" id="chatResponseBlock">
		</div>        
	</div>
</div>
<script type="text/javascript" src="assets/bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="assets/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/bower_components/handlebars/handlebars.js"></script>
<script type="text/javascript" src="assets/js/jquery.common.js"></script>
<script type="text/javascript" src="assets/js/handlebarHelper.js"></script>
<script type="text/javascript" src="assets/js/chatFunctions.js"></script>
<script type="text/javascript" src="assets/js/jquery.chatOption.js"></script>
<%@ include file="/WEB-INF/templates/_chat.jsp"%>
</body>
</html>