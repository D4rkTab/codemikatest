package com.codemika.firstapp.services;


import com.codemika.firstapp.exceptions.UserNotFoundException;
import com.codemika.firstapp.models.User;
import com.codemika.firstapp.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAll(){
        return this.userRepo.findAll();
    }

    public User getOne(Long id){
        return this.userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User create(String name, String surname, String patronymic, String email, String password, String phone){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User(name, surname, patronymic, email, passwordEncoder.encode(password), phone);
        return userRepo.save(user);
    }

    public User update(Long id, User user){
        return userRepo.findById(id)
                .map(_user -> {
                    _user.setName(user.getName());
                    _user.setPatronymic(user.getPatronymic());
                    _user.setSurname(user.getSurname());
                    return userRepo.save(_user);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return userRepo.save(user);
                });
    }

    public void delete(Long id){
        userRepo.deleteById(id);
    }
}

