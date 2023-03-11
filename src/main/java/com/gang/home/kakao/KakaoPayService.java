package com.gang.home.kakao;

import java.net.URI;
import java.net.URISyntaxException;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
	
	@Value("${kakaopay.admin}")
	private String admin_key;
	
	public String kakaoPayReady() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Autorization","KakaoAK "+ admin_key );
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset=UTF-8");
		
		
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("partner_order_id", "1001");
		params.add("partnet_user_id", "gorany");
		params.add("item_name", "아이폰14");
		params.add("quantity", "1");
		params.add("total_amount", "2100");
		params.add("tax_free_amount", "100");
		params.add("approval_url", "http://localhost:81/kakaoPaySuccess");
		params.add("cancel_url", "http://localhost:81/kakaoPayCancel");
		params.add("fail_url", "http://localhost:81/kakaoPaySuccessFail");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
		try {
			kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
			
			log.info(""+ kakaoPayReadyVO);
			
			return kakaoPayReadyVO.getNext_redirect_pc_url();
		
		} catch (RestClientException e) {
			e.printStackTrace();
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}

		return "/pay";
	}
	
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {
		log.info("kakaopayinfo  ");
		log.info("-----------------------");
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + admin_key);
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
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
        	kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
        	log.info("" +kakaoPayApprovalVO);
        	
        	return kakaoPayApprovalVO;
        }catch(RestClientException e) {
        	e.printStackTrace();
        }catch(URISyntaxException e) {
        	e.printStackTrace();
        }
		
		return null;
	}
}
