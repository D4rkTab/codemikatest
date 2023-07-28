package com.codemika.secondApp.repo;

import com.codemika.secondApp.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet, Long> {

}
