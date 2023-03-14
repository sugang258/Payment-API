package com.gang.home.kakao;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model, HttpSession session) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        KakaoPayApprovalVO kakaoPayApprovalVO = kakaoPayService.kakaoPayInfo(pg_token);
        session.setAttribute("payInfo", kakaoPayApprovalVO);
        log.info("payInfooooo : " + kakaoPayApprovalVO);
        
        model.addAttribute("info", kakaoPayApprovalVO);
    }
    
    @PostMapping("/kakao/kakaoPayCancel")
    public void kakaoPayCancel(Model model,HttpSession session) {
    	log.info("kakaoPayCancel----------------");
    	KakaoPayApprovalVO kakaoPayApprovalVO = (KakaoPayApprovalVO) session.getAttribute("payInfo");
    	
    	log.info("infoddddd :   "+kakaoPayApprovalVO);
    	
    	
    	model.addAttribute("cancel", kakaoPayService.kakaoPayCancel(kakaoPayApprovalVO));
    }
    

	

}
