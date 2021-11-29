package AlmacenPago;

public class AlmacenPago {
	
	public static void calcularInversion(double montoAInvertir, double tazaInteresAnual, int cantidadAniosMaximo) {
		for (int i=0; i<=12*cantidadAniosMaximo; i++) {
			String montoAInvertirAnual = String.format("%.4f", montoAInvertir);
			if(i%12 == 0 && i !=0)
				System.out.println(montoAInvertirAnual);
			montoAInvertir = montoAInvertir * (1+ tazaInteresAnual / 12) ;
		}
	}
	
	public static void calcularTiempo(double montoAInvertir, double tazaInteresAnual, double saldoFinalDeseado) {
		int i;
		for(i=0; montoAInvertir < saldoFinalDeseado; i++) {
			montoAInvertir = montoAInvertir * (1+ tazaInteresAnual / 12);
		}
		System.out.println(i);
	}
}
