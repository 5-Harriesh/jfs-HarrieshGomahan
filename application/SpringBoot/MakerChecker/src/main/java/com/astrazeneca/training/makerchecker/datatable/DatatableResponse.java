package com.astrazeneca.training.makerchecker.datatable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DatatableResponse<T> {
	
	private long recordsTotal;
	private List<T> data;

}
