
public class BoardToTextConverter  {
    public static String convertToText(Board board){

	StringBuilder builder = new StringBuilder();

	for (int row = 0; row < board.getHeigth(); row++){
	    builder.append("\n");
	    for(int col = 0; col < board.getWidth(); col++){
		switch(board.getSquareType(row, col)){
		    case OUTSIDE:
			builder.append("|");
			break;
		    case EMPTY:
			builder.append(" ");
			break;
		    case I:
			builder.append("I");
			break;
		    case O:
			builder.append("O");
			break;
		    case T:
			builder.append("T");
			break;
		    case S:
			builder.append("S");
			break;
		    case Z:
			builder.append("Z");
			break;
		    case J:
			builder.append("J");
			break;
		    case L:
			builder.append("L");
			break;
		}
	    }
	}
	textconvertFalling(builder, board);
	String result = builder.toString();
	return result;
    }


    private static void textconvertFalling(StringBuilder builder, Board board){
	if(board.getFalling() != null){ // looks if a tetromino is falling
	    //converts x,y position to string index
	    boolean[][] block = board.getFalling().getBlock();
	    for(int row = 0; row < block.length; row++) { // goes through the listdeepth and gives the block height on the tetromino
		for(int col = 0; col < block[row].length; col++){ // goes through the curent list and checks its length
		    if(block[row][col]){ // checks if the part of the tetromino exists
			int index = board.getWidth() * (board.getFallingY() + row) + board.getFallingY() + row + board.getFallingX() + col;
			switch(board.getFalling().getSquareType()){ //checks a fallings SquareType
				// inserts the right enum to builder
			    case OUTSIDE:
				builder.insert(index, "|");
				break;
			    case EMPTY:
				builder.insert(index, " ");
				break;
			    case I:
				builder.insert(index, "I");
				break;
			    case O:
				builder.insert(index,"O");
				break;
			    case T:
				builder.insert(index,"T");
				break;
			    case S:
				builder.insert(index, "S");
				break;
			    case Z:
				builder.insert(index, "Z");
				break;
			    case J:
				builder.insert(index, "J");
				break;
			    case L:
				builder.insert(index, "L");
				break;
			}
		    }
	    	}

	    }
	}
    }

}
