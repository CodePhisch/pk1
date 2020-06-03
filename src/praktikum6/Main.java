package praktikum6;

public class Main {
	public static void main(String[] args) {
		Audio audio1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Bild bild1 = new Bild("Gebaeude FB Informatik", 2019, "Dortmund");
		
		Medienverwaltung mv = new Medienverwaltung();
		mv.aufnehmen(audio1);
		mv.aufnehmen(bild1);
		
		Menu menu = new Menu(mv);
		menu.zeigeMenu();
	}
}

