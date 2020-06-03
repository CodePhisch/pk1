package praktikum7;

import javafx.application.Application;
import javafx.stage.Stage;
import praktikum7.views.AudioErfassungView;
import praktikum7.views.BildErfassungView;

public class Main extends Application {
	
	/*
	public static void main(String[] args) {
		Audio audio1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Bild bild1 = new Bild("Gebaeude FB Informatik", 2019, "Dortmund");
		
		Medienverwaltung mv = new Medienverwaltung();
		mv.aufnehmen(audio1);
		mv.aufnehmen(bild1);
		
		Menu menu = new Menu(mv);
		menu.zeigeMenu();
	}
	*/
	
	public static void main(String[] args) {
		launch();
	}

	@SuppressWarnings("exports")
	@Override
	public void start(Stage mainStage) throws Exception {
		Audio testAudio = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Bild testBild = new Bild("Gebaeude FB Informatik", 2019, "Dortmund");
		
		mainStage.setTitle("Medienverwaltung");
		mainStage.setWidth(800);
		mainStage.setHeight(450);
		mainStage.show();
		
		AudioErfassungView aev = new AudioErfassungView(testAudio, mainStage);
		aev.showView();
		
		BildErfassungView bev = new BildErfassungView(testBild, mainStage);
		bev.showView();
	}
}

