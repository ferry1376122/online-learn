package org.online.learn.domain.common;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Callback<T> implements Serializable {
	private static final long serialVersionUID = 3735509713236625487L;
	private Integer code;
	private T datas;
	private String msg;
	private Boolean success;
	public Callback() {
		super();
	}
	public Callback(Integer code, T datas, String msg, Boolean success) {
		super();
		this.code = code;
		this.datas = datas;
		this.msg = msg;
		this.success = success;
	}
	public Callback(ReturnCode returnCode,Boolean success) {
		super();
		this.code = returnCode.getCode();
		this.msg = returnCode.getDetail();
		this.success = success;
	}
	public Callback(ReturnCode returnCode,T datas, Boolean success) {
		super();
		this.code = returnCode.getCode();
		this.msg = returnCode.getDetail();
		this.datas = datas;
		this.success = success;
	}
	public Callback(Integer code, T datas, String msg) {
		super();
		this.code = code;
		this.datas = datas;
		this.msg = msg;
		this.success = true;
	}
}