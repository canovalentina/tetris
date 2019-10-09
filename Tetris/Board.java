package Tetris;


import javafx.animation.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Board {

	private Pane _gamePane; 
	private Label _gameOverLabel;
	private Square[][] _squareArray;
	private PieceFactory _pieceFactory;
	private PieceProxy _proxy;
	private boolean _topRowFull, _paused;
	private Timeline _timeline; 

	public Board() {
		_gamePane = new Pane();
		_gamePane.setPrefSize(Constants.STAGE_WIDTH, Constants.STAGE_HEIGHT);
		_squareArray = new Square[Constants.NUM_COLUMNS][Constants.NUM_ROWS];
		_topRowFull=false;
		_paused = false;
		_pieceFactory = new PieceFactory(this);
		_proxy = new PieceProxy();
		_gameOverLabel = this.createGameOverLabel();

		for (int i = 0; i < Constants.NUM_COLUMNS; i++) {
			for (int j = 0; j < Constants.NUM_ROWS; j++){
				if (i>=2 && i<Constants.NUM_COLUMNS-2 && j>=2 && j<Constants.NUM_ROWS-2){
					_squareArray[i][j]= null;
				}
				else {
					_squareArray[i][j]= new Square();
					_gamePane.getChildren().add(_squareArray[i][j]); 
					_squareArray[i][j].setLocation(i*Constants.SQUARE_SIDE, j*Constants.SQUARE_SIDE);
				}
			}	
		}
		
		this.addPiece(); 
		_gamePane.getChildren().add(_gameOverLabel); 
		_timeline = setupAndReturnTimeline();
		_gamePane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyListener()); 
		_gamePane.setFocusTraversable(true);
		_gamePane.requestFocus();
	}

	public Pane getGamePane() {
		return _gamePane;
	}
	
	public Label createGameOverLabel(){
		Label label = new Label("GAME OVER"); 
		label.setLayoutX(140); 
		label.setLayoutY(10); 
		label.setVisible(false); 
		label.setTextFill(Color.RED); 
		return label; 
	}

	public Square[][] getSquareArray(){ 
		return _squareArray;
	}

	
	public void topRowFull(){ 

		for(int i = 2; i < Constants.NUM_COLUMNS-2; i++) { //For every column in the third row.
			if (_squareArray[i][2]==null){ 
				_topRowFull = false; //	If it is null, set boolean to false.
			}
			else {
				_topRowFull = true; 
				break; 
			}
		}
	}
	

	public void addPiece(){
		if (!_topRowFull){ 
			TetrisPiece newPiece = _pieceFactory.getTetrisPiece(); 
			
			//Adds to GamePane 
			_proxy.setPiece(newPiece);
			_gamePane.getChildren().addAll(_proxy.getSquare1(), _proxy.getSquare2(), _proxy.getSquare3(), _proxy.getSquare4()); 
			_proxy.setLocation(Constants.SQUARE_SIDE*(Constants.NUM_COLUMNS/2),Constants.SQUARE_SIDE*2);
		}
	}

	public void movePieceDown(){ 
		_proxy.moveDown();
	}

	public void clearCompletedLines(){
				
		for (int j = Constants.MAX_PLAYABLE_Y - 1; j >= Constants.MIN_PLAYABLE_Y; j--){
			boolean anyRowFull = true;
			for (int i = Constants.MIN_PLAYABLE_X; i < Constants.MAX_PLAYABLE_X; i++){
				if (_squareArray[i][j] == null){
					anyRowFull = false;	
				}
			}
			if (anyRowFull){
				//making all the squares in the full row null
				for (int i = Constants.MIN_PLAYABLE_X; i < Constants.MAX_PLAYABLE_X; i++){
					_gamePane.getChildren().remove(_squareArray[i][j]);
					_squareArray[i][j] = null;
				}
				for (int jj = j; jj > Constants.MIN_PLAYABLE_Y; jj--){
					for (int i = Constants.MIN_PLAYABLE_X; i < Constants.MAX_PLAYABLE_X; i++){
						_squareArray[i][2] = null;
						if (_squareArray[i][jj] != null){
							_squareArray[i][jj].setLocation(
									(int) _squareArray[i][jj].getX(),
									(int) _squareArray[i][jj].getY() + Constants.SQUARE_SIDE);
						}
						_squareArray[i][jj] = _squareArray[i][jj - 1];
					}
				}
				anyRowFull = false;
			}
		}
	}

		
	public void gameOver(){
		/*Method that takes care of the end of the game. If the top row contains any squares, stop the Timer
		 * and make the JLabel that states that the game is over appear. */
		if (_topRowFull== true){ 
			//			_timer.stop(); 
			_gameOverLabel.setVisible(true);
		}
	} 

	public Timeline setupAndReturnTimeline() {
		KeyFrame kf = new KeyFrame(Duration.seconds(0.70), new TimeHandler());
		Timeline timeline = new Timeline(kf);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		return timeline; 
	}

	private class TimeHandler implements EventHandler<ActionEvent>{

		public void handle(ActionEvent event) {
			clearCompletedLines();
			movePieceDown(); 
			clearCompletedLines();
			topRowFull();
			gameOver();
		}
	}

	private class KeyListener implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent e) {
			KeyCode key = e.getCode();

			if (key == KeyCode.RIGHT){ //Right arrow: moves piece right. 
				_proxy.moveRight();
			}

			if (key == KeyCode.LEFT){ //Left arrow: moves piece left. 
				_proxy.moveLeft();
			}

			if (key == KeyCode.DOWN){ //Down arrow: moves piece down. 
				_proxy.moveDown();
			}

			if (key == KeyCode.UP){ //Up arrow: rotates piece. 
				_proxy.rotatePiece();
			}

			if (key == KeyCode.SPACE){ //Space bar: drops piece. 
				_proxy.dropPiece();
			}

			if (key == KeyCode.P){ //"p": pauses and unpauses game. 
				if (!_paused) {
					_paused = true;
					_timeline.pause();
				} else {
					_paused = false;
					_timeline.play();
				}
				//_gamePane.setPauseStatus(_paused);
			}
			e.consume();
		}
	}
	
	
}
