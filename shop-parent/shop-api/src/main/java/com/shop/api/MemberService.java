package com.shop.api;

import com.shop.base.ResponseBase;
import com.shop.entity.UserEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/member")
public interface MemberService {

	// 使用userId查找用户信息
	@RequestMapping("/findUserById")
	ResponseBase findUserById(Long userId);
	@RequestMapping("/regUser")
	ResponseBase regUser(@RequestBody UserEntity user);
}
