package com.codemika.secondapp.controllers;

import com.codemika.secondapp.models.Pet;
import com.codemika.secondapp.service.PetService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping("/pet")
    public Pet getOne(@RequestParam Long id){
        return this.petService.getOne(id);
    }
    @PostMapping("/pet")
    public Pet create(@RequestParam String name, @RequestParam String type, @RequestParam Long userId){
        return this.petService.create(name,type,userId);
    }
    @PutMapping("/pet/{id}")
    public Pet update(@PathVariable Long id, @RequestBody Pet pet, @RequestParam Long userId){
            return this.petService.update(id, pet, userId);
    }
}
