package com.shop.api;

import com.shop.base.ResponseBase;
 import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/menu")
public interface MenusService {


	@RequestMapping("/saveMenu")
	ResponseBase saveMenu(HttpServletRequest request);

	@RequestMapping("/getMenus")
	ResponseBase getMenus(HttpServletRequest request);

	@RequestMapping("/deleteMenu")
	ResponseBase deleteMenu(HttpServletRequest request);

}
