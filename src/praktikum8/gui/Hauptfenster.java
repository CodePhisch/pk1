package praktikum8.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import praktikum8.fachlogik.Audio;
import praktikum8.fachlogik.Bild;

public class Hauptfenster extends Application {
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		// Testobjekte erzeugen
		Audio testAudio = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Bild testBild = new Bild("Gebaeude FB Informatik", 2019, "Dortmund");
		
		// Menü erzeugen
		MenuBar menuBar = new MenuBar();
		
		Menu menuDatei = new Menu("Datei");
		MenuItem dateiLaden = new MenuItem("Laden");
		MenuItem dateiSpeichern = new MenuItem("Speichern");
		MenuItem dateiListeInDatei = new MenuItem("Medienliste in Datei");
		MenuItem dateiBeenden = new MenuItem("Beenden");
		menuDatei.getItems().addAll(dateiLaden, dateiSpeichern, dateiListeInDatei, dateiBeenden);
		
		Menu menuMedium = new Menu("Medium");
		MenuItem mediumAudioNeu = new MenuItem("Audio neu");
		MenuItem mediumBildNeu = new MenuItem("Bild neu");
		menuMedium.getItems().addAll(mediumAudioNeu, mediumBildNeu);
		
		Menu menuAnzeige = new Menu("Anzeige");
		MenuItem anzeigeJahr = new MenuItem("Erscheinungsjahr");
		MenuItem anzeigeNeuestes = new MenuItem("Neuestes Medium");
		menuAnzeige.getItems().addAll(anzeigeJahr, anzeigeNeuestes);
		
		menuBar.getMenus().addAll(menuDatei, menuMedium, menuAnzeige);
		
		// Layout
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar);
		Scene scene = new Scene(bp);
		
		// Fenster anzeigen
		mainStage.setTitle("Medienverwaltung");
		mainStage.setWidth(800);
		mainStage.setHeight(450);
		mainStage.setScene(scene);
		mainStage.show();
		
		// Testfenster für Audio und Bild
		AudioErfassungView aev = new AudioErfassungView(testAudio, mainStage);
		aev.showView();
		
		BildErfassungView bev = new BildErfassungView(testBild, mainStage);
		bev.showView();
	}
}

