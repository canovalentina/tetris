package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TPiece extends TetrisPiece {
	
	public TPiece(Board b){ //Constructor
		super(b);
		super.setPieceColor(Color.ORANGE);	
	}
	
	@Override
	public void setLocation(double x, double y) {
		//Sets location of each individual Square. In this case they line up creating a shape similar to a letter T. 
		(super.getSquare1()).setLocation(x,y);
		(super.getSquare2()).setLocation(x+Constants.SQUARE_SIDE,y);
		(super.getSquare3()).setLocation(x+(2*Constants.SQUARE_SIDE),y);
		(super.getSquare4()).setLocation(x+Constants.SQUARE_SIDE,y+Constants.SQUARE_SIDE);
	}
}
