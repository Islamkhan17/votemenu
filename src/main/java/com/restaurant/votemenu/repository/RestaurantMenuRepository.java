package com.restaurant.votemenu.repository;

import com.restaurant.votemenu.model.RestaurantEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantEntity,Integer> {

  @Query("SELECT R FROM RestaurantEntity R WHERE R.requestDate >= ?1")
  public List<RestaurantEntity> findAllByRequestDateAfter(LocalDate time);
}
