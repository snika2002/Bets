package com.example.bets_v1;

public class Bet_List {
    private int bet_id;
    private String game_name;
    private String player_name;
    private int player_amount;

    public Bet_List(int bet_id, String game_name, String player_name, int player_amount){
        this.bet_id = bet_id;
        this.game_name = game_name;
        this.player_name = player_name;
        this.player_amount = player_amount;
    }

    public int getBet_id() {
        return bet_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public int getPlayer_amount() {
        return player_amount;
    }
}
