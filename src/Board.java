import java.util.Scanner;

public class Board {
    public Cell[][] board;
    public int m;
    public int n;

    public Board(int m, int n){
        this.board = new Cell[m][n];
        this.m = m;
        this.n = n;
        createBoard();
    }

    public Cell[][] createBoard() {
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){ board[i][j] = new Cell(i,j,'-'); }
        }
        return board;
    }

    public String toString(){
        String temp = "";
        for(int i=0; i<m; i++){
            temp += "\n";
            for(int j=0; j<n; j++){temp += board[i][j].get_status();}
        }
        return temp;
    }



}
