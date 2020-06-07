module pk1 {
	exports praktikum1;
	exports praktikum2;
	exports praktikum3;
	exports praktikum4;
	exports praktikum5;
	exports praktikum6;
	exports praktikum7;
	exports praktikum7.exceptions;

	requires java.desktop;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	
	opens praktikum7 to javafx.controls, javafx.base, javafx.graphics;
	opens praktikum8.gui to javafx.controls, javafx.base, javafx.graphics;
	opens vorlesung9.aufgabe38 to javafx.controls, javafx.base, javafx.graphics;
	opens vorlesung9.aufgabe39 to javafx.controls, javafx.base, javafx.graphics;
	opens vorlesung9.aufgabe41 to javafx.controls, javafx.base, javafx.graphics;
}