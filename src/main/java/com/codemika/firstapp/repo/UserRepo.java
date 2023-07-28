package com.codemika.firstapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codemika.firstapp.models.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

}
