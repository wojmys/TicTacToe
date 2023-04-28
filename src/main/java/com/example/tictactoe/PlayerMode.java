package com.example.tictactoe;

public interface PlayerMode {

   void checkPattern();
   void play() throws PositionAlreadyTakenException;
   void chooseCoordinates() throws PositionAlreadyTakenException;
   int getColumns();
   char[][] getXOArray();
   void setCoordinates(int number) throws PositionAlreadyTakenException;


}
