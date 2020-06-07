package vorlesung9.aufgabe41;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Quadrat extends Application implements EventHandler<MouseEvent> {

	private Pane pane;
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		pane = new Pane();
		//pane.setOnMouseClicked(this);
		pane.setOnMousePressed(this);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quadrat");
		primaryStage.show();
	}
	
	@Override
	public void handle(MouseEvent event) {
		Rectangle rect = new Rectangle(event.getSceneX(), event.getSceneY(), 100, 100);
		rect.setFill(Color.BLUE);
		pane.getChildren().clear();
		pane.getChildren().add(rect);
	}
}
