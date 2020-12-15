package org.springframework.samples.petclinic.api.dto;

import java.util.*;

public class Visits {
	private List<VisitDetails> items = new ArrayList<>();

	public List<VisitDetails> getItems() {
		return items;
	}

	public void setItems(List<VisitDetails> items) {
		this.items = items;
	}
}
