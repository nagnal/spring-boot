package com.perf.demo.inputjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdResult_1 {
	@JsonProperty("value")
	public ProdValue value;
    @JsonProperty("key")
    public String key;
	/**
	 * @return the value
	 */
	public ProdValue getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(ProdValue value) {
		this.value = value;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProdResult_1 [value=" + value + ", key=" + key + "]";
	}
}
