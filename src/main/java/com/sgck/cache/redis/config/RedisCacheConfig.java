package com.sgck.cache.redis.config;

import java.util.Map;

public interface RedisCacheConfig {
	// redis 相关配置
	public int getPort();
	public String getHost();
	public String getPwd();
	public int getMaxIdle();
	
	//默认redis池的过期时间，以秒为单位
	public int getDefaultCacheExpiration();
	//每个redis池过期时间，如果设置为0，则表示永不过期
	public Map<String, Long> getCacheExpirations();
}
