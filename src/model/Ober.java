package model;

public class Ober implements Runnable {

	private String id;
	private Balie balie = null;
	private static final int BEZORGTIJD = 10;
	private volatile boolean stoppen = false;

	public Ober(String id, Balie balie) {
		this.id = id;
		this.balie = balie;
	}

	@Override
	public void run() {
		while (!stoppen) {
				Maaltijd maaltijd = balie.pakMaaltijd();
				if (maaltijd != null) {
					bezorgMaaltijd(maaltijd);
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

	private void bezorgMaaltijd(Maaltijd m) {
		try {
			Thread.sleep(BEZORGTIJD);
			System.out.println("Ober " + this.id + " bezorgt maaltijd " + m.getTafelnummer());
		}
		catch (InterruptedException e) {
		}
	}

}
