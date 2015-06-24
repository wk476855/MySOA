package com.demo.resource;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wk on 2015/6/8.
 */
public class Theaters implements Serializable{
	private String status;
	private List<Theater> results;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Theater> getResults() {
		return results;
	}

	public void setResults(List<Theater> results) {
		this.results = results;
	}
}
