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

    public Poly(final SquareType type, final boolean[][] block) {
        this.type = type;
        this.block = block;
    }

}
