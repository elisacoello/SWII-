package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import logging.MyLogger;
import pojos.Ingrediente;
import pojos.Receta;
import pojos.Recetario;

public class XMLTest {
	final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void main(String[] args) throws JAXBException, IOException {
		MyLogger.setupFromFile();
		Recetario rec = generarRecetario();
		LOGGER.warning("Mensaje de warning");
		marshalling(rec);
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
		
		ingrediente.setCantidad(0);
		ingrediente.setNombreIngrediente("Pollo");
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
	/*
	private static void unMarshalling() throws JAXBException {
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Empleado.class);
		// Creamos el JAXBMarshaller
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		// Leyendo un fichero
		File XMLfile = new File("./xml/Empleado1.xml");
		// Creando el objeto
		Empleado empl1 = (Empleado) jaxbU.unmarshal(XMLfile);
		// Escribiendo por pantalla el objeto
		System.out.println(empl1);
	}
	
	private static Empleado randomEmpleado() {
		String nombre = randomString(empleadosNombres);
		String apellido = randomString(empleadosApellidos);
		int dia = (int) (Math.random() * 30);
		double sueldo = (double) (18000 + Math.random() * 5000);
		return new Empleado(contador++, nombre, apellido, "1990-01-"+dia, sueldo);
	}
	
	private static String randomString(String[] array) {
		int index = (int) (Math.random() * array.length);
		return array[index];
	}
	*/
}
