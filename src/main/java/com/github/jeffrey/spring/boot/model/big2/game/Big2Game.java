package com.github.jeffrey.spring.boot.model.big2.game;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Big2Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(name = "big2game_player",joinColumns =@JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players;

    private LocalDateTime gameTime;

    @Override
    public String toString() {
        return "Big2Game{" +
                "players=" + players +
                ", gameTime=" + gameTime +
                '}';
    }

    public LocalDateTime getGameTime() {
        return gameTime;
    }

    public Big2Game(List<Integer> cardLost) {
        int playerid = 0;
        this.players = new ArrayList<>();
        for (Integer i: cardLost) {
            ++playerid;
            players.add(new Player("P" + playerid, i));
        };
        gameTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/New_York"));
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Big2Game)) return false;
        Big2Game big2Game = (Big2Game) o;
        return Objects.equals(id, big2Game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
