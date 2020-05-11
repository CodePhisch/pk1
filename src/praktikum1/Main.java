package praktikum1;

public class Main {
	public static void main(String[] args) {
		Audio audio1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Bild bild1 = new Bild("Gebaeude FB Informatik", 2019, "Dortmund");
		
		audio1.druckeDaten();
		bild1.druckeDaten();
		
		System.out.println("\"" + audio1.getTitel() + "\" ist " + audio1.alter() + " Jahre alt");
		
		Audio audio2 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		if(audio1.equals(audio2)) {
			System.out.println("Die Objekte mit Id " + audio1.getId() + " und Id " + audio2.getId() + " sind (fachlich) gleich");
			System.out.println("Die gleichen Objekte haben den Hashcode " + audio1.hashCode());
		}
		
		if(!audio1.equals(bild1)) {
			System.out.println("Die Objekte mit Id " + audio1.getId() + " und Id " + bild1.getId() + " sind nicht gleich");
			System.out.println("Die unterschiedlichen Objekte haben die Hashcodes " + audio1.hashCode() + " und " + bild1.hashCode());
		}
	}
}