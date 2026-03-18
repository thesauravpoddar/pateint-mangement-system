package com.pm.authservice.service;

import com.pm.authservice.model.User;
import com.pm.authservice.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repo;

  public UserService(UserRepository repo) {
    this.repo = repo;
  }
  
  public Optional<User> findByEmail(String email) {
    return repo.findByEmail(email);
  }
}
