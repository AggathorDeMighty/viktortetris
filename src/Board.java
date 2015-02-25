import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int heigth;

    private Poly falling = null;
    private int fallingX;
    private int fallingY;

    private int fallingTetrominoX;
    private int fallingTetrominoY;
    private TetrominoMaker fallingFactory;

    private Random rnd = new Random();


    public Board(final int width, final int heigth) {

        this.squares = new SquareType[heigth][width];
        this.width = width;
        this.heigth = heigth;
        fallingFactory = new TetrominoMaker();

        for(int row = 0; row < heigth; row++){
            for( int col = 0; col < width; col++){
                if(col == 0 || col == width-1){
                    this.squares[row][col] = SquareType.OUTSIDE;
                }
                else if(row == 0 || row == heigth-1){
                    this.squares[row][col] = SquareType.OUTSIDE;
                }
                else this.squares[row][col] = SquareType.EMPTY;
            }
        }
    }

    public void randomBoard(){
        for(int row = 1; row < heigth-1; row++){
                   for(int col = 1; col < width-1; col++){
                       this.squares[row][col] = SquareType.values()[rnd.nextInt(7)];
                   }
               }
    }

    public void createFalling(){
        fallingX = rnd.nextInt(width-2) + 1;
        fallingY = 0;
        fallingFactory.getPoly(rnd.nextInt(fallingFactory.getNumberOfTypes()-1));
    }

    public SquareType getSquareType(int width, int heigth) {
        return squares[width][heigth];
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public static void main(String[] args){
        Random rnd = new Random();
    }

    public Poly getFalling() {return falling;}

    public int getFallingX() {return fallingX;}

    public int getFallingY() {return fallingY;}

    public int getFallingTetrominoX() {return fallingTetrominoX;}

    public int getFallingTetrominoY() {return fallingTetrominoY;}
}


