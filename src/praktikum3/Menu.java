package praktikum3;

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
			
			String titel, interpret, ort;
			int jahr, dauer;
			auswahl = sc.nextInt();
			switch(auswahl) {
				case 1: 
					titel = JOptionPane.showInputDialog("Titel");
					jahr = Integer.parseInt(JOptionPane.showInputDialog("Jahr"));
					interpret = JOptionPane.showInputDialog("Interpret");
					dauer = Integer.parseInt(JOptionPane.showInputDialog("Dauer"));
					mv.aufnehmen(new Audio(titel, jahr, interpret, dauer));
					System.out.println("Neues Audio-Medium aufgenommen!");
					break;
				case 2: 
					titel = JOptionPane.showInputDialog("Titel");
					jahr = Integer.parseInt(JOptionPane.showInputDialog("Jahr"));
					ort = JOptionPane.showInputDialog("Ort");
					mv.aufnehmen(new Bild(titel, jahr, ort));
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
			}
		}
		
		sc.close();
	}
}
