package com.seeini.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Color2020
 */
@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate<String, Object> RedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		// key的序列化类型
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		// value的序列化类型
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		return redisTemplate;
	}
}
