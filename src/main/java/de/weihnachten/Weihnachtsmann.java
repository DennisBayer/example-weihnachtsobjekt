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
		// (Oder return this.schlitten.istLeer();)
		boolean geschenkeAusgeliefert = false;
		if (this.schlitten.istLeer())
		{
			return true;
		}
		return geschenkeAusgeliefert;
	}

	public boolean kannNochFuettern()
	{
		double gesamtHunger = 0;
		Geschenk naechstGeschenk = this.schlitten.getNaechstesGeschenk();

		for (int i = 0; i < this.schlitten.getAnzahlRentiere(); i++)
		{
			gesamtHunger += this.schlitten.getRentier(i).getHunger(naechstGeschenk.getGewicht());
		}

		return this.futtervorrat > gesamtHunger;
	}

	public void naechstesGeschenkAusliefern()
	{
		if (this.schlitten.istLeer())
		{
			System.out
				.println("Der Weihnachtsmann ist fertig mit der " + "Auslieferung. Schöne Weihnachten.");
		}
		else
		{
			System.out.println(this.schlitten.getNaechstesGeschenk().asString());
		}
	}

	public void fuettern()
	{
		for (int i = 0; i < this.schlitten.getAnzahlRentiere(); i++)
		{
			this.futtervorrat -= this.schlitten.getRentier(i).getHunger();
		}
	}
}
