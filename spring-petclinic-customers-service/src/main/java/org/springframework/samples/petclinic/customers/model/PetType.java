package org.springframework.samples.petclinic.customers.model;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class PetType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
}
