package praktikum7;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class Bild extends Medium {

	private static final long serialVersionUID = 1L;
	
	private String ort;
	
	public Bild(String titel, int jahr, String ort) {
		super(titel, jahr);
		
		this.ort = ort;
	}

	public String getOrt() {
		return ort;
	}
	
	@Override
	public void druckeDaten(OutputStream os) {
		PrintStream ps = new PrintStream(os);
		ps.printf("ID = %d \"%s \" aufgenommen im Jahr %d in %s\n", this.getId(), this.getTitel(), this.getJahr(), this.getOrt());
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

