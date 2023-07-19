package com.example.bets_v1;

public class Player {
    private int player_id;
    private String player_name;
    private String player_login;
    private String player_password;
    private int score;

    public Player(int player_id, String player_name, String player_login, String player_password, int score){
        this.player_id = player_id;
        this.player_name = player_name;
        this.player_login = player_login;
        this.player_password = player_password;
        this.score = score;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getPlayer_login() {
        return player_login;
    }

    public String getPlayer_password() {
        return player_password;
    }

    public int getScore() {
        return score;
    }
}
