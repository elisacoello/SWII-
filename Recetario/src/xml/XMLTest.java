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
	public static void main(String[] args) throws JAXBException, IOException {
		MyLogger.setupFromFile();
		Recetario rec = generarRecetario();
		Recetario rec2 = generarRecetario2();
		
		LOGGER.warning("Mensaje de warning");
		marshalling1(rec);
		marshalling1(rec2);
		
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
		Receta receta2 = new Receta();
				
		receta.setNombreReceta("Ensalada de maiz");
		receta.setInstrucciones("Cocinar el maiz");
		receta.setDificultad("facil");
		receta.setTipo("mediterranea");
		
		receta2.setNombreReceta("Ensalada de puerro");
		receta2.setInstrucciones("Cocinar el puerro");
		receta2.setDificultad("media");
		receta2.setTipo("Arabe");
		
		
		
		ArrayList<Ingrediente> ingredientes = new ArrayList<>(); 
		Ingrediente ingrediente = new Ingrediente();
		
		ArrayList<Ingrediente> ingredientes2 = new ArrayList<>(); 
		Ingrediente ingrediente2 = new Ingrediente();
		
		ingrediente.setCantidad("0");
		ingrediente.setNombreIngrediente("Maiz");
		ingrediente2.setCantidad("2");
		ingrediente2.setNombreIngrediente("puerro");
		ingrediente.setReceta(receta);
		ingredientes.add(ingrediente);
		receta.setIngredientes(ingredientes);
		ingredientes2.add(ingrediente2);
		receta2.setIngredientes(ingredientes2);
		ingrediente2.setReceta(receta2);		
	
		recetario.addReceta(receta);
		recetario.addReceta(receta2);
		
		return recetario;
	}
	
	public  void marshalling(Recetario rec) throws JAXBException {
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Recetario.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		jaxbM.setProperty("com.sun.xml.bind.xmlHeaders", "\n<!DOCTYPE recetario SYSTEM \"DTD.dtd\">");
		//jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		// Escribiendo en un fichero
		File XMLfile = new File("./recursos/RecetarioBakano.xml");
		jaxbM.marshal(rec, XMLfile);
		// Escribiendo por pantalla
		//jaxbM.marshal(book, System.out);
	}
	public static void marshalling1(Recetario rec) throws JAXBException {
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Recetario.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		jaxbM.setProperty("com.sun.xml.bind.xmlHeaders", "\n<!DOCTYPE recetario SYSTEM \"DTD.dtd\">");
		//jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		// Escribiendo en un fichero
		File XMLfile = new File("./recursos/RecetarioBakano.xml");
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
	
	public void exportarRecetario(Recetario rec) throws IOException {
	
		FileReader fr = new FileReader("./recursos/Recetario.xml");
		
		FileWriter fw = new FileWriter("./recursos/Exportar.xml");
		
		String str = ""; 
		   
        int i; 
		
		while ((i = fr.read()) != -1) { 
			  
             // Storing every character in the string 
             str += (char)i; 
         } 
		
		fw.write(str);
		
		 fr.close(); 
         fw.close(); 
	}
}

