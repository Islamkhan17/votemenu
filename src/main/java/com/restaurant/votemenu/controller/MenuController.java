package com.restaurant.votemenu.controller;

import com.restaurant.votemenu.model.MenuEntity;
import com.restaurant.votemenu.model.RestaurantEntity;
import com.restaurant.votemenu.repository.MenuRepository;
import com.restaurant.votemenu.repository.RestaurantMenuRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class MenuController {
  private final RestaurantMenuRepository restaurantRepository;
  private final MenuRepository menuRepository;

  @PostMapping (value = "/create")
  public void create(@RequestBody RestaurantEntity restaurant){
    List<MenuEntity> list = restaurant.getMenu();
    list.stream().forEach(r->r.setRestaurantEntity(restaurant));
    restaurantRepository.saveAndFlush(restaurant);
    menuRepository.saveAll(list);

  }
}
