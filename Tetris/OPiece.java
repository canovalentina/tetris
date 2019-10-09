package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class OPiece extends TetrisPiece {
	
	public OPiece(Board b){ //Constructor
		super(b);
		super.setPieceColor(Color.MAGENTA);	
	}
	
	@Override
	public void setLocation(double x, double y) {
		(super.getSquare1()).setLocation(x,y);
		(super.getSquare2()).setLocation(x+Constants.SQUARE_SIDE,y);
		(super.getSquare3()).setLocation(x,y+Constants.SQUARE_SIDE);
		(super.getSquare4()).setLocation(x+Constants.SQUARE_SIDE,y+Constants.SQUARE_SIDE);
	}

	@Override
	public void rotatePiece(){	
		/*This shape has the condition that it does not rotate so I considered that to avoid any bugs, it would be better to override the
		 * method, leaving it empty. 
		 */
	}
}
