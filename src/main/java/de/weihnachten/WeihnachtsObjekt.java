package de.weihnachten;

/**
 * Ein WeihnachtsObjekt ist alles was mit dem Weihnachtsmann zu tun hat, potentiell ein Gewicht hat und mit
 * einem anderen WeihnachtsObjekt kollidieren kann.
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

	/**
	 * Die Aufgabenstellung verlangt, dass {@link #kannKollidieren()} ein WeihnachtsObjekt entgegen nimmt.
	 * Die Beschreibung impliziert weiterhin, dass mit {@code instanceOf T} geprüft werden soll, ob das Objekt
	 * kollidiert.
	 *
	 * Dies kann das {@link WeihnachtsObjekt} aber nicht leisten, da es seine Spezialisierungen nicht kennt
	 * bzw. kennen darf. Falls doch würde gegen die zwei Prinzipien der Objektorientierten Programmierung
	 * verstoßen - <em>Liskov Substitution principle</em>, <em>Open Close principle</em>.
	 *
	 * Daher überschreiben die Spezialisiserungen einfach die Methode {@link #kannKollidieren()}, um der
	 * Anforderung gerecht zu werden.
	 *
	 * D.h. {@code Riesenrad} und {@code Gluehweinbude} müssen einfach {@code true} in ihren
	 * Implementierungen von {@link #kannKollidieren()} liefern.
	 */
	public boolean kannKollidieren()
	{
		return false;
	}
}
