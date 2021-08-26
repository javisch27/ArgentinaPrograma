
public class App {

	public static void main(String[] args) {
		int butacasTotales = 120;
		int cantFilas = 8;
		SalaDeCine s = new SalaDeCine(butacasTotales, cantFilas);
		
		s.ocuparButaca(5, 7);
		System.out.println (s.butacaOcupada(4, 6));
		System.out.println (s.butacaOcupada(5, 7));
		s.printMapa();
		
	}
}
