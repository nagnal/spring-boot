package com.perf.demo.inputjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputJsonProduct {

	@JsonProperty("type")
	public String type;
	@JsonProperty("msg")
	public String msg;
	@JsonProperty("result")
	public ProdResult result;
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the result
	 */
	public ProdResult getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(ProdResult result) {
		this.result = result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OutputJsonProduct [type=" + type + ", msg=" + msg + ", result=" + result + "]";
	}
}