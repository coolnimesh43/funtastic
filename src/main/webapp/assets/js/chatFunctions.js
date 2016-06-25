var funtastic = funtastic || {};
funtastic.admin = funtastic.admin || {};
funtastic.admin.common = funtastic.admin.common || {};
funtastic.admin.chatFunctions = funtastic.admin.chatFunctions || {};
var $handlebarHelpers = $handlebarHelpers || {};
var $websocketFunctions = $websocketFunctions || {};
(function ( common, $chatFunctions ) {
    "use strict";
    $chatFunctions.init = function () {
        $(document).ready(function () {
            $chatFunctions.renderUserChatList();
            $chatFunctions.eventHandler();
        });
    };
    
    $chatFunctions.eventHandler = function () {
        
        $websocketFunctions.init();
        $websocketFunctions.connect();
        
        $(document).on('click', '.send-button', function () {
            console.log('sendbutton clicked');
            $websocketFunctions.sendMessage();
        });
        
        $(document).on('click', '.collapse-expand', function ( e ) {
            e.preventDefault();
            $chatFunctions.renderChatOptionBlock();
        });
        
        $(document).on('click', '.close-btn', function ( e ) {
            e.preventDefault();
            $('.slide-block').addClass('hide');
            $('.close-btn').addClass('hide');
        });
    };
    
    /* user chat option block render */
    $chatFunctions.renderChatOptionBlock = function () {
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_chatOptionsBlock", templateData, "#chatOptionsBlock");
        $('.slide-block').removeClass('hide');
        $('.close-btn').removeClass('hide');
    };
    
    /* user chat list block render */
    $chatFunctions.renderUserChatList = function () {
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_chatUserListBlock", templateData, "#conversationParticipants");
        $chatFunctions.renderResponseChatBlock();
    };
    
    /* user response chat block render */
    $chatFunctions.renderResponseChatBlock = function () {
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_chatResponseBlock", templateData, "#chatResponseBlock");
    };
    
    $chatFunctions.init();
    
})(funtastic.admin.common, funtastic.admin.chatFunctions);
