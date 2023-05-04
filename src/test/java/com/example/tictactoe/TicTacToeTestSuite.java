package com.example.tictactoe;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

public class TicTacToeTestSuite {

    static int count=0;

    @BeforeEach
    public void before() {
        count++;
        System.out.println("Test Case: "+count+" begin");

    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: "+count+" end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin"+"\n"+"**********************************************");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }


    @Test
    @DisplayName("TestCase0inRow")
        //"if the characters are next to each other, player with mark 'O' should win"

    void testCaseOinRow() throws PositionAlreadyTakenException {
        //Given

        // true==player O
        // false==player X
        boolean player;
        int rows;
        int columns;
        char[][] XOArray;
        int minValueInArray;
        int maxValueInArray;
        boolean computerAsPlayer2;
        boolean flag = true;
        boolean shutApp = false;
        int count = 0;
        String winner;


        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3,3);
//        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);

        //When

        //Player '0' chose position 1,2,3.
        singlePlayerMode.setCoordinates(4); //Player X
        singlePlayerMode.setCoordinates(1); //Player 0
        singlePlayerMode.setCoordinates(9); //Player X
        singlePlayerMode.setCoordinates(2); //Player 0
        singlePlayerMode.setCoordinates(6); //Player X
        singlePlayerMode.setCoordinates(3); //Player 0

        //Player '0' chose position 7,8,9.
        multiPlayerMode.setCoordinates(1); //Player X
        multiPlayerMode.setCoordinates(7); //Player 0
        multiPlayerMode.setCoordinates(2); //Player X
        multiPlayerMode.setCoordinates(8); //Player 0
        multiPlayerMode.setCoordinates(6); //Player X
        multiPlayerMode.setCoordinates(9); //Player 0

        singlePlayerMode.checkWinner();
        String actual=singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2=multiPlayerMode.getWinner();


        //Then
        Assertions.assertEquals("Player 2",actual);
        Assertions.assertEquals("Player 2",actual2);
    }

    @Test
    @DisplayName("TestCase0inColumn")
        //"if the characters are next to each other in column, player with mark 'O' should win"

    void testCaseOinColumn() throws PositionAlreadyTakenException {
        //Given

        // true==player O
        // false==player X
        boolean player;
        int rows;
        int columns;
        char[][] XOArray;
        int minValueInArray;
        int maxValueInArray;
        boolean computerAsPlayer2;
        boolean flag = true;
        boolean shutApp = false;
        int count = 0;
        String winner;


        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3,3);
//        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);

        //When

        //Player '0' chose position 3,6,9.
        singlePlayerMode.setCoordinates(1); //Player X
        singlePlayerMode.setCoordinates(3); //Player 0
        singlePlayerMode.setCoordinates(2); //Player X
        singlePlayerMode.setCoordinates(6); //Player 0
        singlePlayerMode.setCoordinates(4); //Player X
        singlePlayerMode.setCoordinates(9); //Player 0

        //Player '0' chose position 2,5,8.
        multiPlayerMode.setCoordinates(1); //Player X
        multiPlayerMode.setCoordinates(2); //Player 0
        multiPlayerMode.setCoordinates(3); //Player X
        multiPlayerMode.setCoordinates(5); //Player 0
        multiPlayerMode.setCoordinates(6); //Player X
        multiPlayerMode.setCoordinates(8); //Player 0

        singlePlayerMode.checkWinner();
        String actual=singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2=multiPlayerMode.getWinner();


        //Then
        Assertions.assertEquals("Player 2",actual);
        Assertions.assertEquals("Player 2",actual2);
    }
    @Test
    @DisplayName("TestCase0Diagonally")
        //"if the characters are diagonally next to each other , player with mark 'O' should win"

    void testCaseODiagonally() throws PositionAlreadyTakenException {
        //Given

        // true==player O
        // false==player X
        boolean player;
        int rows;
        int columns;
        char[][] XOArray;
        int minValueInArray;
        int maxValueInArray;
        boolean computerAsPlayer2;
        boolean flag = true;
        boolean shutApp = false;
        int count = 0;
        String winner;


        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3,3);
