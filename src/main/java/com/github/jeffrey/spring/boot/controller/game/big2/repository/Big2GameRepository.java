package com.github.jeffrey.spring.boot.controller.game.big2.repository;

import com.github.jeffrey.spring.boot.controller.game.big2.Big2Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface Big2GameRepository extends CrudRepository<Big2Game, Long> {
}
