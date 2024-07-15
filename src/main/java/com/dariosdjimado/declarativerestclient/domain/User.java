package com.dariosdjimado.declarativerestclient.domain;

import lombok.Getter;

@Getter
public class User extends Entity {

  private final String name;

  public User(Long id, String name) {
    super(id);
    this.name = name;
  }
}
