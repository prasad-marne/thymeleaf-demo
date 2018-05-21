package com.example.thymeleafdemo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MailController {

	private final TemplateEngine engine;

	@GetMapping("/mail")
	public String greeting(@RequestParam String message) {
		Context context = new Context();
		context.setVariable("message", message);
		log.info("message: {}", message);
		return engine.process("mailTemplate", context);
	}

}