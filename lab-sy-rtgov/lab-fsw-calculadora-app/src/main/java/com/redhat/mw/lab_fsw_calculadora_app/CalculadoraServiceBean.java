package com.redhat.mw.lab_fsw_calculadora_app;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import static com.redhat.mw.lab_fsw_calculadora_app.Operacion.*;

@Service(CalculadoraService.class)
@ApplicationScoped
public class CalculadoraServiceBean implements CalculadoraService {

	@Inject @Reference
	private SumaService sumaService;

	@Inject	@Reference
	private RestaService restaService;

	@Inject	@Reference
	private MultiplicacionService multiplicacionService;

	@Override
	public Resultado calcular(Operacion op) {
		if (op == null) {
			throw new RuntimeException("Debe enviar parámetro");
		} else {
			boolean exito = true;
			Resultado r = new Resultado();
			r.setDescripcion("OK");
			
			if (op.getTipoOperacion().equals(SUMA)) {
				r.setCodigo("SUMA EXITOSA");
				r.setResultado(sumaService.sumar(op));
				
			} else if (op.getTipoOperacion().equals(RESTA)) {
				r.setCodigo("RESTA EXITOSA");
				r.setResultado(restaService.restar(op));
				
			} else if (op.getTipoOperacion().equals(DIVISION)) {
				r.setCodigo("DIVISION EXITOSA");
				
				
			} else if (op.getTipoOperacion().equals(MULTIPLICACION)) {
				r.setCodigo("MULTIPLICACION EXITOSA");
				r.setResultado(multiplicacionService
						.multiplicar(op));
				
			} else {
				// ERROR NO EXISTE OPERACION
				r.setCodigo("ERROR");
				r.setDescripcion("la operación solicitada no está soportada");
				exito = false;
			}
			r.setExitoso(exito);
			return r;
		}

	}

}
