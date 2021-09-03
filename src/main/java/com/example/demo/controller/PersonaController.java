package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {

  @Autowired
  private UserRepository UserRepository;

  /**
   * Gets Persona by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/Persona/{id}")
  public ResponseEntity<Persona> getPersonaById(@PathVariable(value = "id") Long PersonaId)
      throws ResourceNotFoundException {
    Persona Persona =
        UserRepository
            .orElseThrow(() -> new ResourceNotFoundException("Persona not found on :: " + PersonaId));
    return ResponseEntity.ok().body(Persona);
  }

  /**
   * Create user Persona.
   *
   * @param user the Persona
   * @return the Persona
   */
  @PostMapping("/Persona")
  public Persona createUser(@Valid @RequestBody Persona Persona) {
    return UserRepository.save(Persona);
  }

  /**
   * Update Persona response entity.
   *
   * @param userId the Persona id
   * @param userDetails the Persona details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/users/{id}")
  public ResponseEntity<Persona > updateUser(
      @PathVariable(value = "id") Long PersonaId, @Valid @RequestBody Persona userDetails)
      throws ResourceNotFoundException {

    Persona Persona =
        UserRepository
            .findById(PersonaId)
            .orElseThrow(() -> new ResourceNotFoundException("Persona not found on :: " + PersonaId));

    Persona.setBirthDate(userDetails.getBirthDate());
    Persona.setFullName(userDetails.getFullName());
    Persona.setUpdatedAt(new Date());
    final Persona  updatedPersona = UserRepository.save(Persona);
    return ResponseEntity.ok(updatedUser);
  }

  /**
   * Delete Persona map.
   *
   * @param PersonaId the Persona id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/Persona/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long PersonaId) throws Exception {
    Persona persona =
        UserRepository
            .findById(PersonaId)
            .orElseThrow(() -> new ResourceNotFoundException("Persona not found on :: " + PersonaId));

    UserRepository.delete(Persona);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
