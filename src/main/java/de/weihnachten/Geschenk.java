package de.weihnachten;

/**
 * Ein Geschenk hat ein zuf�lliges Gewicht in Kilogramm.
 *
 * Aus magischen Gr�nden k�nnen weder der Weihnachtsmann, die Rentiere noch die Geschenke mit anderen
 * Weihnachtsobjekten kollidieren.
 *
 * Dieses wird beim Erstellen des Geschenks im Konstruktor bestimmt. Das Gewicht muss zwischen 1kg und 20kg
 * (beides inklusive) liegen.
 *
 * Die Methode asString() gibt einen Text zur�ck, mit dem das Geschenk mit Gewicht beschrieben wird.
 * Wir nehmen an, dass der Weihnachtsmann auf magische Weise die Ziel-Adresse des Geschenks kennt und wir
 * diese nicht verwalten m�ssen.
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
