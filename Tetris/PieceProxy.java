package Tetris;

public class PieceProxy {
	
	private TetrisPiece _piece;

	public PieceProxy(){
		
	}

	public void setPiece(TetrisPiece piece){ 
		_piece = piece;
	}
	
	//All of the following methods are methods that are defined in the TetrisPiece class. 
	
	public void setLocation(double x, double y){
		_piece.setLocation(x,y);
	}

	public void moveRight(){
		_piece.movePieceRight();
	}

	public void moveLeft(){
		_piece.movePieceLeft();
	}

	public void moveDown(){
		_piece.movePieceDown();
	}

	public void rotatePiece(){
		_piece.rotatePiece();
	}

	public void dropPiece(){
		_piece.dropPiece();
	}

	public void setPieceColor(javafx.scene.paint.Color color){
		_piece.setPieceColor(color);
	}

	public Square getSquare1(){
		return _piece.getSquare1();
	}

	public Square getSquare2(){
		return _piece.getSquare2();
	}

	public Square getSquare3(){
		return _piece.getSquare3();
	}

	public Square getSquare4(){
		return _piece.getSquare4();
	}
}
