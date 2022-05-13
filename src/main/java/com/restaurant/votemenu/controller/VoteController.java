package com.restaurant.votemenu.controller;

import com.restaurant.votemenu.model.RestaurantEntity;
import com.restaurant.votemenu.repository.RestaurantMenuRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class VoteController {
  private final RestaurantMenuRepository repository;

  @GetMapping(value = "/vote/{id}")
  public ResponseEntity<?> vote(@PathVariable Long id){
    return ResponseEntity.ok(HttpEntity.EMPTY);
  }

  @GetMapping(value = "/get-all")
  public ResponseEntity<List<RestaurantEntity>> getAll(){
    List<RestaurantEntity> list = repository.findAllByRequestDateAfter(LocalDate.now());
    return ResponseEntity.ok(list);
  }

}
