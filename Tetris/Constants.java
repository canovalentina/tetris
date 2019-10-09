package Tetris;

public class Constants {
	
	public static final int SQUARE_SIDE = 26; 
	public static final int NUM_ROWS = 22; 
	public static final int NUM_COLUMNS = 14; 
	public static final int STAGE_WIDTH = (Constants.SQUARE_SIDE*Constants.NUM_COLUMNS); 
	public static final int STAGE_HEIGHT = (Constants.SQUARE_SIDE*Constants.NUM_ROWS); 
	
	public static final int MIN_PLAYABLE_X = 2;
	public static final int MIN_PLAYABLE_Y = 2;
	public static final int MAX_PLAYABLE_X = Constants.NUM_COLUMNS - 2;
	public static final int MAX_PLAYABLE_Y = Constants.NUM_ROWS - 2; 
}
