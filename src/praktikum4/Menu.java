package praktikum4;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	private Medienverwaltung mv;
	
	public Menu(Medienverwaltung mv) {
		this.mv = mv;
	}
	
	public void zeigeMenu() {
		Scanner sc = new Scanner(System.in);
		int auswahl = 0;
		
		while(auswahl != 6) {
			System.out.println("Medienverwaltung\r\n" + 
					"1. Audio aufnehmen\r\n" + 
					"2. Bild aufnehmen\r\n" + 
					"3. Zeige alle Medien\r\n" + 
					"4. Zeige neues Medium\r\n" + 
					"5. Berechne durchschnittliches Erscheinungsjahr\r\n" + 
					"6. Beenden\r\n" + 
					"Bitte Menuepunkt waehlen:");
			try {
				auswahl = sc.nextInt();
			} catch(Exception e) {
				auswahl = 0;
				sc.next();
			}
			
			switch(auswahl) {
				case 1: 
					readAudio();
					System.out.println("Neues Audio-Medium aufgenommen!");
					break;
				case 2: 
					readBild();
					System.out.println("Neues Bild-Medium aufgenommen!");
					break;
				case 3: 
					mv.zeigeMedien();
					break;
				case 4:
					mv.sucheNeuesMedium();
					break;
				case 5: 
					System.out.println("Durchschnittliches Erscheinungsjahr: " + mv.berechneErscheinungsjahr());
					break;
				case 6: 
					System.out.println("Programm beendet!");
					break;
				default: 
					System.out.println("Bitte g�ltigen Men�punkt ausw�hlen. [1-6]");
			}
		}
		
		sc.close();
	}
	
	private void readAudio() {
		try {
			String titel = readStringSafe("Titel");
			int jahr = readIntSafe("Jahr");
			String interpret = readStringSafe("Interpret");
			int dauer = readIntSafe("Dauer");
			mv.aufnehmen(new Audio(titel, jahr, interpret, dauer));
		} catch(AbbruchException e) {
			JOptionPane.showMessageDialog(null,"Die Aufnahme des Audio-Mediums wurde abgebrochen.");
		}
	}
	
	private void readBild() {
		try {
			String titel = readStringSafe("Titel");
			int jahr = readIntSafe("Jahr");
			String ort = readStringSafe("Ort");
			mv.aufnehmen(new Bild(titel, jahr, ort));
		} catch(AbbruchException e) {
			JOptionPane.showMessageDialog(null,"Die Aufnahme des Bildes wurde abgebrochen.");
		}
	}
	
	private String readStringSafe(String name) throws AbbruchException {
		String s = null;
		while(s == null) {
			try {
				s = JOptionPane.showInputDialog(name);
				if(s == null) throw new AbbruchException("Eingabe bei " + name + " abgebrochen.");
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Fehler beim Einlesen von: " + name);
			}
		}
		
		return s;
	}
	
	private int readIntSafe(String name) throws AbbruchException {
		int i = 0;
		boolean ok = false;
		
		while(ok == false) {
			try {
				String s = JOptionPane.showInputDialog(name);
				if(s == null) throw new AbbruchException("Eingabe bei " + name + " abgebrochen.");
				i = Integer.parseInt(s);
				ok = true;
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Bitte g�ltigen Wert f�r " + name + " eingeben.");
			}
		}
		
		return i;
	}
	
}