//        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);

        //When

        //Player '0' chose position 1,5,9.
        singlePlayerMode.setCoordinates(2); //Player X
        singlePlayerMode.setCoordinates(1); //Player 0
        singlePlayerMode.setCoordinates(3); //Player X
        singlePlayerMode.setCoordinates(5); //Player 0
        singlePlayerMode.setCoordinates(8); //Player X
        singlePlayerMode.setCoordinates(9); //Player 0

        //Player '0' chose position 3,5,7.
        multiPlayerMode.setCoordinates(1); //Player X
        multiPlayerMode.setCoordinates(3); //Player 0
        multiPlayerMode.setCoordinates(2); //Player X
        multiPlayerMode.setCoordinates(5); //Player 0
        multiPlayerMode.setCoordinates(6); //Player X
        multiPlayerMode.setCoordinates(7); //Player 0

        singlePlayerMode.checkWinner();
        String actual=singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2=multiPlayerMode.getWinner();


        //Then
        Assertions.assertEquals("Player 2",actual);
        Assertions.assertEquals("Player 2",actual2);
    }

    @Test
    @DisplayName("TestCaseXinRow")
        //"if the characters are next to each other, player with mark 'X' should win"

    void testCaseXinRow() throws PositionAlreadyTakenException {
        //Given

        // true==player O
        // false==player X
        boolean player;
        int rows;
        int columns;
        char[][] XOArray;
        int minValueInArray;
        int maxValueInArray;
        boolean computerAsPlayer2;
        boolean flag = true;
        boolean shutApp = false;
        int count = 0;
        String winner;


        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3,3);
//        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);

        //When

        //Player 'X' chose position 1,2,3.
        singlePlayerMode.setCoordinates(1); //Player X
        singlePlayerMode.setCoordinates(4); //Player 0
        singlePlayerMode.setCoordinates(2); //Player X
        singlePlayerMode.setCoordinates(6); //Player 0
        singlePlayerMode.setCoordinates(3); //Player X
        singlePlayerMode.setCoordinates(9); //Player 0

        //Player 'X' chose position 7,8,9.
        multiPlayerMode.setCoordinates(7); //Player X
        multiPlayerMode.setCoordinates(6); //Player 0
        multiPlayerMode.setCoordinates(8); //Player X
        multiPlayerMode.setCoordinates(3); //Player 0
        multiPlayerMode.setCoordinates(9); //Player X
        multiPlayerMode.setCoordinates(2); //Player 0

        singlePlayerMode.checkWinner();
        String actual=singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2=multiPlayerMode.getWinner();


        //Then
        Assertions.assertEquals("Player 1",actual);
        Assertions.assertEquals("Player 1",actual2);
    }

    @Test
    @DisplayName("TestCaseXinColumn")
        //"if the characters are next to each other in column, player with mark 'X' should win"

    void testCaseXinColumn() throws PositionAlreadyTakenException {
        //Given

        // true==player O
        // false==player X
        boolean player;
        int rows;
        int columns;
        char[][] XOArray;
        int minValueInArray;
        int maxValueInArray;
        boolean computerAsPlayer2;
        boolean flag = true;
        boolean shutApp = false;
        int count = 0;
        String winner;


        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3,3);
//        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);

        //When

        //Player 'X' chose position 3,6,9.
        singlePlayerMode.setCoordinates(3); //Player X
        singlePlayerMode.setCoordinates(1); //Player 0
        singlePlayerMode.setCoordinates(6); //Player X
        singlePlayerMode.setCoordinates(2); //Player 0
        singlePlayerMode.setCoordinates(9); //Player X
        singlePlayerMode.setCoordinates(4); //Player 0

        //Player 'X' chose position 2,5,8.
        multiPlayerMode.setCoordinates(2); //Player X
        multiPlayerMode.setCoordinates(4); //Player 0
        multiPlayerMode.setCoordinates(5); //Player X
        multiPlayerMode.setCoordinates(9); //Player 0
        multiPlayerMode.setCoordinates(8); //Player X
        multiPlayerMode.setCoordinates(7); //Player 0

        singlePlayerMode.checkWinner();
        String actual=singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2=multiPlayerMode.getWinner();


        //Then
        Assertions.assertEquals("Player 1",actual);
        Assertions.assertEquals("Player 1",actual2);
    }
    @Test
    @DisplayName("TestCaseXDiagonally")
        //"if the characters are diagonally next to each other, player with mark 'X' should win"

    void testCaseXDiagonally() throws PositionAlreadyTakenException {
        //Given

        // true==player O
        // false==player X
        boolean player;
        int rows;
        int columns;
        char[][] XOArray;
        int minValueInArray;
        int maxValueInArray;
        boolean computerAsPlayer2;
        boolean flag = true;
        boolean shutApp = false;
        int count = 0;
        String winner;


        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3,3);
