package com.restaurant.votemenu.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant")
/*@Access(AccessType.FIELD)*/
public class RestaurantEntity {
  public static final int START_SEQ = 10000;

  @Id
  @Column(name = "restaurant_id")
  @SequenceGenerator(name = "rest_seq", sequenceName = "rest_seq", allocationSize = 1, initialValue = START_SEQ)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rest_seq")
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "restaurantEntity")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private List<MenuEntity> menu;

  @Column(name = "request_date")
  private LocalDate requestDate = LocalDate.now();

}
