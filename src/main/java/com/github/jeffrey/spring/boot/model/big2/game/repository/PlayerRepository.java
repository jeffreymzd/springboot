package com.github.jeffrey.spring.boot.model.big2.game.repository;

import com.github.jeffrey.spring.boot.model.big2.game.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
