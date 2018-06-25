package com.github.jeffrey.spring.boot.controller.game.big2.repository;

import com.github.jeffrey.spring.boot.controller.game.big2.Player;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
