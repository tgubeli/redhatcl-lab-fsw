package com.redhat.mw.lab_fsw_calculadora_app;

import org.overlord.rtgov.client.ActivityReporter;
import org.overlord.rtgov.client.DefaultActivityReporter;
import org.switchyard.component.bean.Service;

@Service(SumaService.class)
public class SumaServiceBean implements SumaService {
	
	private ActivityReporter _reporter = new DefaultActivityReporter();

	@Override
	public int sumar(Operacion op) {
		int result = op.getNumero1() + op.getNumero2();
		if (_reporter != null) {
			_reporter.logInfo(String.format("operación : %d + %d = %d",
					op.getNumero1(), op.getNumero2(), result));
		}
		return result;
	}

}
