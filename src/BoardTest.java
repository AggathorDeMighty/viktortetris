
public class BoardTest
{
    public static void main(String[] args) {
	Board testBrd = new Board(10, 20);
	testBrd.randomBoard();
	int i = 0;
	while (i < 11) {
	    i++;
	    System.out.println(BoardToTextConverter.convertToText(testBrd));
	}
    }
}
