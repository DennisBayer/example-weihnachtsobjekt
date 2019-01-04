package de.weihnachten;

import java.util.Scanner;

/**
 * Auch wenn im Diagramm nicht dargestellt, sollen alle Klassen öffentlich (public) sichtbar sein.
 *
 * Alle Klassen liegen im Paket de.weihnachten.
 *
 * Für diese Aufgabe genügt es, wenn die Methoden/Konstruktoren der Klassen, wie bislang in der Vorlesung,
 * keine Sichtbarkeit haben – public ist aber auch möglich.
 *
 * Attribute müssen private sein.
 *
 * Jede Klasse hat eine main-Methode, die die jeweilige Klasse demonstriert/testet.
 *
 * Jede Methode ist geeignet dokumentiert, insbesondere durch eine Zeile über dem Methodenkopf, in der die
 * Methode kurz beschrieben wird.
 *
 * Methoden die Attribute verändern werden nicht benötigt – die Konstruktoren genügen.
 *
 * Weitere Hilfsmethoden zum Berechnen von Werten, z.B., dem aktuellen Hunger aller Rentiere am Schlitten
 * können angelegt werden.
 *
 * Alle Methoden im Hauptprogramm müssen wie bisher üblich static sein. In den Klassen sind nur die
 * test-Methoden static. Alle andere Methoden sind nicht static.
 */
public class Weihnachten
{
	public static void main(String[] args)
	{
		int anzahlDerRentiere;
		int anzahlDerGeschenke;
		int futtermenge;
		try (Scanner scanner = new java.util.Scanner(System.in))
		{
			anzahlDerRentiere = 4;//ermitteleAnzahlDerRentiere(scanner);
			anzahlDerGeschenke = 15;//ermittleAnzahlDerGeschenke(scanner);
			futtermenge = 130;//ermittleFuttermenge(scanner);
		}

		Rentier[] rentiere = erstelleRentiere(anzahlDerRentiere);
		Geschenk[] geschenke = erstelleGeschenke(anzahlDerGeschenke);
		Schlitten schlitten = new Schlitten(rentiere, geschenke);

		Weihnachtsmann weihnachtsmann = new Weihnachtsmann(futtermenge, schlitten);

		if (schlitten.kannFliegen())
		{
			System.out
				.printf(
					"Wir starten Weihnachten mit %d Geschenken, %d Rentier(en) und einem Schlitten mit %d kg.",
					schlitten.getAnzahlGeschenke(), schlitten.getAnzahlRentiere(), schlitten.getGewicht())
				.println();
		}
		else
		{
			System.out.println("Eingabe fehlerhaft! Rentiere können nicht losfliegen! Programmende!");
			System.exit(1);
		}

		stelleRentiereVor(schlitten);

		System.out.println("Die Tour beginnt:");

		while (!schlitten.istLeer())
		{
			weihnachtsmann.naechstesGeschenkAusliefern();

			if (weihnachtsmann.kannNochFuettern())
			{
				weihnachtsmann.fuettern();
			}
			else
			{
				System.out.println("Der Futtervorrat reicht nicht aus! Programmende!");
				System.exit(1);
			}
		}

		System.out.println("Der Weihnachtsmann ist fertig mit der Auslieferung. Schöne Weihnachten.");
		System.exit(0);
	}

	private static void stelleRentiereVor(Schlitten schlitten)
	{
		System.out.println("Die Rentiere sind:");

		for (int i = 0; i < schlitten.getAnzahlRentiere(); i++)
		{
			System.out.println(schlitten.getRentier(i).asString());
		}
	}

	private static int ermitteleAnzahlDerRentiere(Scanner scanner)
	{
		return leseKonsoleneingabe("Bitte geben Sie die Anzahl der Rentiere ein: ", scanner);
	}

	private static int ermittleAnzahlDerGeschenke(Scanner scanner)
	{
		return leseKonsoleneingabe("Bitte geben Sie die Anzahl der Geschenke ein: ", scanner);
	}

	private static int ermittleFuttermenge(Scanner scanner)
	{
		return leseKonsoleneingabe("Bitte geben Sie den Futtervorrat in kg ein: ", scanner);
	}

	private static int leseKonsoleneingabe(String aufforderung, Scanner scanner)
	{
		int eingabe;
		do
		{
			System.out.println(aufforderung);
			eingabe = scanner.nextInt();
		}
		while (eingabe <= 0);

		return eingabe;
	}

	private static Rentier[] erstelleRentiere(int anzahlDerRentiere)
	{
		Rentier[] rentiere = new Rentier[anzahlDerRentiere];
		for (int i = 0; i < anzahlDerRentiere; i++)
		{
			rentiere[i] = new Rentier();
		}

		return rentiere;
	}

	private static Geschenk[] erstelleGeschenke(int anzahlDerGeschenke)
	{
		Geschenk[] geschenke = new Geschenk[anzahlDerGeschenke];
		for (int i = 0; i < anzahlDerGeschenke; i++)
		{
			geschenke[i] = new Geschenk();
		}

		return geschenke;
	}
}
