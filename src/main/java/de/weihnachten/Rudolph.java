package de.weihnachten;

/**
 * Erweitern Sie das Programm, d.h., zunächst Plan und Klassendiagramm, indem Sie die Klasse Rudolph von
 * Rentier erben lassen.
 *
 * Rudolph überschreibt die asString()-Methode und stellt sich anders vor als seine Rentier-Kollegen.
 *
 * Damit seine Nase auch rot leuchtet, hat Rudolf grundsätzlich doppelt so viel Hunger wie der hungrigste
 * seiner Rentier-Kollegen, d.h., sein Hungerfaktor ändert sich von 0.01 zu 0.02.
 * Realisieren Sie dies durch geeignete Anpassung von Rudolph und Rentier aber ohne zusätzliches Attribut
 * und ohne die Berechnungsformel in Rudolph zu wiederholen.
 *
 * Sorgen Sie dafür, dass bei der Erstellung der Rentiere zuerst ein Rudolph und danach die restlichen Rentiere
 * angelegt werden, wobei die Gesamtanzahl weiterhin der Konsoleneingabe entsprechen soll, also ein normales
 * Rentier weniger angelegt werden muss. Natürlich muss auch Rudolph getestet werden.
 */
public class Rudolph extends Rentier
{
	@Override
	protected double getHungerFaktor()
	{
		return super.getHungerFaktor() * 2;
	}

	@Override
	public String asString()
	{
		return String.format(
			" - Ich bin Rudolph und meine Nase leuchtet. Mein indiv. Hunger %.1f und Gewicht %d kg",
			getHunger(), getGewicht());
	}
}
