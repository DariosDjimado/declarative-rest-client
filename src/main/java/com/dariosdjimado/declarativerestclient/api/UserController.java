package com.dariosdjimado.declarativerestclient.api;

import com.dariosdjimado.declarativerestclient.domain.User;
import com.dariosdjimado.declarativerestclient.domain.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @GetMapping()
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return userRepository.findById(id);
  }

  // ...
}
