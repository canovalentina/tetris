package Tetris;

import javafx.scene.layout.Pane;

public class PieceFactory {
	
	Board _b;
	
	public PieceFactory(Board b){ //Constructor
		_b = b;
	}

	public TetrisPiece getTetrisPiece(){ //returns a random TetrisPiece
		int rand = (int) (Math.random()*7);
		TetrisPiece piece = null;
		switch (rand) {
		case 0:
			piece = new OPiece(_b);
			break;
		case 1:
			piece = new IPiece(_b);
			break;
		case 2:
			piece = new SPiece(_b);
			break;
		case 3:
			piece = new ZPiece(_b);
			break;
		case 4:
			piece = new LPiece(_b);
			break;
		case 5:
			piece = new JPiece(_b);
			break;
		case 6:
			piece = new TPiece(_b);
			break;
		default: 
			piece = new OPiece(_b);
			break;	
		}
		return piece; 
	}

}//class PieceFactory


