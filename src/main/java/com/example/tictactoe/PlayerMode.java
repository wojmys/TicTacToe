package com.example.tictactoe;

import java.util.Scanner;

public abstract class PlayerMode {

    Scanner scanner = new Scanner(System.in);

    // true==player1
    // false==player2
    boolean player;

    //only for singlePlayer
    boolean dontPrint;

    int rows;
    int columns;
    static char[][] XOArray;
    int minValueInArray;
    int maxValueInArray;
    boolean computerAsPlayer2;
    boolean flag = true;
    private boolean shutApp = false;
    private int count = 0;
    private String winner;

    View view = new View();

    public void play() {
        while (flag) {
            try {
                chooseCoordinates();
            } catch (Exception ex) {
                System.out.println("choose value from " + minValueInArray + " to " + maxValueInArray + "\n");
                continue;
            }
            if (checkWinner()) {
                flag = false;
                shutApp = true;
                view.presentWinner(winner);
                view.presentArray(this.XOArray);
            } else if (dontPrint) {
                continue;
            } else if(!player && computerAsPlayer2) {
                System.out.println("------------------"+"\n"+
                        "Computer's choice: "+"\n");
                view.presentArray(this.XOArray);
            }else {
                view.presentArray(this.XOArray);
            }
        }
    }

    public int getColumns() {
        return columns;
    }

    public char[][] getXOArray() {
        return XOArray;
    }

    public String getPlayer() {
        if (!player) {
            return "Player 1";
        } else {
            return "Player 2";
        }
    }

    public void checkPattern() {
        if (rows == 3 && columns == 3) {
            minValueInArray = 1;
            maxValueInArray = 9;
        } else if (rows == 5 && columns == 5) {
            minValueInArray = 1;
            maxValueInArray = 100;
        } else {
            return;
        }
    }

    public void setCoordinates(int number) throws PositionAlreadyTakenException {
        char mark;
        if (!player) {
            mark = 'X';
        } else {
            mark = 'O';
        }
        switch (number) {
            case 1:
                if (Character.isLetterOrDigit(XOArray[0][0])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[0][0] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }

            case 2:
                if (Character.isLetterOrDigit(XOArray[0][1])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[0][1] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }
            case 3:
                if (Character.isLetterOrDigit(XOArray[0][2])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[0][2] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }
            case 4:
                if (Character.isLetterOrDigit(XOArray[1][0])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[1][0] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }
            case 5:
                if (Character.isLetterOrDigit(XOArray[1][1])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[1][1] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }
            case 6:
                if (Character.isLetterOrDigit(XOArray[1][2])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[1][2] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }
            case 7:
                if (Character.isLetterOrDigit(XOArray[2][0])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[2][0] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }
            case 8:
                if (Character.isLetterOrDigit(XOArray[2][1])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[2][1] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }
            case 9:
                if (Character.isLetterOrDigit(XOArray[2][2])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[2][2] = mark;
                    changePlayer();
                    dontPrint = false;
                    break;
                }
        }
    }

    public abstract void chooseCoordinates();

    public void changePlayer() {
        player = !player;
        count++;
    }

    public boolean checkWinner() {
        if (count == maxValueInArray) {
            winner = "draw";
            return true;
        } else if ((XOArray[0][0] == 'O' && XOArray[0][1] == 'O' && XOArray[0][2] == 'O') ||
                (XOArray[1][0] == 'O' && XOArray[1][1] == 'O' && XOArray[1][2] == 'O') ||
                (XOArray[2][0] == 'O' && XOArray[2][1] == 'O' && XOArray[2][2] == 'O') ||
                (XOArray[0][0] == 'O' && XOArray[1][0] == 'O' && XOArray[2][0] == 'O') ||
                (XOArray[0][1] == 'O' && XOArray[1][1] == 'O' && XOArray[2][1] == 'O') ||
                (XOArray[0][2] == 'O' && XOArray[1][2] == 'O' && XOArray[2][2] == 'O') ||
                (XOArray[0][0] == 'O' && XOArray[1][1] == 'O' && XOArray[2][2] == 'O') ||
                (XOArray[2][0] == 'O' && XOArray[1][1] == 'O' && XOArray[0][2] == 'O')) {
            winner = "Player 2";
            return true;
        } else if ((XOArray[0][0] == 'X' && XOArray[0][1] == 'X' && XOArray[0][2] == 'X') ||
                (XOArray[1][0] == 'X' && XOArray[1][1] == 'X' && XOArray[1][2] == 'X') ||
                (XOArray[2][0] == 'X' && XOArray[2][1] == 'X' && XOArray[2][2] == 'X') ||
                (XOArray[0][0] == 'X' && XOArray[1][0] == 'X' && XOArray[2][0] == 'X') ||
                (XOArray[0][1] == 'X' && XOArray[1][1] == 'X' && XOArray[2][1] == 'X') ||
                (XOArray[0][2] == 'X' && XOArray[1][2] == 'X' && XOArray[2][2] == 'X') ||
                (XOArray[0][0] == 'X' && XOArray[1][1] == 'X' && XOArray[2][2] == 'X') ||
                (XOArray[2][0] == 'X' && XOArray[1][1] == 'X' && XOArray[0][2] == 'X')
        ) {
            winner = "Player 1";
            return true;
        } else {
            return false;
        }
    }

}
