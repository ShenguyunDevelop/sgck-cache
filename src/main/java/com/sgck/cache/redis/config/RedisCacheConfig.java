package com.sgck.cache.redis.config;

import java.util.Map;

public interface RedisCacheConfig {
	// redis �������
	public int getPort();
	public String getHost();
	public String getPwd();
	public int getMaxIdle();
	
	//Ĭ��redis�صĹ���ʱ�䣬����Ϊ��λ
	public int getDefaultCacheExpiration();
	//ÿ��redis�ع���ʱ�䣬�������Ϊ0�����ʾ��������
	public Map<String, Long> getCacheExpirations();
}
