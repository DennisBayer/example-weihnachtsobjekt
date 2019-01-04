package de.weihnachten;

/**
 * Einige Eigenschaften werden magisch, d.h., per Zufall, andere per Berechnung bestimmt. Für beides ist die
 * Klasse java.lang.Math sehr hilfreich.
 *
 * An einigen Stellen benötigen wir eine zufällige Fließkommazahl aus einem vorgegebenen Bereich.
 * Hierfür macht es Sinn, die Klasse XMasUtils (nicht im Diagramm dargestellt) zu erstellen. Eine statische
 * Methode dieser Klasse gibt für gegebene Minimum/Maximum-Grenzen eine zufällige Fließkommazahl innerhalb
 * dieses Bereichs zurück.
 *
 * Analog benötigen wir an einigen Stellen zufällige Ganzzahlen innerhalb gegebener Minimum/Maximum-Grenzen
 * – sinnigerweise unter Verwendung der Methode für Fließkommazahlen.
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
