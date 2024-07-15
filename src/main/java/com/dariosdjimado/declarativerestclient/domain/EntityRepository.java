package com.dariosdjimado.declarativerestclient.domain;

import java.util.List;

public interface EntityRepository<E extends Entity> {
  List<E> findAll();

  E findById(Long id);

  void save(E entity);

  // ...
}
