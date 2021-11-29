
public class SalaDeCine {

	private boolean butacas [][];
	
	public SalaDeCine(int butacasTotales, int cantFilas) {
		//Validar entrada
		if(butacasTotales % cantFilas != 0) {
			throw new RuntimeException("No se puede, el resto debe dar 0");
		}
		//Constructor
		butacas = new boolean [cantFilas][butacasTotales / cantFilas];
	}
	
	public boolean butacaOcupada(int fila, int columna) {
		return butacas [fila][columna];
	}
	
	public boolean ocuparButaca(int fila, int columna) {
		butacas[fila][columna] = true;
		return true;
	}
	
	public void printMapa() {
		for (int i = 0; i < butacas.length; i++) {
			boolean[] filas = butacas[i];
			for (int j = 0; j < filas.length; j++) {
				boolean butaca = filas[j];

				System.out.print(butaca ? "X " : "_ ");
			}
			System.out.println();
		}
	}
	
	public int butacasOcupadasTotales() {
		int butacasOcupadasTotales = 0;
		for (int i = 0; i < butacas.length; i++) {
			if(this.butacaOcupada(i, i))
				butacasOcupadasTotales += 1;
		}		
		return butacasOcupadasTotales;	
	}
	
}
