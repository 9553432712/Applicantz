package com.beta.replyservice.srvice.impl;

import com.beta.replyservice.common.Util;
import com.beta.replyservice.dto.ReplyMessage;
import com.beta.replyservice.srvice.ReplyService;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceV2Impl implements ReplyService {
    @Override
    public ReplyMessage process(String message) {
        if (message == null || message.length() == 0) {
            return new ReplyMessage("Message is empty");
        } else if (message.contains("-")) {
            String s[] = message.split("-");
            if (s.length != 2) {
                return new ReplyMessage("V2 supports pattern:: 11-kbzw9ru(Number-String)");
            } else {
                return Util.processV2(s[1], s[0]);
            }
        }
        return null;
    }
}
