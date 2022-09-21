package ar.CuentaBancariaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.CuentaBancaria.Cuenta;
import junit.framework.Assert;

public class CuentaBancariaTest {
	//TESTING SSH
	@SuppressWarnings("deprecation")
	@Test
	public void queAlCrearUnaCuentaSuSaldoSeaCero() {
		Double valorEsperado = 0.0;
		Cuenta cuenta = crearUnaCuenta();
		Double valorObtenido = cuenta.getSaldo();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queAlIngresarSaldoElSaldoSeIncremente() {
		Double valorEsperado = 100.0;
		Double dineroIngresado = 100.0;
		Cuenta cuenta = crearUnaCuenta();
		ingresoDineroALaCuenta(cuenta, dineroIngresado);
		Double valorObtenido = cuenta.getSaldo();
		Assert.assertEquals(valorEsperado, valorObtenido);
		
		
	}
	@Test
	public void queAlIngresarSaldoSeDecremente() {
		Double dineroIngresado = 100.0;
		Double extraerDinero = 50.0;
		Cuenta cuenta = crearUnaCuenta();
		ingresoDineroALaCuenta(cuenta, dineroIngresado);
		extraigoDineroDeLaCuenta(cuenta, extraerDinero);
		entoncesSuSaldoEs(cuenta, 50.0);
	}
	@Test
	public void queNopuedoExtraerUnMontoSuperiorAlSaldoDeLaCuenta() {
		Cuenta cuenta = crearUnaCuenta();
		Double valorEsperado = 100.0;
		Double dineroIngresado=100.0;
		Double extraerDinero = 200.0;
		ingresoDineroALaCuenta(cuenta, dineroIngresado);
		extraigoDineroDeLaCuenta(cuenta, extraerDinero);
		entoncesSuSaldoEs(cuenta, valorEsperado);
	}
	@Test
	public void queNoPuedoDepositarValorNegativo() {
		Cuenta cuenta = crearUnaCuenta();
		Double valorEsperado = 0.0;
		Double dineroIngresado= -100.0;
		ingresoDineroALaCuenta(cuenta,dineroIngresado);
		entoncesSuSaldoEs(cuenta, valorEsperado);
	}
	@Test
	public void queNoPuedoExtraerValorNegativo() {
		Cuenta cuenta = crearUnaCuenta();
		Double dineroIngresado = 100.0;
		Double dineroExtraido = -100.0;
		ingresoDineroALaCuenta(cuenta, dineroIngresado);
		extraigoDineroDeLaCuenta(cuenta, dineroExtraido);
		entoncesSuSaldoEs(cuenta, dineroIngresado);
		
		
	}
	@Test
	public void queSePuedaTranferirDineroAOtraCuenta() {
		Cuenta cuentaOrigen = crearUnaCuenta();
		Cuenta cuentaDestino = crearUnaCuenta();
		Double dineroIngresado = 100.0;
		ingresoDineroALaCuenta(cuentaOrigen, dineroIngresado);
		transferenciaDeSaldo(cuentaOrigen, cuentaDestino, dineroIngresado);
		entoncesSuSaldoEs(cuentaOrigen, 0.0);
		entoncesSuSaldoEs(cuentaDestino, 100.0);
		
	}
	
	@Test
	public void queNoSePuedaTranferirSinMontoSufuciente() {
		Cuenta cuentaOrigen = crearUnaCuenta();
		Cuenta cuentaDestino = crearUnaCuenta();
		Double dineroIngresado = 100.0;
		Double dineroEnCuentaInsuficiente = 200.0;
		ingresoDineroALaCuenta(cuentaOrigen, dineroIngresado);
		transferenciaDeSaldo(cuentaOrigen, cuentaDestino, dineroEnCuentaInsuficiente);
		entoncesSuSaldoEs(cuentaOrigen, 100.0);
		entoncesSuSaldoEs(cuentaDestino, 0.0);
	}

	private void transferenciaDeSaldo(Cuenta cuentaOrigen, Cuenta cuentaDestino, Double dineroIngresado) {
		cuentaOrigen.transferirSaldo(cuentaDestino, dineroIngresado);
		
	}

	private void extraigoDineroDeLaCuenta(Cuenta cuenta, Double extraerDinero) {
		cuenta.extraerDinero(extraerDinero);
		
	}

	private void ingresoDineroALaCuenta(Cuenta cuenta, Double dineroIngresado) {
		cuenta.ingresarSaldo(dineroIngresado);
		
	}

	private void entoncesSuSaldoEs(Cuenta cuenta, double saldoEnCuenta) {
		Double valorEsperado = saldoEnCuenta;
		Double valorObtenido = cuenta.getSaldo();
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	private Cuenta crearUnaCuenta() {
		
		return new Cuenta(0.0);
	}

}
