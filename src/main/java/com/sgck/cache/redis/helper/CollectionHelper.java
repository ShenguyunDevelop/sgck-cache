package com.sgck.cache.redis.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;


/*
 * 此类是Spring-data-redis的帮助类
 * 用于获取 @Cacheable @CachePut 注解的对象列表
 */
public class CollectionHelper {
	@SuppressWarnings("rawtypes")
	@Autowired private RedisTemplate template;
	@Autowired private RedisCacheManager cacheManager;
	
	@SuppressWarnings("unchecked")
	public List<String> getCachedItemIDList(final String cacheName){
		return (List<String>) template.execute(new RedisCallback<List<String>>() {
			@Override
			public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
				Set<byte[]> keys = connection.keys(template.getKeySerializer().serialize(cacheName + ":*"));
				List<String> cacheKeys = new ArrayList<String>();

				if (!CollectionUtils.isEmpty(keys)) {
					for (byte[] key : keys) {
						cacheKeys.add(template.getKeySerializer().deserialize(key).toString().replace(cacheName + ":", ""));
					}
				}

				return cacheKeys;
			}
		});
	}
	
	public <T> Map<String,T> getCachedItemList(String cacheName,Class<T> type){
		if(cacheManager == null){
			return null;
		}
		
		Cache redisCache = cacheManager.getCache(cacheName);
		if(redisCache == null){
			return null;
		}
		
		List<String> keyList = getCachedItemIDList(cacheName);
		if(keyList == null || keyList.isEmpty()){
			return null;
		}
		
		Map<String,T> result = new HashMap<String,T>();
		for(String key : keyList){
			T object = redisCache.get(key, type);
			if(object != null){
				result.put(key, object);
			}
		}
		
		return result;
	}
}
