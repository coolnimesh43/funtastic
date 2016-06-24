var dashboard = {};
var $handlebarHelpers = $handlebarHelpers || {};
(function(){
   dashboard.init = function (){
       console.log("here... why isnt this being called");
       dashboard.renderConversationTitleBlock();
       dashboard.renderUserInfoBlock();
       dashboard.renderActiveConversationBlock();
   },
   dashboard.renderUserInfoBlock = function (){
       var templateData = {

       };
       $handlebarHelpers.renderTemplate("#_userInfo", templateData, "#header-user-info");
   }, 
   dashboard.renderConversationTitleBlock = function(){
       var templateData = {

       };
       $handlebarHelpers.renderTemplate("#_conversationTitle", templateData, "#conversation-title");
   },
   dashboard.renderActiveConversationBlock = function (){
       var templateData = {

       };
       $handlebarHelpers.renderTemplate("#_activeConversation", templateData, "#active-conversations");
   }
   dashboard.init();
})();