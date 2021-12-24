package com.redis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.demo.model.RedisHashDemoModel;
import com.redis.demo.repos.RedisHashDemoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/redis/redishash")
@CrossOrigin("*")
public class RedisHashDemoController {

	@Autowired
	private RedisHashDemoRepository redisHashDemoRepository;
	
	@GetMapping("/values")
	@Tag(name = "RedisHash", description = "Redis Hash Operations")
	private Iterable<RedisHashDemoModel> getRedisHashValues() {
		return redisHashDemoRepository.findAll();
	}
	
	@PostMapping("/values")
	@Tag(name = "RedisHash", description = "Redis Hash Operations")
	private void saveRedisHash(@RequestBody RedisHashDemoModel model) {
		redisHashDemoRepository.save(model);
	}
}