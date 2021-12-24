package com.redis.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.demo.service.RedisServerCommandService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/redis/server")
@CrossOrigin("*")
public class RedisServerCommandsController {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private RedisServerCommandService redisServerCommandService;
	
	@GetMapping("/info")
	@Tag(name = "Server", description = "Server Info")
	public String getServerInfo() {
		return redisTemplate.getConnectionFactory().getConnection().execute("info", null).toString();
	}
	
	@GetMapping("/info/print")
	@Tag(name = "Server", description = "Server Info")
	public Map<String, Object> printServerInfo() {
		return redisServerCommandService.getServerInfo();
	}
}
