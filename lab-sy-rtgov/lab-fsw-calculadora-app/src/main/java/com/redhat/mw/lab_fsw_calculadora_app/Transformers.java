package com.redhat.mw.lab_fsw_calculadora_app;

import java.io.StringReader;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class Transformers {

	private static final String ID_OPERACION = "idOperacion";
	private static final String TIPO_OPERACION = "tipoOperacion";
	private static final String NUMERO1 = "numero1";
	private static final String NUMERO2 = "numero2";
	private static final String SLEEP_TIME = "sleepMilisegundos";

	@Transformer(to = "{urn:com.redhat.mw:lab-fsw-calculadora-app:1.0}resultado")
	public Element transformResultadoToResultado(Resultado from) {
		StringBuilder a = new StringBuilder();
        a.append("<lab-fsw-calculadora-app:resultado xmlns:lab-fsw-calculadora-app=\"urn:com.redhat.mw:lab-fsw-calculadora-app:1.0\">")
        .append("<codigo>" + from.getCodigo() + "</codigo>")
        .append("<descripcion>" + from.getDescripcion() + "</descripcion>")
        .append("<exitoso>" + from.isExitoso() + "</exitoso>")
        .append("<resultado>" + from.getResultado() + "</resultado>")
        .append("</lab-fsw-calculadora-app:resultado>");
		return toElement(a.toString());
	}

	@Transformer(from = "{urn:com.redhat.mw:lab-fsw-calculadora-app:1.0}operacion")
	public Operacion transformOperacionToOperacion(Element from) {

		Operacion op = new Operacion();
		op.setIdOperacion(Integer.parseInt(getElementValue(from, ID_OPERACION)));
		op.setTipoOperacion(getElementValue(from, TIPO_OPERACION));
		op.setNumero1(Integer.parseInt(getElementValue(from, NUMERO1)));
		op.setNumero2(Integer.parseInt(getElementValue(from, NUMERO2)));
		op.setSleepMilisegundos(Integer.parseInt(getElementValue(from,
				SLEEP_TIME)));

		return op;
	}

	/**
	 * Returns the text value of a child node of parent.
	 */
	private String getElementValue(Element parent, String elementName) {
		String value = null;
		NodeList nodes = parent.getElementsByTagName(elementName);
		if (nodes.getLength() > 0) {
			value = nodes.item(0).getChildNodes().item(0).getNodeValue();
		}
		return value;
	}

	private Element toElement(String xml) {
		DOMResult dom = new DOMResult();
		try {
			TransformerFactory.newInstance().newTransformer()
					.transform(new StreamSource(new StringReader(xml)), dom);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return ((Document) dom.getNode()).getDocumentElement();
	}
}
