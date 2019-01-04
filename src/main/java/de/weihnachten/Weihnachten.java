package de.weihnachten;

import java.util.Scanner;
import java.util.Stack;

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
			futtermenge = 140;//ermittleFuttermenge(scanner);
		}

		Rentier[] rentiere = erstelleRentiere(anzahlDerRentiere);
		Geschenk[] geschenke = erstelleGeschenke(anzahlDerGeschenke);
		Schlitten schlitten = new Schlitten(rentiere, geschenke);

		Weihnachtsmann weihnachtsmann = new Weihnachtsmann(futtermenge, schlitten);

		boolean schlittenZuSchwer = !schlitten.kannFliegen();
		boolean flugbahnBehindert = flugbahnBehindert();
		if (schlittenZuSchwer || flugbahnBehindert)
		{
			System.out.printf(
				"Der Schlitten kann nicht fliegen: zu schwer [%b], Flugbahn behindert [%b]. Programmende!",
				schlittenZuSchwer, flugbahnBehindert).println();
			System.exit(1);
		}
		else
		{
			System.out
				.printf(
					"Wir starten Weihnachten mit %d Geschenken, %d Rentier(en) und einem Schlitten mit %d kg.",
					schlitten.getAnzahlGeschenke(), schlitten.getAnzahlRentiere(), schlitten.getGewicht())
				.println();
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
				System.out.println("Der Futtervorrat reicht nicht aus. Programmende!");
				System.exit(1);
			}
		}

		System.out.println("Der Weihnachtsmann ist fertig mit der Auslieferung. Schöne Weihnachten.");
		System.exit(0);
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

		rentiere[0] = new Rudolph();
		for (int i = 1; i < anzahlDerRentiere; i++)
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

	private static boolean flugbahnBehindert()
	{
		WeihnachtsObjekt[][] flugplan = erstelleFlugplan();

		for (int i = 0, j = 0; i < flugplan.length; i++, j++)
		{
			WeihnachtsObjekt hindernis = flugplan[i][j];
			if (hindernis != null && hindernis.kannKollidieren())
			{
				return true;
			}
		}

		return false;
	}

	private static WeihnachtsObjekt[][] erstelleFlugplan()
	{
		WeihnachtsObjekt[][] flugplan = new WeihnachtsObjekt[30][30];

		// Erstelle Hindernisse
		int anzahlDerHindernisse = XMasUtils.getZufallsGanzzahl(10, 50);
		Stack<WeihnachtsObjekt> hindernisse = new Stack<>();
		for (int i = 0; i < anzahlDerHindernisse; i++)
		{
			hindernisse.push(new Tannenbaum());
		}

		// Platziere Hindernisse
		int breite = flugplan.length;
		int hoehe = flugplan[0].length;

		while (!hindernisse.isEmpty())
		{
			int zufallsBreite = XMasUtils.getZufallsGanzzahl(0, breite - 1);
			int zufallsHoehe = XMasUtils.getZufallsGanzzahl(0, hoehe - 1);

			if (flugplan[zufallsBreite][zufallsHoehe] == null)
			{
				flugplan[zufallsBreite][zufallsHoehe] = hindernisse.pop();
			}
		}

		return flugplan;
	}

	private static void stelleRentiereVor(Schlitten schlitten)
	{
		System.out.println("Die Rentiere sind:");

		for (int i = 0; i < schlitten.getAnzahlRentiere(); i++)
		{
			System.out.println(schlitten.getRentier(i).asString());
		}
	}
}
