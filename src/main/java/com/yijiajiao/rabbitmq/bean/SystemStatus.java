package com.yijiajiao.rabbitmq.bean;

public enum SystemStatus {

	OK(200, "success"),

	// 500- 服务器错误
	SERVER_ERROR(500, "服务器异常"),
	// 400- 请求错误
	BAD_REQUEST(400, "Bad Request"), UNAUTHORIZED(401, "参数不匹配"), UNSUPPORTED_MEDIA_TYPE(
			415, "Unsupported Media Type"),

	UNSUPPORTED_TEL(50001, "手机号已经存在"), SEND_ERROR(50002, "验证码发送失败"),

	UUIMS_ERROR(60001, "请求认证服务器出错"),

	ID_NOT_FOUND(400001, "请求参数不匹配"),

	TOKEN_TIME_OUT(600002, "登录过期,请重新登录");

	SystemStatus(int status, String str) {
		setCode(status);
		setStr(str);
	}

	/*
	 * public SystemStatus newStatus(int status, String str){
	 * 
	 * }
	 */
	private int code;

	private String str;

	public int getCode() {
		return code;
	}

	public String getStr() {
		return str;
	}

	private void setCode(int code) {
		this.code = code;
	}

	private void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("code");
		sb.append(":");
		sb.append(code);
		sb.append(",");
		sb.append("message");
		sb.append(":");
		sb.append(str);
		return sb.toString();
	}

}
