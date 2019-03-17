package com.astrazeneca.training.makerchecker.datatable;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class DatatableRequest {

	private Map<String, DatatableFilter> filters;
	private Integer first;
	private Integer rows;
	private String sortField;
	private Integer sortOrder;

}
