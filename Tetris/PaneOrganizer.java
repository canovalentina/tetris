package Tetris;

import javafx.scene.layout.*;

public class PaneOrganizer {
	
	private Pane _root; 

	public PaneOrganizer() {
		_root = new HBox(); 
		 Board board = new Board(); 
		 Pane gamePane = board.getGamePane(); 
		 _root.getChildren().add(gamePane); 
	}
	
	public Pane getPane(){
		return _root; 
	}
}
