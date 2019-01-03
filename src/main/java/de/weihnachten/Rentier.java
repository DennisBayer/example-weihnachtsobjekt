package de.weihnachten;

public class Rentier extends GewichtigesWeihnachtsObjekt
{
	private double hunger;

	public Rentier()
	{
		super(XMasUtils.getZufallsGanzzahl(200, 300));
		this.hunger = XMasUtils.getZufallHunger(1.0, 2.0);
	}

	public double getHunger()
	{
		return this.hunger;
	}

	public double getHunger(double gGewicht)
	{
		double anzEssensrationen = this.hunger + (0.01 * gGewicht);
		return anzEssensrationen;
	}

	public String asString()
	{
		// Ich bin ein Rentier mit indiv. Hunger 1.0 und Gewicht 245 kg
		return String.format(" - Ich bin ein Rentier mit indiv. Hunger %.1f und Gewicht %d kg", this.hunger,
			getGewicht());
	}
}
