package com.redis.demo.service;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServerCommandService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	
	public Map<String, Object> getServerInfo() {
		
		String serverInfo = redisTemplate.getConnectionFactory().getConnection().execute("info", null).toString();
		
		//System.out.println("serverInfo===>" + serverInfo);
		
		String[] serverInfoArray = serverInfo.split("\r\n");
		
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		for (String info: serverInfoArray) {
			if (info.startsWith("#")) {
				String[] titleArray = info.split("#");
				if (titleArray == null || titleArray.length <= 0) {
					continue;
				}
			} 
			if (info.contains(":")) {
				String[] properties = info.split(":");
				propertiesMap.put(properties[0], properties[1].trim());
			}
		}
		
		return propertiesMap;
	}
}
