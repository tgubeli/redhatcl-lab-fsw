package com.redhat.mw.lab_fsw_calculadora_app;

public class Resultado {
	private String codigo;
	private double resultado;
	private boolean exitoso;
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public boolean isExitoso() {
		return exitoso;
	}

	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

}
