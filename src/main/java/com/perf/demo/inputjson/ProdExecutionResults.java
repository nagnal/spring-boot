package com.perf.demo.inputjson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdExecutionResults {
	@JsonProperty("results")
	public List<ProdResult_1> results = null;
	@JsonProperty("facts")
	public List<Fact> facts = null;
	/**
	 * @return the results
	 */
	public List<ProdResult_1> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<ProdResult_1> results) {
		this.results = results;
	}
	/**
	 * @return the facts
	 */
	public List<Fact> getFacts() {
		return facts;
	}
	/**
	 * @param facts the facts to set
	 */
	public void setFacts(List<Fact> facts) {
		this.facts = facts;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProdExecutionResults [results=" + results + ", facts=" + facts + "]";
	}
}
