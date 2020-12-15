package org.springframework.samples.petclinic.visits.web;

import java.util.*;
import javax.validation.Valid;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.visits.model.Visit;
import org.springframework.samples.petclinic.visits.model.VisitRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Timed("petclinic.visit")
class VisitResource {
	private final VisitRepository visitRepository;

	VisitResource(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@PostMapping("owners/*/pets/{petId}/visits")
	@ResponseStatus(HttpStatus.CREATED)
	public Visit create(
		@Valid @RequestBody Visit visit,
		@PathVariable("petId") int petId) {

		visit.setPetId(petId);
		log.info("Saving visit {}", visit);
		return visitRepository.save(visit);
	}

	@GetMapping("owners/*/pets/{petId}/visits")
	public List<Visit> visits(@PathVariable("petId") int petId) {
		return visitRepository.findByPetId(petId);
	}

	@GetMapping("pets/visits")
	public Visits visitsMultiGet(@RequestParam("petId") List<Integer> petIds) {
		final List<Visit> byPetIdIn = visitRepository.findByPetIdIn(petIds);
		return new Visits(byPetIdIn);
	}

	static class Visits {
		List<Visit> items;

		public Visits(List<Visit> byPetIdIn) {
		}

		public List<Visit> getItems() {
			return items;
		}

		public void setItems(List<Visit> items) {
			this.items = items;
		}
	}
}
