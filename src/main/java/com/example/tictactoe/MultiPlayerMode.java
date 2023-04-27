package com.example.tictactoe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiPlayerMode implements PlayerMode {

    Scanner scanner = new Scanner(System.in);

    // true==player1
    // false==player2
    private boolean player;

    private String winner;
    private int rows;
    private int columns;
    static char[][] XOArray;
    private int minValueInArray;
    private int maxValueInArray;
    private boolean flag=true;
    private int count=0;

    View view = new View();

    public MultiPlayerMode() {

    }

    public MultiPlayerMode(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        XOArray = new char[rows][columns];
        checkPattern();
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public char[][] getXOArray() {
        return XOArray;
    }

    public void checkPattern() {
        if (rows == 3 && columns == 3) {
            minValueInArray = 1;
            maxValueInArray = 9;
        } else {
            minValueInArray = 1;
            maxValueInArray = 25;
        }

    }

    @Override
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
                }
                break;
            case 2:
                if (Character.isLetterOrDigit(XOArray[0][1])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[0][1] = mark;
                    changePlayer();
                    break;
                }
            case 3:
                if (Character.isLetterOrDigit(XOArray[0][2])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[0][2] = mark;
                    changePlayer();
                    break;
                }
            case 4:
                if (Character.isLetterOrDigit(XOArray[1][0])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[1][0] = mark;
                    changePlayer();
                    break;
                }
            case 5:
                if (Character.isLetterOrDigit(XOArray[1][1])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[1][1] = mark;
                    changePlayer();
                    break;
                }
            case 6:
                if (Character.isLetterOrDigit(XOArray[1][2])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[1][2] = mark;
                    changePlayer();
                    break;
                }
            case 7:
                if (Character.isLetterOrDigit(XOArray[2][0])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[2][0] = mark;
                    changePlayer();
                    break;
                }
            case 8:
                if (Character.isLetterOrDigit(XOArray[2][1])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[2][1] = mark;
                    changePlayer();
                    break;
                }
            case 9:
                if (Character.isLetterOrDigit(XOArray[2][2])) {
                    throw new PositionAlreadyTakenException();
                } else {
                    XOArray[2][2] = mark;
                    changePlayer();
                    break;
                }
            default:
               play();
        }
    }

    @Override
    public void play() throws PositionAlreadyTakenException {
        while (flag) {
            try {
                setCoordinates(chooseCoordinates());
            } catch (Exception ex) {
                System.out.println("Position already taken! Try another one");
            }
            if (checkWinner()) {
                flag = false;
                view.presentWinner(winner);
                view.presentArray(this.XOArray);
                // return;
            } else {
                view.presentArray(this.XOArray);
            }
        }
    }

    @Override
    public int chooseCoordinates()  {
        int number = 0;
        System.out.println("choose a number");
        try {
            number = scanner.nextInt();
            if (number < minValueInArray || number > maxValueInArray) {
                throw new Exception();
            }
        }
        catch (Exception e) {
            System.out.println("choose correct Integer value");
        }
        return number;
    }

    public void changePlayer() {
        player = !player;
        count++;
    }

    public boolean checkWinner() {
        if(count==maxValueInArray){
            winner="draw";
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
                (XOArray[2][0] == 'X' && XOArray[1][1] == 'O' && XOArray[0][2] == 'X')

        ) {
            winner = "Player 1";
            return true;
        } else {
            return false;
        }
    }
}
