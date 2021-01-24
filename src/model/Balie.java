package model;

import java.util.ArrayList;
import java.util.Random;

public class Balie {

	private ArrayList<Bestelling> bestellingen = null;
	private ArrayList<Maaltijd> maaltijden = null;

	private static final Object bestellingLock = new Object();
	private static final Object maaltijdLock = new Object();

	public Balie() {
		this.bestellingen = new ArrayList<Bestelling>();
		this.maaltijden = new ArrayList<Maaltijd>();
	}

	// Nieuwe bestelling plaatsen die kok de bereidt
	public void plaatsBestelling(Bestelling b) {
		synchronized (bestellingLock) {
			bestellingen.add(b);
		}
	}

	// Kok pakt bestelling om te bereiden
	public Bestelling pakBestelling() {
		synchronized (bestellingLock) {
			Bestelling res = null;
			if(!bestellingen.isEmpty()) {
				res = bestellingen.remove(0);
				return res;
			} else {
				return null;
			}
		}
	}

	// Kok plaatst maaltijd voor bezorging
	public void plaatsMaaltijd(Maaltijd m) {
		synchronized (maaltijdLock) {
			maaltijden.add(m);
		}
	}

	// Ober pakt een maaltijd om te bezorgen
	public Maaltijd pakMaaltijd() {
		synchronized (maaltijdLock) {
			Maaltijd res = null;
			if(!maaltijden.isEmpty()) {
				res = maaltijden.remove(0);
				return res;
			} else {
				return null;
			}
		}
	}

	public void genereerBestellingen() {
		for (int i = 0; i < Restaurant.AANTALBESTELLINGEN; i++) {
			int tafelnummer = randInt(1, Restaurant.AANTALTAFELS);
			int bereidingstijd = randInt(Restaurant.MINIMALE_BEREIDINGSTIJD, Restaurant.MAXIMALE_BEREIDINGSTIJD);
			Bestelling b = new Bestelling(bereidingstijd, tafelnummer);
			this.plaatsBestelling(b);
		}
	}

	private static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
