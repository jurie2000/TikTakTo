package org.example.GameFolder;

public class PlayField {
    private final char[][] field;
    private int counter = 0;
    public PlayField(){
        field = new char[3][3];
        iniPlayField();
    }

    public Boolean isFieldFull(){
        for(int yCordinate = 0; yCordinate < field.length; yCordinate++){
            for(int xCordinate = 0; xCordinate < field[yCordinate].length; xCordinate++){
                if(field[yCordinate][xCordinate] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public void iniPlayField(){
        for(int yCordinate = 0; yCordinate < field.length; yCordinate++){
            for(int xCordinate = 0; xCordinate < field[yCordinate].length; xCordinate++){
                field[yCordinate][xCordinate] = ' ';
            }
        }
    }

    public void printPlayField(){
        char startLetter = 'A';

        for(int counter = 0; counter < field.length; counter++){
            System.out.print(' ');
            System.out.print(startLetter++);

        }
        System.out.println();
        for(int yCordinate = 0; yCordinate < field.length; yCordinate++){
            for(int xCordinate = 0; xCordinate < field[yCordinate].length; xCordinate++){
                System.out.print('|');
                System.out.print(field[yCordinate][xCordinate]);
            }
            System.out.print(" " + yCordinate);
            System.out.print(' ');
            System.out.println();
        }
    }

    public boolean setField(int yCordinate,int xCordinate, char playerLetter){
       if(!checkOutOfBounds(yCordinate, xCordinate) && checkIfFieldFree(yCordinate, xCordinate)){
           field[yCordinate][xCordinate] = playerLetter;
           return true;
       }else {
           return false;
       }
    }

    public boolean checkOutOfBounds(int yCordinate,int xCordinate){
        return !(yCordinate <= field.length-1 && yCordinate >= 0 && xCordinate >= 0 && xCordinate <= field.length-1);
    }

    public boolean checkForWin(int yCordinate,int xCordinate,Player player){
        checkRight(yCordinate,xCordinate,player);
        checkLeft(yCordinate,xCordinate,player);
        if(counter >= 2){
            setCounter(0);
            return true;
        }else {
            setCounter(0);
        }
        checkUpper(yCordinate,xCordinate,player);
        checkLower(yCordinate,xCordinate,player);
        if(counter >= 2){
            setCounter(0);
            return true;
        }else {
            setCounter(0);
        }
        checkLowerRight(yCordinate,xCordinate,player);
        checkUpperLeft(yCordinate,xCordinate,player);
        if(counter >= 2){
            setCounter(0);
            return true;
        }else {
            setCounter(0);
        }
        checkLowerLeft(yCordinate,xCordinate,player);
        checkUpperRight(yCordinate,xCordinate,player);
        if(counter >= 2){
            setCounter(0);
            return true;
        }else {
            setCounter(0);
        }
        return false;
    }

    public void checkRight(int yCordinate,int xCordinate,Player player){
        while (field[yCordinate][xCordinate] == player.getPlayerLetter()) {
            xCordinate++;
            counter++;
            if(checkOutOfBounds(yCordinate, xCordinate)){
                counter--;
                setCounter(checkForNegativeInput(counter));
                return;
            }
        }
        counter--;
        setCounter(checkForNegativeInput(counter));
    }
    public void checkLeft(int yCordinate,int xCordinate,Player player){
        while (field[yCordinate][xCordinate] == player.getPlayerLetter()) {
            xCordinate--;
            counter++;
            if(checkOutOfBounds(yCordinate, xCordinate)){
                counter--;
                setCounter(checkForNegativeInput(counter));
                return;
            }
        }
        counter--;
        setCounter(checkForNegativeInput(counter));
    }

    public void checkUpper(int yCordinate,int xCordinate,Player player){
        while (field[yCordinate][xCordinate] == player.getPlayerLetter()) {
            yCordinate++;
            counter++;
            if(checkOutOfBounds(yCordinate, xCordinate)){
                counter--;
                setCounter(checkForNegativeInput(counter));
                return;
            }
        }
        counter--;
        setCounter(checkForNegativeInput(counter));
    }
    public void checkLower(int yCordinate,int xCordinate,Player player){
        while (field[yCordinate][xCordinate] == player.getPlayerLetter()) {
            yCordinate--;
            counter++;
            if(checkOutOfBounds(yCordinate, xCordinate)){
                counter--;
                setCounter(checkForNegativeInput(counter));
                return;
            }
        }
        counter--;
        setCounter(checkForNegativeInput(counter));
    }

    public void checkUpperLeft(int yCordinate,int xCordinate,Player player){
        while (field[yCordinate][xCordinate] == player.getPlayerLetter()) {
            yCordinate--;
            xCordinate--;
            counter++;
            if(checkOutOfBounds(yCordinate, xCordinate)){
                counter--;
                setCounter(checkForNegativeInput(counter));
                return;
            }
        }
        counter--;
        setCounter(checkForNegativeInput(counter));
    }

    public void checkUpperRight(int yCordinate,int xCordinate,Player player){
        while (field[yCordinate][xCordinate] == player.getPlayerLetter()) {
            yCordinate--;
            xCordinate++;
            counter++;
            if(checkOutOfBounds(yCordinate, xCordinate)){
                counter--;
                setCounter(checkForNegativeInput(counter));
                return;
            }
        }
        counter--;
        setCounter(checkForNegativeInput(counter));
    }
    public void checkLowerLeft(int yCordinate,int xCordinate,Player player){
        while (field[yCordinate][xCordinate] == player.getPlayerLetter()) {
            yCordinate++;
            xCordinate--;
            counter++;
            if(checkOutOfBounds(yCordinate, xCordinate)){
                counter--;
                setCounter(checkForNegativeInput(counter));
                return;
            }
        }
        counter--;
        setCounter(checkForNegativeInput(counter));
    }
    public void checkLowerRight(int yCordinate,int xCordinate,Player player){
        while (field[yCordinate][xCordinate] == player.getPlayerLetter()) {
            yCordinate++;
            xCordinate++;
            counter++;
            if(checkOutOfBounds(yCordinate, xCordinate)){
                counter--;
                setCounter(checkForNegativeInput(counter));
                return;
            }
        }
        counter--;
        setCounter(checkForNegativeInput(counter));
    }

    public void setCounter(int counter){
        this.counter = counter;
    }
    public int getCounter(){
        return counter;
    }
    public int checkForNegativeInput(int counter){
        if(counter < 0)
            return 0;
        else
            return counter;
    }

    public boolean checkIfFieldFree(int yCordinate,int xCordinate){
        return field[yCordinate][xCordinate] == ' ';
    }

}
