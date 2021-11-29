
public class CuentaCorriente extends CuentaBancaria {
	private double deuda;
	private final double LIMITE_DESCUBIERTO;
	
	public CuentaCorriente (double limiteDescubierto) {
		super();
		this.LIMITE_DESCUBIERTO = limiteDescubierto;
	}
	
	public double getDescubierto() {
		return this.LIMITE_DESCUBIERTO - deuda;
	}
	
	@Override
	protected boolean noHaySaldoPara(double monto) {
		return this.saldo + this.getDescubierto() >= monto;
	}
	
	protected void descontarDeSaldo(double monto) {
		double faltante = monto - saldo;
		if (faltante > 0)
			integrar(faltante);
		this.saldo -= monto;
	}
	
	private synchronized void integrar(double faltante) {
		this.saldo += faltante;
		this.deuda += faltante;
	}
	
	@Override
	public boolean depositar(double importe) {
		if(this.importeNegativoOCero(importe)) {
			return false;
		}
		double restante = pagarDeuda(importe);
		super.depositar(restante);
		return true;
	}
	
	private double pagarDeuda(double montoInicial) {
		double deudaInicial = deuda;
		if (deuda > 0) {
			deuda = Math.max(0, deuda - montoInicial);
		}
		return Math.max(0, montoInicial - deudaInicial);
	}
}
