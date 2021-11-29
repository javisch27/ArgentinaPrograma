
public class Luchador {
	private int alturaenMM;
	private int peso;
	
	
	public Luchador(int peso, int alturaenMM){
		this.peso = peso;
		this.alturaenMM = alturaenMM;
	}
	
	public boolean dominaA (Luchador otro) {
		if(this.peso > otro.peso && this.alturaenMM >= otro.alturaenMM) {
			return true;
		}
		if (this.alturaenMM > otro.alturaenMM && this.peso >= otro.peso) {
			return true;
		}
		return false;
	}
}
