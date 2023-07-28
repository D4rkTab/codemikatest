package com.codemika.secondapp.repo;

import com.codemika.secondapp.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet, Long> {

}
