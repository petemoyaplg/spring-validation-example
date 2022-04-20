package com.plg.springvalidationexample.generics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class Timestamp {
  @Column(name = "createdAt")
  @Temporal(TemporalType.DATE)
  protected Date createdAt;

  @Column(name = "updatedAt")
  @Temporal(TemporalType.DATE)
  protected Date updatedAt;

  @Column(name = "deletedAt")
  @Temporal(TemporalType.DATE)
  protected Date deletedAt;
}
