package praktikum4;

import java.util.Objects;

public class Bild extends Medium {

	private String ort;
	
	public Bild(String titel, int jahr, String ort) {
		super(titel, jahr);
		
		this.ort = ort;
	}

	public String getOrt() {
		return ort;
	}
	
	@Override
	public void druckeDaten() {
		System.out.println("ID = " + this.getId() + 
				" \"" + this.getTitel() + 
				"\" aufgenommen im Jahr " + this.getJahr() + 
				" in " + ort); 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			Bild bild = (Bild) obj;
			return Objects.equals(ort, bild.getOrt());
		} 
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(ort);
	}
}

