public class Board {
    private Cell[][] board;
    private final int m;
    private final int n;

    public Board(int m, int n){
        this.board = new Cell[m][n];
        this.m = m;
        this.n = n;
        this.board = createBoard();
        placeBoats(createBoats());
    }

    public Cell[][] createBoard() {
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){ board[i][j] = new Cell(i,j,'-'); }
        }
        return board;
    }

    //  Create correct # of boats depending on size of board, store in array.
    public Boat[] createBoats(){
        Boat[] boats;

        if (m == 3 || n ==3){
            boats = new Boat[]{new Boat(2)};
            return boats;
        }

        else if((n ==4) || m ==4){
            boats = new Boat[2];
            boats[1] = new Boat(2);
            boats[0] = new Boat(3);
            return boats;
        }

        else if((4 < n && n <= 6) || (4 < m && m <=6)){
            boats = new Boat[3];
            boats[2] = new Boat(2);
            boats[1] = new Boat(3);
            boats[0] = new Boat(3);
            return boats;
        }

        else if((6 < n && n <= 8) || (6 < m && m <=8)){
            boats = new Boat[4];
            boats[3] = new Boat(2);
            boats[2] = new Boat(3);
            boats[1] = new Boat(3);
            boats[0] = new Boat(4);
            return boats;
        }

        else if((8 < n && n <= 10) || (8 < m && m <=10)){
            boats = new Boat[5];
            boats[4] = new Boat(2);
            boats[3] = new Boat(3);
            boats[2] = new Boat(3);
            boats[1] = new Boat(4);
            boats[0] = new Boat(5);
            return boats;
        }
        return boats = new Boat[0];
    }

    // Checks location for placement of boat. returns true if all spaces are available
    // LOCATION represents the row or column being examined
    public boolean isPlaced(boolean orientation, int location, int size, int start) {
        boolean status = true;

        // VERTICAL
        if (orientation) {
            for (int i = 0; i < size && status; i++) {
                if (board[start][location].getStatus() != '-') {
                    status = false;
                }
                start += 1;
            }
        }
        //HORIZONTAL
        else {
            for (int j = 0; j < size && status; j++) {
                if (board[location][start].getStatus() != '-') {
                    status = false;
                }
                start += 1;
            }
        }
        return status;
    }

    public void placeBoats(Boat[] boats){
        boolean attempt;
        boolean status;

        for(int i=0; i< boats.length; i++){
            attempt = false;
            status = false;

            // attempts to place ship, will iterate until successful placement
            while(!attempt){
                attempt = true;
                boats[i].setOrientation();

                // VERTICAL
                if (boats[i].getOrientation()){
                    // BASED ON STACK OVERFLOW...
                    int x = (int)(Math.random() * n); //determines the COL to place in
                    int y = (int)(Math.random() * (m-1)); //determines WHERE in COL to START placement

                    if(boats[i].getSize()+y<=m){

                        // VERIFICATION
                        status = isPlaced(boats[i].getOrientation(), x, boats[i].getSize(), y);

                        //PLACEMENT
                        if (status){
                            for(int k=0; k<boats[i].getSize(); k++){
                                board[y][x].setStatus('B');
                                y+=1;
                            }
                        }
                        else{attempt=false;}
                    }
                    else{attempt=false;}
                }

                //HORIZONTAL
                else{
                    int y = (int)(Math.random() * m); //determines the ROW to place in
                    int x = (int)(Math.random() * (n-1)); // determines WHERE in ROW to START placement

                    if(boats[i].getSize()+x<=n){

                        //VERIFICATION
                        status = isPlaced(boats[i].getOrientation(), y, boats[i].getSize(), x);

                        //PLACEMENT
                        if (status){
                            for(int k=0; k<boats[i].getSize(); k++){
                                board[y][x].setStatus('B');
                                x+=1;
                            }
                        }
                        else{attempt=false;}
                    }
                    else{attempt=false;}
                    }
                }
            }
        }


    public String toString(){
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<m; i++){
            temp.append("\n");
            for(int j=0; j<n; j++){
                temp.append(board[i][j].getStatus());}
        }
        return temp.toString();
    }

    //NEEDS TO BE IMPLEMENTED
    public void fire(int x, int y){
        if (board[x][y].getStatus()=='-'){
            board[x][y].setStatus('M');
            System.out.print("Miss.");
        }
        else if (board[x][y].getStatus()=='H'){
            System.out.print("Already hit. Penalty Applied");

        }
        else if (board[x][y].getStatus()=='B'){
            System.out.print("Hit!");
            board[x][y].setStatus('H');

        }
        else if (board[x][y].getStatus()=='M'){
            System.out.print("Already missed here. Penalty Applied");
        }
    }


}
