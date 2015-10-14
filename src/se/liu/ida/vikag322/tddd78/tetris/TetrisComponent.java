package se.liu.ida.vikag322.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener
{

    private Board board;
    private EnumMap<SquareType, Color> enumMap;


    public TetrisComponent(Board board) {
	this.board = board;
	this.enumMap = new EnumMap<SquareType, Color>(SquareType.class);

	enumMap.put(SquareType.OUTSIDE, Color.DARK_GRAY);
	enumMap.put(SquareType.EMPTY, Color.LIGHT_GRAY);
	enumMap.put(SquareType.I, Color.BLUE);
	enumMap.put(SquareType.J, Color.RED);
	enumMap.put(SquareType.L, Color.ORANGE);
	enumMap.put(SquareType.O, Color.YELLOW);
	enumMap.put(SquareType.T, Color.GREEN);
	enumMap.put(SquareType.S, Color.PINK);
	enumMap.put(SquareType.Z, Color.MAGENTA);
    }

    @Override public Dimension getPreferredSize() {
	super.getPreferredSize();
	return new Dimension(BoardTest.WIDTH * Board.SQUARE_SIZE, BoardTest.HEIGHT * Board.SQUARE_SIZE);
    }

    @Override protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	drawBoard(g2d);

	drawFalling(g2d, board);
    }
    public void boardChanged(){
	repaint();
    }

    private void drawBoard(Graphics2D g2d) {
	for (int row = 0; row < board.getHeigth(); row++) {
	    for (int col = 0; col < board.getWidth(); col++) {
		g2d.setColor(enumMap.get(board.getSquareType(row, col)));
		g2d.fillRect(col * Board.SQUARE_SIZE, row * Board.SQUARE_SIZE, Board.SQUARE_SIZE, Board.SQUARE_SIZE);

	    }
	}
    }
    private void drawFalling(Graphics2D g2d, Board board){
	if(board.getFalling() != null){
	    boolean[][] block = board.getFalling().getBlock();
	    for(int row = 0; row < block.length; row++){
		for( int col = 0; col < block[row].length; col++){
		    if(block[row][col]){
			int x = board.getFallingX() + col * Board.SQUARE_SIZE;
			int y = board.getFallingY() + row * Board.SQUARE_SIZE;
			switch(board.getFalling().getSquareType()){

			    case OUTSIDE:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			    case EMPTY:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			    case I:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			    case O:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			    case T:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			    case S:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			    case Z:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			    case J:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			    case L:
				g2d.setColor(enumMap.get(board.getSquareType(row, col)));
				g2d.fillRect(x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
			}
		    }
		}
	    }
	}
    }


}
