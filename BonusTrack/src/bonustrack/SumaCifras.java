package bonustrack;

public class SumaCifras {
		
	public int sumarCifras(int numero) {
		
		int cifras = cuantasCifrasTiene(numero);
		
		int suma = 0;
		/*
		int unidad =    numero / 1 % 10;
		int decena =    numero / 10 % 10;
		int centena =   numero / 100 % 10;
		int unidadmil = numero / 1000 % 10;
		suma = unidad + decena + centena + unidadmil;
		*/
		
		for(int i=0; i < cifras; i++) {
			suma += numero / Math.pow(10, i) % 10;
		}
		
		
		while(suma >= 10) {
			suma = suma % 10 + suma /10;
		} 
		
		return suma;
	}

	private int cuantasCifrasTiene(int numero) {
		int div = numero;
		int cifras = 0;
		while(div != 0) {
			div = div / 10;
			cifras ++;
		}
		return cifras;
	}
	
	public static void main(String[] args) {
		
		SumaCifras sc = new SumaCifras();
		System.out.println(sc.sumarCifras(1213));
		System.out.println(sc.sumarCifras(1234));
		System.out.println(sc.sumarCifras(2999));
		System.out.println(sc.sumarCifras(489));
		System.out.println(sc.sumarCifras(6));
		System.out.println(sc.sumarCifras(111111));
		System.out.println(sc.sumarCifras(9999999));
	}
	

}
