package com.plg.springvalidationexample.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @Column(length = 36)
  private String userId;
  @Column(length = 50)
  private String name;
  @Column(length = 100)
  private String email;
  @Column(length = 500)
  private String password;
  @Column(length = 1)
  private String gender;
  private int age;
  @Column(length = 50)
  private String nationality;
}
