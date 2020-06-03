package praktikum7;

import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium implements Comparable<Medium>, Serializable {

	private static final long serialVersionUID = 1L;

	public static int anzahlMedien = 0;
	
	private int id;
	private String titel;
	private int jahr;
	
	public Medium(String titel, int jahr) {
		this.titel = titel;
		this.jahr = jahr;
		
		id = anzahlMedien++;
	}
	
	public int alter() {
		int aktuellesJahr = LocalDate.now().getYear();
		return aktuellesJahr - jahr;
	}
	
	public int getId() {
		return id;
	}

	public String getTitel() {
		return titel;
	}

	public int getJahr() {
		return jahr;
	}

	public abstract void druckeDaten(OutputStream os);
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Medium medium = (Medium) obj;
		
		if(!(Objects.equals(this.getTitel(), medium.getTitel())
				&& Objects.equals(this.getJahr(), medium.getJahr())))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titel, jahr);
	}
	
	@Override
	public int compareTo(Medium m) {
		return Integer.compare(this.jahr, m.getJahr());
	}
}
