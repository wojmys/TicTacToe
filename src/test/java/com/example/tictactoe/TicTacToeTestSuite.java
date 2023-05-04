package com.example.tictactoe;

import org.junit.jupiter.api.*;

public class TicTacToeTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
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

        boolean actual = singlePlayerMode.checkWinner();
        boolean actual2 = multiPlayerMode.checkWinner();

        //Then
        Assertions.assertTrue(actual);
        Assertions.assertTrue(actual2);
    }
}//end of TicTacTOe winner tests


//    Napisz testy weryfikujące zwycięstwa O w wierszach.
//    Napisz testy weryfikujące zwycięstwa O w kolumnach.
//    Napisz testy weryfikujące zwycięstwa O po przekątnych planszy.
//    Napisz testy weryfikujące zwycięstwa X w wierszach.
//    Napisz testy weryfikujące zwycięstwa X w kolumnach.
//    Napisz testy weryfikujące zwycięstwa X po przekątnych planszy.
//    Napisz testy weryfikujące układy, które prowadzą do remisu.
//    Napisz testy weryfikujące, czy w przypadku błędnie wykonanych ruchów zostanie rzucony odpowiedni wyjątek.



