package com.restaurant.votemenu.repository;

import com.restaurant.votemenu.model.Vote;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
  Optional<Vote> findByUserId(Integer userId);

  List<Vote> findAllByRestaurantIdBetween(LocalDateTime startOfTheDay, LocalDateTime endOfTheDay);

  @Query("SELECT COUNT(V) FROM Vote V WHERE V.restaurantId=?1 and V.voteDateTime >= ?2")
  Integer findCountByRestaurantId(Integer restaurantId, LocalDateTime localDateTime);
}
