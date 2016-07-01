package com.sgck.cache.redis.serializer;

import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

/**
 * @author yuan
 * 2015-8-31上午10:44:32
 * 该类只能用于redis key的序列化，不能用于value的序列化
 */
public class StringRedisKeySerializer implements RedisSerializer<Object> {

	private final Charset charset;

	public StringRedisKeySerializer() {
		this(Charset.forName("UTF8"));
	}

	public StringRedisKeySerializer(Charset charset) {
		Assert.notNull(charset);
		this.charset = charset;
	}

	public Object deserialize(byte[] bytes) {
		return (bytes == null ? null : new String(bytes, charset));
	}

	public byte[] serialize(Object string) {
		return (string == null ? null : String.valueOf(string).getBytes(charset));
	}
}
