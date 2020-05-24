package praktikum5;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class Audio extends Medium {

	private String interpret;
	private int dauer;
	
	public Audio(String titel, int jahr, String interpret, int dauer) {
		super(titel, jahr);
		
		this.interpret = interpret;
		this.dauer = dauer;
	}

	public String getInterpret() {
		return interpret;
	}

	public int getDauer() {
		return dauer;
	}

	@Override
	public void druckeDaten(OutputStream os) {
		PrintStream ps = new PrintStream(os);
		ps.printf("ID = %d \"%s \" von %s aus %d Spieldauer: %d sek.\n", this.getId(), this.getTitel(), this.getInterpret(), this.getJahr(), this.getDauer());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			Audio audio = (Audio) obj;
			return Objects.equals(interpret, audio.getInterpret())
					&& Objects.equals(dauer, audio.getDauer());
		} 
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(interpret, dauer);
	}
}
