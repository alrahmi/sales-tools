package com.rahmi.BuildCar.util.filter;

import java.io.IOException;

import javax.ws.rs.QueryParam;

import org.codehaus.jackson.map.ObjectMapper;

public class RequestForm {

	private int page = 1;
	private int limit = -1;
	private Sort sort;

	public int getPage() {
		return page;
	}

	@QueryParam("page")
	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	@QueryParam("limit")
	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Sort getSort() {
		return sort;
	}

	@QueryParam("sort")
	public void setSort(String sortJson) {
		if (sortJson == null || sortJson == "") {
			return;
		}
		ObjectMapper mapper = new ObjectMapper();
		Sort sort;
		try {
			sort = mapper.readValue(sortJson, Sort.class);
			this.sort = sort;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
