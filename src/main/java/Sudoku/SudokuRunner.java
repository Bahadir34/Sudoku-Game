package Sudoku;

import java.util.Scanner;

public class SudokuRunner
{
    static Scanner scan = new Scanner(System.in);
    static int difficultyLevel;

    public static void main(String[] args)
    {

        int board[][] = initializeGame();
        showBoard(board);

        do {
            System.out.print("Game Situation : " + checkBoard(4,board));
            System.out.println();

            System.out.print("Raw : ");
            int rawnumber = scan.nextInt();

            System.out.print("Column : ");
            int column = scan.nextInt();

            System.out.print("Number : ");
            int number = scan.nextInt();

            board = enterNumber(board,rawnumber,column,number);

            showBoard(board);
            System.out.println("Length of Board : " + board.length);

        }while(true);
    }


    public static int[][] initializeGame()
    {
        System.out.print("Difficulty Level (4 - 9): ");

        do {

            difficultyLevel = scan.nextInt();

        }while(difficultyLevel != 4 && difficultyLevel != 9);


        GameBoard board = new GameBoard(difficultyLevel);


        return board.gameBoard;
    }

    public static void showBoard(int board[][])
    {
        for(int[] w : board)
        {
            for (int u : w)
            {
                System.out.print(u + " ");
            }
            System.out.println();
        }
    }

    public static int[][] enterNumber(int board[][] , int raw , int column , int number)
    {
        try
        {
            board[raw-1][column-1] = number;
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.print("Invalid raw or column number has entered!\n");
        }

        return board;
    }

    private static boolean checkBoard(int difficultyLevel , int[][] board)
    {
        boolean result = false;

        //If the difficulty level has selected as 4, so The code will run this control blocks.
        if(difficultyLevel == 4)
        {
            int sumOfColumns = 0 , sumOfRaws = 0;
            int raw = 0 , column = 0;
            for(int i = 0 ; i < board.length; i++)
            {
                sumOfRaws += board[raw][i];
                sumOfColumns += board[i][column];

                if(i == (board.length -1))
                {
                    if(sumOfRaws == 10 && sumOfColumns == 10)
                    {
                        if(raw == 3 && column == 3)
                            break;

                        result = true;
                        i = -1;
                        raw++;
                        column++;
                        sumOfColumns = 0;
                        sumOfRaws = 0;
                    }

                    else
                    {
                        result = false;
                        break;
                    }

                }

            }
        }

        //If the difficulty level has selected as 9, so The code will run this control blocks.
        else
        {
            int sumOfColumns = 0 , sumOfRaws = 0;
            int raw = 0 , column = 0;
            for(int i = 0 ; i <board.length ; i++)
            {
                sumOfRaws+= board[raw][i];

                if(i == (board.length -1))
                {
                    if(sumOfColumns == 10)
                    {
                        result = true;
                        i = 0;
                        raw++;
                        sumOfRaws = 0;
                    }

                    else
                    {
                        result = false;
                        break;
                    }

                }
            }
        }

        return result;
    }
}
