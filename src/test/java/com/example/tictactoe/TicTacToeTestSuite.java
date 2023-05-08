package com.example.tictactoe;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

public class TicTacToeTestSuite {

    static int count = 0;

    @BeforeEach
    public void before() {
        count++;
        System.out.println("Test Case: " + count + " begin");

    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: " + count + " end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin" + "\n" + "**********************************************");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }


    @Test
    @DisplayName("TestCaseWin0inRow")
        //"if the characters are next to each other, player with mark 'O' should win"

    void TestCaseWin0inRow() throws PositionAlreadyTakenException {
        //Given

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10, 10);

        //When

        //Player '0' chose position 0.0, 0.1, 0.2.
        singlePlayerMode.setCoordinates(1, 0); //Player X
        singlePlayerMode.setCoordinates(0, 0); //Player 0
        singlePlayerMode.setCoordinates(2, 2); //Player X
        singlePlayerMode.setCoordinates(0, 1); //Player 0
        singlePlayerMode.setCoordinates(1, 2); //Player X
        singlePlayerMode.setCoordinates(0, 2); //Player 0

        //Player '0' chose position 2.0, 2.1, 2.2
        multiPlayerMode.setCoordinates(0, 0); //Player X
        multiPlayerMode.setCoordinates(2, 0); //Player 0
        multiPlayerMode.setCoordinates(0, 1); //Player X
        multiPlayerMode.setCoordinates(2, 1); //Player 0
        multiPlayerMode.setCoordinates(1, 2); //Player X
        multiPlayerMode.setCoordinates(2, 2); //Player 0

        //PLayer 'O' chose position 5.9, 5.8, 5.7, 5.6, 5.5
        multiPlayerMode2.setCoordinates(5, 9);
        multiPlayerMode2.setCoordinates(0, 0);
        multiPlayerMode2.setCoordinates(5, 8);
        multiPlayerMode2.setCoordinates(0, 1);
        multiPlayerMode2.setCoordinates(5, 7);
        multiPlayerMode2.setCoordinates(0, 2);
        multiPlayerMode2.setCoordinates(5, 6);
        multiPlayerMode2.setCoordinates(0, 3);
        multiPlayerMode2.setCoordinates(5, 5);

        singlePlayerMode.checkWinner();
        String actual = singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2 = multiPlayerMode.getWinner();

        multiPlayerMode2.checkWinner();
        String actual3 = multiPlayerMode2.getPlayer();


        //Then
        Assertions.assertEquals("Player 2", actual);
        Assertions.assertEquals("Player 2", actual2);
        Assertions.assertEquals("Player 2", actual3);
    }

    @Test
    @DisplayName("TestCaseWin0inColumn")
        //"if the characters are next to each other in column, player with mark 'O' should win"

    void TestCaseWin0inColumn() throws PositionAlreadyTakenException {
        //Given

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10, 10);

        //When

        //Player '0' chose position 0.2, 1.2, 2.2
        singlePlayerMode.setCoordinates(0, 0); //Player X
        singlePlayerMode.setCoordinates(0, 2); //Player 0
        singlePlayerMode.setCoordinates(0, 1); //Player X
        singlePlayerMode.setCoordinates(1, 2); //Player 0
        singlePlayerMode.setCoordinates(1, 0); //Player X
        singlePlayerMode.setCoordinates(2, 2); //Player 0

        //Player '0' chose position 0.1, 1.1, 2.1
        multiPlayerMode.setCoordinates(0, 0); //Player X
        multiPlayerMode.setCoordinates(0, 1); //Player 0
        multiPlayerMode.setCoordinates(0, 2); //Player X
        multiPlayerMode.setCoordinates(1, 1); //Player 0
        multiPlayerMode.setCoordinates(1, 2); //Player X
        multiPlayerMode.setCoordinates(2, 1); //Player 0

        //PLayer 'O' chose position 5.4, 6.4, 7.4, 8.4, 9.4
        multiPlayerMode2.setCoordinates(5, 4);
        multiPlayerMode2.setCoordinates(0, 0);
        multiPlayerMode2.setCoordinates(6, 4);
        multiPlayerMode2.setCoordinates(0, 1);
        multiPlayerMode2.setCoordinates(7, 4);
        multiPlayerMode2.setCoordinates(0, 2);
        multiPlayerMode2.setCoordinates(8, 4);
        multiPlayerMode2.setCoordinates(0, 3);
        multiPlayerMode2.setCoordinates(9, 4);

        singlePlayerMode.checkWinner();
        String actual = singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2 = multiPlayerMode.getWinner();

