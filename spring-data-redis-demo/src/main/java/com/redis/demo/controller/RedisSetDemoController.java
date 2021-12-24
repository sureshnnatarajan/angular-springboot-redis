package com.redis.demo.controller;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.SetOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@RequestMapping("/redis/set")
public class RedisSetDemoController {

	@Resource(name = "redisTemplate")
	private SetOperations<String, String> setOperations;
	
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	@PostMapping("/url")
	@Tag(name = "URL", description = "URL Operations")
	public Long storeUrl(@RequestBody String url) {
		
		if (!setOperations.isMember("uniqueUrl", url)) {
			return setOperations.add("uniqueUrl", url);
		}
		
		return -1L;
	}
	
	@GetMapping("/url")
	@Tag(name = "URL", description = "URL Operations")
	public Set<String> getUrls() {
		return setOperations.members("uniqueUrl");
	}
	
	@PostMapping("/url/unique")
	@Tag(name = "URL", description = "URL Operations")
	public HttpStatus storeUniqueUrl(@RequestBody String url) {
		
		if (!setOperations.isMember("uniqueUrl", url)) {
			setOperations.add("uniqueUrl", url);
			
			return HttpStatus.OK;
		}
		
		return HttpStatus.CONFLICT;
	}
}
