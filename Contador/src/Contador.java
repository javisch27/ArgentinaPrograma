
public class Contador {
	
	private short valor = 0;
	
	public void contar() {
		this.valor++;
	}
	
	public void reiniciar() {
		this.valor = 0;
	}
	
	public short mostrar() {
		return this.valor;
	}
}
