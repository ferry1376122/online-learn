package org.online.learn.domain.common;

import java.io.Serializable;
import java.util.Map;


public class Result implements Serializable {

	private static final long serialVersionUID = -8895587618998707011L;

	private String msg;
	private Map<String, Object> datas;
	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getDatas() {
		return datas;
	}

	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}

	public Result() {
		super();
	}

	public Result(Boolean isSuccess, String msg) {
		super();
		this.msg = msg;
	}

	public Result(Boolean isSuccess, String msg, Integer code) {
		super();
		this.msg = msg;
		this.code = code;
	}
	public Result(ReturnCode returnCode) {
		super();
		this.msg = returnCode.getDetail();
		this.code = returnCode.getCode();
	}

	public Result(Boolean isSuccess, String msg, Map<String, Object> datas, Integer code) {
		super();
		this.msg = msg;
		this.datas = datas;
		this.code = code;
	}

	@Override
	public String toString() {
		return "Result [msg=" + msg + ", datas=" + datas + ", code=" + code + "]";
	}

}
