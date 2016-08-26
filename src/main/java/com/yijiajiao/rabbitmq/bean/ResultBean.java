package com.yijiajiao.rabbitmq.bean;

import java.util.UUID;

public class ResultBean {
	public String requestId = UUID.randomUUID().toString().replace("-", "");
	public String httpCode = "";
	public int code;
	public String message;
	public Object result = "";

	public int getCode() {
		return code;
	}

	private void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	private void setResult(Object result) {
		this.result = result;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

	/**
	 * 
	 * @param status
	 *            异常返回枚举类型
	 */
	public void setFailMsg(SystemStatus status) {
		setCode(status.getCode());
		setMessage(status.getStr());
	}

	/**
	 * 
	 * @param status
	 *            异常返回枚举类型
	 */
	public void setFailMsg(int code, String str) {
		setCode(code);
		setMessage(str);
	}

	/**
	 * 
	 * @param result
	 *            成功返回数据
	 */
	public void setSucResult(Object result) {
		setCode(SystemStatus.OK.getCode());
		setMessage(SystemStatus.OK.getStr());
		setResult(result);
	}

}
