package ar.CuentaBancaria;

public class Cuenta {
	
	private double saldoEnCuenta=0.0;

	public Cuenta(double saldoEnCuenta) {
		this.saldoEnCuenta = saldoEnCuenta;
		
	}

	public Double getSaldo() {
		// TODO Auto-generated method stub
		return saldoEnCuenta;
	}



	public void setSaldoEnCuenta(double saldoEnCuenta) {
		this.saldoEnCuenta = saldoEnCuenta;
	}

	public void ingresarSaldo(Double dineroIngresado) {
		if(dineroIngresado > 0) {
			this.saldoEnCuenta = this.saldoEnCuenta + dineroIngresado;
		}
		
		
	}

	public void extraerDinero(Double extraerDinero) {
		if(extraerDinero <= this.saldoEnCuenta) {
			if(extraerDinero > 0) {
				this.saldoEnCuenta = this.saldoEnCuenta - extraerDinero;
			}
			
		}
		
	}

	public void transferirSaldo(Cuenta cuentaDestino, Double dineroIngresado) {
		
		if(dineroIngresado <= this.getSaldo()) {
			
			this.extraerDinero(dineroIngresado);
			
			cuentaDestino.ingresarSaldo(dineroIngresado);
		
		
	}

}}
