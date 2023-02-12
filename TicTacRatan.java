
//================================
//CREATED BY - > Ratandeep Singh
//================================

import java.util.Scanner;

public class TicTacRatan {
    static char[][] board = new char[3][3];
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';

        play();
    }
    

    static void play() {
        System.out.print("Player \"X\" Enter Your name : ");
        String Player1 = scan.next();
        System.out.print("Player \"O\" Enter Your name : ");
        String Player2 = scan.next();
        int count = 1;
        boolean play = true;
        char turn = 'X';
        String name = Player1;
        printing();
        while (play) {
            System.out.println("\t\t [ " + name + "'s ] Turn");
            int row = 0, col = 0;
            System.out.print("Enter The Position (1 to 9) : ");
            int num = scan.nextInt();
            if (num > 9 || num < 0) {
                System.out.println("\n[WRONG INPUT] so, Enter Input Again\n");
                continue;
            }
            switch (num) {
                case 1:
                    row = 0;
                    col = 0;
                    break;
                case 2:
                    row = 0;
                    col = 1;
                    break;
                case 3:
                    row = 0;
                    col = 2;
                    break;
                case 4:
                    row = 1;
                    col = 0;
                    break;
                case 5:
                    row = 1;
                    col = 1;
                    break;
                case 6:
                    row = 1;
                    col = 2;
                    break;
                case 7:
                    row = 2;
                    col = 0;
                    break;
                case 8:
                    row = 2;
                    col = 1;
                    break;
                case 9:
                    row = 2;
                    col = 2;
                    break;
            }
            if (board[row][col] != ' ') {
                System.out.println("\n[ALREADY CONTAINS A ELEMENT] so, Enter Input Again\n");
                continue;
            }
            board[row][col] = turn;
            if (Winner(row, col)) {
                play = false;
                printing();
                System.out.println("\t    " + name + " WINS!");
            } else if (count == 5) {
                play = false;
                printing();
                System.out.println("GAME TIE");
            } else {
                printing();
                if (turn == 'X') {
                    turn = 'O';
                    name = Player2;
                } else {
                    turn = 'X';
                    name = Player1;
                    count++;
                }
            }
        }
    }

    static void printing() {
        System.out.println("---------------------------------------------");
        System.out.println("\t   | 1 | 2 | 3 |");
        System.out.println("\t   | 4 | 5 | 6 |");
        System.out.println("\t   | 7 | 8 | 9 |");
        System.out.print("\n\t   -------------");
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                if (j == 0)
                    System.out.print("\t   | ");
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();
        System.out.println("\t   -------------");
    }
    static boolean Winner(int row, int col) {
        if (board[0][col] == board[1][col] && board[0][col] == board[2][col])
            return true;
        if (board[row][0] == board[row][1] && board[row][0] == board[row][2])
            return true;
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != ' ')
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != ' ')
            return true;
        return false;
    }
}
