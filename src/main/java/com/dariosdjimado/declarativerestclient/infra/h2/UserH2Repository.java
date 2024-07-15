package com.dariosdjimado.declarativerestclient.infra.h2;

import com.dariosdjimado.declarativerestclient.domain.User;
import com.dariosdjimado.declarativerestclient.domain.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserH2Repository implements UserRepository {
  private final UserH2Dao dao;

  @Override
  public List<User> findAll() {
    return dao.findAll().stream().map(this::toDomain).toList();
  }

  @Override
  public User findById(Long id) {
    return dao.findById(id).map(this::toDomain).orElse(null);
  }

  @Override
  public void save(User entity) {
    dao.save(new UserH2Entity(entity.getId(), entity.getName()));
  }

  private User toDomain(UserH2Entity entity) {
    return new User(entity.getId(), entity.getName());
  }
}
