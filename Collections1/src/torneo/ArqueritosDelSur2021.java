package torneo;

import java.io.FileNotFoundException;

public class ArqueritosDelSur2021 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Torneo arqueritosDelSur = new Torneo("entrada/tiros.csv");
		
		arqueritosDelSur.getSalida();
	}
}