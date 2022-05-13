package com.restaurant.votemenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "menu")
/*@Access(AccessType.FIELD)*/
public class MenuEntity {
  public static final int START_SEQ = 1000;

  @Id
  @Column(name = "menu_id")
  @SequenceGenerator(name = "menu_seq", sequenceName = "menu_seq", allocationSize = 1, initialValue = START_SEQ)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
  private Long id;

  @Column(name = "name")
  String name;

  @Column(name = "price")
  BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "rest_id")
  @JsonIgnore
//  @OnDelete(action = OnDeleteAction.CASCADE)
  private RestaurantEntity restaurantEntity;

}
