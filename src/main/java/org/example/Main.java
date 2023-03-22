package org.example;

import org.example.GameFolder.GameClass;

public class Main {
    public static void main(String[] args) {
        GameClass game = new GameClass();
        do{
            game.iniGameClass();
        }while (game.startGame() == 'Y');



    }
}