package se.liu.ida.vikag322.tddd78.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int heigth;
    public static final int SQUARE_SIZE = 30;

    private Poly falling = null;
    private int fallingX;
    private int fallingY;

    private int fallingTetrominoX;
    private int fallingTetrominoY;
    private TetrominoMaker fallingFactory;

    private Random rnd = new Random();
    private List<BoardListener> boardListeners;

    public Board(final int width, final int heigth) {

        squares = new SquareType[heigth][width];
        this.width = width;
        this.heigth = heigth;
        fallingFactory = new TetrominoMaker();
	boardListeners = new ArrayList<BoardListener>();

        for(int row = 0; row < heigth; row++){
            for( int col = 0; col < width; col++){
		// CODE INSPECTION NOTE i don't want to colapse this anymore, everything dissapears and i dont know why
                if(col == 0 || col == width - 1 || row == 0 || row == heigth - 1){
                    this.squares[row][col] = SquareType.OUTSIDE;
                }
                else this.squares[row][col] = SquareType.EMPTY;
            }
        }
	notifyListeners();
    }

    public void randomBoard(){
        for(int row = 1; row < heigth-1; row++){
	    for(int col = 1; col < width-1; col++){
		this.squares[row][col] = SquareType.values()[rnd.nextInt(7)];
	    }
	}
    	notifyListeners();
    }

    public void tick(){
	createFalling();
	fallingTetromino();
    }


    public void fallingTetromino(){

	fallingTetrominoX = fallingX;
	fallingTetrominoY = fallingY + 1;

	if(falling == null){
	    fallingY = fallingTetrominoY;
	}
    }

    public void createFalling(){
        fallingX = rnd.nextInt(width-2) + 1;
        fallingY = 0;
        fallingFactory.getPoly(rnd.nextInt(fallingFactory.getNumberOfTypes()-1));
    	notifyListeners();
    }

    public void addBoardListener(BoardListener bl){
	boardListeners.add(bl);
    }

    private void notifyListeners(){
	for( BoardListener boardListener : boardListeners){
	    boardListener.boardChanged();
	}
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


