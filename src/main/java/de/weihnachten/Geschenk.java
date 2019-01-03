package de.weihnachten;

/**
 * Ein Geschenk hat ein zufälliges Gewicht in Kilogramm.
 *
 * Aus magischen Gründen können weder der Weihnachtsmann, die Rentiere noch die Geschenke mit anderen
 * Weihnachtsobjekten kollidieren.
 *
 * Dieses wird beim Erstellen des Geschenks im Konstruktor bestimmt. Das Gewicht muss zwischen 1kg und 20kg
 * (beides inklusive) liegen.
 *
 * Die Methode asString() gibt einen Text zurück, mit dem das Geschenk mit Gewicht beschrieben wird.
 * Wir nehmen an, dass der Weihnachtsmann auf magische Weise die Ziel-Adresse des Geschenks kennt und wir
 * diese nicht verwalten müssen.
 */
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
