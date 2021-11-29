package CoronaConCirculo;

public class Circulo {

	private double radio;
	
	public Circulo(double radio) {
		setRadio(radio);
	}
	
	private void setRadio(double radio) {
		if(radio <= 0)
			throw new Error ("Radio negativo o cero");
		this.radio = radio;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public double getDiametro() {
		return this.radio * 2;
	}
	
	public double getPerimetro() {
		return Math.PI * this.getDiametro();
	}
	
	public double getSuperficie() {
		return Math.PI * Math.pow(this.radio, 2);
	}

}
