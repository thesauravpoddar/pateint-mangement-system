package com.pm.authservice.controller;

import com.pm.authservice.dto.LoginRequestDTO;
import com.pm.authservice.dto.LoginResponseDTO;
import com.pm.authservice.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  private final AuthService service;

  public AuthController(AuthService service) {
    this.service = service;
  }

  @Operation(summary = "Generate token on user login")
  @PostMapping("/login")
  public ResponseEntity<LoginResponseDTO> login(
      @RequestBody LoginRequestDTO loginRequestDTO) {

    Optional<String> tokenOpt = service.authenticate(loginRequestDTO);

    if (tokenOpt.isEmpty()) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    String token = tokenOpt.get();
    return ResponseEntity.ok(new LoginResponseDTO(token));
  }

  @Operation(summary = "Validate Token")
  @GetMapping("/validate")
  public ResponseEntity<Void> validateToken(
      @RequestHeader("Authorization") String header) {

    // Authorization: Bearer <token>
    if(header == null || !header.startsWith("Bearer ")) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    return service.validateToken(header.substring(7))
        ? ResponseEntity.ok().build()
        : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
}
