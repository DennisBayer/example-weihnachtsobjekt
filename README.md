# Weihnachten

* Es kann noch einiges optimiert werden, jedoch gibt es gewisse Vorgaben, die einzuhalten sind.

## Beispiel
```
Wir starten Weihnachten mit 10 Geschenken, 4 Rentier(en) und einem Schlitten mit 82 kg.Die Rentiere sind:
 - Ich bin ein Rentier mit indiv. Hunger 1,5 und Gewicht 271 kg
 - Ich bin ein Rentier mit indiv. Hunger 1,8 und Gewicht 271 kg
 - Ich bin ein Rentier mit indiv. Hunger 1,2 und Gewicht 266 kg
 - Ich bin ein Rentier mit indiv. Hunger 1,7 und Gewicht 232 kg
Die Tour beginnt:
 - Der Weihnachtsmann liefert aus: Geschenk: 4 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 4 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 16 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 10 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 11 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 2 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 1 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 14 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 14 kg
 - Der Weihnachtsmann liefert aus: Geschenk: 6 kg
Der Weihnachtsmann ist fertig mit der Auslieferung. Schöne Weihnachten.
```

## ToDo

[] Die "Test"-Main-Methoden aller Klassen fehlen noch.

## Revisionen

* 0.1.7 - Aufgabenbeschreibung in Klassen ergänzt.
* 0.1.6 - Bugfix
  * Weihnachtsmann - `istFertig` vereinfacht
  * Weihnachtsmann - `kannNochFuettern` korrigiert/vereinfacht
  * Weihnachtsmann - `fuettern` korrigiert
* 0.1.5 - Bugfix
  * Schlitten - `getNaechstesGeschenk` korrigiert (lt. Aufgabenstellung).
  * Schlitten - `getAnzahlGeschenke` und `getGewicht` korrigiert/vereinfacht.
* 0.1.4 - Bugfix
  * Rentier - `asString` korrigiert.
* 0.1.3 - Bugfix
  * XMasUtils - Falsche Berechnung, falls untere und obere Grenze identisch.
  * Geschenk - Verwendung von `asString` für Ausgabe anstelle `toString`.
* 0.1.2 - Aufräumarbeiten
* 0.1.1 - Bugfix
  * Falsche Iteration über Rentiere bei Verwendung von `schlitten.getAnzahlRentiere()`.
* 0.1.0 - Initialer Commit