funtastic.admin = funtastic.admin || {};
funtastic.admin.common = funtastic.admin.common || {};
funtastic.admin.commentOption = funtastic.admin.commentOption || {};
(function($commentOption, commonFunctions) {
	"use strict";
	$commentOption.init = function() {
		$commentOption.fetchGif("search", "a");
		$commentOption.fetchMeme();
	};

	$commentOption.fetchGif = function(type, term) {
		var url = commonFunctions.getBaseUrl() + "comment/gif/" + type + "/"
				+ term;
		commonFunctions.apiCall(url, "GET", null, function(response) {
			var jsonData = JSON.parse(response);
		}, function(error) {
		});
	}

	$commentOption.fetchMeme = function() {
		var url = commonFunctions.getBaseUrl() + "comment/meme";
		commonFunctions.apiCall(url, "GET", null, function(response) {
			var jsonData = JSON.parse(response);
		}, function(error) {
		});
	}

	$commentOption.init();

})(funtastic.admin.commentOption, funtastic.admin.common);