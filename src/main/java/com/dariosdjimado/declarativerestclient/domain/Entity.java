package com.dariosdjimado.declarativerestclient.domain;

import lombok.Getter;

@Getter
public class Entity {
  private final Long id;

  public Entity(Long id) {
    this.id = id;
  }
}
