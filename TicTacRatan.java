//================================
//CREATED BY - > RatanDeep Singh
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
        int count = 1;
        boolean play = true;
        char turn = 'X';
        printing();
        while (play) {
            System.out.println("\t\t [PLAYER " + turn + "]");
            System.out.print("Enter Row and Column Number with space : ");
            int row = scan.nextInt() - 1;
            int col = scan.nextInt() - 1;
            if (row > 2 || row < 0 || col > 2 || col < 0) {
                System.out.println("\n[WRONG INPUT] so, Enter Input Again\n");
                continue;
            }
            if (board[row][col] != ' ') {
                System.out.println("\n[ALREADY CONTAINS A ELEMENT] so, Enter Input Again\n");
                continue;
            }
            board[row][col] = turn;
            if (Winner(row, col)) {
                play = false;
                printing();
                System.out.println("\tPLAYER " + turn + " WINS!");
            } else if (count == 5) {
                play = false;
                printing();
                System.out.println("GAME TIE");
            } else {
                printing();
                if (turn == 'X')
                    turn = 'O';
                else {
                    turn = 'X';
                    count++;
                }
            }

        }

    }

    static void printing() {
        System.out.println("------------------------------------");
        System.out.println("\t   |1 1|1 2|1 3|");
        System.out.println("\t   |2 1|2 2|2 3|");
        System.out.println("\t   |3 1|3 2|3 3|");

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