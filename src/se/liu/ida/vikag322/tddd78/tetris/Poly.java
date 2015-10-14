package se.liu.ida.vikag322.tddd78.tetris;

public class Poly
{
    private SquareType type;
    private boolean[][] block;

    public SquareType getSquareType() {
        return type;
    }
    public boolean[][] getBlock(){
        return block;
    }

    public Poly(SquareType type, boolean[][] block) {
        this.type = type;
        this.block = block;
    }

}
