var dashboard = {};
var smileSlider;
var smilePosition = 0;
var $handlebarHelpers = $handlebarHelpers || {};
(function ( common ) {
    dashboard.init = function () {
        console.log("here... why isnt this being called");
        dashboard.renderConversationTitleBlock();
        dashboard.renderUserInfoBlock();
        dashboard.renderActiveConversationBlock();
        dashboard.eventHandler();
        dashboard.initialiseSmileySlider();
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
        common.apiCall(url, "GET", null, function ( response ) {
            var templateData = {
                detail : response,
                groupId : groupId
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
    dashboard.renderActiveConversationBlock = function () {
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
    }, dashboard.increaseSmile = function () {
        smilePosition += 0.1;
        smileSlider.position(smilePosition);
    }, dashboard.decreaseSmile = function () {
        smilePosition -= 0.1;
        if (smilePosition < 0) {
            smilePosition = 0;
        }
        smileSlider.position(smilePosition);
    }
    dashboard.init();
})(funtastic.admin.common);
