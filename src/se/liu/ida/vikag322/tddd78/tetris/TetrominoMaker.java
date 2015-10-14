package se.liu.ida.vikag322.tddd78.tetris;

import java.util.ArrayList;
import java.util.List;

public class TetrominoMaker
{
    // CODE INSPECTION NOTE I don't want to make these blocks local, this looks better!
    private int numberOfTypes = 0;

    private boolean[][] IBlock = {
	    {false,false,false,false},
	    {true,true,true,true},
	    {false,false,false,false},
	    {false,false,false,false}
    };
    private boolean[][] JBlock = {
	    {true,false,false},
	    {true,true,true},
	    {false,false,false}
    };
    private boolean[][] LBlock = {
	    {false,false,true},
	    {true,true,true},
	    {false,false,false}
    };
    private boolean[][] OBlock = {
	    {true,true},
	    {true,true}
    };
    private boolean[][] SBlock = {
	    {false,true,true},
	    {true,true,false},
	    {false,false,false}
    };
    private boolean[][] TBlock = {
	    {false,true,false},
	    {true,true,true},
	    {false,false,false}
    };
    private boolean[][] ZBlock = {
	    {true,true,false},
	    {false,true,true},
	    {false,false,false}
    };

    private List<boolean[][]> blockList;
    private List<SquareType> typeList;

    public TetrominoMaker() {
	blockList = new ArrayList<boolean[][]>();
	typeList = new ArrayList<SquareType>();
	addBlock(SquareType.I, IBlock);
	addBlock(SquareType.J, JBlock);
	addBlock(SquareType.L, LBlock);
	addBlock(SquareType.O, OBlock);
	addBlock(SquareType.S, SBlock);
	addBlock(SquareType.T, TBlock);
	addBlock(SquareType.Z, ZBlock);
    }

    public int getNumberOfTypes(){
	return numberOfTypes;
    }

    public Poly getPoly(int n){
	return new Poly(typeList.get(n),blockList.get(n));
    }

    public void addBlock(SquareType type,boolean[][] block){
	blockList.add(block);
	typeList.add(type);
	numberOfTypes++;
    }

}

