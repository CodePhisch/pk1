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
import praktikum7.Bild;

@SuppressWarnings("unused")
public class BildErfassungView extends Stage {

	
	private Bild bild;
	
	public BildErfassungView(Bild bild, Stage mainStage) {
		this.bild = bild;
		this.initOwner(mainStage);
		this.initModality(Modality.WINDOW_MODAL);
		this.setTitle("Bilderfassung");
	}
	
	public void showView() {
		// Controls erzeugen
		Label labelTitel = new Label("Titel:");
		Label labelOrt = new Label("Ort:");
		Label labelJahr = new Label("Aufnahmejahr:");
		
		TextField inputTitel = new TextField();
		inputTitel.setMinWidth(200);
		TextField inputOrt = new TextField();
		inputOrt.setMinWidth(200);
		TextField inputJahr = new TextField();
		inputJahr.setMinWidth(200);
		
		Button btnNeu = new Button("Neu");
		Button btnAbbruch = new Button("Abbruch");
		
		// Controls anordnen
		BorderPane bp = new BorderPane();
		
		GridPane gp = new GridPane();
		gp.setHgap(10.0);
		gp.setVgap(10.0);
		gp.setPadding(new Insets(10.0));
		
		gp.add(labelTitel, 0, 0);
		gp.add(labelOrt, 0, 1);
		gp.add(labelJahr, 0, 2);
		GridPane.setHalignment(labelTitel, HPos.RIGHT);
		GridPane.setHalignment(labelOrt, HPos.RIGHT);
		GridPane.setHalignment(labelJahr, HPos.RIGHT);
		
		gp.add(inputTitel, 1, 0);
		gp.add(inputOrt, 1, 1);
		gp.add(inputJahr, 1, 2);
		
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
