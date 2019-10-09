package Tetris;

import javafx.scene.Scene;
import javafx.scene.layout.*; 
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;

import java.util.Date;

/**
 * It's time for Tetris! This is the  main class to get things started.
 * 
 * nipucel: The following two sentences should be changed/removed.
 *
 * The main method of this application calls the App constructor. You 
 * will need to fill in the constructor to instantiate your Tetris game.
 *
 * Class comments here...
 *
 * @author <your login here>
 *
 */


// nipucel: Should we extend Application for them, or let them do it themselves? 

public class App extends Application {

	public App() {
		// Constructor code goes here.
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		PaneOrganizer organizer = new PaneOrganizer();
		Scene scene = new Scene(organizer.getPane(), Constants.STAGE_WIDTH, Constants.STAGE_HEIGHT);
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("TETRIS");
		stage.show();
	} 
	
	/* nipucel: Deleted main line (not needed in FX applications). 
	   If we do include it, then we probably have to extend Application for them,
	   since mainlines in FX look as follows:*/
//
//	public static void main(String[] args) {
//		launch(args); // launch is a method inherited from Application
//	}
}
