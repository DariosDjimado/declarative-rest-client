package com.dariosdjimado.declarativerestclient.infra.h2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserH2Dao extends JpaRepository<UserH2Entity, Long> {
  List<UserH2Entity> findByName(String name);
}
