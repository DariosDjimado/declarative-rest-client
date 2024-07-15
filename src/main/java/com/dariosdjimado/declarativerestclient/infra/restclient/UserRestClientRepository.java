package com.dariosdjimado.declarativerestclient.infra.restclient;

import com.dariosdjimado.declarativerestclient.domain.User;
import com.dariosdjimado.declarativerestclient.domain.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
@RequiredArgsConstructor
public class UserRestClientRepository implements UserRepository {
  private final UserRestClient client;

  @Override
  public List<User> findAll() {
    return convertToDomain(client.findAll());
  }

  @Override
  public User findById(Long id) {
    return client.findById(id).map(this::convertToDomain)
            .orElse(null);
  }

  @Override
  public void save(User entity) {
    client.save(new UserRestClientEntity(
            entity.getId(), entity.getName()));
  }

  private User convertToDomain(UserRestClientEntity entity) {
    return new User(entity.id(), entity.name());
  }

  private List<User> convertToDomain(
          List<UserRestClientEntity> entities) {
    return entities.stream().map(this::convertToDomain).toList();
  }
}
