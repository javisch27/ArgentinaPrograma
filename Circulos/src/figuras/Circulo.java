package figuras;
	
	public class Circulo {
		private Punto centro;
		private double radio;
		
		public Circulo(Punto centro, double radio) {
			this.centro = centro;
			this.radio = radio;
		}
		
		public boolean intersectaCon(Circulo otroCirculo) {
			return (this.centro.distanciaEntreDosPuntos(otroCirculo.centro)) < (this.radio + otroCirculo.radio);
		}
		
		public static void main(String[] args) {
			Circulo miCirculo = new Circulo(new Punto(0, 0), 1);
			System.out.println(miCirculo.centro + ", " + miCirculo.radio);
			
			Circulo miCirculo2 = new Circulo(new Punto(1, 1), 1.5);
			System.out.println(miCirculo2.centro + ", " + miCirculo2.radio);
			
			System.out.println(miCirculo.intersectaCon(miCirculo2));
		}
	}