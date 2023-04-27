package com.example.tictactoe;

public class SinglePlayerMode implements PlayerMode {

    private int playerNumber;

    private int rows;
    private int columns;
    private char[][] XOArray;

    public SinglePlayerMode() {

    }

    public SinglePlayerMode(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        XOArray = new char[rows][columns];
    }

    @Override
    public void play() {

    }

    @Override
    public int chooseCoordinates() {
        return 0;
    }

    @Override
    public int getRows() {
        return 0;
    }

    @Override
    public int getColumns() {
        return 0;
    }

    @Override
    public char[][] getXOArray() {
        return new char[0][];
    }

    @Override
    public void setCoordinates(int number) {

    }


}
