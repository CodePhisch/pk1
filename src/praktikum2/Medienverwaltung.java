package praktikum2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Medienverwaltung {
	private List<Medium> medien = new ArrayList<Medium>();
	
	public void aufnehmen(Medium medium) {
		medien.add(medium);
	}
	
	public void zeigeMedien() {
		System.out.println("--- Medienverwaltung ---");
		Iterator<Medium> it = medien.iterator();
        while(it.hasNext())
        {
            it.next().druckeDaten();
        }
	}
	
	public void sucheNeuesMedium() {
		Collections.sort(medien);
		
		System.out.println("--- Neuestes Medium ---");
		medien.get(0).druckeDaten();
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