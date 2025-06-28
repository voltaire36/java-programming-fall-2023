import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate; // Import for LocalDate
import java.time.format.DateTimeParseException; // Import for DateTimeParseException



public class GUI {
    private JFrame frame;
    private JTextField playerIdField, firstNameField, lastNameField, addressField, postalCodeField, provinceField, phoneNumberField;
    private JTextField playerGameIdField;
    private JTextField gameIdField, gameTitleField;
    private JTextField playingDateField, scoreField;
    private JButton insertPlayerButton, updatePlayerButton, displayPlayersButton;
    private JButton insertGameButton, updateGameButton, displayGamesButton;
    private JButton insertPlayerGameButton, updatePlayerGameButton, displayPlayerGamesButton;
    private JTable playersTable, gamesTable, playerGamesTable;

    public GUI() {
        frame = new JFrame("Game Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.add(createPlayerPanel(), BorderLayout.NORTH);
        frame.add(createGamePanel(), BorderLayout.CENTER);
        frame.add(createPlayerGamePanel(), BorderLayout.SOUTH);
    }


    private JPanel createPlayerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Player Details"));

        // Initialize input fields for player data
        playerIdField = new JTextField(10);
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        addressField = new JTextField(10);
        postalCodeField = new JTextField(10);
        provinceField = new JTextField(10);
        phoneNumberField = new JTextField(10);

        // Initialize buttons for player operations
        insertPlayerButton = new JButton("Insert Player");
        updatePlayerButton = new JButton("Update Player");
        displayPlayersButton = new JButton("Display Players");

        // Initialize table for displaying player data
        playersTable = new JTable();

        // Add components to the player panel
        panel.add(new JLabel("Player ID:"));
        panel.add(playerIdField);
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Postal Code:"));
        panel.add(postalCodeField);
        panel.add(new JLabel("Province:"));
        panel.add(provinceField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(insertPlayerButton);
        panel.add(updatePlayerButton);
        panel.add(displayPlayersButton);
        panel.add(new JScrollPane(playersTable));



        // Action listeners for player buttons
        insertPlayerButton.addActionListener(e -> {
            try {
                Player player = getPlayerDataFromFields();
                DatabaseConnector.insertPlayer(player);
                JOptionPane.showMessageDialog(panel, "Player inserted successfully");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error inserting player: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid format for Player ID");
            }
        });



        updatePlayerButton.addActionListener(e -> {
            try {
                Player player = getPlayerDataFromFields();
                DatabaseConnector.updatePlayer(player);
                JOptionPane.showMessageDialog(panel, "Player updated successfully");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error updating player: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid format for Player ID");
            }
        });



        displayPlayersButton.addActionListener(e -> {
            try {
                List<Player> players = DatabaseConnector.getAllPlayers();
                updatePlayersTable(players);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching players: " + ex.getMessage());
            }
        });

        return panel;
    }

    private Player getPlayerDataFromFields() {
        int playerId = Integer.parseInt(playerIdField.getText());
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String postalCode = postalCodeField.getText();
        String province = provinceField.getText();
        String phoneNumber = phoneNumberField.getText();
        return new Player(playerId, firstName, lastName, address, postalCode, province, phoneNumber);
    }


    private void updatePlayersTable(List<Player> players) {
        // Column names for the table
        String[] columnNames = {"Player ID", "First Name", "Last Name", "Address", "Postal Code", "Province", "Phone Number"};

        // Create a default table model with the column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add each player's data as a row in the model
        for (Player player : players) {
            Object[] row = new Object[]{
                    player.getPlayerId(),
                    player.getFirstName(),
                    player.getLastName(),
                    player.getAddress(),
                    player.getPostalCode(),
                    player.getProvince(),
                    player.getPhoneNumber()
            };
            model.addRow(row);
        }

        // Set the model on the table
        playersTable.setModel(model);
    }


    private JPanel createGamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Game Details"));

        // Initialize input fields for game data
        gameIdField = new JTextField(10);
        gameTitleField = new JTextField(10);

        // Initialize buttons for game operations
        insertGameButton = new JButton("Insert Game");
        updateGameButton = new JButton("Update Game");
        displayGamesButton = new JButton("Display Games");

        // Initialize table for displaying game data
        gamesTable = new JTable();

        // Add components to the game panel
        panel.add(new JLabel("Game ID:"));
        panel.add(gameIdField);
        panel.add(new JLabel("Game Title:"));
        panel.add(gameTitleField);
        panel.add(insertGameButton);
        panel.add(updateGameButton);
        panel.add(displayGamesButton);
        panel.add(new JScrollPane(gamesTable));

        // Action listeners for game buttons
        insertGameButton.addActionListener(e -> {
            try {
                int gameId = Integer.parseInt(gameIdField.getText());
                String gameTitle = gameTitleField.getText();
                DatabaseConnector.insertGame(gameId, gameTitle);
                JOptionPane.showMessageDialog(panel, "Game inserted successfully");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error inserting game: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid format for Game ID");
            }
        });

        updateGameButton.addActionListener(e -> {
            try {
                int gameId = Integer.parseInt(gameIdField.getText());
                String gameTitle = gameTitleField.getText();
                DatabaseConnector.updateGame(gameId, gameTitle);
                JOptionPane.showMessageDialog(panel, "Game updated successfully");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error updating game: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid format for Game ID");
            }
        });

        displayGamesButton.addActionListener(e -> {
            try {
                List<Game> games = DatabaseConnector.getAllGames();
                updateGamesTable(games);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching games: " + ex.getMessage());
            }
        });

        return panel;
    }

