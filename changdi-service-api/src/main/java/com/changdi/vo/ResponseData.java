package com.changdi.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ResponseData<T> {
	private T data;
	private String msg;
	private String ret;


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("data", this.data)
				.append("msg", this.msg).append("ret", this.ret).toString();
	}

}
