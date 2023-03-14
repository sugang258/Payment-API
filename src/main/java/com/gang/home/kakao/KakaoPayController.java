package com.gang.home.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
public class KakaoPayController {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@GetMapping("/kakaoPay")
	public String kakaoPayGet() {
		return "/kakao/kakaoPay";
		
	}
	
	@PostMapping("/kakaoPay")
	public String kakaoPay() {
		log.info("kakaoPay post");
		return "redirect:"+kakaoPayService.kakaoPayReady();
	}
	
    @GetMapping("/kakao/kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        
        model.addAttribute("info", kakaoPayService.kakaoPayInfo(pg_token));
    }
    
    @GetMapping("/kakao/kakaoPayCancel")
    public void kakaoPayCancel() {
    	log.info("kakaoPayCancel----------------");
    }
    

	

}
