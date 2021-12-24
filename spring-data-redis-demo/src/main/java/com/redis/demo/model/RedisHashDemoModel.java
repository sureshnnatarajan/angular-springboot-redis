package com.redis.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("RedisHashDemo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisHashDemoModel {

	@Id
	private String name;
	
	private String title;
	
	private String location;
}
