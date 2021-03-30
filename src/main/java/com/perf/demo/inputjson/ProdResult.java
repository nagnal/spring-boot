package com.perf.demo.inputjson;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ProdResult {
	@JsonProperty("execution-results")
	public ProdExecutionResults executionResults;

	/**
	 * @return the executionResults
	 */
	public ProdExecutionResults getExecutionResults() {
		return executionResults;
	}

	/**
	 * @param executionResults the executionResults to set
	 */
	public void setExecutionResults(ProdExecutionResults executionResults) {
		this.executionResults = executionResults;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProdResult [executionResults=" + executionResults + "]";
	}
}
