package com.github.jeffrey.spring.boot.engine;

import com.github.jeffrey.spring.boot.model.big2.game.Big2Game;
import com.github.jeffrey.spring.boot.model.big2.game.Player;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class Big2Calculator {
    public Big2Game calculateBig2GainOrLoss(List<Integer> nums) {
        if (nums.size() != 4) {
            return null;
        }
        Big2Game gameResult = new Big2Game(nums);
        List<Player> players = gameResult.getPlayers();
        List<Integer> lossFromEachPlay = players.stream().map(Player::getCardsLost).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("Game time: " + LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/New_York")) + "\n");
        sb.append("Player|Cards|GainOrLoss\n");
        players.forEach(p -> {
            lossFromEachPlay.forEach(l -> p.setGainOrLoss(p.calculateWinCount(l)));
            sb.append(p.getName() + "|" + p.getCardsLost() + "|" + p.getGainOrLoss() + "\n");
        });
        System.out.println(sb.toString());
        return gameResult;
    }
}
