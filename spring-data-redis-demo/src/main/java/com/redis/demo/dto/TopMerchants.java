package com.redis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopMerchants {

	private String merchantName;
	
	private Double invoiceAmount;
}
