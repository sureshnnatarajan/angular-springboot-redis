package com.redis.demo.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopMerchantsDto {

	private String merchantName;
	
	private Double invoiceAmount;
}
