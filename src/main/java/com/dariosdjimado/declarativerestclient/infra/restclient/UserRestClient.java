package com.dariosdjimado.declarativerestclient.infra.restclient;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface UserRestClient {

  @GetExchange()
  List<UserRestClientEntity> findAll();

  @GetExchange("/{id}")
  Optional<UserRestClientEntity> findById(@PathVariable Long id);

  @PostExchange("/")
  void save(UserRestClientEntity entity);

  @DeleteExchange("/{id}")
  void deleteById(@PathVariable Long id);
}
