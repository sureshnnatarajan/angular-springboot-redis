package com.redis.demo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redis.demo.model.RedisHashDemoModel;

@Repository
public interface RedisHashDemoRepository extends CrudRepository<RedisHashDemoModel, String> {

}
