package com.redhat.mw.lab_fsw_calculadora_app;

public class Operacion {

	public static final String SUMA = "SUMA";
	public static final String RESTA = "RESTA";
	public static final String DIVISION = "DIVISION";
	public static final String MULTIPLICACION = "MULTIPLICACION";

	private int idOperacion;
	private String tipoOperacion;
	private int numero1;
	private int numero2;

	private int sleepMilisegundos = 0;

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	public int getSleepMilisegundos() {
		return sleepMilisegundos;
	}

	public void setSleepMilisegundos(int sleepMilisegundos) {
		this.sleepMilisegundos = sleepMilisegundos;
	}

	public int getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}

	@Override
	public String toString() {
		return String.format("{operacion: {id:%d, tipoOperacion : %s, n1 : %d, n2: %d, sleepTime:%d}}", idOperacion,tipoOperacion,numero1,numero2,sleepMilisegundos);
	}
}
