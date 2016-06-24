var funtastic = funtastic || {};
funtastic.admin = funtastic.admin || {};
funtastic.admin.common = funtastic.admin.common || {};
funtastic.admin.chatFunctions = funtastic.admin.chatFunctions || {};
var $handlebarHelpers = $handlebarHelpers || {};
(function ( common, $chatFunctions ) {
    "use strict";
    $chatFunctions.init = function () {
        $(document).ready(function () {
            $chatFunctions.renderUserChatList();
            $chatFunctions.eventHandler();
        });
    };
    
    $chatFunctions.eventHandler = function () {
    };
    
    /* user chat list block render */
    $chatFunctions.renderUserChatList = function () {
        console.log("renderUserChatList");
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_chatUserListBlock", templateData, "#chatUserBlock");
        $chatFunctions.renderResponseChatBlock();
    };
    
    /* user response chat block render */
    $chatFunctions.renderResponseChatBlock = function () {
        console.log("renderResponseChatBlock");
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_chatResponseBlock", templateData, "#chatResponseBlock");
    };
    
    $chatFunctions.init();
    
})(funtastic.admin.common, funtastic.admin.chatFunctions);