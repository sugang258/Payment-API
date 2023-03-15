package com.gang.home.toss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TossPayController {
	
	@GetMapping("tossPay")
	public String tossPay() {
		return "tossPay";
	}

}
