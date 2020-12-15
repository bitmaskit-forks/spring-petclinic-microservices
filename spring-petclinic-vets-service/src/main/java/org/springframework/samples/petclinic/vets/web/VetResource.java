package org.springframework.samples.petclinic.vets.web;

import java.util.*;

import org.springframework.samples.petclinic.vets.model.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vets")
@RestController
class VetResource {
	private final VetRepository vetRepository;

	VetResource(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@GetMapping
	public List<Vet> showResourcesVetList() {
		return vetRepository.findAll();
	}
}
