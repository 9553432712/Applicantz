package com.beta.replyservice.srvice.impl;

import com.beta.replyservice.dto.ReplyMessage;
import com.beta.replyservice.srvice.ReplyService;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceV1Impl implements ReplyService {
    @Override
    public ReplyMessage process(String message) {
        return new ReplyMessage(message);
    }
}
