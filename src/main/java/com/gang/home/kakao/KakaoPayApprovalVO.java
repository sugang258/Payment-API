package com.gang.home.kakao;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayApprovalVO {
	
	private String aid, tid, cid, sid;
	private String partner_order_id;
	private String partner_user_id;
	private String payment_method_type;
	private AmountVO amount;
	private CardVO cardVO;
	private String item_name, item_code, payload;
	private Integer quantity, tax_free_amount, vat_amount;
	private Date create_at, approved_at;
}
