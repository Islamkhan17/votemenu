package com.restaurant.votemenu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vote")
public class Vote {
  public static final int START_SEQ = 10000;

  @Id
  @Column(name = "vote_id")
  @SequenceGenerator(name = "vote_seq", sequenceName = "vote_seq", allocationSize = 1, initialValue = START_SEQ)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_seq")
  private Integer voteId;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "vote_date_time")
  private LocalDateTime voteDateTime;

  @JsonIgnore
  @Column(name = "restaurant_id")
  private Integer restaurantId;
}
