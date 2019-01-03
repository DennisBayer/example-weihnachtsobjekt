package de.weihnachten;

public class Weihnachten
{

	public static void main(String[] args)
	{
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		int arraygroesseRentiere;

		do
		{
			System.out.println("Bitte geben Sie die Anzahl der Rentiere ein: ");
			arraygroesseRentiere = scanner.nextInt();
		}
		while (arraygroesseRentiere < 0);

		Rentier[] rentiere = new Rentier[arraygroesseRentiere];
		for (int i = 0; i < arraygroesseRentiere; i++)
		{
			rentiere[i] = new Rentier();
		}

		int arraygroesseGeschenke;
		do
		{
			System.out.println("Bitte geben Sie die Anzahl der Geschenke ein:");
			arraygroesseGeschenke = scanner.nextInt();
		}
		while (arraygroesseGeschenke < 0);

		Geschenk[] geschenke = new Geschenk[arraygroesseGeschenke];
		for (int i = 0; i < arraygroesseGeschenke; i++)
		{
			geschenke[i] = new Geschenk();
		}
		double eingabeFutter;
		do
		{
			System.out.println("Bitte geben Sie den Futtervorrat in kg ein: ");
			eingabeFutter = scanner.nextDouble();
		}
		while (eingabeFutter < 0);

		Schlitten neuerSchlitten = new Schlitten(rentiere, geschenke);

		Weihnachtsmann derWeihnachtsmann = new Weihnachtsmann(eingabeFutter, neuerSchlitten);

		if (neuerSchlitten.kannFliegen())
		{
			System.out.println(
				"Wir starten Weihnachten mit " + arraygroesseGeschenke + " Geschenken " + arraygroesseRentiere
					+ " Rentier(en) und einem" + " Schlitten mit " + neuerSchlitten.getGewicht() + " kg.");
		}
		else
		{
			System.out.println("Eingabe fehlerhaft! Rentiere koennen nicht" + " losfliegen! Programmende!");
			System.exit(1);
		}

		System.out.println("Die Rentiere sind:");

		for (int i = 0; i < rentiere.length; i++)
		{
			System.out.println(neuerSchlitten.getRentier(i).asString());
		}

		System.out.println("Die Tour beginnt:");

		System.out.println(" Der Weihnachtsmann liefert aus: ");

		for (int i = 0; i < arraygroesseGeschenke; i++)
		{
			derWeihnachtsmann.naechstesGeschenkAusliefern();

			if (derWeihnachtsmann.kannNochFuettern())
			{
				System.out
					.println("Der Weihnachtsmann ist fertig mit der" + " Auslieferung. Schöne Weihnachten.");
			}
			else
			{
				System.out.println("Der Futtervorrat reicht nicht aus! " + "Programmende!");
				System.exit(1);
			}
		}
		scanner.close();
		System.exit(1);
	}
}
