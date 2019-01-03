package de.weihnachten;

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
		Geschenk[] temp = new Geschenk[this.geschenke.length];

		temp[0] = this.geschenke[0];

		for (int i = 1; i < temp.length; i++)
		{
			temp[i] = this.geschenke[i];
		}
		for (int i = 0; i < temp.length; i++)
		{
			this.geschenke[i] = temp[i];
		}

		return temp[0];
	}

	@Override
	public int getGewicht()
	{
		int gGewicht = 0;
		for (int i = 0; i < this.geschenke.length; i++)
		{
			gGewicht += this.geschenke[i].getGewicht();
		}
		return gGewicht;

	}

	public boolean kannFliegen()
	{
		return 100 * Math.sqrt(this.rentiere.length) > getGewicht();
	}

	public boolean istLeer()
	{
		if (this.geschenke.length == 0)
		{
			return true;
		}
		return false;
	}

	public int getAnzahlRentiere()
	{
		int zaehler = 0;

		for (int i = 0; i < this.rentiere.length; i++)
		{
			zaehler++;
		}

		return zaehler;
	}

	public int getAnzahlGeschenke()
	{
		int zaehler = 0;

		for (int i = 0; i < this.geschenke.length; i++)
		{
			zaehler++;
		}

		return zaehler;

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
