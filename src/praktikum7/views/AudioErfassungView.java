package praktikum7.views;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import praktikum7.Audio;

@SuppressWarnings("unused")
public class AudioErfassungView extends Stage {

	
	private Audio audio;
	
	public AudioErfassungView(Audio audio, Stage mainStage) {
		this.audio = audio;
		this.initOwner(mainStage);
		this.initModality(Modality.WINDOW_MODAL);
		this.setTitle("Audioerfassung");
	}
	
	public void showView() {
		// Controls erzeugen
		Label labelTitel = new Label("Titel:");
		Label labelInterpret = new Label("Ort:");
		Label labelJahr = new Label("Jahr:");
		Label labelDauer = new Label("Dauer:");
		
		TextField inputTitel = new TextField();
		inputTitel.setMinWidth(200);
		TextField inputInterpret = new TextField();
		inputInterpret.setMinWidth(200);
		TextField inputJahr = new TextField();
		inputJahr.setMinWidth(200);
		TextField inputDauer = new TextField();
		inputDauer.setMinWidth(200);
		
		Button btnNeu = new Button("Neu");
		Button btnAbbruch = new Button("Abbruch");
		
		// Controls anordnen
		BorderPane bp = new BorderPane();
		
		GridPane gp = new GridPane();
		gp.setHgap(10.0);
		gp.setVgap(10.0);
		gp.setPadding(new Insets(10.0));
		
		gp.add(labelTitel, 0, 0);
		gp.add(labelInterpret, 0, 1);
		gp.add(labelJahr, 0, 2);
		gp.add(labelDauer, 0, 3);
		GridPane.setHalignment(labelTitel, HPos.RIGHT);
		GridPane.setHalignment(labelInterpret, HPos.RIGHT);
		GridPane.setHalignment(labelJahr, HPos.RIGHT);
		GridPane.setHalignment(labelDauer, HPos.RIGHT);
		
		gp.add(inputTitel, 1, 0);
		gp.add(inputInterpret, 1, 1);
		gp.add(inputJahr, 1, 2);
		gp.add(inputDauer, 1, 3);
		
		gp.setAlignment(Pos.CENTER);
		bp.setCenter(gp);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(btnNeu, btnAbbruch);
		hbox.setAlignment(Pos.CENTER);
		HBox.setMargin(btnNeu, new Insets(10.0));
		HBox.setMargin(btnAbbruch, new Insets(10.0));
		bp.setBottom(hbox);
		
		// Anzeigen
		this.setScene(new Scene(bp));
		this.show();
	}
}
