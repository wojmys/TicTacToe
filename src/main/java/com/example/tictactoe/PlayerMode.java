package com.example.tictactoe;

public interface PlayerMode {

   void play() throws PositionAlreadyTakenException;
   int chooseCoordinates() throws PositionAlreadyTakenException;
   int getRows() ;
   int getColumns();
   char[][] getXOArray();
   void setCoordinates(int number) throws PositionAlreadyTakenException;


}
