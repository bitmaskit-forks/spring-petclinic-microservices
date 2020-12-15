package org.springframework.samples.petclinic.customers.model;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface PetRepository extends JpaRepository<Pet, Integer> {
	/**
	 * Retrieve all {@link PetType}s from the data store.
	 *
	 * @return a Collection of {@link PetType}s.
	 */
	@Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
	List<PetType> findPetTypes();

	@Query("FROM PetType ptype WHERE ptype.id = :typeId")
	Optional<PetType> findPetTypeById(@Param("typeId") int typeId);
}
