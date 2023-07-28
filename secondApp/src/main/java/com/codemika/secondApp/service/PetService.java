package com.codemika.secondapp.service;

import com.codemika.secondapp.exceptions.PetNotFoundException;
import com.codemika.secondapp.models.Pet;
import org.springframework.stereotype.Service;
import com.codemika.secondapp.repo.PetRepo;
@Service
public class PetService {
    private PetRepo petRepo;

    public PetService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    public Pet create(String name, String type, Long userId){
        Pet pet = new Pet(name, type, userId);
        return this.petRepo.save(pet);
    }
    public Pet update(Long id, Pet pet, Long userId){
        return this.petRepo.findById(id)
                .map(_pet -> {
                    _pet.setName(pet.getName());
                    _pet.setType(pet.getType());
                    _pet.setUserId(userId);
                    return this.petRepo.save(_pet);
                })
                .orElseGet(() -> {
                    pet.setId(id);
                    return petRepo.save(pet);
                });
    }
    public Pet getOne(Long id){
        return this.petRepo.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

}