        multiPlayerMode2.checkWinner();
        String actual3 = multiPlayerMode2.getPlayer();


        //Then
        Assertions.assertEquals("Player 2", actual);
        Assertions.assertEquals("Player 2", actual2);
        Assertions.assertEquals("Player 2", actual3);
    }

    @Test
    @DisplayName("TestCaseWin0Diagonally")
        //"if the characters are diagonally next to each other , player with mark 'O' should win"

    void TestCaseWin0Diagonally() throws PositionAlreadyTakenException {
        //Given

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);
        MultiPlayerMode multiPlayerMode3 = new MultiPlayerMode(10,10);

        //When

        //Player '0' chose position 0.0, 1.1, 2.2
        singlePlayerMode.setCoordinates(0, 1); //Player X
        singlePlayerMode.setCoordinates(0, 0); //Player 0
        singlePlayerMode.setCoordinates(0, 2); //Player X
        singlePlayerMode.setCoordinates(1, 1); //Player 0
        singlePlayerMode.setCoordinates(2, 1); //Player X
        singlePlayerMode.setCoordinates(2, 2); //Player 0

        //Player '0' chose position 0.2, 1.1, 2.0
        multiPlayerMode.setCoordinates(0, 0); //Player X
        multiPlayerMode.setCoordinates(0, 2); //Player 0
        multiPlayerMode.setCoordinates(0, 1); //Player X
        multiPlayerMode.setCoordinates(1, 1); //Player 0
        multiPlayerMode.setCoordinates(1, 2); //Player X
        multiPlayerMode.setCoordinates(2, 0); //Player 0

        //Player 'O' chose position 9.9, 8.8, 7.7, 6.6, 5.5
        multiPlayerMode2.setCoordinates(0,0);
        multiPlayerMode2.setCoordinates(9,9);
        multiPlayerMode2.setCoordinates(0,1);
        multiPlayerMode2.setCoordinates(8,8);
        multiPlayerMode2.setCoordinates(0,2);
        multiPlayerMode2.setCoordinates(7,7);
        multiPlayerMode2.setCoordinates(0,3);
        multiPlayerMode2.setCoordinates(6,6);
        multiPlayerMode2.setCoordinates(7,4);
        multiPlayerMode2.setCoordinates(5,5);

        //Player 'O' chose position 8.3, 7.4, 6.5, 5.6, 4.7
        multiPlayerMode3.setCoordinates(0,0);
        multiPlayerMode3.setCoordinates(8,3);
        multiPlayerMode3.setCoordinates(0,1);
        multiPlayerMode3.setCoordinates(7,4);
        multiPlayerMode3.setCoordinates(0,2);
        multiPlayerMode3.setCoordinates(6,5);
        multiPlayerMode3.setCoordinates(0,3);
        multiPlayerMode3.setCoordinates(5,6);
        multiPlayerMode3.setCoordinates(7,9);
        multiPlayerMode3.setCoordinates(4,7);

        singlePlayerMode.checkWinner();
        String actual = singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2 = multiPlayerMode.getWinner();

        multiPlayerMode2.checkWinner();
        String actual3 = multiPlayerMode2.getWinner();

        multiPlayerMode3.checkWinner();
        String actual4 = multiPlayerMode3.getWinner();

        //Then
        Assertions.assertEquals("Player 2", actual);
        Assertions.assertEquals("Player 2", actual2);
        Assertions.assertEquals("Player 2", actual3);
        Assertions.assertEquals("Player 2", actual4);

    }

    @Test
    @DisplayName("TestCaseWinXinRow")
        //"if the characters are next to each other, player with mark 'X' should win"

    void TestCaseWinXinRow() throws PositionAlreadyTakenException {
        //Given

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10, 10);

        //When

        //Player 'X' chose position 0.0, 0.1, 0.2
        singlePlayerMode.setCoordinates(0, 0); //Player X
        singlePlayerMode.setCoordinates(1, 0); //Player 0
        singlePlayerMode.setCoordinates(0, 1); //Player X
        singlePlayerMode.setCoordinates(1, 2); //Player 0
        singlePlayerMode.setCoordinates(0, 2); //Player X
        singlePlayerMode.setCoordinates(2, 2); //Player 0

        //Player 'X' chose position 2.0, 2.1, 2.2
        multiPlayerMode.setCoordinates(2, 0); //Player X
        multiPlayerMode.setCoordinates(1, 2); //Player 0
        multiPlayerMode.setCoordinates(2, 1); //Player X
        multiPlayerMode.setCoordinates(0, 2); //Player 0
        multiPlayerMode.setCoordinates(2, 2); //Player X
        multiPlayerMode.setCoordinates(1, 1); //Player 0

        //PLayer 'X' chose position 5.4, 6.4, 7.4, 8.4, 9.4
        multiPlayerMode2.setCoordinates(5, 4);
        multiPlayerMode2.setCoordinates(0, 1);
        multiPlayerMode2.setCoordinates(6, 4);
        multiPlayerMode2.setCoordinates(0, 0);
        multiPlayerMode2.setCoordinates(7, 4);
        multiPlayerMode2.setCoordinates(0, 2);
        multiPlayerMode2.setCoordinates(8, 4);
        multiPlayerMode2.setCoordinates(0, 9);
        multiPlayerMode2.setCoordinates(9, 4);


        singlePlayerMode.checkWinner();
        String actual = singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2 = multiPlayerMode.getWinner();

        multiPlayerMode2.checkWinner();
        String actual3 = multiPlayerMode2.getWinner();


        //Then
        Assertions.assertEquals("Player 1", actual);
        Assertions.assertEquals("Player 1", actual2);
        Assertions.assertEquals("Player 1", actual3);
    }

    @Test
    @DisplayName("TestCaseWinXinColumn")
        //"if the characters are next to each other in column, player with mark 'X' should win"

    void TestCaseWinXinColumn() throws PositionAlreadyTakenException {
        //Given

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10, 10);

        //When

        //Player 'X' chose position 0.2, 1.2, 2.2
        singlePlayerMode.setCoordinates(0, 2); //Player X
        singlePlayerMode.setCoordinates(0, 0); //Player 0
        singlePlayerMode.setCoordinates(1, 2); //Player X
        singlePlayerMode.setCoordinates(0, 1); //Player 0
        singlePlayerMode.setCoordinates(2, 2); //Player X
        singlePlayerMode.setCoordinates(1, 0); //Player 0

        //Player 'X' chose position 0.1, 1.1, 2.1
        multiPlayerMode.setCoordinates(0, 1); //Player X
        multiPlayerMode.setCoordinates(1, 0); //Player 0
        multiPlayerMode.setCoordinates(1, 1); //Player X
        multiPlayerMode.setCoordinates(2, 2); //Player 0
        multiPlayerMode.setCoordinates(2, 1); //Player X
        multiPlayerMode.setCoordinates(2, 0); //Player 0

        //Player 'X' chose position 2.7,3.7,4.7,5.7,6,7
        multiPlayerMode2.setCoordinates(2, 7);
        multiPlayerMode2.setCoordinates(3, 0);
        multiPlayerMode2.setCoordinates(3, 7);
        multiPlayerMode2.setCoordinates(3, 2);
        multiPlayerMode2.setCoordinates(4, 7);
        multiPlayerMode2.setCoordinates(3, 8);
        multiPlayerMode2.setCoordinates(5, 7);
        multiPlayerMode2.setCoordinates(5, 9);
        multiPlayerMode2.setCoordinates(6, 7);

        singlePlayerMode.checkWinner();
        String actual = singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2 = multiPlayerMode.getWinner();

        multiPlayerMode2.checkWinner();
        String actual3 = multiPlayerMode2.getWinner();


        //Then
        Assertions.assertEquals("Player 1", actual);
        Assertions.assertEquals("Player 1", actual2);
        Assertions.assertEquals("Player 1", actual3);
    }

    @Test
    @DisplayName("TestCaseWinXDiagonally")
        //"if the characters are diagonally next to each other, player with mark 'X' should win"

    void testCaseXWinDiagonally() throws PositionAlreadyTakenException {
        //Given

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);
        MultiPlayerMode multiPlayerMode3 = new MultiPlayerMode(10,10);

        //When

        //Player 'X' chose position 0.0, 1.1, 2.2
        singlePlayerMode.setCoordinates(0, 0); //Player X
        singlePlayerMode.setCoordinates(0, 1); //Player 0
        singlePlayerMode.setCoordinates(1, 1); //Player X
        singlePlayerMode.setCoordinates(2, 0); //Player 0
        singlePlayerMode.setCoordinates(2, 2); //Player X
        singlePlayerMode.setCoordinates(2, 1); //Player 0

        //Player 'X' chose position 0.2, 1.1, 2.0
        multiPlayerMode.setCoordinates(0, 2); //Player X
        multiPlayerMode.setCoordinates(0, 0); //Player 0
        multiPlayerMode.setCoordinates(1, 1); //Player X
        multiPlayerMode.setCoordinates(0, 1); //Player 0
        multiPlayerMode.setCoordinates(2, 0); //Player X
        multiPlayerMode.setCoordinates(2, 1); //Player 0

        //Player 'X' chose position 0.8, 1.7, 2.6, 3.5, 4.4
        multiPlayerMode2.setCoordinates(0,8);
        multiPlayerMode2.setCoordinates(0,0);
        multiPlayerMode2.setCoordinates(1,7);
        multiPlayerMode2.setCoordinates(0,1);
        multiPlayerMode2.setCoordinates(2,6);
        multiPlayerMode2.setCoordinates(0,2);
        multiPlayerMode2.setCoordinates(3,5);
        multiPlayerMode2.setCoordinates(0,3);
        multiPlayerMode2.setCoordinates(4,4);
        multiPlayerMode2.setCoordinates(2,9);

        //Player 'X' chose position 0.9, 1.8, 2.7, 3.6, 4.5
        multiPlayerMode3.setCoordinates(0,9);
        multiPlayerMode3.setCoordinates(0,0);
        multiPlayerMode3.setCoordinates(1,8);
        multiPlayerMode3.setCoordinates(0,1);
        multiPlayerMode3.setCoordinates(2,7);
        multiPlayerMode3.setCoordinates(0,2);
        multiPlayerMode3.setCoordinates(3,6);
        multiPlayerMode3.setCoordinates(0,3);
        multiPlayerMode3.setCoordinates(4,5);
        multiPlayerMode3.setCoordinates(0,8);


        singlePlayerMode.checkWinner();
        String actual = singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2 = multiPlayerMode.getWinner();

        multiPlayerMode2.checkWinner();
        String actual3 = multiPlayerMode2.getWinner();

        multiPlayerMode3.checkWinner();
        String actual4 = multiPlayerMode3.getWinner();

        //Then
        Assertions.assertEquals("Player 1", actual);
        Assertions.assertEquals("Player 1", actual2);
        Assertions.assertEquals("Player 1", actual3);
        Assertions.assertEquals("Player 1", actual4);
    }

    @Test
    @DisplayName("TestCaseDrawScenario")
    void TestCaseDrawScenario() throws PositionAlreadyTakenException {
        //Given

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3, 3);

        //When

        //Player 'X' chose position 0.0, 0.2, 1.0, 1.2, 2.1
        singlePlayerMode.setCoordinates(0, 0); //Player X
        singlePlayerMode.setCoordinates(0, 1); //Player 0
        singlePlayerMode.setCoordinates(0, 2); //Player X
        singlePlayerMode.setCoordinates(1, 1); //Player 0
        singlePlayerMode.setCoordinates(1, 0); //Player X
        singlePlayerMode.setCoordinates(2, 0); //Player 0
        singlePlayerMode.setCoordinates(1, 2); //Player X
        singlePlayerMode.setCoordinates(2, 2); //Player 0
        singlePlayerMode.setCoordinates(2, 1); //Player X

        //Player 'X' chose position 0.1, 0.2, 1.0, 1.1, 2.2
        multiPlayerMode.setCoordinates(0, 1); //Player X
        multiPlayerMode.setCoordinates(0, 0); //Player 0
        multiPlayerMode.setCoordinates(0, 2); //Player X
        multiPlayerMode.setCoordinates(1, 2); //Player 0
        multiPlayerMode.setCoordinates(1, 0); //Player X
        multiPlayerMode.setCoordinates(2, 0); //Player 0
        multiPlayerMode.setCoordinates(1, 1); //Player X
        multiPlayerMode.setCoordinates(2, 1); //Player 0
        multiPlayerMode.setCoordinates(2, 2); //Player X

        singlePlayerMode.checkWinner();
        String actual = singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2 = multiPlayerMode.getWinner();


        //Then
        Assertions.assertEquals("Draw", actual);
        Assertions.assertEquals("Draw", actual2);
    }

    @Test
    @DisplayName("TestCaseExceptionThrown")
        //"throws an exception if position already taken"

    void TestCaseExceptionThrown() throws PositionAlreadyTakenException {
        //Given

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3, 3);

        //When

        singlePlayerMode.setCoordinates(1, 1);
        Executable executable = () -> singlePlayerMode.setCoordinates(1, 1);

        singlePlayerMode.setCoordinates(2, 2);
        Executable executable2 = () -> singlePlayerMode.setCoordinates(2, 2);

        //Then
        Assertions.assertThrows(PositionAlreadyTakenException.class, executable);
        Assertions.assertThrows(PositionAlreadyTakenException.class, executable2);

    }
}//end of TicTacTOe winner tests






