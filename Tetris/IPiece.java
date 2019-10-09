package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class IPiece extends TetrisPiece {
	

	public IPiece(Board b){ //Constructor
		super(b);
		super.setPieceColor(Color.RED);	
	}

	@Override
	public void setLocation(double x, double y) { 
		//Sets location of each individual Square. In this case they are all in a straight line, creating a shape similar to a letter I. 
		(super.getSquare1()).setLocation(x,y);
		(super.getSquare2()).setLocation(x,y+Constants.SQUARE_SIDE);
		(super.getSquare3()).setLocation(x,y+(2*Constants.SQUARE_SIDE));
		(super.getSquare4()).setLocation(x,y+(3*Constants.SQUARE_SIDE));
	}

}
