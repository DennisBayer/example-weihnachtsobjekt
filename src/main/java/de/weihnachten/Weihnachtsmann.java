package de.weihnachten;

/**
 * Der Weihnachtsmann – Eigenname, daher gegen alle Konventionen kein großes „M“ – ist zwar ein WeihnachtsObjekt
 * aber kein GewichtigesWeihnachtsObjekt, da er glaubt nichts zu wiegen (hat also ein Gewicht von 0),
 * denn sonst macht er sich nicht auf die Reise und es gibt keine Geschenke.
 *
 * Aus magischen Gründen können weder der Weihnachtsmann, die Rentiere noch die Geschenke mit anderen
 * Weihnachtsobjekten kollidieren
 *
 * istFertig() in der Klasse Weihnachtsmann gibt an, ob alle Geschenke vom Schlitten ausgeliefert wurden.
 *
 * Die Methode kannNochFuettern() gibt an, ob der aktuelle Futtervorrat ausreicht, um den Hunger seiner
 * Rentiere zu stillen.
 *
 * Die Methode naechstesGeschenkAusliefern() gibt das nächste auszuliefernde Geschenk auf der Konsole aus,
 * sofern der Schlitten noch nicht leer ist.
 *
 * Die Methode fuettern() verringert den Futtervorrat des Weihnachtsmanns um die Menge, die seine Rentiere
 * einmalig fressen.
 */
public class Weihnachtsmann extends WeihnachtsObjekt
{
	private double futtervorrat;
	private Schlitten schlitten;

	public Weihnachtsmann(double futtervorrat, Schlitten schlitten)
	{
		this.futtervorrat = futtervorrat;
		this.schlitten = schlitten;
	}

	public boolean istFertig()
	{
		return this.schlitten.istLeer();
	}

	public boolean kannNochFuettern()
	{
		return this.futtervorrat >= ermitteleAktuellenHunger();
	}

	private double ermitteleAktuellenHunger()
	{
		int anzahlRentiere = this.schlitten.getAnzahlRentiere();
		int gewicht = this.schlitten.getGewicht();

		double gesamtHunger = 0;
		for (int i = 0; i < anzahlRentiere; i++)
		{
			gesamtHunger += this.schlitten.getRentier(i).getHunger(gewicht);
		}

		return gesamtHunger;
	}

	public void naechstesGeschenkAusliefern()
	{
		if (this.schlitten.istLeer())
		{
			System.out.println("Der Weihnachtsmann ist fertig mit der Auslieferung. Schöne Weihnachten.");
		}
		else
		{
			System.out.println(
				" - Der Weihnachtsmann liefert aus: " + this.schlitten.getNaechstesGeschenk().asString());
		}
	}

	public void fuettern()
	{
		this.futtervorrat = this.futtervorrat - ermitteleAktuellenHunger();
	}
}
