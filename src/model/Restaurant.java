package model;

public class Restaurant {

	private Kok aKok1 = null;
	private Kok aKok2 = null;
	private Kok aKok3 = null;
	private Kok aKok4 = null;

	private Ober aOber1 = null;
	private Ober aOber2 = null;
	private Ober aOber3 = null;
	private Ober aOber4 = null;

	public static final int AANTALTAFELS = 10;
	public static final int AANTALBESTELLINGEN = 20;
	public static final int MINIMALE_BEREIDINGSTIJD = 750;
	public static final int MAXIMALE_BEREIDINGSTIJD = 1500;

	public Restaurant() {
		Balie balie = new Balie();
		balie.genereerBestellingen();
		aKok1 = new Kok("1", balie);
		aKok2 = new Kok("2", balie);
		aKok3 = new Kok("3", balie);
		aKok4 = new Kok("4", balie);

		aOber1 = new Ober("1", balie);
		aOber2 = new Ober("2", balie);
		aOber3 = new Ober("3", balie);
		aOber4 = new Ober("4", balie);
	}

	public void start() {
		aKok1.run();
		aKok2.run();
		aKok3.run();
		aKok4.run();

		aOber1.run();
		aOber2.run();
		aOber3.run();
		aOber4.run();
	}

	
	

}
