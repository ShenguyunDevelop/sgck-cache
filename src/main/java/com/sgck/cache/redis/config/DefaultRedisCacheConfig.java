package com.sgck.cache.redis.config;

import java.util.Map;

public class DefaultRedisCacheConfig implements RedisCacheConfig {
	private String host;
	private String pwd;
	private int port;
	private int maxIdle;

	private int defaultCacheExpiration;
	private Map<String, Long> cacheExpirations;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	public int getDefaultCacheExpiration() {
		return defaultCacheExpiration;
	}
	public void setDefaultCacheExpiration(int defaultCacheExpiration) {
		this.defaultCacheExpiration = defaultCacheExpiration;
	}
	public Map<String, Long> getCacheExpirations() {
		return cacheExpirations;
	}
	public void setCacheExpirations(Map<String, Long> cacheExpirations) {
		this.cacheExpirations = cacheExpirations;
	}
}
