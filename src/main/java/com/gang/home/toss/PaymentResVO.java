package com.gang.home.toss;

import lombok.Data;

@Data
public class PaymentResVO {
	
	private String payType;
	private Long amount;
	private String orderId;
	private String orderName;
	private String customerEmail;
	private String customerName;
	private String successUrl;
	private String failUrl;
	private String createDate;
	private String paySuccessYn;
	

}
