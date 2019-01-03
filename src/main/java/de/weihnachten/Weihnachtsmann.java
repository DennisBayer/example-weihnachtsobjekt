package de.weihnachten;

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
			System.out.println(this.schlitten.getNaechstesGeschenk().asString());
		}
	}

	public void fuettern()
	{
		this.futtervorrat = this.futtervorrat - ermitteleAktuellenHunger();
	}
}
