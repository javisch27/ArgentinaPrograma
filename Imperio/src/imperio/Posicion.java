package imperio;

public class Posicion {
	private int x;
	private int y;
	
	public Posicion(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public double distanciaCon(Posicion posicion2) {
		return Math.hypot(this.x - posicion2.x, this.y - posicion2.y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return x == other.x && y == other.y;
	}
	
	
}
