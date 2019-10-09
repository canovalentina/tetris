package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SPiece extends TetrisPiece {
	
	public SPiece(Board b){ //Constructor
		super(b);
		super.setPieceColor(Color.TEAL);	
	}
	
	@Override
	public void setLocation(double x, double y) {
		//Sets location of each individual Square. In this case they line up creating a shape similar to a letter S. 
		(super.getSquare1()).setLocation(x,y);
		(super.getSquare2()).setLocation(x,y+Constants.SQUARE_SIDE);
		(super.getSquare3()).setLocation(x+Constants.SQUARE_SIDE, y+Constants.SQUARE_SIDE);
		(super.getSquare4()).setLocation(x+Constants.SQUARE_SIDE, y+(2*Constants.SQUARE_SIDE));
	}
}
