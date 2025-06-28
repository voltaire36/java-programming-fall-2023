import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

public class DatabaseConnector {
    private static final String URL = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
    private static final String USER = "COMP228_F23_piy_113";
    private static final String PASSWORD = "password";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
//        Connection con = null;
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            con = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("db connected");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return con;

    }

    // Insert a new player into the 'Player' table
    public static void insertPlayer(Player player) throws SQLException {
        String sql = "INSERT INTO Player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, player.getPlayerId());
            statement.setString(2, player.getFirstName());
            statement.setString(3, player.getLastName());
            statement.setString(4, player.getAddress());
            statement.setString(5, player.getPostalCode());
            statement.setString(6, player.getProvince());
            statement.setString(7, player.getPhoneNumber());
            statement.executeUpdate();
        }
    }


    // Update player information in the 'Player' table
    public static void updatePlayer(Player player) throws SQLException {
        String sql = "UPDATE Player SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ? WHERE player_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, player.getFirstName());
            statement.setString(2, player.getLastName());
            statement.setString(3, player.getAddress());
            statement.setString(4, player.getPostalCode());
            statement.setString(5, player.getProvince());
            statement.setString(6, player.getPhoneNumber());
            statement.setInt(7, player.getPlayerId());
            statement.executeUpdate();
        }
    }

    // Retrieve all players from the 'Player' table and return as a list of Player objects
    public static List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Player player = new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("address"),
                        resultSet.getString("postal_code"),
                        resultSet.getString("province"),
                        resultSet.getString("phone_number")
                );
                players.add(player);
            }
        }
        return players;
    }


    // Method to insert a new game into the 'Game' table
    public static void insertGame(int gameId, String gameTitle) throws SQLException {
        String sql = "INSERT INTO Game (game_id, game_title) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, gameId);
            statement.setString(2, gameTitle);
            statement.executeUpdate();
        }
    }

    // Method to update game information in the 'Game' table
    public static void updateGame(int gameId, String gameTitle) throws SQLException {
        String sql = "UPDATE Game SET game_title = ? WHERE game_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, gameTitle);
            statement.setInt(2, gameId);
            statement.executeUpdate();
        }
    }

    // Retrieve all games from the 'Game' table and return as a list of Game objects
    public static List<Game> getAllGames() throws SQLException {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM Game";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Game game = new Game(
                        resultSet.getInt("game_id"),
                        resultSet.getString("game_title")
                );
                games.add(game);
            }
        }
        return games;
    }

    // Insert a new player-game session into 'PlayerAndGame' table
    public static void insertPlayerGame(PlayerGame playerGame) throws SQLException {
        String sql = "INSERT INTO PlayerAndGame (player_game_id, game_id, player_id, playing_date, score) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, playerGame.getPlayerGameId());
            statement.setInt(2, playerGame.getGameId());
            statement.setInt(3, playerGame.getPlayerId());
            statement.setDate(4, Date.valueOf(playerGame.getPlayingDate()));
            statement.setInt(5, playerGame.getScore());
            statement.executeUpdate();
        }
    }

    // Update a player-game session in 'PlayerAndGame' table
    public static void updatePlayerGame(PlayerGame playerGame) throws SQLException {
        String sql = "UPDATE PlayerAndGame SET game_id = ?, player_id = ?, playing_date = ?, score = ? WHERE player_game_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, playerGame.getGameId());
            statement.setInt(2, playerGame.getPlayerId());
            statement.setDate(3, Date.valueOf(playerGame.getPlayingDate()));
            statement.setInt(4, playerGame.getScore());
            statement.setInt(5, playerGame.getPlayerGameId());
            statement.executeUpdate();
        }
    }

    // Retrieve all player-game sessions from 'PlayerAndGame' table
    public static List<PlayerGame> getAllPlayerGames() throws SQLException {
        List<PlayerGame> playerGames = new ArrayList<>();
        String sql = "SELECT * FROM PlayerAndGame";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                PlayerGame playerGame = new PlayerGame(
                        resultSet.getInt("player_game_id"),
                        resultSet.getInt("game_id"),
                        resultSet.getInt("player_id"),
                        resultSet.getDate("playing_date").toLocalDate(), // Assuming playing_date is stored as a Date
                        resultSet.getInt("score")
                );
                playerGames.add(playerGame);
            }
        }
        return playerGames;
    }
}