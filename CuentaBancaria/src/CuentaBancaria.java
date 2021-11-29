
public class CuentaBancaria {

	protected double saldo;
	
	public CuentaBancaria() {
		this.saldo = 0;
	}
	
	protected boolean noHaySaldoPara(double monto) {
		return monto < 0;
	}
	
	protected boolean importeNegativoOCero(double importe) {
		return importe <= 0;
	}
	
	public double consultarSaldo() {
		return this.saldo;
	}
	
	public boolean extraer(double importe) {
		if (this.noHaySaldoPara (this.saldo - importe) || this.importeNegativoOCero(importe))
			return false;
		this.saldo -= importe;
		return true;
	}
	
	public boolean depositar(double importe) {
		if (this.importeNegativoOCero(importe)) {
			return false;
		}
		this.saldo += importe;
		return true;
	}
	
	public boolean transferirA(CuentaBancaria otraCuenta, double importe) {
		if (this.noHaySaldoPara (this.saldo - importe) || this.importeNegativoOCero(importe)) {
			return false;
		}
		this.saldo -= importe;
		otraCuenta.saldo += importe;
		return true;
	}
}


