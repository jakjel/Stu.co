package org.s3.individualassignment.backend.controller;

import org.s3.individualassignment.backend.domain.ChatMessage;
import org.s3.individualassignment.backend.domain.MessageContent;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


@Controller
public class ChatController {

    @MessageMapping("/hello")
    @SendTo("/topic/websockets")
    public MessageContent messaging(ChatMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new MessageContent(HtmlUtils.htmlEscape(message.getName()));
    }
}
