package Tetris;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TetrisPiece  {

	private Square _square1, _square2, _square3, _square4;  
	private Square[][] _squareArray;
	private Board _board;

	public TetrisPiece(Board b){ //Constructor
		_board = b;
		_squareArray = _board.getSquareArray(); 
		_square1 = new Square();
		_square2 = new Square();
		_square3 = new Square();
		_square4 = new Square();
		_square1.setStroke(Color.BLACK);
		_square2.setStroke(Color.BLACK);
		_square3.setStroke(Color.BLACK);
		_square4.setStroke(Color.BLACK);
	}

	public void setLocation(double x, double y){ 
		//Sets location of each square to the same point. This method will be overriden by each subclass to set the squares' position depending on the type of Piece. 

		_square1.setX(x);
		_square1.setY(y);
		_square2.setX(x);
		_square2.setY(y);
		_square3.setX(x);
		_square3.setY(y);
		_square4.setX(x);
		_square4.setY(y);
	}

	/*The methods movePieceRight(), movePieceLeft(), movePieceDown() and rotatePiece() are very similar. First, they create an int that will be the index
	 * of the position in the array where the TetrisPiece's new location will be. Then, with these indexes, they check if the newPosition is not filled
	 * with a square, and only if it is null, will the TetrisPiece be able to move. Finally, the setLocation method is called on each individual square that composes
	 * the TetrisPiece.
	 */

	public boolean checkValidMove(int xChange, int yChange){

		int x1 = (int)((_square1.getX()/Constants.SQUARE_SIDE) + xChange);
		int y1 = (int)((_square1.getY()/Constants.SQUARE_SIDE) + yChange);
		int x2 = (int)((_square2.getX()/Constants.SQUARE_SIDE) + xChange);
		int y2 = (int)((_square2.getY()/Constants.SQUARE_SIDE) + yChange);
		int x3 = (int)((_square3.getX()/Constants.SQUARE_SIDE) + xChange);
		int y3 = (int)((_square3.getY()/Constants.SQUARE_SIDE) + yChange);
		int x4 = (int)((_square4.getX()/Constants.SQUARE_SIDE) + xChange);
		int y4 = (int)((_square4.getY()/Constants.SQUARE_SIDE) + yChange);

		if (_squareArray[x1][y1]==null&&_squareArray[x2][y2]==null&& _squareArray[x3][y3]==null&&_squareArray[x4][y4]==null){
			return true;
		}
		return false; 

	}

	public void movePieceRight(){ //Moves the TetrisPiece the length of the Square side to the right. 
		//x+1, y no change

		if(checkValidMove(1,0)){
			_square1.setLocation((_square1.getX()+Constants.SQUARE_SIDE), _square1.getY());
			_square2.setLocation((_square2.getX()+Constants.SQUARE_SIDE), _square2.getY());
			_square3.setLocation((_square3.getX()+Constants.SQUARE_SIDE), _square3.getY());
			_square4.setLocation((_square4.getX()+Constants.SQUARE_SIDE), _square4.getY());
		}
	}

	public void movePieceLeft(){ //Moves the TetrisPiece the length of the Square side to the left. 
		//x-1, y no change


		if(checkValidMove(-1,0)){
			_square1.setLocation((_square1.getX()-Constants.SQUARE_SIDE), _square1.getY());
			_square2.setLocation((_square2.getX()-Constants.SQUARE_SIDE), _square2.getY());
			_square3.setLocation((_square3.getX()-Constants.SQUARE_SIDE), _square3.getY());
			_square4.setLocation((_square4.getX()-Constants.SQUARE_SIDE), _square4.getY());
		}
	}

	public void movePieceDown(){ //Moves the TetrisPiece the length of the Square side down. 
		//x no change y+1

		if(checkValidMove(0,1)){
			_square1.setLocation(_square1.getX(), (_square1.getY()+Constants.SQUARE_SIDE));
			_square2.setLocation(_square2.getX(), (_square2.getY()+Constants.SQUARE_SIDE));
			_square3.setLocation(_square3.getX(), (_square3.getY()+Constants.SQUARE_SIDE));
			_square4.setLocation(_square4.getX(), (_square4.getY()+Constants.SQUARE_SIDE));
		}
		else{
			_squareArray[(int)((_square1.getX()/Constants.SQUARE_SIDE))][(int)((_square1.getY()/Constants.SQUARE_SIDE))]= _square1;
			_squareArray[(int)((_square2.getX()/Constants.SQUARE_SIDE))][(int)((_square2.getY()/Constants.SQUARE_SIDE))]= _square2;
			_squareArray[(int)((_square3.getX()/Constants.SQUARE_SIDE))][(int)((_square3.getY()/Constants.SQUARE_SIDE))]= _square3;
			_squareArray[(int)((_square4.getX()/Constants.SQUARE_SIDE))][(int)((_square4.getY()/Constants.SQUARE_SIDE))]= _square4;

			_board.addPiece();
		}
	}

	public void rotatePiece(){ 

		/*This method is a bit more complicated than the previous one. it will still have to check the condition that the new location of
		 * the square is null, but instead of simply move the piece, the new location of each square will be determined by the following functions: 
		 * 		new XLocation = centerOfRotationX - centerOfRotationY + oldYLocation
		 * 		new YLocation = centerOfRotationY + centerOfRotationX - oldXLocation. 
		 * I assigned _square2 to always be the center of rotation. */

		double newXLocation1 = (_square2.getX())-(_square2.getY())+(_square1.getY()); 
		double newYLocation1 = (_square2.getY())+(_square2.getX())-(_square1.getX()); 
		double newXLocation2 = (_square2.getX())-(_square2.getY())+(_square2.getY()); 
		double newYLocation2 = (_square2.getY())+(_square2.getX())-(_square2.getX()); 
		double newXLocation3 = (_square2.getX())-(_square2.getY())+(_square3.getY()); 
		double newYLocation3 = (_square2.getY())+(_square2.getX())-(_square3.getX()); 
		double newXLocation4 = (_square2.getX())-(_square2.getY())+(_square4.getY()); 
		double newYLocation4 = (_square2.getY())+(_square2.getX())-(_square4.getX()); 

		int newX1 = (int)(newXLocation1/Constants.SQUARE_SIDE);
		int newX2 = (int)(newXLocation2/Constants.SQUARE_SIDE);
		int newX3 = (int)(newXLocation3/Constants.SQUARE_SIDE);
		int newX4 = (int)(newXLocation4/Constants.SQUARE_SIDE);
		int newY1 = (int)(newYLocation1/Constants.SQUARE_SIDE);
		int newY2 = (int)(newYLocation2/Constants.SQUARE_SIDE);
		int newY3 = (int)(newYLocation3/Constants.SQUARE_SIDE);
		int newY4 = (int)(newYLocation4/Constants.SQUARE_SIDE);

		if ((_squareArray[newX1][newY1]==null)&&(_squareArray[newX2][newY2]==null)&&(_squareArray[newX3][newY3]==null)&&(_squareArray[newX4][newY4]==null)){
			_square1.setLocation(newXLocation1, newYLocation1);
			_square2.setLocation(newXLocation2, newYLocation2);
			_square3.setLocation(newXLocation3, newYLocation3);
			_square4.setLocation(newXLocation4, newYLocation4);
		}
	}

	public void dropPiece(){ //This method is a quicker way of making you TetrisPiece reach its final location. Will move the PieceDown while the index of the new Position is null.  

		while(checkValidMove(0,1)){
			this.movePieceDown(); 
		}
	}

	public void setPieceColor(javafx.scene.paint.Color color){ //Method defined to facilitate setting the color of the Piece by the subclasses (by not having to set the color of each square).
		_square1.setFill(color);
		_square2.setFill(color);
		_square3.setFill(color);
		_square4.setFill(color);
	}

	public Square getSquare1(){
		return _square1;
	}

	public Square getSquare2(){
		return _square2;
	}

	public Square getSquare3(){
		return _square3;
	}

	public Square getSquare4(){
		return _square4;
	}
}
