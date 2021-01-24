  package model;

public class Kok implements Runnable {

	private String id;
	private Balie balie = null;
	private volatile boolean stoppen = false;

	public Kok(String id, Balie balie) {
		this.id = id;
		this.balie = balie;
	}

	@Override
	public void run() {
		while (!stoppen) {
				Bestelling bestelling = balie.pakBestelling();
				if (bestelling != null) {
					Maaltijd maaltijd = bereidMaaltijd(bestelling);
					balie.plaatsMaaltijd(maaltijd);
				} else {
					try {
						Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				}
			}

	}

	public void stoppen() {
		stoppen = true;
	}

	private Maaltijd bereidMaaltijd(Bestelling b) {
		try {
			Thread.sleep(b.getBereidingstijd());
			System.out.println("Kok " + this.id + " bereidt bestelling voor tafel " + b.getTafelnummer());

		}
		catch (InterruptedException e) {
		}
		return new Maaltijd(b.getTafelnummer());
	}

}
