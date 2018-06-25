package com.github.jeffrey.spring.boot.controller;

import com.github.jeffrey.spring.boot.controller.game.big2.Big2Game;
import com.github.jeffrey.spring.boot.controller.game.big2.repository.Big2GameRepository;
import com.github.jeffrey.spring.boot.controller.game.big2.repository.PlayerRepository;
import com.github.jeffrey.spring.boot.engine.Big2Calculator;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Component
public class Big2CalcController {
    private PlayerRepository playerRepository;
    private Big2GameRepository big2GameRepository;

    public Big2CalcController(PlayerRepository playerRepository, Big2GameRepository big2GameRepository) {
        this.playerRepository = playerRepository;
        this.big2GameRepository = big2GameRepository;
    }

    @RequestMapping("/big2calc")
    public Big2Game calculateBig2GameResult(@RequestParam(name="numbers", required=true) String nums, Model model) {
        List<Integer> integers = Arrays.asList(nums.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        Big2Game result = new Big2Calculator().calculateBig2GainOrLoss(integers);
        result.getPlayers().forEach(p -> playerRepository.save(p));
        big2GameRepository.save(result);
        return result;
    }
}
