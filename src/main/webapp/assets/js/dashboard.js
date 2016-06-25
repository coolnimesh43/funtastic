var dashboard = {};
var $handlebarHelpers = $handlebarHelpers || {};
(function ( common ) {
    dashboard.init = function () {
        console.log("here... why isnt this being called");
        dashboard.renderConversationTitleBlock();
        dashboard.renderUserInfoBlock();
        dashboard.renderActiveConversationBlock();
        dashboard.eventHandler();
    },

    dashboard.eventHandler = function () {
        $(document).on("click", "#create-group-btn", function () {
            $("#group-add")[0].reset();
            $('#modal1').openModal();
        });
        $(document).on("click", "#create-group", function () {
            var url = common.getBaseUrl() + "group";
            var data = {
                name : $("input[name='name']").val()
            };
            common.apiCall(url, "POST", data, function ( response ) {
                dashboard.renderGroupBlock();
            }, function ( error ) {
                alert("error");
            });
        });
        
        $(document).on("click", "#active-conversations a", function () {
            var url = common.getBaseUrl() + "user";
            dashboard.renderUserBlock($(this).data("group-id"));
        });
        
        $(document).on("click", "[name='add-user-group']", function () {
            var url = common.getBaseUrl() + "group/user";
            var data = {
                groupId : $("#group-id").val(),
                userId : $("[name='user_id']").val()
            };
            common.apiCall(url, "POST", data, function ( response ) {
                dashboard.renderGroupBlock();
            }, function ( error ) {
                alert("error");
            });
        });
        
        $(document).on("click", ".delete-member", function () {
            var url = common.getBaseUrl() + "group/" + $(this).data("group-id");
            common.apiCall(url, "DELETE", null, function ( response ) {
                dashboard.renderExistingUserBlock();
            }, function ( error ) {
                alert("error");
            });
        });
    }
    dashboard.renderUserInfoBlock = function () {
        var templateData = {};
        $handlebarHelpers.renderTemplate("#_userInfo", templateData, "#header-user-info");
    }, dashboard.renderConversationTitleBlock = function () {
        var templateData = {

        };
        $handlebarHelpers.renderTemplate("#_conversationTitle", templateData, "#conversation-title");
    }, dashboard.renderActiveConversationBlock = function () {
        var templateData = {};
        $handlebarHelpers.renderTemplate("#_activeConversation", templateData, "#active-conversations");
    },

    dashboard.renderGroupBlock = function () {
        var url = common.getBaseUrl() + "group";
        common.apiCall(url, "GET", null, function ( response ) {
            var templateData = {
                detail : response
            };
            $handlebarHelpers.renderTemplate("#_activeConversationAjax", templateData, "#active-conversations");
        }, function ( error ) {
        });
    }, dashboard.renderUserBlock = function ( groupId ) {
        var url = common.getBaseUrl() + "user";
        $("#group-id").val(groupId);
        common.apiCall(url, "GET", null, function ( response ) {
            var templateData = {
                detail : response
            };
            $handlebarHelpers.renderTemplate("#_userList", templateData, "#user-add-section");
            $('select').material_select();
        }, function ( error ) {
        });
    }, dashboard.renderExistingUserBlock = function ( groupId ) {
        var url = common.getBaseUrl() + "group/" + groupId;
        common.apiCall(url, "GET", null, function ( response ) {
            var templateData = {
                detail : response
            };
            $handlebarHelpers.renderTemplate("#_existingUserList", templateData, "#existing-user-add-section");
            $('select').material_select();
        }, function ( error ) {
        });
    }
    dashboard.init();
})(funtastic.admin.common);