//        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);

        //When

        //Player 'X' chose position 1,5,9.
        singlePlayerMode.setCoordinates(1); //Player X
        singlePlayerMode.setCoordinates(2); //Player 0
        singlePlayerMode.setCoordinates(5); //Player X
        singlePlayerMode.setCoordinates(7); //Player 0
        singlePlayerMode.setCoordinates(9); //Player X
        singlePlayerMode.setCoordinates(8); //Player 0

        //Player 'X' chose position 3,5,7.
        multiPlayerMode.setCoordinates(3); //Player X
        multiPlayerMode.setCoordinates(1); //Player 0
        multiPlayerMode.setCoordinates(5); //Player X
        multiPlayerMode.setCoordinates(2); //Player 0
        multiPlayerMode.setCoordinates(7); //Player X
        multiPlayerMode.setCoordinates(8); //Player 0

        singlePlayerMode.checkWinner();
        String actual=singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2=multiPlayerMode.getWinner();


        //Then
        Assertions.assertEquals("Player 1",actual);
        Assertions.assertEquals("Player 1",actual2);
    }

    @Test
    @DisplayName("TestCaseDrawScenario")

    void TestCaseDrawScenario() throws PositionAlreadyTakenException {
        //Given

        // true==player O
        // false==player X
        boolean player;
        int rows;
        int columns;
        char[][] XOArray;
        int minValueInArray;
        int maxValueInArray;
        boolean computerAsPlayer2;
        boolean flag = true;
        boolean shutApp = false;
        int count = 0;

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3,3);
//        MultiPlayerMode multiPlayerMode2 = new MultiPlayerMode(10,10);

        //When

        //Player 'X' chose position 1,3,4,6,8.
        singlePlayerMode.setCoordinates(1); //Player X
        singlePlayerMode.setCoordinates(2); //Player 0
        singlePlayerMode.setCoordinates(3); //Player X
        singlePlayerMode.setCoordinates(5); //Player 0
        singlePlayerMode.setCoordinates(4); //Player X
        singlePlayerMode.setCoordinates(7); //Player 0
        singlePlayerMode.setCoordinates(6); //Player X
        singlePlayerMode.setCoordinates(9); //Player 0
        singlePlayerMode.setCoordinates(8); //Player X

        //Player 'X' chose position 2,3,4,5,9.
        multiPlayerMode.setCoordinates(2); //Player X
        multiPlayerMode.setCoordinates(1); //Player 0
        multiPlayerMode.setCoordinates(3); //Player X
        multiPlayerMode.setCoordinates(6); //Player 0
        multiPlayerMode.setCoordinates(4); //Player X
        multiPlayerMode.setCoordinates(7); //Player 0
        multiPlayerMode.setCoordinates(5); //Player X
        multiPlayerMode.setCoordinates(8); //Player 0
        multiPlayerMode.setCoordinates(9); //Player X

        singlePlayerMode.checkWinner();
        String actual=singlePlayerMode.getWinner();

        multiPlayerMode.checkWinner();
        String actual2=multiPlayerMode.getWinner();


        //Then
        Assertions.assertEquals("Draw",actual);
        Assertions.assertEquals("Draw",actual2);
    }

    @Test
    @DisplayName("TestCaseExceptionThrown")
        //"throws an exception if position already taken"

    void TestCaseExceptionThrown() throws PositionAlreadyTakenException {
        //Given

        // true==player O
        // false==player X
        boolean player;
        int rows;
        int columns;
        char[][] XOArray;
        int minValueInArray;
        int maxValueInArray;
        boolean computerAsPlayer2;
        boolean flag = true;
        boolean shutApp = false;
        int count = 0;

        SinglePlayerMode singlePlayerMode = new SinglePlayerMode(3, 3);
        MultiPlayerMode multiPlayerMode = new MultiPlayerMode(3,3);

        //When

        //Players chose position 1
        singlePlayerMode.setCoordinates(1);
        Executable executable= ()->singlePlayerMode.setCoordinates(1);

        //Players chose position 5
        singlePlayerMode.setCoordinates(5);
        Executable executable2= ()->singlePlayerMode.setCoordinates(5);

        //Then
        Assertions.assertThrows(PositionAlreadyTakenException.class, executable);
        Assertions.assertThrows(PositionAlreadyTakenException.class, executable2);

    }
}//end of TicTacTOe winner tests






