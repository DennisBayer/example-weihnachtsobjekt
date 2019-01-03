package de.weihnachten;

import java.util.Arrays;

/**
 * Die Methode getNaechstesGeschenk() in der Klasse Schlitten nimmt das oberste Geschenk vom Schlitten
 * (Index 0) und gibt es zurück.
 *
 * Beachten Sie, dass durch das Entnehmen des Geschenks dieses aus dem Schlitten entfernt werden muss und
 * ggf. die restlichen Geschenke im Schlitten aufrutschen. getGewicht() gibt das Gesamtgewicht aller
 * Geschenke in kg zurück - der Schlitten selbst wiegt magischerweise nichts.
 *
 * kannFliegen() gibt an, ob die Rentiere ausreichen, um den Schlitten mit seinem aktuellen Geschenkgewicht
 * in die Luft zu bringen. n Rentiere sind in der Lage ein Geschenkgewicht von kg zu ziehen.
 *
 * istLeer() gibt an, ob alle Geschenke bereits vom Schlitten entnommen wurden.
 *
 * getAnzahlRentiere() bzw. getAnzahlGeschenke() liefern die aktuelle Anzahl an Rentieren bzw. Geschenken.
 *
 * getRentier(int index) gibt das Rentier an der spezifizierten Stelle zurück, wobei index zwischen 0 und
 * getAnzahlRentiere() liegen muss (beides inklusive).
 */
public class Schlitten extends WeihnachtsObjekt
{
	private Rentier[] rentiere;
	private Geschenk[] geschenke;

	public Schlitten(Rentier[] rentiere, Geschenk[] geschenke)
	{
		this.rentiere = rentiere;
		this.geschenke = geschenke;
	}

	public Geschenk getNaechstesGeschenk()
	{
		// Zugriff auf nächstes Geschenk soll immer über index 0 passieren (ein Stack wäre praktischer).

		// Oberstes Geschenk nehmen
		Geschenk naechstesGeschenk = this.geschenke[0];

		// Geschenke aufrutschen lassen
		for (int i = 0; i < this.geschenke.length - 1; i++)
		{
			this.geschenke[i] = this.geschenke[i + 1];
		}

		// "Letzes, doppeltes" Geschenk entfernen
		this.geschenke[this.geschenke.length - 1] = null;

		return naechstesGeschenk;

		// alternativ
		// ein neues Array mit length-1 erstellen, füllen und this.geschenke zuweisen
	}

	@Override
	public int getGewicht()
	{
		return Arrays.stream(this.geschenke).filter(g -> g != null).map(Geschenk::getGewicht).reduce(0,
			Integer::sum);

		//		// alternativ
		//		int gesamtGewicht = 0;
		//		for (Geschenk geschenk : geschenke)
		//		{
		//			if (geschenk != null)
		//			{
		//				gesamtGewicht += geschenk.getGewicht();
		//			}
		//		}
		//
		//		return gesamtGewicht;
	}

	public boolean kannFliegen()
	{
		return 100 * Math.sqrt(this.rentiere.length) >= getGewicht();
	}

	public boolean istLeer()
	{
		return getAnzahlGeschenke() <= 0;
	}

	public int getAnzahlRentiere()
	{
		return this.rentiere.length;
	}

	public int getAnzahlGeschenke()
	{
		return (int) Arrays.stream(this.geschenke).filter(g -> g != null).count();

		//		// alternativ
		//		int anzahlGeschenke = 0;
		//		for (Geschenk geschenk : this.geschenke)
		//		{
		//			if (geschenk != null)
		//			{
		//				anzahlGeschenke++;
		//			}
		//		}
		//
		//		return anzahlGeschenke > 0;
	}

	public Rentier getRentier(int index)
	{
		int anzahlRentiere = getAnzahlRentiere();

		if (index < 0 && index > anzahlRentiere)
		{
			System.out
				.printf("Index muss zwischen 0 und der Anzahl %d der" + " Rentiere sein!", anzahlRentiere - 1)
				.println();

			return null;
		}

		return this.rentiere[index];
	}
}
