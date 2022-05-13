package com.restaurant.votemenu.repository;

import com.restaurant.votemenu.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
