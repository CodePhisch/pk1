package praktikum6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class Medienverwaltung {
	private List<Medium> medien;
	
	public Medienverwaltung() {
		medien = new ArrayList<Medium>();
	}
	
	public void aufnehmen(Medium medium) {
		medien.add(medium);
	}
	
	public void zeigeMedien() {
		Collections.sort(medien);
		OutputStream os = new PrintStream(System.out);
		System.out.println("--- Alle Medien ---");
		for(Medium m : medien) {
			m.druckeDaten(os);
		}
		System.out.println("--- ----------- ---");
	}
	
	public void sucheNeuesMedium() {
		Collections.sort(medien);
		OutputStream os = new PrintStream(System.out);
		System.out.println("--- Neuestes Medium ---");
		medien.get(medien.size() - 1).druckeDaten(os);
		System.out.println("--- --------------- ---");
	}
	
	public double berechneErscheinungsjahr() {
		int summe = 0;
		
		for(Medium m : medien) {
			summe += m.getJahr();
		}
		
		if(medien.size() > 0) {
			return (double) summe / medien.size();
		} else {
			return 0.0;
		}
	}
	
	public void writeListToFile() {
		Collections.sort(medien);
		File file;
		boolean validFile = false;
		
		do {
			try {
				file = readFile();
				if(file != null) {
					try {
						OutputStream os = new FileOutputStream(file);
						for(Medium m : medien) {
							m.druckeDaten(os);
						}
						return;
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Fehler beim Dateizugriff!");
				}
			} catch (EmptyFilenameException e) {
				int auswahl = JOptionPane.showConfirmDialog(null, "Der Dateiname darf nicht leer sein! Neuen eingeben?", "Fehlerhafte Eingabe", JOptionPane.YES_NO_OPTION);
				if(auswahl == 1) {
					System.out.println("Eingabe abgebrochen wegen leerem Dateipfad.");
					return;
				}
			} catch (AbbruchException e) {
				System.out.println("Eingabe des Dateinamens abgebrochen.");
				return;
			} 
		} while(!validFile);
		
	}
	
	public File readFile() throws EmptyFilenameException, AbbruchException {
		String path = JOptionPane.showInputDialog("Bitte geben Sie den Dateipfad ein");
		
		if(path == null) throw new AbbruchException("Eingabe des Dateinamens abgebrochen.");
		if(path.isEmpty()) throw new EmptyFilenameException("Leerer Dateiname");
		
		File file = new File(path);
		if(file.isFile()) return file;
		return null;
	}
	
	public void speichern() {
		File saveFile = new File(".\\media.ser");
		
		try {
			FileOutputStream fos = new FileOutputStream(saveFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(medien);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println(ioe.getMessage());
			return;
		} 
		
		System.out.println("Medien erfolgreich in Datei gespeichert.");
	}
	
	@SuppressWarnings("unchecked")
	public void laden() {
		File saveFile = new File(".\\media.ser");
		
		try {
			FileInputStream fis = new FileInputStream(saveFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			medien = (List<Medium>) ois.readObject();
			Medium.anzahlMedien = medien.size();
			
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return;
		} 
		
		System.out.println("Medien erfolgreich aus Datei geladen.");
	}
}