package Sudoku;

public class GameBoard
{
    int[][] gameBoard;

    public GameBoard(int dimensionNumber)
    {
        this.gameBoard = new int[dimensionNumber][dimensionNumber];
    }
}
