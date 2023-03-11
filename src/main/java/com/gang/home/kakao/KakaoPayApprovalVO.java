package com.gang.home.kakao;

import lombok.Data;

@Data
public class KakaoPayApprovalVO {
	
	private String aid, tid, cid, sid;
	private String partnet_order_id;
	private String partner_user_id;
	private String patment_method_type;
}
