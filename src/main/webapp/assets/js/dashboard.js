var dashboard = {};
var smileSlider;
var smilePosition = 0;
var $handlebarHelpers = $handlebarHelpers || {};
(function(common) {
	var emojiData = [
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/smiling-face-with-smiling-eyes.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/white-smiling-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/smiling-face-with-open-mouth.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-throwing-a-kiss.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-throwing-a-kiss.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/kissing-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/kissing-face-with-smiling-eyes.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-with-stuck-out-tongue-and-winking-eye.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-with-stuck-out-tongue-and-tightly-closed-eyes.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-with-stuck-out-tongue.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/flushed-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/grinning-face-with-smiling-eyes.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/pensive-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/relieved-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/unamused-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/disappointed-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/persevering-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/crying-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-with-tears-of-joy.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/loudly-crying-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/sleepy-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/disappointed-but-relieved-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-with-open-mouth-and-cold-sweat.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-with-medical-mask.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/smiling-face-with-sunglasses.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-with-look-of-triumph.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/confounded-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/face-screaming-in-fear.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/angry-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/pouting-face.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/imp.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/smiling-face-with-horns.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/see-no-evil-monkey.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/hear-no-evil-monkey.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/speak-no-evil-monkey.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/pile-of-poo.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/smiling-cat-face-with-open-mouth.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/grinning-cat-face-with-smiling-eyes.png",
			"http://pix.iemoji.com/images/emoji/apple/ios-9/256/smiling-cat-face-with-heart-shaped-eyes.png" ];
	dashboard.init = function() {
		console.log("here... why isnt this being called");
		dashboard.renderConversationTitleBlock();
		dashboard.renderUserInfoBlock();
		dashboard.renderActiveConversationBlock();
		dashboard.eventHandler();
		$handlebarHelpers.registerCustomHandlebarHelpers();
		$('.modal-trigger').leanModal();
		dashboard.fetchGif("trending", "a");
		dashboard.fetchRandomGif("random", "a");
		dashboard.fetchMeme();
		dashboard.fetchEmoji();
	}, dashboard.eventHandler = function() {
		$websocketFunctions.init();
		$websocketFunctions.connect();

		$(document).on("click", "#create-group-btn", function() {
			$("#group-add")[0].reset();
			$('#modal1').openModal();
		});
		$(document).on("click", "#create-group", function() {
			var url = common.getBaseUrl() + "group";
			var data = {
				name : $("input[name='name']").val()
			};
			common.apiCall(url, "POST", data, function(response) {
				dashboard.renderGroupBlock();
			}, function(error) {
				alert("error");
			});
		});

		$(document).on('click', ".random-button", function() {
			$('#modal1').openModal();
		});

		$(document).on('click', ".trending-button", function() {
			$('#modal2').openModal();
		});

		$(document).on('click', ".meme-button", function() {
			$('#modal3').openModal();
		});

		$(document).on('click', ".emoji-button", function() {
			$('#modal4').openModal();
		});
		
		$(document).on("click", "#active-conversations a", function() {
			var url = common.getBaseUrl() + "user";
			dashboard.renderUserBlock($(this).data("group-id"));
		});

		$(document).on("click", ".collection li", function() {
			var src = $(this).find('img').prop('src');
			$websocketFunctions.sendMessage();
		});

		$(document).on("click", "[name='add-user-group']", function() {
			var url = common.getBaseUrl() + "group/user";
			var data = {
				groupId : $("#group-id").val(),
				userId : $("[name='user_id']").val()
			};
			common.apiCall(url, "POST", data, function(response) {
				dashboard.renderGroupBlock();
			}, function(error) {
				alert("error");
			});
		});

		$(document).on(
				"click",
				".delete-member",
				function() {
					var url = common.getBaseUrl() + "group/"
							+ $(this).data("group-id");
					common.apiCall(url, "DELETE", null, function(response) {
						dashboard.renderExistingUserBlock();
					}, function(error) {
						alert("error");
					});
				});
	}
	dashboard.renderUserInfoBlock = function() {
		var templateData = {};
		$handlebarHelpers.renderTemplate("#_userInfo", templateData,
				"#header-user-info");
	}, dashboard.renderConversationTitleBlock = function() {
		var templateData = {

		};
		$handlebarHelpers.renderTemplate("#_conversationTitle", templateData,
				"#conversation-title");
		dashboard.initialiseSmileySlider();
	}, dashboard.renderActiveConversationBlock = function() {
		var templateData = {};
		$handlebarHelpers.renderTemplate("#_activeConversation", templateData,
				"#active-conversations");
	},

	dashboard.fetchGif = function(type, term) {
		var url = common.getBaseUrl() + "comment/gif/" + type + "/" + term;
		common.apiCall(url, "GET", null, function(response) {
			var templateData = {
				detail : response
			};
			$handlebarHelpers.renderTemplate("#_gifyResponse", templateData,
					"#gif-div");
		}, function(error) {
		});
	}, dashboard.fetchRandomGif = function(type, term) {
		var url = common.getBaseUrl() + "comment/gif/" + type + "/" + term;
		common.apiCall(url, "GET", null, function(response) {
			var templateData = {
				detail : response
			};
			$handlebarHelpers.renderTemplate("#_gifyResponse", templateData,
					"#gif-random");
		}, function(error) {
		});
	},

	dashboard.fetchMeme = function() {
		var url = common.getBaseUrl() + "comment/meme";
		common.apiCall(url, "GET", null, function(response) {
			var templateData = {
				detail : response.data.memes
			};
			$handlebarHelpers.renderTemplate("#_memeResponse", templateData,
					"#meme-div");
		}, function(error) {
		});
	},
	dashboard.fetchEmoji = function() {
			$handlebarHelpers.renderTemplate("#_emojiResponse", emojiData,
					"#emoji");
	}, dashboard.renderGroupBlock = function() {
		var url = common.getBaseUrl() + "group";
		common.apiCall(url, "GET", null, function(response) {
			var templateData = {
				detail : response
			};
			$handlebarHelpers.renderTemplate("#_activeConversationAjax",
					templateData, "#active-conversations");
		}, function(error) {
		});
	}, dashboard.renderUserBlock = function(groupId) {
		var url = common.getBaseUrl() + "user";
		common.apiCall(url, "GET", null, function(response) {
			var templateData = {
				detail : response,
				groupId : groupId
			};
			$handlebarHelpers.renderTemplate("#_userList", templateData,
					"#user-add-section");
			$('select').material_select();
		}, function(error) {
		});
	}, dashboard.renderExistingUserBlock = function(groupId) {
		var url = common.getBaseUrl() + "group/" + groupId;
		common.apiCall(url, "GET", null, function(response) {
			var templateData = {
				detail : response
			};
			$handlebarHelpers.renderTemplate("#_existingUserList",
					templateData, "#existing-user-add-section");
			$('select').material_select();
		}, function(error) {
		});
	}
	dashboard.renderActiveConversationBlock = function() {
		var templateData = {

		};
		$handlebarHelpers.renderTemplate("#_activeConversation", templateData,
				"#active-conversations");
	}, dashboard.initialiseSmileySlider = function() {
		smileSlider = new SmileySlider(document.getElementById("slider"))

		smileSlider.position(0); // make it sad
		smileSlider.position(1); // make it happy

		var p = smileSlider.position() // get it's position
		smileSlider.position(p / 2) // make it half as happy

		smileSlider.position(function(p) {
			// do something when it changes
		});

		$.ajax({
			url : 'http://view-count.herokuapp.com/view/'
					+ encodeURIComponent(location.href),
			xhrFields : {
				withCredentials : true
			},
			success : function(count) {
			}
		});
	}, dashboard.increaseSmile = function() {
		smilePosition += 0.1;
		smileSlider.position(smilePosition);
	}, dashboard.decreaseSmile = function() {
		smilePosition -= 0.1;
		if (smilePosition < 0) {
			smilePosition = 0;
		}
		smileSlider.position(smilePosition);
	}, dashboard.eventHandler = function() {
		$(document).on("change", "select", function() {
			console.log("hereeeeee");
			var value = $(this).val();
			var jsonData = {
				description : '',
				mood : {
					id : value
				}
			};
			$.ajax({
				url : commonFunctions.getBaseUrl() + 'status',
				data : JSON.stringify(jsonData),
				method : "POST",
				success : function(count) {
					console.log("here");
					var position = 0;
					if (value == '6') {
						position = 0;
					} else if (value == '5') {
						position = 0.25;
					} else if (value == '4') {
						position = 1;
					} else {
						position = 0.5;
					}
					smileSlider.position(position);
				}
			});
		});
	}
	dashboard.init();
})(funtastic.admin.common);
