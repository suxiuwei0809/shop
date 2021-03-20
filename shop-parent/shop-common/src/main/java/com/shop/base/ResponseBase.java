package com.shop.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ResponseBase {

	private Integer code;
	private String msg;
	private Object data;

	public Integer getRtnCode() {
		return code;
	}

	public void setRtnCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseBase() {

	}

	public ResponseBase(Integer rtnCode, String msg, Object data) {
		super();
		this.code = rtnCode;
		this.msg = msg;
		this.data = data;
	}



	@Override
	public String toString() {
		return "ResponseBase [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
