package com.pm.authservice.service;

import com.pm.authservice.dto.LoginRequestDTO;
import com.pm.authservice.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final UserService userSvc;
  private final PasswordEncoder encoder;
  private final JwtUtil jwt;

  public AuthService(UserService userSvc, PasswordEncoder encoder,
      JwtUtil jwt) {
    this.userSvc = userSvc;
    this.encoder = encoder;
    this.jwt = jwt;
  }

  public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
    Optional<String> token = userSvc.findByEmail(loginRequestDTO.getEmail())
        .filter(u -> encoder.matches(loginRequestDTO.getPassword(),
            u.getPassword()))
        .map(u -> jwt.generateToken(u.getEmail(), u.getRole()));

    return token;
  }

  public boolean validateToken(String token) {
    try {
      jwt.validateToken(token);
      return true;
    } catch (JwtException e){
      return false;
    }
  }
}
