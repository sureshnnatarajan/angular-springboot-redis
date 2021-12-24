package com.redis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/redis/string")
@CrossOrigin("*")
public class RedisStringDemoController {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@PostMapping("/url")
	@Tag(name = "String", description = "String URL Operations")
	public Boolean storeStringUrl(@RequestBody String url) {
		return redisTemplate.getConnectionFactory().getConnection().set("urlKey".getBytes(), url.getBytes());
	}
	
	@GetMapping("/url")
	@Tag(name = "String", description = "String URL Operations")
	public byte[] getStringUrl() {
		return redisTemplate.getConnectionFactory().getConnection().get("urlKey".getBytes());
	}
}
