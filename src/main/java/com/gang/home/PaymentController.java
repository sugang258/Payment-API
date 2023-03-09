package com.gang.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
	
	@GetMapping("/kakaoPay")
	public String kakaoPay() {
		System.out.println("hihihi");
		return "kakaoPay";
	}
	
	@GetMapping("/kakao")
	public String kakao() {
		System.out.println("helloodododododo");

		return "/payment/kakao";
	}

}
