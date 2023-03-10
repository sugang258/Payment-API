package com.gang.home.kakao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;

@Service
@Log
public class KakaoPayService {

	private static final String HOST = "https://kapi.kakao.com";
	private KakaoPayReadyVO kakaoPayReadyVO;
	private KakaoPayApprovalVO kakaoPayApprovalVO;
	private KakaoPayCancelVO kakaoPayCancelVO;
	
	@Value("${kakaopay.admin}")
	private String admin_key;
	
	public String kakaoPayReady() {
		log.info("ready!!!!");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		
		//header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","KakaoAK "+ admin_key);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=UTF-8");
		
		//body
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("partner_order_id", "1001");
		params.add("partner_user_id", "gorany");
		params.add("item_name", "아이폰14");
		params.add("quantity", "1");
		params.add("total_amount", "2100");
		params.add("tax_free_amount", "100");
		params.add("approval_url", "http://localhost:81/kakao/kakaoPaySuccess");
		params.add("cancel_url", "http://localhost:81/kakao/kakaoPayCancel");
		params.add("fail_url", "http://localhost:81/kakao/kakaoPaySuccessFail");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
		log.info("body:  "+ body);
		
		try {
			kakaoPayReadyVO = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/ready", body, KakaoPayReadyVO.class);
			
			log.info("kakaoakakakad  :  "+ kakaoPayReadyVO);
			return kakaoPayReadyVO.getNext_redirect_pc_url();
			
		} catch(RestClientException e){
			e.printStackTrace();
		}
			
		log.info("dd ::    " + kakaoPayReadyVO);
						
		return "/kakaoPay";
	}
	
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {
		log.info("kakaopayinfo  ");
		log.info("-----------------------");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + admin_key);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=UTF-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("pg_token", pg_token);
        params.add("total_amount", "2100");
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
			kakaoPayApprovalVO = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/approve", body, KakaoPayApprovalVO.class);
			
			log.info(""+ kakaoPayApprovalVO);
			
			return kakaoPayApprovalVO;
		
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public KakaoPayCancelVO kakaoPayCancel(KakaoPayApprovalVO kakaoPayApprovalVO) {
		
		log.info("cancel-------");
		log.info("info:    "+kakaoPayApprovalVO);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+admin_key);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=UTF-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.add("cid", kakaoPayApprovalVO.getCid());
		params.add("tid", kakaoPayApprovalVO.getTid());
		params.add("cancel_amount", kakaoPayApprovalVO.getAmount().getTotal().toString());
		params.add("cancel_tax_free_amount","100");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
		try {
			kakaoPayCancelVO = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/cancel", body, KakaoPayCancelVO.class);
			
			log.info(" cancel  :   "+kakaoPayCancelVO);
			return kakaoPayCancelVO;
		}catch(RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}
}
