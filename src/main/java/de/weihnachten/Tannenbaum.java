package de.weihnachten;

/**
 * Letztes Jahr ist der Weihnachtsmann mit seinem Schlitten bei Nebel im Wald an einem Tannenbaum
 * hängengeblieben. Für dieses Jahr wünscht er sich eine einfache Kollisionsprüfung, die vor der Ausführung
 * der Tour ausgeführt wird.
 * Wird eine Kollision erkannt, wird die Tour wie bei falschem Gewicht abgebrochen.
 * Eine echte SmartphoneNavigation wäre natürlich besser, aber der Weihnachtsmann ist ja bescheiden.
 *
 * Erweitern Sie zunächst Plan und Klassendiagramm anhand der Folgenden Beschreibung.
 *
 * Ein Tannenbaum, ist ein WeihnachtsObjekt ohne Gewicht ist. Allerdings kann ein Tannenbaum mit einem
 * Schlitten kollidieren (Methode kannKollidieren) - wir wollen ja nicht, dass dem Weihnachtsmann oder den
 * Rentieren etwas passiert. Ob ein Objekt vom Typ T ist, kann man mit objekt instanceof T herausfinden.
 *
 * Tragen Sie in der Klasse Weihnachten dann eine zufällige Anzahl von 10-50 Tannenbäumen an zufälligen
 * Positionen in eine Karte (ein zwei-dimensionales Array der Größe 30x30 mit Elementen vom Typ
 * WeihnachtsObjekt) ein, und fragen Sie dann mit der Methode kannKollidieren ab, ob eine diagonale Route
 * durch die Karte ohne Kollision mit dem Schlitten möglich ist.
 *
 *  Geben Sie in einem Kommentar an, wie Sie Ihr Programm anpassen, müssen, wenn zusätzlich noch Riesenrad
 *  und Glühweinbude als Hindernisse berücksichtigt werden sollen.
 */
public class Tannenbaum extends WeihnachtsObjekt
{
	@Override
	public boolean kannKollidieren()
	{
		return true;
	}
}
