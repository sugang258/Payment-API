package com.gang.home.kakao;

import lombok.Data;

@Data
public class ApprovedCancelAmountVO {

	private Integer total;
	private Integer tax_free;
	private Integer vat, point, discount, green_deposit;
}
