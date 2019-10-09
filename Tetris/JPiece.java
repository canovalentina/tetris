package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class JPiece extends TetrisPiece {
	
	public JPiece(Board b){ //Constructor
		super(b);
		super.setPieceColor(Color.YELLOW);	
	}

	@Override
	public void setLocation(double x, double y) {
		(super.getSquare1()).setLocation(x,y);
		(super.getSquare2()).setLocation(x+Constants.SQUARE_SIDE,y);
		(super.getSquare3()).setLocation(x+(2*Constants.SQUARE_SIDE),y);
		(super.getSquare4()).setLocation(x+(2*Constants.SQUARE_SIDE),y+Constants.SQUARE_SIDE);

	}
}
