package com.example.bets_v1;

import org.postgresql.shaded.com.ongres.scram.common.exception.ScramParseException;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Connect_PostgreSQL {

    private static String url = "jdbc:postgresql://localhost:5432/test";
    private static String name = "postgres";
    private static String password = "0000";
    private static Connection conn;
    private static Statement stat;

    public static void main(String args[]) throws SQLException, ClassNotFoundException, ScramParseException {
        System.out.println(Drop_Table("bets"));
        //System.out.println(Drop_Table("games"));
        //System.out.println(CreateTable_Games());
        //System.out.println(CreateTable_players());
        System.out.println(CreateTable_bets());
        //Insert_Game("Крестики-нолики", LocalDateTime.parse("20.05.2023 03:39", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        //ArrayList<Game> games = getGames();
        //Delete_Game(1);
        //System.out.println(getBet_List());
        //System.out.println("Buhf^");
        //Play(2);
        /*Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, "postgres", "0000");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "DELETE FROM bets;";
        stat.executeUpdate(sql);
        conn.commit();
        Select_Bets();
        System.out.println("ertyuh");
        Select_Games();
        //Insert_Bet("Player_2", 2, 500);*/
    }

    public static void Select_Bets() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery( "SELECT * FROM bets WHERE game_id = " + 2);
        while (rs.next()){
            System.out.println(rs.getInt("bet_id"));
            System.out.println(rs.getInt("game_id"));
            System.out.println(rs.getInt("player_id"));
            System.out.println(rs.getInt("amount"));
        }
    }

    public static void Select_Games() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery( "SELECT * FROM games");
        while (rs.next()){
            System.out.println(rs.getInt("game_id"));
            System.out.println(rs.getString("game_name"));
        }
    }

    public static String CreateTable_Games() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, "postgres", "0000");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "create table games(" +
                "    game_id serial primary key," +
                "    game_name varchar(1000)," +
                "    date timestamp" +
                ");";
        stat.executeUpdate(sql);
        stat.close();
        conn.commit();
        conn.close();
        return "Таблица games создана";
    }

    public static String CreateTable_players() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, "postgres", "0000");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "create table players(" +
                "    player_id serial primary key," +
                "    player_name varchar(1000)," +
                "    player_login varchar(1000)," +
                "    player_password varchar(1000)," +
                "    score integer" +
                ");";
        stat.executeUpdate(sql);
        stat.close();
        conn.commit();
        conn.close();
        return "Таблица players создана";
    }

    public static String CreateTable_bets() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, "postgres", "0000");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "create table bets(" +
                "    bet_id serial primary key," +
                "    game_id integer," +
                "    player_id integer," +
                "    amount integer"
                + ")";
        stat.executeUpdate(sql);
        stat.close();
        conn.commit();
        conn.close();
        return "Таблица bets создана";
    }

    public static String Drop_Table(String table) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "DROP TABLE " + table;
        stat.executeUpdate(sql);
        conn.commit();
        stat.close();
        conn.close();
        return ("Таблица удалена");
    }

    public static boolean Check_Player(String player_login, String player_password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String player_name = null;
        Connection conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery( "SELECT * FROM players " + "WHERE player_login = '" + player_login + "' AND player_password = '" + player_password + "';");
        while (rs.next()){
            player_name = rs.getString("player_name");
        }
        rs.close();
        stat.close();
        conn.close();
        if (player_name != null){
            return true;
        }
        else return false;
    }

    public static boolean Check_Login(String login) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String player_login = null;
        Connection conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery( "SELECT * FROM players " + "WHERE player_login = '" + login + "';");
        while (rs.next()){
            player_login = rs.getString("player_login");
        }
        rs.close();
        stat.close();
        conn.close();
        if (player_login == null){
            return true;
        }
        else return false;
    }

    public static void Insert_Player(String player_name, String player_login, String player_password, int score) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, "postgres", "0000");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "INSERT INTO players (player_name, player_login, player_password, score) "
                + "VALUES ('" + player_name + "', '" + player_login + "', '"+ player_password  + "', " + score + ");";
        stat.executeUpdate(sql);
        conn.commit();
        stat.close();
        conn.close();
    }


    public static Player getPlayer(String player_login) throws ClassNotFoundException, SQLException {
        Player player = null;
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery( "SELECT * FROM players " + "WHERE player_login = '" + player_login + "';");
        while (rs.next()){
            player = new Player(rs.getInt("player_id"), rs.getString("player_name"), rs.getString("player_login"), rs.getString("player_password"), rs.getInt("score"));
        }
        rs.close();
        stat.close();
        conn.close();
        return player;
    }

    public static ArrayList<Game> getGames() throws ClassNotFoundException, SQLException, ScramParseException {
        ArrayList<Game> games = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery( "SELECT * FROM games;");
        while (rs.next()){
            System.out.println(rs.getString("date"));
            games.add(new Game(rs.getInt("game_id"), rs.getString("game_name"), rs.getString("date")));
        }
        rs.close();
        stat.close();
        conn.close();
        if(games.size() == 0){
            return null;
        }
        else return games;
    }

    public static void Change_Score(String player_login, int score) throws ClassNotFoundException, SQLException {
        Player player = null;
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "UPDATE players SET score = score + " + score + "" +
                "     WHERE player_login = '"+ player_login + "';";
        stat.executeUpdate(sql);
        conn.commit();
        stat.close();
        conn.close();
    }

    public static void Select_Table(String table) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery( "SELECT * FROM " + table + ";");
        while (rs.next()){
            System.out.println(rs.getString("player_login"));
            System.out.println(rs.getString("score"));
        }
    }

    public static void Insert_Game(String game_name, LocalDateTime date) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, "postgres", "0000");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "INSERT INTO games (game_name, date) "
                + "VALUES ('" + game_name + "', '" + date + "');";
        stat.executeUpdate(sql);
        conn.commit();
        stat.close();
        conn.close();
    }

    public static void Delete_Game(ArrayList<Bet> bets) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, "postgres", "0000");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        int game_id = bets.get(0).getGame_id();
        for (int i = 0; i < bets.size(); i++)
        {
            String sql = "DELETE FROM bets WHERE bet_id = " + bets.get(i).getBet_id() + ";";
            stat.executeUpdate(sql);
            conn.commit();
        }
        String sql = "DELETE FROM games WHERE game_id = " + game_id + ";";
        stat.executeUpdate(sql);
        conn.commit();
        stat.close();
        conn.close();
    }

    public static void Delete_Game(int game_id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, "postgres", "0000");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "DELETE FROM games WHERE game_id = " + game_id + ";";
        stat.executeUpdate(sql);
        conn.commit();
        stat.close();
        conn.close();
    }

    public static boolean Insert_Bet(String player_login, int game_id, int amount) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        int player_id = 0;
        int score = 0;
        conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "SELECT * FROM players" +
                "     WHERE player_login = '" + player_login + "';" ;
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            player_id = rs.getInt("player_id");
            score = rs.getInt("score");
        }
        if((score >= amount) && (player_id != 0)){
            sql = "INSERT INTO bets (game_id, player_id, amount) "
                    + "VALUES (" + game_id + ", " + player_id + ", "+ amount  + ");";
            stat.executeUpdate(sql);
            conn.commit();
            conn.close();
            stat.close();
            return true;
        }
        else return false;

    }

    public static void Play(int game_id, int ratio) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        ArrayList<Bet> bets = new ArrayList<>();
        ArrayList<Integer> winners = new ArrayList<>();
        int n;
        Random random = new Random();
        conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "SELECT * FROM bets" +
                "     WHERE game_id = " + game_id + ";" ;
        ResultSet rs = stat.executeQuery(sql);
        System.out.println(game_id);
        while (rs.next()){
            System.out.println(rs.getInt("bet_id"));
            bets.add(new Bet(rs.getInt("bet_id"), rs.getInt("game_id"), rs.getInt("player_id"), rs.getInt("amount") ));
            System.out.println(bets.get(bets.size()-1).getBet_id() + " "+ bets.get(bets.size()-1).getGame_id() + " " + bets.get(bets.size()-1).getPlayer_id()+ " " + bets.get(bets.size()-1).getAmount());
        }
        if(bets.size() > 0){
            n = random.nextInt((bets.size()  - 1) - 0 + 1) + 0;
            if(n != 0) {
                for (int i = 0; i < n; i++) {
                    winners.add(random.nextInt((bets.size()) - 0 + 1) + 0);
                }
                for (int i = 0; i < n; i++) {
                    Change_Score(bets.get(winners.get(i)).getPlayer_id(), +(bets.get(winners.get(i)).getAmount() * ratio));
                }
            }
            Delete_Game(bets);
        }
        else Delete_Game(game_id);

        conn.close();
        stat.close();
    }

    public static void Change_Score(int player_id, int score) throws ClassNotFoundException, SQLException {
        Player player = null;
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "UPDATE players SET score = score + " + score + "" +
                "     WHERE player_id = "+ player_id + ";";
        stat.executeUpdate(sql);
        conn.commit();
        stat.close();
        conn.close();
    }

    public static ArrayList<Bet_List> getBet_List() throws ClassNotFoundException, SQLException {
        ArrayList<Bet_List> bet_list = new ArrayList<>();
        int game_id = -1;
        int player_id;
        String game_name = "", player_name = "";
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, name, password);
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        String sql = "SELECT * FROM bets";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            game_id = rs.getInt("game_id");
            player_id = rs.getInt("player_id");
            String sql2 = "SELECT * FROM games" +
                    "      WHERE game_id = " + game_id + ";";
            ResultSet rs2 = stat.executeQuery(sql2);
            while (rs2.next()){
                game_name = rs2.getString("game_name");
            }
            sql2 = "SELECT * FROM players" +
                    "      WHERE player_id = " + player_id + ";";
            rs2 = stat.executeQuery(sql2);
            while (rs2.next()){
                player_name = rs2.getString("player_name");
            }
            bet_list.add(new Bet_List(rs.getInt("bet_id"), game_name, player_name, rs.getInt("amount")));
        }
        return bet_list;
    }
}