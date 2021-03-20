package com.shop.api;

import java.util.Map;

import com.shop.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
public interface TestApiService {
	@RequestMapping("/test")
	public Map<String, Object> test(Integer id, String name);

	@RequestMapping("/testResponseBase")
	public ResponseBase testResponseBase();

	@RequestMapping("/testRedis")
	public ResponseBase settestRedis(String key, String value);
}
