package com.customvalidator.models.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public @Entity @Table(name = "members") @Setter @Getter @AllArgsConstructor class Member implements Serializable {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(name = "name", length = 100, nullable = false)
   private String name;

   @Column(name = "no_pone", length = 12, nullable = false, unique = true)
   private String number;

   @Column(name = "email", nullable = false, unique = true)
   private String email;

   @Column(name = "password", length = 255, nullable = false)
   private String password;

   public Member(){}
}
