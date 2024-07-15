package com.dariosdjimado.declarativerestclient.infra.h2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserH2Entity {
  @Id private Long id;
  private String name;

  public UserH2Entity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  protected UserH2Entity() {}
}
