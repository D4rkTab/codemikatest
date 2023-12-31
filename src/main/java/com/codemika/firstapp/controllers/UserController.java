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

    @GetMapping("/user/{userId}")
    public User getOne(@PathVariable Long userId){
        return userService.getOne(userId);
    }
    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }
    @PutMapping("/user/{userId}")
    public User update(@PathVariable Long userId, @RequestBody User user){
        return userService.update(userId, user);
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
