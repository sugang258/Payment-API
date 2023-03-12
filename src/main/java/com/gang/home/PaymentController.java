package com.gang.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
	
	
//	@GetMapping("/kakaoPay")
//	public String kakaoPay() {
//		return "kakaoPay";
//	}
	
	
	@GetMapping("/danal")
	public String Danal() {
		return "danal";
	}
	

}
