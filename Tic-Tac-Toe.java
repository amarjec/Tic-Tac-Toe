import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i =0; i< board.length; i++) {
            for (int j=0; j< board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " chance : ");
            int row = sc.nextInt()-1;
            while (row < 0 || row >2) {
                System.out.println("Enter Valid Row");
                row = sc.nextInt()-1;
            }
            int col = sc.nextInt()-1;

            while (col < 0 || col >2) {
                System.out.println("Enter Valid Column");
                col = sc.nextInt()-1;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);

                if (gameOver) {
                    System.out.println("Player " +player+ " has won!");
                }else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            }
            else {
                System.out.println("Invalid move, try again!");
            }
        }

    }
    public static void printBoard (char[][] board) {
        for (int i =0; i< board.length; i++) {
            for (int j=0; j< board[i].length; j++) {
                if (j==2) {
                    System.out.print(board[i][j]);
                }else {
                    System.out.print(board[i][j] + " | ");
                }
            }
            System.out.println();
        }


    }

    public static boolean haveWon (char[][] board, char player) {
        // row wise winning
        for (int row=0; row<board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // col wise winning
        for (int col=0; col<board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // diagonal wise winning check
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}
