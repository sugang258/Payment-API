package com.gang.home.kakao;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayCancelVO {
	private String aid,tid,cid,status;
	private String partner_order_id, partner_user_id;
	private String payment_method_type;
	private AmountVO amount;
	private ApprovedCancelAmountVO approvedCancelAmountVO;
	private CanceledAmountVO canceledAmountVO;
	private CancelAvailableAmountVO cancelAvailableAmountVO;
	private String item_name,item_code;
	private Integer quantity;
	private Date create_at, approved_at, canceled_at;
	private String payload;
	
	
}
