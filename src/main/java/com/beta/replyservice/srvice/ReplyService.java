package com.beta.replyservice.srvice;

import com.beta.replyservice.dto.ReplyMessage;

public interface ReplyService {
    ReplyMessage process(String message);
}
