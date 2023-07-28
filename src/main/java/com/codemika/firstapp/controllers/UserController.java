package com.codemika.firstapp.controllers;


import com.codemika.firstapp.exceptions.UserNotFoundException;
import com.codemika.firstapp.models.User;
import com.codemika.firstapp.repo.UserRepo;
import com.codemika.firstapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
//    Routes:
//    Get: /api/user @RequestParam Long id => User,
//    Get: /api/users => List<User>,
//    Put: /api/user @RequestParam Long id, @RequestParam User user => User,
//    Post: /api/user @RequestParam String name, @RequestParam String surname,
//    @RequestParam String patronymic, @RequestParam String email,
//    @RequestParam String password, @RequestParam String phone
//            => User
//    Delete: /api/user @RequestParam id => null

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public User getOne(Long id){
        return userService.getOne(id);
    }
    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }
    @PutMapping("/user")
    public User update(@RequestParam Long id, @RequestParam String name, @RequestParam String surname, @RequestParam String patronymic){
        return userService.update(id, name, surname, patronymic);
    }

    @PostMapping("/user")
    public User create( @RequestParam String name, @RequestParam String surname,
                        @RequestParam String patronymic, @RequestParam String email,
                        @RequestParam String password, @RequestParam String phone){
        return userService.create(name, surname, patronymic, email, password, phone);
    }
    @DeleteMapping("/user")
    public void delete(@RequestParam Long id){
        userService.delete(id);
    }
}
