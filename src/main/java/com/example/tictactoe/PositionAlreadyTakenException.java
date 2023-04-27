package com.example.tictactoe;

public class PositionAlreadyTakenException extends Exception{
    public PositionAlreadyTakenException() {
        super("Position already taken! Try another one");
    }

}
