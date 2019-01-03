package de.weihnachten;

public class Rentier extends GewichtigesWeihnachtsObjekt
{
	private double hunger;

	public Rentier()
	{
		super(XMasUtils.getZufallsGanzzahl(200, 300));
		this.hunger = (XMasUtils.getZufallHunger(1.0, 2.0));
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
		return " - Ich bin ein Rentier mit indiv. Hunger " + Double.toString(this.hunger) + " und Gewicht "
			+ Integer.toString(getGewicht()) + " kg";
	}
}
