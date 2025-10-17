package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.ashokit.model.User;

public class RedisConfig {
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();
		  
		return jcf;
	}
	@Bean
	RedisTemplate<String, User> redisTemplate(){
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

}
