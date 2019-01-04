package de.weihnachten;

/**
 * Letztes Jahr ist der Weihnachtsmann mit seinem Schlitten bei Nebel im Wald an einem Tannenbaum
 * h�ngengeblieben. F�r dieses Jahr w�nscht er sich eine einfache Kollisionspr�fung, die vor der Ausf�hrung
 * der Tour ausgef�hrt wird.
 * Wird eine Kollision erkannt, wird die Tour wie bei falschem Gewicht abgebrochen.
 * Eine echte SmartphoneNavigation w�re nat�rlich besser, aber der Weihnachtsmann ist ja bescheiden.
 *
 * Erweitern Sie zun�chst Plan und Klassendiagramm anhand der Folgenden Beschreibung.
 *
 * Ein Tannenbaum, ist ein WeihnachtsObjekt ohne Gewicht ist. Allerdings kann ein Tannenbaum mit einem
 * Schlitten kollidieren (Methode kannKollidieren) - wir wollen ja nicht, dass dem Weihnachtsmann oder den
 * Rentieren etwas passiert. Ob ein Objekt vom Typ T ist, kann man mit objekt instanceof T herausfinden.
 *
 * Tragen Sie in der Klasse Weihnachten dann eine zuf�llige Anzahl von 10-50 Tannenb�umen an zuf�lligen
 * Positionen in eine Karte (ein zwei-dimensionales Array der Gr��e 30x30 mit Elementen vom Typ
 * WeihnachtsObjekt) ein, und fragen Sie dann mit der Methode kannKollidieren ab, ob eine diagonale Route
 * durch die Karte ohne Kollision mit dem Schlitten m�glich ist.
 *
 *  Geben Sie in einem Kommentar an, wie Sie Ihr Programm anpassen, m�ssen, wenn zus�tzlich noch Riesenrad
 *  und Gl�hweinbude als Hindernisse ber�cksichtigt werden sollen.
 */
public class Tannenbaum extends WeihnachtsObjekt
{
	@Override
	public boolean kannKollidieren()
	{
		return true;
	}
}
