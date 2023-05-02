package com.example.tictactoe;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        GameConfigurator gameConfigurator = new GameConfigurator();
        gameConfigurator.initialGreeting();

        try {
            gameConfigurator.chooseGamePattern();
        } catch (Exception e) {
            gameConfigurator.chooseGamePattern();
        }
        gameConfigurator.showRules();

        try {
            gameConfigurator.chooseGameMode();
        } catch (Exception e) {
            gameConfigurator.chooseGameMode();
        }

    }//end of main
}
