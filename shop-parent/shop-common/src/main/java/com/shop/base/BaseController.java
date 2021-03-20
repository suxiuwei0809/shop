package com.shop.base;

import com.shop.constants.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

	// 返回成功 ,data值为null
	public ResponseBase setResultSuccess() {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
	}
	// 返回成功 ,data可传
	public ResponseBase setResultSuccess(Object data) {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
	}
	// 返回失败
	public ResponseBase setResultError(String msg){
		return setResult(Constants.HTTP_RES_CODE_500,msg, null);
	}
	// 自定义返回结果
	public ResponseBase setResult(Integer code, String msg, Object data) {
		ResponseBase responseBase = new ResponseBase();
		responseBase.setRtnCode(code);
		responseBase.setMsg(msg);
		if (data != null)
			responseBase.setData(data);
		return responseBase;
	}

	public static Map getRequestParamMap(HttpServletRequest request)
	{
		Map map = new HashMap();
		//得到枚举类型的参数名称，参数名称若有重复的只能得到第一个
		Enumeration enums = request.getParameterNames();
		while (enums.hasMoreElements())
		{
			String paramName = (String) enums.nextElement();
			String paramValue = request.getParameter(paramName);
			//形成键值对应的map
			map.put(paramName, paramValue);
		}
		return map;
	}
}
