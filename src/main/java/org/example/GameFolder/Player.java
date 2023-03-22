package org.example.GameFolder;

public class Player {
    private final String playerName;
    private final char playerLetter;
    public
    Player(String playerName){
        this.playerName = playerName;
        this.playerLetter = playerName.charAt(0);
    }
    String getPlayerName(){
        return playerName;
    }
    char getPlayerLetter() { return  playerLetter; }
}
