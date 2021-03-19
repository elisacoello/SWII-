package xml;

import java.io.File;
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
	public static void main(String[] args) throws JAXBException, IOException {
		MyLogger.setupFromFile();
		Recetario rec = generarRecetario();
		Recetario rec2 = generarRecetario2();
		
		LOGGER.warning("Mensaje de warning");
		marshalling(rec);
		marshalling(rec2);
		
		//unMarshalling();
	}
	
	private static Recetario generarRecetario(){
		Recetario recetario = new Recetario();
		
		Receta receta = new Receta();
		receta.setNombreReceta("Ensalada de maiz y pollo");
		receta.setInstrucciones("Cocinar el maiz con sal");
		receta.setDificultad("facil");
		receta.setTipo("mediterranea");
		ArrayList<Ingrediente> ingredientes = new ArrayList<>(); 
		Ingrediente ingrediente = new Ingrediente();
		
		ingrediente.setCantidad("0");
		ingrediente.setNombreIngrediente("Pollo");
		ingrediente.setReceta(receta);
				
		ingredientes.add(ingrediente);
		receta.setIngredientes(ingredientes);
		recetario.addReceta(receta);
		
		return recetario;
	}
	
	private static Recetario generarRecetario2(){
		Recetario recetario = new Recetario();
		
		Receta receta = new Receta();
		receta.setNombreReceta("Ensalada de maiz");
		receta.setInstrucciones("Cocinar el maiz");
		receta.setDificultad("facil");
		receta.setTipo("mediterranea");
		ArrayList<Ingrediente> ingredientes = new ArrayList<>(); 
		Ingrediente ingrediente = new Ingrediente();
		
		ingrediente.setCantidad("0");
		ingrediente.setNombreIngrediente("Maiz");
		ingrediente.setReceta(receta);
				
		ingredientes.add(ingrediente);
		receta.setIngredientes(ingredientes);
		recetario.addReceta(receta);
		
		return recetario;
	}
	
	private static void marshalling(Recetario rec) throws JAXBException {
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Recetario.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		jaxbM.setProperty("com.sun.xml.bind.xmlHeaders", "\n<!DOCTYPE recetario SYSTEM \"DTD.dtd\">");
		//jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		// Escribiendo en un fichero
		File XMLfile = new File("./recursos/Recetariobaby.xml");
		jaxbM.marshal(rec, XMLfile);
		// Escribiendo por pantalla
		//jaxbM.marshal(book, System.out);
	}
	
	private static void unMarshalling() throws JAXBException {
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Recetario.class);
		// Creamos el JAXBMarshaller
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		// Leyendo un fichero
		File XMLfile = new File("./recursos/Recetario.xml");
		// Creando el objeto
		Recetario rec1 = (Recetario) jaxbU.unmarshal(XMLfile);
		// Escribiendo por pantalla el objeto
		System.out.println(rec1);
		//System.out.println(rec1.toString());
	}
	
	
	public Recetario  inicializarRecetario() throws JAXBException {
		JAXBContext jaxbC = JAXBContext.newInstance(Recetario.class);
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		File XMLfile = new File("./recursos/Recetario.xml");
		Recetario rec1 = (Recetario) jaxbU.unmarshal(XMLfile);
		return rec1;
	}
	
}

