package org.example.GameFolder;

import java.util.Scanner;

public class GameClass {
    PlayField playField;
    Player playerOne;
    Player playerTwo;

    public void iniGameClass(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcomme to TicTacTo");
        System.out.println("Player one Please Enter you Name: ");
        playerOne = new Player(scanner.next());
        System.out.println("Player two Please Enter you Name: ");
        playerTwo = new Player(scanner.next());

        playField = new PlayField();

    }

    public char startGame(){
        System.out.println("This is your Map Hav Fun!");
        playField.printPlayField();
        while (true){
            if(playField.isFieldFull()){
                return noWinner();
            }
          if(playerTurn(playerOne)){
              return winner(playerOne);
          }else if(playField.isFieldFull()){
              return noWinner();
          }else if (playerTurn(playerTwo)){
              return winner(playerTwo);
          }
        }
    }

    public char noWinner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Its a Draw wwould you like to play one more game ?: [Y] Yes [N] NO ");
        return scanner.next().charAt(0);
    }

    public char winner(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getPlayerName() + " your a the Winner");
        System.out.println("Would you like to play one more time ?: [Y] Yes [N] NO");
        return scanner.next().charAt(0);

    }

    public Boolean playerTurn(Player player){
        playField.printPlayField();
        int yCordinate,xCordinate = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Player " + player.getPlayerName() + "your Turn has start.");
            System.out.println("Please select your Field: ");
            System.out.println("Select a Number: ");
            yCordinate = scanner.nextInt();
            System.out.println("Select a Letter: ");
            xCordinate = convertLetterToNumber(scanner.next().charAt(0));
        }while (!playField.setField(yCordinate, xCordinate, player.getPlayerLetter()));
        return playField.checkForWin(yCordinate,xCordinate,player);
    }
    private int convertLetterToNumber(char letter){
        return switch (letter) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            default -> -1;
        };
    }
}
