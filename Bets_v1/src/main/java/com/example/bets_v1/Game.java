package com.example.bets_v1;

import org.postgresql.shaded.com.ongres.scram.common.ScramAttributeValue;
import org.postgresql.shaded.com.ongres.scram.common.exception.ScramParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.postgresql.shaded.com.ongres.scram.common.ScramAttributeValue.parse;

public class Game {
    private int game_id;
    private String game_name;
    private LocalDateTime date;

    public Game(int game_id, String game_name, String date) throws ScramParseException {
        this.game_id = game_id;
        this.game_name = game_name;
        this.date = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public int getGame_id() {
        return game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
