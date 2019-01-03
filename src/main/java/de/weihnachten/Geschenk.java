package de.weihnachten;

public class Geschenk extends GewichtigesWeihnachtsObjekt
{
	public Geschenk()
	{
		super(XMasUtils.getZufallsGanzzahl(1, 20));
	}

	public String asString()
	{
		return String.format("Geschenk: %d kg", getGewicht());
	}
}
