public class Cell {
    public int row;
    public int col;
    public char status;

    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = status;

    }

    public char get_status(){
        return status;
    }
    // status can be - (not been guessed, no boat
    // B not been guessed, boat present
    // H has been guessed, hit
    // M has been guessed, miss
    public void set_status(char c){
        this.status = c;
    }
}
