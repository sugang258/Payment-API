package com.gang.home.kakao;

import lombok.Data;

@Data
public class AmountVO {
	
	private Integer total;
	private Integer tax_free;
	private Integer vat;
	private Integer point;
	private Integer discount;

}
