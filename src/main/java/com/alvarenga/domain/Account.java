package com.alvarenga.domain;

public class Account {
  private Long id;
  private String name;
  private User user;

  public Account(Long id, String name, User user) {
    this.id = id;
    this.name = name;
    this.user = user;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public User getUser() {
    return this.user;
  }

}
