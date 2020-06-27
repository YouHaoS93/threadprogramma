package model;

public class Restaurant {

	private Kok aKok = null;
	private Ober aOber = null;
	public static final int AANTALTAFELS = 10;
	public static final int AANTALBESTELLINGEN = 20;
	public static final int MINIMALE_BEREIDINGSTIJD = 750;
	public static final int MAXIMALE_BEREIDINGSTIJD = 1500;

	public Restaurant() {
		Balie balie = new Balie();
		balie.genereerBestellingen();
		aKok = new Kok("1", balie);
		aOber = new Ober("1", balie);
	}

	public void start() {
		aKok.bereidMaaltijden();
		aOber.bezorgMaaltijden();
	}

	
	

}
