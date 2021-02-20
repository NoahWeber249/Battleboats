import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner ScannerS = new Scanner(System.in);
        System.out.println("Enter m dimension for board: ");
        int m = ScannerS.nextInt();
        System.out.println("Enter n dimension for board: ");
        int n = ScannerS.nextInt();
        Board gameBoard = new Board(m,n);
        System.out.println(gameBoard.toString());

        boolean gameStatus = false;
        int gameRound = 0;

//        while (!gameStatus){
//            gameStatus = true;
//
//
//
//
//        }



    }
}
