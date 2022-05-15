package com.restaurant.votemenu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantValue {
  private RestaurantEntity restaurant;
  private Integer value;
}
