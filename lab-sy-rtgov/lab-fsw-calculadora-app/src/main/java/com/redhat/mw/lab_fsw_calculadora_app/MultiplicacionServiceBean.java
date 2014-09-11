package com.redhat.mw.lab_fsw_calculadora_app;

import org.overlord.rtgov.client.ActivityReporter;
import org.overlord.rtgov.client.DefaultActivityReporter;
import org.switchyard.component.bean.Service;

@Service(MultiplicacionService.class)
public class MultiplicacionServiceBean implements MultiplicacionService {
	private ActivityReporter _reporter = new DefaultActivityReporter();

	@Override
	public int multiplicar(Operacion op) {
		if (op.getSleepMilisegundos() > 0) {
			if (_reporter != null) {
				_reporter
						.logWarning("Precaución, la ejecución de la multiplicación se detendrá por "
								+ op.getSleepMilisegundos() + " milisegundos!");
			}
			try {
				Thread.sleep(op.getSleepMilisegundos());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int result = op.getNumero1() * op.getNumero2();
		if (_reporter != null){
			_reporter.logInfo(String.format("operación : %d X %d = %d", op.getNumero1(), op.getNumero2(), result));
		}
		return result;
	}

}
