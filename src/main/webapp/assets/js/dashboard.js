var dashboard = {};
var smileSlider;
var smilePosition = 0;
var $handlebarHelpers = $handlebarHelpers || {};
(function () {
    dashboard.init = function () {
        dashboard.renderConversationTitleBlock();
        dashboard.renderUserInfoBlock();
        dashboard.renderActiveConversationBlock();
    }, dashboard.renderUserInfoBlock = function () {
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_userInfo", templateData, "#header-user-info");
    }, dashboard.renderConversationTitleBlock = function () {
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_conversationTitle", templateData, "#conversation-title");
        dashboard.initialiseSmileySlider();
    }, dashboard.renderActiveConversationBlock = function () {
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_activeConversation", templateData, "#active-conversations");
    }, dashboard.initialiseSmileySlider = function () {
        smileSlider = new SmileySlider(document.getElementById("slider"))

        smileSlider.position(0); // make it sad
        smileSlider.position(1) // make it happy
        
        var p = smileSlider.position() // get it's position
        smileSlider.position(p / 2) // make it half as happy
        
        smileSlider.position(function ( p ) {
            // do something when it changes
        });
        
        $.ajax({
            url : 'http://view-count.herokuapp.com/view/' + encodeURIComponent(location.href),
            xhrFields : {
                withCredentials : true
            },
            success : function ( count ) {
            }
        });
    }, dashboard.increaseSmile = function (){
        smilePosition += 0.1;
        smileSlider.position(smilePosition);
    }, dashboard.decreaseSmile = function (){
        smilePosition -= 0.1;
        if (smilePosition < 0 ) {
            smilePosition = 0;
        }
        smileSlider.position(smilePosition);
    }
    
    
    dashboard.init();
})();