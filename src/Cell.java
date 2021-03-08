public class Cell {
    private int row;
    private int col;
    private char status;

    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = status;

    }
    // ACCESSOR METHODS

    // status can be - (not been guessed, no boat
    // B not been guessed, boat present
    // H has been guessed, hit
    // M has been guessed, miss
    
    public char getStatus(){
        return status;
    }
    
    public void setStatus(char c){
        this.status = c;
    }
    
    public int getRow(){return this.row;}
    
    public int getCol(){return this.col;}
    

}
