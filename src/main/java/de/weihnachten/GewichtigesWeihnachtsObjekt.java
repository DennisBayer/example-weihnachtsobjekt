package de.weihnachten;

/**
 * Ein GewichtigesWeihnachtsObjekt ist ein WeihnachtsObjekt mit eigenem Gewicht in kg.
 *
 * Der Weihnachtsmann – Eigenname, daher gegen alle Konventionen kein großes „M“ – ist zwar ein WeihnachtsObjekt
 * aber kein GewichtigesWeihnachtsObjekt, da er glaubt nichts zu wiegen (hat also ein Gewicht von 0),
 * denn sonst macht er sich nicht auf die Reise und es gibt keine Geschenke.
 *
 * Aus magischen Gründen können weder der Weihnachtsmann, die Rentiere noch die Geschenke mit anderen
 * Weihnachtsobjekten kollidieren-
 */
public class GewichtigesWeihnachtsObjekt extends WeihnachtsObjekt
{
	private int gewicht;

	public GewichtigesWeihnachtsObjekt(int gewicht)
	{
		this.gewicht = gewicht;
	}

	@Override
	public int getGewicht()
	{
		return this.gewicht;
	}
}
