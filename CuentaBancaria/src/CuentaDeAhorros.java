
public class CuentaDeAhorros extends CuentaBancaria{
	private double saldoSecundario = 0;
	
	public CuentaDeAhorros() {
		super();
	}

	public boolean pasarASaldoSecundario(double importe) {
		if(this.noHaySaldoPara(this.saldo - importe) || this.importeNegativoOCero(importe)) {
			return false;
		}
		this.saldo -= importe;
		this.saldoSecundario += importe;
		return true;
	}
	
	public boolean reintegrarSaldoSecundario(double importe) {
		if(this.noHaySaldoPara(this.saldoSecundario - importe) || this.importeNegativoOCero(importe)) {
			return false;
		}
		this.saldo += importe;
		this.saldoSecundario -= importe;
		return true;
	}
	
	public double consultarSaldoSecundario() {
		return this.saldoSecundario;
	}
}