package de.weihnachten;

/**
 * Jedes Rentier hat ein zuf�lliges Gewicht (Minimalgewicht 200kg, Maximalgewicht 300kg) und verdr�ckt pro
 * Mahlzeit eine unterschiedliche Anzahl an Essensrationen.
 *
 * Aus magischen Gr�nden k�nnen weder der Weihnachtsmann, die Rentiere noch die Geschenke mit anderen
 * Weihnachtsobjekten kollidieren.
 *
 * Das eigene Gewicht und der individuelle hunger wird bei der Erstellung des Rentiers im Konstruktor
 * zuf�llig ermittelt. Der hunger betr�gt zwischen einer und zwei Essensrationen (beides inklusive) und wird
 * von der Methode getHunger() zur�ckgegeben.
 *
 * Die Methode getHunger(double gGewicht) Klasse Rentier gibt die Menge an Essensrationen zur�ck, die dieses
 * Rentier pro Mahlzeit abh�ngig vom Gesamtgewicht der Geschenke gGewicht verdr�ckt. Die Menge an
 * Essensrationen (getHunger) wird mit hunger + 0.01 * gGewicht berechnet. Bei 100kg Geschenken und einem
 * individuellen hunger von 1.5 ben�tigt das Rentier also 1.5 + 0.01 * 100 = 2.5 Essensrationen.
 *
 * Die Methode asString() gibt eine Beschreibung des Rentiers mit seinem individuellen Hungerwert zur�ck.
 */
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
