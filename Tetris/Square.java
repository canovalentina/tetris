package Tetris;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle {
	
	public Square(){
		super();
		this.setWidth(Constants.SQUARE_SIDE);
		this.setHeight(Constants.SQUARE_SIDE);
		this.setFill(Color.GRAY);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(1);
	}
	
	public void setLocation(double x, double y){ 
		this.setX(x);
		this.setY(y);
	}
}
