package com.example.bets_v1;

public class Bet {
    private int bet_id;
    private int game_id;
    private int player_id;
    private int amount;

    public Bet(int bet_id, int game_id, int player_id, int amount){
        this.bet_id = bet_id;
        this.game_id = game_id;
        this.player_id = player_id;
        this.amount = amount;
    }

    public int getBet_id() {
        return bet_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public int getAmount() {
        return amount;
    }
}
