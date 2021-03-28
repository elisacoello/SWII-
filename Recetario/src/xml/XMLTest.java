package xml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import logging.MyLogger;
import pojos.Ingrediente;
import pojos.Receta;
import pojos.Recetario;

public class XMLTest {
	final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public  void exportarRecetario(Recetario rec) throws JAXBException {
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Recetario.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		jaxbM.setProperty("com.sun.xml.bind.xmlHeaders", "\n<!DOCTYPE recetario SYSTEM \"DTD.dtd\">");
		//jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		// Escribiendo en un fichero
		File XMLfile = new File("./recursos/RecetarioExportado.xml");
		jaxbM.marshal(rec, XMLfile);
		// Escribiendo por pantalla
		//jaxbM.marshal(book, System.out);
	}
	
	public  void exportarReceta(Receta rec) throws JAXBException {
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Receta.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		//jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		// Escribiendo en un fichero
		File XMLfile = new File("./recursos/RecetaExportada.xml");
		jaxbM.marshal(rec, XMLfile);
		// Escribiendo por pantalla
		//jaxbM.marshal(book, System.out);
	}
	
	public Recetario  inicializarRecetario() throws JAXBException {
		JAXBContext jaxbC = JAXBContext.newInstance(Recetario.class);
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		File XMLfile = new File("./recursos/Recetario.xml");
		Recetario rec1 = (Recetario) jaxbU.unmarshal(XMLfile);
		return rec1;
	}
	
	public Recetario importarRecetario(String ruta) throws JAXBException {
		JAXBContext jaxbC = JAXBContext.newInstance(Recetario.class);
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		File fichero = new File(ruta);
		Recetario rec1 = (Recetario) jaxbU.unmarshal(fichero);
		return rec1;
	}
	
	public Receta importarReceta(String ruta) throws JAXBException {
		JAXBContext jaxbC = JAXBContext.newInstance(Receta.class);
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		File fichero = new File(ruta);
		Receta rec1 = (Receta) jaxbU.unmarshal(fichero);
		return rec1;
	}

}