    private void updateGamesTable(List<Game> games) {
        // Column names for the game table
        String[] columnNames = {"Game ID", "Game Title"};

        // Create a default table model with the column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add each game's data as a row in the model
        for (Game game : games) {
            Object[] row = new Object[]{
                    game.getGameId(),
                    game.getGameTitle()
            };
            model.addRow(row);
        }

        // Set the model on the table
        gamesTable.setModel(model);
    }




    private JPanel createPlayerGamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Player and Game Details"));

        // Initialize input fields for player and game relationship data
        playingDateField = new JTextField(10);
        scoreField = new JTextField(10);
        playerGameIdField = new JTextField(10);

        // Initialize buttons for player and game relationship operations
        insertPlayerGameButton = new JButton("Add Game Session");
        updatePlayerGameButton = new JButton("Update Game Session");
        displayPlayerGamesButton = new JButton("Display Game Sessions");

        // Initialize table for displaying player and game relationship data
        playerGamesTable = new JTable();

        // Add components to the panel
        panel.add(new JLabel("Playing Date (YYYY-MM-DD):"));
        panel.add(playingDateField);
        panel.add(new JLabel("Score:"));
        panel.add(scoreField);
        panel.add(insertPlayerGameButton);
        panel.add(updatePlayerGameButton);
        panel.add(displayPlayerGamesButton);
        panel.add(new JScrollPane(playerGamesTable));
        panel.add(new JLabel("Player Game ID:"));
        panel.add(playerGameIdField);


        insertPlayerGameButton.addActionListener(e -> {
            try {
                int playerGameId = Integer.parseInt(playerGameIdField.getText());
                int gameId = Integer.parseInt(gameIdField.getText());
                int playerId = Integer.parseInt(playerIdField.getText());
                LocalDate playingDate = LocalDate.parse(playingDateField.getText());
                int score = Integer.parseInt(scoreField.getText());

                PlayerGame playerGame = new PlayerGame(playerGameId, gameId, playerId, playingDate, score);
                DatabaseConnector.insertPlayerGame(playerGame);
                JOptionPane.showMessageDialog(panel, "Game session added successfully");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error adding game session: " + ex.getMessage());
            } catch (DateTimeParseException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input format");
            }
        });


// Action listener for updatePlayerGameButton
        updatePlayerGameButton.addActionListener(e -> {
            try {
                int playerGameId = Integer.parseInt(playerGameIdField.getText());
                int gameId = Integer.parseInt(gameIdField.getText());
                int playerId = Integer.parseInt(playerIdField.getText());
                LocalDate playingDate = LocalDate.parse(playingDateField.getText());
                int score = Integer.parseInt(scoreField.getText());

                PlayerGame playerGame = new PlayerGame(playerGameId, gameId, playerId, playingDate, score);
                DatabaseConnector.updatePlayerGame(playerGame);
                JOptionPane.showMessageDialog(panel, "Game session updated successfully");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error updating game session: " + ex.getMessage());
            } catch (DateTimeParseException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input format");
            }
        });




        // Action listener for displayPlayerGamesButton
        displayPlayerGamesButton.addActionListener(e -> {
            try {
                List<PlayerGame> playerGames = DatabaseConnector.getAllPlayerGames();
                updatePlayerGamesTable(playerGames);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching player game sessions: " + ex.getMessage());
            }
        });

        return panel;
    }

    private void updatePlayerGamesTable(List<PlayerGame> playerGames) {
        // Column names for the playerGames table
        String[] columnNames = {"Player Game ID", "Game ID", "Player ID", "Playing Date", "Score"};

        // Create a default table model with the column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add each player game session's data as a row in the model
        for (PlayerGame playerGame : playerGames) {
            Object[] row = new Object[]{
                    playerGame.getPlayerGameId(),
                    playerGame.getGameId(),
                    playerGame.getPlayerId(),
                    playerGame.getPlayingDate().toString(), // assuming getPlayingDate returns a LocalDate
                    playerGame.getScore()
            };
            model.addRow(row);
        }

        // Set the model on the table
        playerGamesTable.setModel(model);
    }

    public void display() {
        frame.setVisible(true);
    }
}


