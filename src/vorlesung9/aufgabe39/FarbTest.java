package vorlesung9.aufgabe39;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FarbTest extends Application implements EventHandler<ActionEvent>{

	private Rectangle rect;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button("Farbenwechsel");
		btn.setOnAction(this);
		
		rect = new Rectangle(100, 100);
		rect.setFill(this.getRandomColor());
		
		BorderPane root = new BorderPane();
		
		BorderPane.setMargin(rect, new Insets(20));
		root.setCenter(rect);
		
		BorderPane.setAlignment(btn, Pos.CENTER);
		BorderPane.setMargin(btn, new Insets(20));
		root.setBottom(btn);
		
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setTitle("Farb-Test");
		primaryStage.setMinWidth(250);
		primaryStage.setMinHeight(250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		rect.setFill(this.getRandomColor());
	}
	
	private Color getRandomColor() {
		Random random = new Random();
		return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	}
	
	public static void main(String[] args) {
		launch();
	}
}
