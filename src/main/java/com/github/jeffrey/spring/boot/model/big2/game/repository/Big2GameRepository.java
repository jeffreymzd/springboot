package com.github.jeffrey.spring.boot.model.big2.game.repository;

import com.github.jeffrey.spring.boot.model.big2.game.Big2Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface Big2GameRepository extends CrudRepository<Big2Game, Long> {
}
