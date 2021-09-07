package com.beta.replyservice.controller;

import com.beta.replyservice.dto.ReplyMessage;
import com.beta.replyservice.srvice.impl.ReplyServiceV2Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/reply")
public class ReplyV2Controller {

	@Autowired
	ReplyServiceV2Impl replyService;

	@GetMapping("/")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return replyService.process(message);
	}
}