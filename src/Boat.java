public class Boat {
    private boolean orientation;
    private final int size;

    public Boat(int size){
        this.size = size;
    }
    // ACCESSOR METHODS
    public void setOrientation(){
        //sets orientation to random boolean, vertical if true, horizontal if false
        this.orientation = Math.random() < 0.5;
    }

    public boolean getOrientation(){
        return this.orientation;
    }

    public int getSize(){
        return this.size;
    }

}
