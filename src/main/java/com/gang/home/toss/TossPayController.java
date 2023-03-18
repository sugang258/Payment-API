package com.gang.home.toss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TossPayController {
	
	@GetMapping("tossPay")
	public String tossPay() {
		return "/toss/tossPay";
	}
	
	@GetMapping("/toss/success")
	public String tossPaySuccess() {
		return "/toss/tossPaySuccess";
	}

}
