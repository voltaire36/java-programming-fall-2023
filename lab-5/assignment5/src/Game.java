public class Game {
    private int gameId;
    private String gameTitle;

    // Constructor
    public Game(int gameId, String gameTitle) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
    }

    // Getters and Setters
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameTitle='" + gameTitle + '\'' +
                '}';
    }
}
