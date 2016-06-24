var funtastic = funtastic || {};
funtastic.common = funtastic.common || {};
var $websocketFunctions = $websocketFunctions || {};
(function ( common ) {
    var websocketUrl;
    $websocketFunctions.init = function () {
        var stompClient = null;
        $websocketFunctions.connect = function () {
            console.log('connect');
            var socket = new SockJS('/funtastic/chat');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function ( frame ) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/messages', function ( messageOutput ) {
                    $websocketFunctions.showMessageOutput(JSON.parse(messageOutput.body));
                });
            });
        }

        $websocketFunctions.disconnect = function () {
            console.log('disconnect');
            if (stompClient != null) {
                stompClient.disconnect();
            }
            console.log("Disconnected");
        }

        $websocketFunctions.sendMessage = function () {
            console.log("sendMessage");
            var text = $('.response-box').val();
            var from = $('.response-box').data('user-id');
            stompClient.send("/app/chat", {}, JSON.stringify({
                'from' : from,
                'text' : text
            }));
        }

        $websocketFunctions.showMessageOutput = function ( messageOutput ) {
            console.log('showMessageOutput');
            console.log(messageOutput);
            $('.arbitary-div')
                    .before(
                            "<li class='right clearfix'><span class='chat-img pull-right'><span class='chat-img pull-right'><img alt='User Avatar' src='http://bootdey.com/img/Content/user_1.jpg'></span><div class='chat-body clearfix'></span><div class='chat-body clearfix'><div class='header'><strong class='primary-font'>"
                                    + messageOutput.from + "</strong><small class='pull-right text-muted'><i class='fa fa-clock-o'></i>" + messageOutput.time + "</small></div><p>" + messageOutput.text + "</p></div></li></div>");
            $('.response-box').val("");
            
            /*
             * $('.arbitary-div') .before( "<li class='left clearfix'><span
             * class='chat-img pull-left'><img alt='User Avatar'
             * src='http://bootdey.com/img/Content/user_3.jpg'></span><div
             * class='chat-body clearfix'><div class='chat-body clearfix'><div
             * class='header'><strong class='primary-font'>" +
             * messageOutput.from + "</strong><small class='pull-right
             * text-muted'><i class='fa fa-clock-o'></i>" + messageOutput.time + "</small></div><p>" +
             * messageOutput.text + "</p></div></li></div>");
             * $('.response-box').val("");
             */
        }
    }

})(funtastic.admin.common);
