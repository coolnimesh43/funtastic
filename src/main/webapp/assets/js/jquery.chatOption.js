funtastic.admin = funtastic.admin || {};
funtastic.admin.common = funtastic.admin.common || {};
funtastic.admin.commentOption = funtastic.admin.commentOption || {};
(function($commentOption, commonFunctions) {
	"use strict";
	$commentOption.init = function() {
		$handlebarHelpers.registerCustomHandlebarHelpers();
		$('.modal-trigger').leanModal();
		$commentOption.fetchGif("trending", "a");
		$commentOption.fetchMeme();
	};

	$commentOption.fetchGif = function(type, term) {
		var url = commonFunctions.getBaseUrl() + "comment/gif/" + type + "/"
				+ term;
		commonFunctions.apiCall(url, "GET", null, function(response) {
			var templateData = {
				detail : response
			};
			$handlebarHelpers.renderTemplate("#_gifyResponse", templateData,
					"#gif-div");
		}, function(error) {
		});
	}

	$commentOption.fetchMeme = function() {
		var url = commonFunctions.getBaseUrl() + "comment/meme";
		commonFunctions.apiCall(url, "GET", null, function(response) {
			var templateData = {
				detail : response.data.memes
			};
			$handlebarHelpers.renderTemplate("#_memeResponse", templateData,
					"#meme-div");
		}, function(error) {
		});
	}

	$commentOption.init();

})(funtastic.admin.commentOption, funtastic.admin.common);