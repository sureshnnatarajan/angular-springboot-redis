package com.redis.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/redis/list")
@CrossOrigin("*")
public class RedisListDemoController {

	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOperations;
	
	@GetMapping("/values")
	@Tag(name = "List", description = "List Operations")
	public List<String> getValues() {
		return listOperations.range("listKeys", 0, -1);
	}
	
	@PostMapping("/value/left")
	@Tag(name = "List", description = "List Operations")
	public String saveValueLeft(@RequestBody String value) {
		listOperations.leftPush("listKeys", value);
		return HttpStatus.OK.toString();
	}
	
	@PostMapping("/value/right")
	@Tag(name = "List", description = "List Operations")
	public String saveValueRight(@RequestBody String value) {
		listOperations.rightPush("listKeys", value);
		return HttpStatus.OK.toString();
	}
}
