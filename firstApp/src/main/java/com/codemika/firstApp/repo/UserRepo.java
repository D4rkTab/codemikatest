package com.codemika.firstApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codemika.firstApp.models.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

}
