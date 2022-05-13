package com.restaurant.votemenu.model;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  public static final int START_SEQ = 100000;

  @Id
  @Column(name = "user_id")
  @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1, initialValue = START_SEQ)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  Long id;

  @Column(name = "fio")
  String fio;

  @Enumerated(EnumType.STRING)
  @Column(name = "roles")
  private Role role;
}
