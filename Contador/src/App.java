
public class App {
	
	public static void main(String[] args) {
		Contador micontador = new Contador();
		System.out.println(micontador.mostrar());
		
		micontador.contar();
		System.out.println(micontador.mostrar());
		
		micontador.contar();
		micontador.contar();
		micontador.contar();
		System.out.println(micontador.mostrar());
		
		micontador.reiniciar();
		System.out.println(micontador.mostrar());
		
		micontador.contar();
		System.out.println(micontador.mostrar());
	}
}
