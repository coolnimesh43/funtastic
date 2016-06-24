/**
 * 
 */
package org.funtastic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.funtastic.pojo.OutputMessage;
import org.funtastic.pojo.Response;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author adhpawal
 */
@Controller
public class ChatController {

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(final Response message) throws Exception {
		final String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new OutputMessage(message.getFrom(), message.getText(), time);
	}
}
