package model;

public class Restaurant {

	private Kok aKok1 = null;
	private Kok aKok2 = null;
	private Kok aKok3 = null;

	private Ober aOber1 = null;
	private Ober aOber2 = null;
	private Ober aOber3 = null;

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

		aOber1 = new Ober("1", balie);
		aOber2 = new Ober("2", balie);
		aOber3 = new Ober("3", balie);
	}

	public void start() {
		Thread t1 = new Thread(aKok1);
		Thread t2 = new Thread(aKok2);
		Thread t3 = new Thread(aKok3);

		Thread t4 = new Thread(aOber1);
		Thread t5 = new Thread(aOber2);
		Thread t6 = new Thread(aOber3);

		t1.start();
		t4.start();
		t2.start();
		t5.start();
		t6.start();
		t3.start();

		try {
			Thread.sleep(10000);
			aKok1.stoppen();
			aKok2.stoppen();
			aKok3.stoppen();

			aOber1.stoppen();
			aOber2.stoppen();
			aOber3.stoppen();

		} catch (InterruptedException e) {
		}
	}
}




	
	


