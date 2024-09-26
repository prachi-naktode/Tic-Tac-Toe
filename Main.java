package ticTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                board[row][col] = ' ';
            }
        }

        char player = 'O';
        boolean isGameOver = false;

        Scanner scan = new Scanner(System.in);

        while(!isGameOver){
            printBoard(board);
            if(isBoardFull(board)){
                System.out.println("Match draw");
                return;
            }
            System.out.println("Player " + player + " Enter your move");
            System.out.println("Enter row: ");
            int row = scan.nextInt();
            row -= 1;

            System.out.println("Enter col: ");
            int col = scan.nextInt();
            col -= 1;

            if(board[row][col] == ' '){
                board[row][col] = player;
                isGameOver = hasWon(board, player);
                if(isGameOver){
                    printBoard(board);
                    System.out.println(player + " has won");
                    return;
                }
                else{
                    player = (player == 'X') ? 'O' : 'X';
                }
            }
            else{
                System.out.println("No empty position. Try again!");
            }
        }

        printBoard(board);
    }

    public static void printBoard(char[][] board){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean hasWon(char[][] board, char player){
        // check rows
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //check for columns
        for(int col = 0; col < board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //check for diagonal top left - bottom right
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        //check for diagonal top right - bottom left
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board){
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == ' ' || board[row][1] == ' ' || board[row][2] == ' '){
                return false;
            }
        }
        return true;
    }
}
