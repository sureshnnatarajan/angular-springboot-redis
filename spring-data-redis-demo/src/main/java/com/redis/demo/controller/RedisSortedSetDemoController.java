package com.redis.demo.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.demo.dto.TopMerchants;
import com.redis.demo.service.RedisSortedSetDemoService;
import com.redis.demo.service.TopMerchantsDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/redis/sortedset")
@CrossOrigin("*")
public class RedisSortedSetDemoController {

	@Resource(name = "redisTemplate")
	private ZSetOperations<String, String> zSetOperations;
	
	@Autowired
	private RedisSortedSetDemoService sortedSetService;
	
	@PostMapping("/url")
	@Tag(name = "SortedSet", description = "Sorted Set Operations")
	public Set<String> saveUrl(@RequestBody String url) {
		
		zSetOperations.add("accessedUrl", url, url.length());
		
		return zSetOperations.range("accessedUrl", 0, 10);
	}
	
	@GetMapping("/url")
	@Tag(name = "SortedSet", description = "Sorted Set Operations")
	public Set<String> getUrlsByScore() {
		return zSetOperations.range("accessedUrl", 0, 10);
	}
	
	@PostMapping("/merchants")
	@Tag(name = "Merchants", description = "Top Merchants by Invoice Amount")
	public Set<String> saveMerchant(@RequestBody TopMerchants input) {
		
		zSetOperations.add("topMerchants", input.getMerchantName(), input.getInvoiceAmount());
		
		return zSetOperations.reverseRange("topMerchants", 0, 10);
	}
	
	@GetMapping("/merchants")
	@Tag(name = "Merchants", description = "Top Merchants by Invoice Amount")
	public  Set<ZSetOperations.TypedTuple<String>> getMerchantsByScore() {
		return zSetOperations.rangeByScoreWithScores("topMerchants", 10, 10000000); 
	}
	
	@GetMapping("/merchants/score")
	@Tag(name = "Merchants", description = "Top Merchants by Invoice Amount")
	public List<TopMerchantsDto> getTopMerchants() {
		return sortedSetService.getMerchants();
	}
}
