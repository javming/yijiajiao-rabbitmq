package com.yijiajiao.rabbitmq.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

	public static JedisPool pool;

	private static String redisIp = Config.getString("redis.ip");

	static {
		JedisPoolConfig config = new JedisPoolConfig();
		int active = Config.getInt("redis.maxactive");
		int idle = Config.getInt("redis.maxidle");
		int wait = Config.getInt("redis.maxwait");
		config.setMaxActive(active);
		config.setMaxIdle(idle);
		config.setMaxWait(wait);
		config.setTestOnBorrow(true);
		pool = new JedisPool(config, redisIp);
	}

}
