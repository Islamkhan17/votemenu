package com.restaurant.votemenu.controller;

import com.restaurant.votemenu.model.RestaurantValue;
import com.restaurant.votemenu.model.Vote;
import com.restaurant.votemenu.repository.RestaurantMenuRepository;
import com.restaurant.votemenu.repository.VoteRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant-vote")
@RequiredArgsConstructor
public class RestaurantController {
  private final VoteRepository voteRepository;
  private final RestaurantMenuRepository restaurantMenuRepository;

  @GetMapping(value = "/winner")
  public ResponseEntity<List<RestaurantValue>> getWinner() {
    var restaurantList =
        restaurantMenuRepository.findAllByRequestDateAfter(LocalDate.now().minusDays(1));
    var restaurantValueList = restaurantList.stream().map(o -> new RestaurantValue(o,
        voteRepository.findCountByRestaurantId(o.getId(), LocalDate.now().atStartOfDay()))).collect(
        Collectors.toList());
    return ResponseEntity.ok(
        restaurantValueList);
  }
}
