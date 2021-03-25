package xml;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class CustomErrorHandler implements ErrorHandler {
	Boolean errorProduced = Boolean.FALSE;
	public Boolean isValid() {
		return !this.errorProduced;
	}
	public void error(SAXParseException exception) throws SAXException {
		Logger.getLogger(Validar_DTD.class.getName()).log(Level.SEVERE, null, exception);
		errorProduced = Boolean.TRUE;
	}
	public void fatalError(SAXParseException exception) throws SAXException {
		Logger.getLogger(Validar_DTD.class.getName()).log(Level.SEVERE, null, exception);
		errorProduced = Boolean.TRUE;
	}
	public void warning(SAXParseException exception) throws SAXException {
		Logger.getLogger(Validar_DTD.class.getName()).log(Level.SEVERE, null, exception);
		errorProduced = Boolean.TRUE;
	}
}
