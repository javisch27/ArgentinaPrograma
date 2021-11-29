package figuras;

	public class Punto {
		
		private double x;
		private double y;
	
		public Punto(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double distanciaEntreDosPuntos(Punto otroPunto) {
			return Math.sqrt(Math.pow ((this.x - otroPunto.x), 2) + Math.pow ((this.y - otroPunto.y), 2)); 
		}
		
		public static void main(String[] args) {
			Punto miPunto1 = new Punto(2,2);
			System.out.println(miPunto1.x + "," + miPunto1.y);
			Punto miPunto2 = new Punto(1,1);
			System.out.println(miPunto1.distanciaEntreDosPuntos(miPunto2));
		}
		
	}
