package de.weihnachten;

/**
 * Ein WeihnachtsObjekt ist alles was mit dem Weihnachtsmann zu tun hat, potentiell ein Gewicht hat
 * und mit einem anderen WeihnachtsObjekt kollidieren kann.
 */
public class WeihnachtsObjekt
{
	/**
	 * Ein WeihnachtsObjekt ist aber kein GewichtigesWeihnachtsObjekt, da es glaubt nichts zu wiegen
	 * (hat also ein Gewicht von  0).
	 */
	public int getGewicht()
	{
		return 0;
	}

	public boolean kannKollidieren()
	{
		return false;
	}
}
