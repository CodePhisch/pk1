package praktikum4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medienverwaltung {
	private List<Medium> medien;
	
	public Medienverwaltung() {
		medien = new ArrayList<Medium>();
	}
	
	public void aufnehmen(Medium medium) {
		medien.add(medium);
	}
	
	public void zeigeMedien() {
		System.out.println("--- Alle Medien ---");
		Collections.sort(medien);
        
		for(Medium m : medien) {
			m.druckeDaten();
		}
		System.out.println("--- ----------- ---");
	}
	
	public void sucheNeuesMedium() {
		Collections.sort(medien);
		
		System.out.println("--- Neuestes Medium ---");
		medien.get(medien.size() - 1).druckeDaten();
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
}