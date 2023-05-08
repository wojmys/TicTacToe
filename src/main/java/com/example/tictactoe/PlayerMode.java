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
    char[][] XOArray;
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
            } else if (!player && computerAsPlayer2) {
                System.out.println("------------------" + "\n" +
                        "Computer's choice: " + "\n");
                view.presentArray(this.XOArray);
            } else {
                view.presentArray(this.XOArray);
            }
        }
    }

    public String getWinner() {
        return winner;
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
        } else if (rows == 10 && columns == 10) {
            minValueInArray = 1;
            maxValueInArray = 100;
        } else {
            return;
        }
    }

    public void setCoordinates(int row, int column) throws PositionAlreadyTakenException {
        char mark;
        if (!player) {
            mark = 'X';
        } else {
            mark = 'O';
        }
        if (Character.valueOf(XOArray[row][column]) == 'X' || Character.valueOf(XOArray[row][column]) == 'O') {
            throw new PositionAlreadyTakenException();
        } else {
            XOArray[row][column] = mark;
            changePlayer();
            dontPrint = false;
        }
    }

    public abstract void chooseCoordinates();

    public void changePlayer() {
        player = !player;
        count++;
    }


    public boolean checkWinner() {
        String paternX;
        String patern0;

        if (count == (maxValueInArray)) {
            this.winner = "Draw";
            return true;
        }
        if (columns == 3) {
            paternX = "XXX";
            patern0 = "OOO";
        } else {
            paternX = "XXXXX";
            patern0 = "OOOOO";
        }
        if (((columns == 3) && (XOArray[0][0] == 'X' &&
                XOArray[1][1] == 'X' &&
                XOArray[2][2] == 'X')) ||
                ((columns == 3) && (XOArray[1][1] == 'X' &&
                        XOArray[0][2] == 'X' &&
                        XOArray[2][0] == 'X'))
        ) {
            this.winner = "Player 1";
            return true;
        } else if (((columns == 3) && (XOArray[0][0] == 'O' &&
                XOArray[1][1] == 'O' &&
                XOArray[2][2] == 'O')) ||
                ((columns == 3) && (XOArray[1][1] == 'O' &&
                        XOArray[0][2] == 'O' &&
                        XOArray[2][0] == 'O'))
        ) {
            this.winner = "Player 2";
            return true;
        }

        for (int i = 0; i < columns; i++) {
            String vertical = new String();
            for (int j = 0; j < columns; j++) {
                vertical += XOArray[j][i];
            }
            if (vertical.contains(paternX)) {
                this.winner = "Player 1";
                return true;

            } else if (vertical.contains(patern0)) {
                this.winner = "Player 2";
                return true;
            }
        }
        for (int i = 0; i < columns; i++) {
            String horizontal = new String();
            for (int j = 0; j < columns; j++) {
                horizontal += XOArray[i][j];
            }
            if (horizontal.contains(paternX)) {
                this.winner = "Player 1";
                return true;

            } else if (horizontal.contains(patern0)) {
                this.winner = "Player 2";
                return true;
            }
        }

        try {
            for (int i = 2; i < 8; ++i) {
                for (int j = 2; j < 8; ++j) {
                    if (XOArray[i][j] == 'X') {
                        if (((XOArray[i + 1][j + 1] == 'X') &&
                                (XOArray[i + 2][j + 2] == 'X') &&
                                (XOArray[i - 1][j - 1] == 'X') &&
                                (XOArray[i - 2][j - 2] == 'X')

                        )||
                                (XOArray[i + 1][j - 1] == 'X') &&
                                        (XOArray[i - 2][j + 2] == 'X') &&
                                        (XOArray[i + 1][j - 1] == 'X') &&
                                        (XOArray[i + 2][j - 2] == 'X')

                        ) {
                            this.winner = "Player 1";
                            return true;
                        }

                    } else if (XOArray[i][j] == 'O') {
                        if (((XOArray[i + 1][j + 1] == 'O') &&
                                (XOArray[i + 2][j + 2] == 'O') &&
                                (XOArray[i - 1][j - 1] == 'O') &&
                                (XOArray[i - 2][j - 2] == 'O'))
                                ||
                                ((XOArray[i + 1][j - 1] == 'O') &&
                                        (XOArray[i - 2][j + 2] == 'O') &&
                                        (XOArray[i + 1][j - 1] == 'O') &&
                                        (XOArray[i + 2][j - 2] == 'O'))

                        )
                         {
                            this.winner = "Player 2";
                            return true;
                        }

                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception");
        }

//        for (int i = 0; i < columns; ++i) {
//            for (int j = 0; j < columns; ++j) {
//                if (i >= 2 && j >= 2 && i <= 7 && j <= 7 && XOArray[i][j] == 'X') {
//                    if ((XOArray[i + 1][j + 1] == 'X') &&
//                            (XOArray[i + 2][j + 2] == 'X') &&
//                            (XOArray[i - 1][j - 1] == 'X') &&
//                            (XOArray[i - 2][j - 2] == 'X')
//
//                    ) {
//                        this.winner = "Player 1";
//                        return true;
//                    }
//
//                } else if (i >= 2 && j >= 2 && i <= 7 && j <= 7 && XOArray[i][j] == 'O') {
//                    if ((XOArray[i + 1][j + 1] == 'O') &&
//                            (XOArray[i + 2][j + 2] == 'O') &&
//                            (XOArray[i - 1][j - 1] == 'O') &&
//                            (XOArray[i - 2][j - 2] == 'O')
//                    ) {
//                        this.winner = "Player 2";
//                        return true;
//                    }
//
//                }
//            }
//        }
        return false;
//        if (horizontal.contains(paternX)) {
//            this.winner = "Player 1";
//            return true;
//
//        } else if (horizontal.contains(patern0)) {
//            this.winner = "Player 2";
//            return true;
//        } else {
//            return false;
//        }


    }
//            public boolean checkWinner () {
//                if (count == maxValueInArray) {
//                    this.winner = "Draw";
//                    return true;
//                } else if ((XOArray[0][0] == 'O' && XOArray[0][1] == 'O' && XOArray[0][2] == 'O') ||
//                        (XOArray[1][0] == 'O' && XOArray[1][1] == 'O' && XOArray[1][2] == 'O') ||
//                        (XOArray[2][0] == 'O' && XOArray[2][1] == 'O' && XOArray[2][2] == 'O') ||
//                        (XOArray[0][0] == 'O' && XOArray[1][0] == 'O' && XOArray[2][0] == 'O') ||
//                        (XOArray[0][1] == 'O' && XOArray[1][1] == 'O' && XOArray[2][1] == 'O') ||
//                        (XOArray[0][2] == 'O' && XOArray[1][2] == 'O' && XOArray[2][2] == 'O') ||
//                        (XOArray[0][0] == 'O' && XOArray[1][1] == 'O' && XOArray[2][2] == 'O') ||
//                        (XOArray[2][0] == 'O' && XOArray[1][1] == 'O' && XOArray[0][2] == 'O')) {
//                    this.winner = "Player 2";
//                    return true;
//                } else if ((XOArray[0][0] == 'X' && XOArray[0][1] == 'X' && XOArray[0][2] == 'X') ||
//                        (XOArray[1][0] == 'X' && XOArray[1][1] == 'X' && XOArray[1][2] == 'X') ||
//                        (XOArray[2][0] == 'X' && XOArray[2][1] == 'X' && XOArray[2][2] == 'X') ||
//                        (XOArray[0][0] == 'X' && XOArray[1][0] == 'X' && XOArray[2][0] == 'X') ||
//                        (XOArray[0][1] == 'X' && XOArray[1][1] == 'X' && XOArray[2][1] == 'X') ||
//                        (XOArray[0][2] == 'X' && XOArray[1][2] == 'X' && XOArray[2][2] == 'X') ||
//                        (XOArray[0][0] == 'X' && XOArray[1][1] == 'X' && XOArray[2][2] == 'X') ||
//                        (XOArray[2][0] == 'X' && XOArray[1][1] == 'X' && XOArray[0][2] == 'X')
//                ) {
//                    winner = "Player 1";
//                    return true;
//                } else {
//                    return false;
//                }
//            }

    public void setArray() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                XOArray[i][j] = '-';
            }
        }
    }
}
