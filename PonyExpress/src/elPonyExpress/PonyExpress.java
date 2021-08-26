package elPonyExpress;

public class PonyExpress {

	public static int caballos (int[]distancias) {
		int contadorCaballos = 1;
		int distanciaTotal = 0;
		for(int i = 0; i < distancias.length; i++) {
			distanciaTotal += distancias[i];
			if(distanciaTotal > 100) {
				contadorCaballos ++;
				distanciaTotal = distancias[i];
			}
		}
		return contadorCaballos;
	}
}