
public class TarjetaDeDebito {
	private CuentaBancaria cuentaAsociada;
	
	public TarjetaDeDebito(CuentaBancaria cuentaAsociada) {
		this.cuentaAsociada = cuentaAsociada;
	}
	
	public void comprar(double monto) {
		cuentaAsociada.extraer(monto);
	}
}
