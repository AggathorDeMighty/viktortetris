package se.liu.ida.vikag322.tddd78.tetris;

public final class BoardTest
{
    public static final int HEIGHT = 20;
    public static final int WIDTH = 10;

    private BoardTest() {}

    public static void main(String[] args) {
	    Board testBrd = new Board(WIDTH, HEIGHT);
        TetrisFrame testFrame = new TetrisFrame(testBrd);
    }
}
