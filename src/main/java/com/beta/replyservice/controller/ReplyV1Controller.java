package com.beta.replyservice.controller;

import com.beta.replyservice.dto.ReplyMessage;
import com.beta.replyservice.srvice.impl.ReplyServiceV1Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/reply")
public class ReplyV1Controller {

	@Autowired
	ReplyServiceV1Impl replyServiceV1;

	@GetMapping("/")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return replyServiceV1.process(message);
	}
}