package com.restaurant.votemenu.controller;

import com.restaurant.votemenu.model.RestaurantEntity;
import com.restaurant.votemenu.model.Vote;
import com.restaurant.votemenu.repository.RestaurantMenuRepository;
import com.restaurant.votemenu.repository.VoteRepository;
import com.restaurant.votemenu.util.DateTimeUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class VoteController {
  private final RestaurantMenuRepository restaurantMenuRepository;
  private final VoteRepository voteRepository;
  /* private final UserContextHolder userContextHolder;*/

  @PostMapping(value = "/vote/{userId}")
  public ResponseEntity<Vote> vote(@RequestBody RestaurantEntity restaurant,
                                   @PathVariable String userId) {
    var voteOptional = voteRepository.findByUserId(Integer.valueOf(userId));
    if (voteOptional.isPresent()) {
      return ResponseEntity.ok(voteOptional.get());
    }
    var vote = new Vote();
    vote.setVoteDateTime(LocalDateTime.now());
    vote.setUserId(Integer.valueOf(userId));
    vote.setRestaurantId(restaurant.getId());
    return ResponseEntity.ok(voteRepository.saveAndFlush(vote));
  }

  @GetMapping(value = "/get-all-restaurants")
  public ResponseEntity<List<RestaurantEntity>> getAll() {
    List<RestaurantEntity> list =
        restaurantMenuRepository.findAllByRequestDateAfter(LocalDate.now().minusDays(1));
    return ResponseEntity.ok(list);
  }

  @PostMapping(value = "/reset-vote/{userId}")
  public ResponseEntity<Vote> reset(@RequestBody RestaurantEntity restaurant,
                                    @PathVariable String userId) {
    var voteOptional = voteRepository.findByUserId(Integer.valueOf(userId));
    if (voteOptional.isPresent()) {
      if (DateTimeUtil.isTimeToReset(voteOptional.get().getVoteDateTime())) {
        voteOptional.get().setRestaurantId(restaurant.getId());
        voteRepository.saveAndFlush(voteOptional.get());
      }
    }
    return ResponseEntity.ok(voteOptional.get());
  }


}
