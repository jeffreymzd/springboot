package com.github.jeffrey.spring.boot.model.big2.game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String getName() {
        return name;
    }

    public int getGainOrLoss() {
        return gainOrLoss;
    }

    private String name;

    private int cardsLost;
    private int gainOrLoss;

    public Player() {}

    public Player(String name, int lost) {
        this.name = name;
        this.cardsLost = lost;
    }

    public int getId() {
        return id;
    }

    public int getCardsLost() {
        return cardsLost;
    }

    public int calculateWinCount(int lostOfCounterparty) {
        return lostOfCounterparty - cardsLost;
    }

    public void setGainOrLoss(int gainOrLoss) {
        this.gainOrLoss += gainOrLoss;
    }

    @Override
    public String toString() {
        return "Player" + id + "{" +
                "name='" + name + '\'' +
                ", cardsLost=" + cardsLost +
                ", gainOrLoss=" + gainOrLoss +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
