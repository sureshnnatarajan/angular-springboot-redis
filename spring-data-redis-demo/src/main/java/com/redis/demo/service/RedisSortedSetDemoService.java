package com.redis.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisSortedSetDemoService {

	@Resource(name = "redisTemplate")
	private ZSetOperations<String, String> zSetOperations;

	public List<TopMerchantsDto> getMerchants() {
		Set<ZSetOperations.TypedTuple<String>> topMerchantSet = zSetOperations.rangeByScoreWithScores("topMerchants", 10, 10000000);
		List<TopMerchantsDto> topMerchantsDtoList = new ArrayList<>();
		
		if (topMerchantSet == null || topMerchantSet.isEmpty()) {
			return topMerchantsDtoList;
		}
		
		topMerchantSet.forEach(merchant -> {
			TopMerchantsDto dto = new TopMerchantsDto();
			dto.setMerchantName(merchant.getValue());
			dto.setInvoiceAmount(merchant.getScore());
			topMerchantsDtoList.add(dto);
		});
		
		return topMerchantsDtoList;
	}
	
}
