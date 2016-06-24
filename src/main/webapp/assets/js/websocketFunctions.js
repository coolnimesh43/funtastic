var funtastic = funtastic || {};
funtastic.common = funtastic.common || {};
var $websocketFunctions = $websocketFunctions || {};
(function ( common ) {
    var websocketUrl;
    $websocketFunctions.init = function () {
        var output = $("#response-query");
        var socketUrl = common.getWebsocketUrl();
        // websocketUrl = new WebSocket(socketUrl +
        // $('.login-user-account').data('user-account-id'));
        websocketUrl = new WebSocket(socketUrl + "1");
        websocketUrl.onopen = function () {
            $websocketFunctions.writeResponse();
        };
        
        // Handle messages sent by the server.
        websocketUrl.onmessage = function ( evt ) {
            var msg = $.parseJSON(evt.data);
            if ($(".questions.selected").data("question-id") == msg.questionId) {
                if (msg.recipentUser.id == msg.user.id) {
                    $(".question-arbitary-div").before(
                            "<div class='admin-answer question-common-class'><span class='admin-img'><i class='icon-user'></i></span><span class='pointed-arrow'><span class='admin-text'>" + msg.response
                                    + "</span></span><a class='hide' title='Flag' href='#'><i class='icon-flag'></i></a></div>");
                } else {
                    $(".question-arbitary-div").before(
                            "<div class='user-question question-common-class'><span class='user-img'><i class='icon-user'></i></span><span class='pointed-arrow-left'><span class='user-text'>" + msg.response
                                    + "</span></span><a class='hide' title='Flag' href='#'><i class='icon-flag'></i></a></div>");
                }
            } else {
                if ($(".questions[data-question-id=" + msg.questionId + "]") && msg.recipentUser.id != msg.user.id) {
                    if (!$(".questions[data-question-id=" + msg.questionId + "]").find('.new-message').length > 0) {
                        $(".questions[data-question-id=" + msg.questionId + "]").find("a").css("color", "#000");
                        $(".questions[data-question-id=" + msg.questionId + "]").find(".info-vehicle-ask-vehicle").after("<div class='new-message'>new</div>");
                        $websocketFunctions.renderUnreadQuestionNumber();
                    }
                }
            }
        };
        
        websocketUrl.onclose = function () {
            websocketUrl.close();
        };
        
        websocketUrl.onerror = function ( error ) {
            console.log('WebSocket Error: ' + error);
        };
    };
    
    $websocketFunctions.renderUnreadQuestionNumber = function () {
        var unreadQuestionNumber = $("#unread-number").html();
        var number = unreadQuestionNumber.match(/\d+/);
        var newUnreadNumber = parseInt(number[0]) + 1;
        $("#unread-number").html('(' + newUnreadNumber + ')');
    };
    
    $websocketFunctions.messageSend = function () {
        console.log('inside messageSend');
        var response = $("#response-text").val();
        var listingQuestionId = $("#query-response").data("listing-question-id");
        var userId = $('.login-user-account').data('user-account-id');
        if (response != null && response != "") {
            websocketUrl.send(JSON.stringify({
                response : response,
                questionId : listingQuestionId,
                userId : userId
            }));
        }
    };
    
    $websocketFunctions.writeResponse = function () {
        var message = $("#response-text").val();
    };
    
})(funtastic.admin.common);
