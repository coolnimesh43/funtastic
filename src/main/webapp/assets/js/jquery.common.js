var funtastic = funtastic || {};
funtastic.admin = funtastic.admin || {};
(function(common, $) {
	var translations = {};
	common.initializeIntercom = function() {
		var w = window;
		var ic = w.Intercom;
		if (typeof ic === "function") {
			ic('reattach_activator');
			ic('update', intercomSettings);
		} else {
			var d = document;
			var i = function() {
				i.c(arguments)
			};
			i.q = [];
			i.c = function(args) {
				i.q.push(args)
			};
			w.Intercom = i;
			function l() {
				var s = d.createElement('script');
				s.type = 'text/javascript';
				s.async = true;
				s.src = 'https://widget.intercom.io/widget/ff3gdxw9';
				var x = d.getElementsByTagName('script')[0];
				x.parentNode.insertBefore(s, x);
			}

			if (w.attachEvent) {
				w.attachEvent('onload', l);
			} else {
				w.addEventListener('load', l, false);
			}
		}

	};

	/**
	 * Initialize the intercom
	 */
	window.intercomSettings = {
		app_id : "ff3gdxw9"
	};

	$.fn.vinField = function() {
		var element = $(this);
		element.prop('maxLength', 17).attr("pattern", "[A-Z0-9]").attr(
				"autocomplete", "off").attr("autocapitalize", "words");
		return this;
	};
	var centralizeModal = function() {
		if (!$(this).hasClass("modal-fullscreen")) {
			var modal = $(this), dialog = modal.find('.modal-dialog');
			modal.css('display', 'block');

			dialog.css("margin-top", Math.max(0, ($(window).height() - dialog
					.height()) / 2));
			dialog.css("top", 0);
		}

	};
	/**
	 * sets an inputfield for no special characters
	 */
	$.fn.noSpecialCharacters = function(event) {
		if ((event.which > 30 && event.which < 48)
				|| (event.which > 57 && event.which < 65)
				|| (event.which > 90 && event.which < 97)
				|| (event.which > 122 && event.which < 127)) {
			event.preventDefault();
		}
	};
	/**
	 * Makes server side ajax call
	 */
	common.apiCall = function(url, method, data, successCallBack,
			errorCallBack, async) {
		var ajaxOptions = {
			type : method,
			url : url,
			dataType : "JSON",
			async : (typeof async === undefined) ? true : async
		};
		if (typeof data !== "undefined" && data != null) {
			ajaxOptions.data = data;
		}
		return $.ajax(ajaxOptions).done(
				function(response) {
					if (typeof successCallBack !== "undefined"
							&& successCallBack !== null) {
						var data = perpetulist.cyclicJsonHandler
								.processJson(response);
						successCallBack(data);
					}

				}).fail(function(error) {
			if (typeof errorCallBack !== "undefined" && errorCallBack !== null)
				errorCallBack(error);
		});
	}
	common.setTranslations = function(translationList) {
		translations = translationList;
	};
	common.getTranslation = function(key) {
		if (translations.hasOwnProperty(key)) {
			return translations[key];
		} else {
			return key;
		}

	};
	common.getUrlParameter = function(parameter) {
		var results = new RegExp('[\?&]' + parameter + '=([^&#]*)')
				.exec(window.location.href);
		if (results == null) {
			return null;
		} else {
			return results[1] || 0;
		}
	};
	common.setVinField = function() {
		if ($(document).find(".vin").length > 0) {
			$(".vin").vinField();
		}

		$(".vin").off("keypress").on("keypress", function(e) {
			if (!e.ctrlKey) {
				var currentValue = $(this).val();
				if (currentValue.length < 17) {
					$(".vin").noSpecialCharacters(e);
				} else {
					$(this).trigger("input");
				}
			}
		});
		$(".vin").on("paste", function(e) {
			setTimeout(function() {
				var event = $.Event('keypress');
				event.which = 1000
				event.key = "%";
				$(".vin").trigger(event);
			}, 0);

		});
	};
	common.init = function() {
		$(document).ready(
				function() {
					$(document).on(
							"click",
							".message .message-close",
							function() {
								var msgContainer = $(this).parent();
								if (msgContainer.hasClass("error")) {
									msgContainer.fadeOut("slow", function() {
										$(this).removeClass("error");
										msgContainer.find(".message-content")
												.text("");
									});
								} else if (msgContainer.hasClass("success")) {
									msgContainer.fadeOut("slow", function() {
										$(this).removeClass("success");
										msgContainer.find(".message-content")
												.text("");
									});
								}
							});
					$(document).on("scroll", function() {
						if ($(this).scrollTop() > 200) {
							$('#return-to-top').fadeIn();
						} else {
							$('#return-to-top').fadeOut();
						}
					});
					$(document).on("click", "#return-to-top", function() {
						$('html, body').animate({
							scrollTop : 0
						}, 400);
					});
					// Reposition when a modal is shown
					$(document).on("ready", function() {
						$('.modal').on('show.bs.modal', centralizeModal);
						common.setVinField();
					});
					$(document).on(
							"input",
							".address-field",
							function() {
								if ($(this).val().length > 0
										&& !$(this).prop('readonly')) {
									$(".clear-address").show();
								} else {
									$(".clear-address").hide();
								}
							});
					$(document).on("click", ".clear-address", function() {
						if (!$(".address-field").prop('readonly')) {
							$(".address-field").val('');
							$("#street-num").val('');
							$("#street-name").val('');
							$("#state").val('');
							$(this).hide();
						}
					});
					$(document).on(
							"click",
							".fa-location-arrow",
							function() {
								if (!$(".address-field").prop('readonly')) {
									var $addressField = $(".address-field");
									var $streetNumField = $("#street-num");
									var $streetNameField = $("#street-name");
									var $stateField = $("#state");
									common.getCurrentLocation($addressField,
											$streetNumField, $streetNameField,
											$stateField);
								}
							});
					// Reposition when the window is resized
					$(window).on('resize', function() {
						$('.modal:visible').each(centralizeModal);
					});
					$(document).on("keydown", "input[type=email]",
							function(event) {
								var key = event.key;
								var re = /[a-zA-Z0-9@\.\_\-\+]/;
								return re.test(key);
							});
					common.enableUISearch();
				});
		$(document).on("input", ".address-field", function() {
			if ($(this).val().length > 0 && !$(this).prop('readonly')) {
				$(".clear-address").show();
			} else {
				$(".clear-address").hide();
			}
		});
		$(document).on("click", ".clear-address", function() {
			if (!$(".address-field").prop('readonly')) {
				$(".address-field").val('');
				$("#street-num").val('');
				$("#street-name").val('');
				$("#state").val('');
				$(this).hide();
			}
		});
		$(document)
				.on(
						"click",
						".fa-location-arrow",
						function() {
							if (!$(".address-field").prop('readonly')) {
								var $addressField = $(".address-field");
								var $streetNumField = $("#street-num");
								var $streetNameField = $("#street-name");
								var $stateField = $("#state");
								common.getCurrentLocation($addressField,
										$streetNumField, $streetNameField,
										$stateField);
							}
						});
	};
	common.getBaseUrl = function() {
		var baseUrl = location.protocol + "//" + location.host + "/funtastic/";
		return baseUrl;
	};
	common.getWebsocketUrl = function() {
		var websocketUrl = "ws://" + location.host + "/chat/";
		return websocketUrl;
	}
	common.setSidebarHeight = function(sidebarElement, extraHeight) {
		if (sidebarElement.length > 0) {
			var sidebarHeight = (typeof extraHeight !== "undefined") ? (sidebarHeight - extraHeight)
					: sidebarHeight;
			var scrollableElement = sidebarElement.find("ul");
			scrollableElement.css("height", sidebarHeight + "px").css(
					"overflowY", "auto");
			scrollableElement.mCustomScrollbar();
		}
	};
	common.showMessage = function(msgContainer, msg, type) {
		if ($(msgContainer).find(".message").length > 0) {
			var msgContainerObj = $(msgContainer).find(".message");
			msgContainerObj.removeClass("hide-me");
			var msgContent = msgContainerObj.find(".message-content");
			msgContent.text(msg);
			msgContainerObj.addClass(type).fadeIn('slow').delay("4000")
					.fadeOut("slow", function() {
						msgContent.text("");
						$(this).removeClass(type);
					});
		}
	};
	common.fullScreenModalEvents = function() {
		$(".modal-transparent").on('show.bs.modal', function() {
			setTimeout(function() {
				$(".modal-backdrop").addClass("modal-backdrop-transparent");
			}, 0);
		});
		$(".modal-transparent").on('hidden.bs.modal', function() {
			$(".modal-backdrop").addClass("modal-backdrop-transparent");
		});

		$(".modal-fullscreen").on('show.bs.modal', function() {
			setTimeout(function() {
				$(".modal-backdrop").addClass("modal-backdrop-fullscreen");
			}, 0);
		});
		$(".modal-fullscreen").on('hidden.bs.modal', function() {
			$(".modal-backdrop").addClass("modal-backdrop-fullscreen");
		});
	};
	common.removeArrayObject = function(property, value, someArray) {
		return someArray.filter(function(e) {
			return e[property] !== value;
		});
	};
	common.removeArrayElement = function(value, someArray) {
		var index = someArray.indexOf(value);
		if (index > -1) {
			someArray.splice(index, 1);
		}
		return someArray;
	};
	common.isObjectEmpty = function(obj) {
		for ( var prop in obj) {
			if (obj.hasOwnProperty(prop))
				return false;
		}
		return true;
	};
	common.objectLength = function(obj) {
		count = 0;
		for ( var key in obj) {
			if (obj.hasOwnProperty(k)) {
				++count;
			}
		}
		return count;
	};
	common.getObjectValuesAsArray = function(obj) {
		var objectValueArray = [];
		for (key in obj) {
			if (obj.hasOwnProperty(key)) {
				objectValueArray.push(obj[key]);
			}
		}
		return objectValueArray;
	};
	common.removeObjectProperty = function(value, obj) {
		for (key in obj) {
			if (obj.hasOwnProperty(key) && obj[key] === value) {
				delete obj[key];
			}
		}
		return obj;
	}
	common.select = function(selectSelector, onChangeCallBack, options) {
		options = options || {};
		selectSelector.select2();
		selectSelector.on("select2:select", function(e) {
			if (typeof onChangeCallBack === "function") {
				onChangeCallBack(e, e.params.data.id);
			}
		});
	};
	common.getDynamicQuality = function(bandwidthValue) {
		if (bandwidthValue < 32) {
			return 15;
		} else if (bandwidthValue < 64) {
			return 30;
		} else if (bandwidthValue < 128) {
			return 50;
		} else if (bandwidthValue < 256) {
			return 70;
		} else if (bandwidthValue < 512) {
			return 80;
		} else {
			return 100;
		}
	};
	common.resizeImages = function(element, imageUrl, containerWidth,
			containerHeight, successCallBack, failCallBack) {
		var data = {
			imageUrl : imageUrl,
			width : parseInt(containerWidth),
			height : parseInt(containerHeight)
		};
		var response = common.getBaseUrl()
				+ "unsafe/full-fit-in/"
				+ data.width
				+ "x"
				+ data.height
				+ "/filters:quality("
				+ common.getDynamicQuality(perpetulist.bandwidthDetectionHelper
						.getBandwidth()) + ")/" + data.imageUrl;
		var img = new Image();
		img.src = response;
		img.onerror = function() {
			successCallBack(imageUrl);
		}
		successCallBack(response);
	};
	common.setImageSrc = function(element, imageUrl) {
		if (imageUrl) {
			$(element).attr("src", imageUrl);
		}
	};
	common.setDataAttribute = function(element, dataAttribute, attributeValue) {
		$(element).attr(dataAttribute, attributeValue);
	};
	/**
	 * Gets email domain information
	 */
	common.getEmailDomainInfo = function(email) {
		var splittedEmail = email.split("@");
		var domainName = splittedEmail[0];
		if (typeof splittedEmail[1] !== "undefined")
			var domainName = splittedEmail[1].split(".");
		return domainName[0];
	};

	/**
	 * Sets timer
	 */
	common.setSecondTimer = function(seconds, timerContainer, callBack) {
		var time = parseInt(seconds);
		var timerContainerText = timerContainer.html();
		var setTimer = setInterval(function() {
			timerContainer.html(timerContainerText + "<b>" + time + "</b>");
			time--;
			if (time === 0) {
				clearInterval(setTimer);
				callBack();
			}
		}, 1000)
	}
	/**
	 * Enables google address search plugin
	 * 
	 * @param elementId
	 *            id of the field where we need to initialize the plugin
	 * @param stateFieldElement
	 *            jQuery object of the field where state is to be populated
	 * @param streetNumElement
	 *            jQuery object of the field where street number is to be
	 *            populated
	 * @param streetNameElement
	 *            jQuery object of the field where street name is to be
	 *            populated
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	common.enableGoogleSearch = function($addressField, $stateFieldElement,
			$streetNumFieldElement, $streetNameFieldElement) {
		if (typeof google !== "undefined") {
			var input = $addressField.get(0);
			var autocomplete = new google.maps.places.Autocomplete(input);
			google.maps.event
					.addListener(
							autocomplete,
							'place_changed',
							function() {
								var place = autocomplete.getPlace();
								if (place.geometry) {
									if (typeof $stateFieldElement === "object"
											&& typeof $streetNumFieldElement === "object"
											&& typeof $streetNameFieldElement === "object") {
										$stateFieldElement.val('');
										$streetNumFieldElement.val('');
										$streetNameFieldElement.val('');
										for (var i = 0; i < place.address_components.length; i++) {
											if ($
													.inArray(
															"street_number",
															place.address_components[i].types) !== -1) {
												$streetNumFieldElement
														.val(place.address_components[i].long_name);
											} else if ($
													.inArray(
															"route",
															place.address_components[i].types) !== -1) {
												$streetNameFieldElement
														.val(place.address_components[i].long_name);
											} else if ($
													.inArray(
															"administrative_area_level_1",
															place.address_components[i].types) !== -1) {
												$stateFieldElement
														.val(place.address_components[i].long_name);
											}
										}
									}
								}
							});

			if (!$addressField.prop('readonly')) {

				$(".fa-location-arrow").show();
			} else {
				$(".fa-location-arrow").hide();
			}

			if ($addressField.val().length && !$addressField.prop('readonly')) {

				$(".clear-address").show();
			} else {
				$(".clear-address").hide();
			}
		}
	};

	common.getCurrentLocation = function($addressField, $stateFieldElement,
			$streetNumFieldElement, $streetNameFieldElement) {
		if (typeof google != "undefined" && navigator.geolocation) {
			navigator.geolocation
					.getCurrentPosition(function(position) {
						$(".container").loadingOverlay();
						var latitude = position.coords.latitude;
						var longitude = position.coords.longitude;
						$
								.ajax({
									url : "http://maps.googleapis.com/maps/api/geocode/json?latlng="
											+ latitude
											+ ","
											+ longitude
											+ "&sensor=true",
									method : "GET",
									success : function(response) {
										$(".container")
												.loadingOverlay("remove");
										if (response.results.length > 0) {
											var result = response.results[0];
											$addressField
													.val(result.formatted_address);
											$stateFieldElement.val('');
											$streetNumFieldElement.val('');
											$streetNameFieldElement.val('');
											for (var i = 0; i < result.address_components.length; i++) {
												if ($
														.inArray(
																"street_number",
																result.address_components[i].types) !== -1) {
													$streetNumFieldElement
															.val(result.address_components[i].long_name);
												} else if ($
														.inArray(
																"route",
																result.address_components[i].types) !== -1) {
													$streetNameFieldElement
															.val(result.address_components[i].long_name);
												} else if ($
														.inArray(
																"administrative_area_level_1",
																result.address_components[i].types) !== -1) {
													$stateFieldElement
															.val(result.address_components[i].long_name);
												}
											}
											if (!$addressField.prop('readonly')) {
												$(".fa-location-arrow").show();
											} else {
												$(".fa-location-arrow").hide();
											}
											if ($addressField.val().length
													&& !$addressField
															.prop('readonly')) {
												$(".clear-address").show();
											} else {
												$(".clear-address").hide();
											}
										}
									},
									error : function() {
										$(".container")
												.loadingOverlay("remove");
									},
									dataType : "JSON"
								});
					});
		}
	};

	/**
	 * Check if the element is present on the view port or not.
	 * 
	 * @author adhpawal
	 * @param el :
	 *            DOM Element
	 * @see http://stackoverflow.com/questions/123999/how-to-tell-if-a-dom-element-is-visible-in-the-current-viewport/7557433#7557433
	 */
	common.isElementInViewport = function(el) {
		// if element is instance of jQuery
		if (typeof jQuery === "function" && el instanceof jQuery) {
			el = el[0];
		}
		var rect = el.getBoundingClientRect();
		return (rect.bottom >= 0
				&& rect.right >= 0
				&& rect.top <= (window.innerHeight || document.documentElement.clientHeight) && rect.left <= (window.innerWidth || document.documentElement.clientWidth));
	};

	/**
	 * Enables WYSIWYG for given Selector. Currently we are using Medium Editor
	 * for the job.
	 * 
	 * @see https://github.com/yabwe/medium-editor/blob/master/OPTIONS.md
	 * @author adhpawal
	 */
	common.enableWYSIWYG = function(elementSelector) {
		var editor = new MediumEditor(elementSelector, {
			keyboardCommands : false,
			toolbar : {
				allowMultiParagraphSelection : true,
				buttons : [ 'bold', 'italic', 'underline', 'anchor', 'h2',
						'h3', 'quote', 'strikethrough', 'superscript',
						'subscript', 'orderedlist', 'unorderedlist',
						'removeFormat' ],
				diffLeft : 0,
				diffTop : -10,
				firstButtonClass : 'medium-editor-button-first',
				lastButtonClass : 'medium-editor-button-last',
				standardizeSelectionStart : false,
				static : false,
				relativeContainer : null,
				align : 'center',
				sticky : false,
				updateOnEmptySelection : false
			},
			sticky : true,
			imageDragging : false,
			paste : {
				forcePlainText : true,
				cleanPastedHTML : true,
				cleanReplacements : [],
				cleanAttrs : [ 'class', 'style', 'dir' ],
				cleanTags : [ 'meta' ]
			},
			anchor : {
				customClassOption : null,
				customClassOptionText : 'Button',
				linkValidation : true,
				placeholderText : 'Paste or type a link',
				targetCheckbox : false,
				targetCheckboxText : 'Open in new window'
			},
			anchorPreview : {
				hideDelay : 300
			}
		});
	};
	common.changeLanguage = function(languageCode) {
		var url = location.pathname + '?language=' + languageCode;
		$(".wrapper").loadingOverlay();
		$.ajax({
			url : url,
			success : function(response) {
				document.open();
				document.write(response);
				document.close();
			},
			dataType : "text"
		});
	};
	common.enableUISearch = function() {
		if ($("#sb-search").length)
			new UISearch(document.getElementById('sb-search'));
	};
	common.init();
})(funtastic.admin.common = funtastic.admin.common || {}, jQuery);