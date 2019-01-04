package de.weihnachten;

/**
 * Einige Eigenschaften werden magisch, d.h., per Zufall, andere per Berechnung bestimmt. F�r beides ist die
 * Klasse java.lang.Math sehr hilfreich.
 *
 * An einigen Stellen ben�tigen wir eine zuf�llige Flie�kommazahl aus einem vorgegebenen Bereich.
 * Hierf�r macht es Sinn, die Klasse XMasUtils (nicht im Diagramm dargestellt) zu erstellen. Eine statische
 * Methode dieser Klasse gibt f�r gegebene Minimum/Maximum-Grenzen eine zuf�llige Flie�kommazahl innerhalb
 * dieses Bereichs zur�ck.
 *
 * Analog ben�tigen wir an einigen Stellen zuf�llige Ganzzahlen innerhalb gegebener Minimum/Maximum-Grenzen
 * � sinnigerweise unter Verwendung der Methode f�r Flie�kommazahlen.
 */
public class XMasUtils
{
	public static double getZufallsFliesskommazahl(double ug, double og)
	{
		return (Math.random() * (og - ug)) + ug;
	}

	public static int getZufallsGanzzahl(int ug, int og)
	{
		return (int) getZufallsFliesskommazahl(ug, og);
	}

	public static double getZufallHunger(double ug, double og)
	{
		return (Math.random() * (og - ug)) + ug;
	}
}
