package interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xquery.XQException;

import org.xml.sax.SAXException;

import pojos.Ingrediente;
import pojos.Receta;
import pojos.Recetario;
import xml.ImportarPersona;
import xml.RecetarioXPath;
import xml.RecetarioXQuery;
import xml.Validar_DTD;
import xml.XMLTest;
public class Interfaz {

	public static void main(String[] args) throws JAXBException, IOException, XQException, XPathExpressionException, SAXException, ParserConfigurationException {
		int opcion = 0;
		boolean cerrojo = true;
		Ingrediente ingrediente = new Ingrediente();
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner entrada;
		entrada = new Scanner(System.in);
		Recetario rec = new Recetario();
		Receta receta = new Receta();
		Receta recete = new Receta();
		XMLTest xml = new XMLTest();
		RecetarioXQuery xquery = new RecetarioXQuery();
		RecetarioXPath xpath = new RecetarioXPath();
		Validar_DTD val_dtd = new Validar_DTD();
		while(opcion!=11) {
			System.out.println("Bienvenido a su recetario\n" + "¿Qué desea hacer?\n");
			System.out.println("1. Inicializar recetario\n");
			System.out.println("2. Importar Recetario\n");
			System.out.println("3. Exportar Recetario\n");
			System.out.println("4. Importar una receta\n");
			System.out.println("5. Exportar una receta\n");
			System.out.println("6. Validar XML con DTD\n");
			System.out.println("7. Sentencias XPath\n");
			System.out.println("77. Sentencias XPath predefinida\n");
			System.out.println("8. Sentencias XQuery\n");
			System.out.println("88. Sentencia XQuery predefinida\n");
			System.out.println("9. Añadir receta por consola\n");
			System.out.println("10. Mostrar todas las recetas\n");
			System.out.println("11. Salir\n");
			
			
			opcion = entrada.nextInt();	
			
			switch(opcion) {
			case(1):
				System.out.println("Iniciando recetario por defecto...\n");
				rec = xml.inicializarRecetario();
				System.out.println("Importación correcta\n");
				break;
			case(2):
				System.out.println("Introduzca el fichero del recetario a importar\n");
				String ruta = br.readLine();
				rec = xml.importarRecetario(ruta);
				break;
			case(3):
				xml.exportarRecetario(rec);
				System.out.println("Exportación correcta\n");
				break;
			case(4):
				System.out.println("Introduzca el fichero con la receta a importar\n");
				String ruta1 = br.readLine();
				receta = xml.importarReceta(ruta1);
				rec.addReceta(receta);
				break;
			case(5):
				System.out.println("Introduce el nombre de la receta que quieres buscar\n");
				String nombre = br.readLine();
				recete = rec.buscarReceta(nombre);
				xml.exportarReceta(recete);				
				break;
			case(6):
				System.out.println("Introduzca el xml a validar por el DTD\n");
				String rutaXml = br.readLine();
				val_dtd.ejecutarValidador(rutaXml);
				break;
			case(66):
				//Elisa
				//Cambiar el mensaje aquí y arriba en la descripción de las funcionesalgo como "XQUERY - OBTENER.... y lo que obtenga la query.
				//Hacer lo mismo con XPath
				System.out.println("Ejecutando Validador XML por la cara");
				String rutaxml = "./recursos/recetario_para_DTD.xml";
				val_dtd.ejecutarValidador(rutaxml);
				break;
				
			case(7):
				System.out.println("Introduzca la sentencia XPath");
				String sentencia_xPath = br.readLine();
				xpath.ejecutarXPath(sentencia_xPath);
				break;
				
			case(77):
				//Elisa
				//Cambiar el mensaje aquí y arriba en la descripción de las funcionesalgo como "XQUERY - OBTENER.... y lo que obtenga la query.
				//Hacer lo mismo con XPath
				System.out.println("Ejecutando XPath por la cara");
				String sentencia = "//receta[@dificultad='facil']";
				xpath.ejecutarXPath(sentencia);
				break;
			case(8):
				System.out.println("Introduzca el fichero xquery");
				String ruta_xquery = br.readLine();
				xquery.ejecutarXQuery(ruta_xquery);
				break;
			case(88):
				//Elisa
				//Cambiar el mensaje aquí y arriba en la descripción de las funcionesalgo como "XQUERY - OBTENER.... y lo que obtenga la query.
				//Hacer lo mismo con XPath
				System.out.println("Ejecutando XQuery por la cara");
				
				xquery.ejecutarXQuery("./recursos/prueba_XQuery.xq");
				break;
				
			case(9):
				System.out.println("Introduzca la receta que desea importar\n");
				System.out.println("Introduzca la dificultad de la receta:\n");
				String dificultad = br.readLine();
				System.out.println("Introduzca el tipo de la receta:\n");
				String tipo = br.readLine();
				System.out.println("Introduzca el nombre de la receta:\n");
				String nombreReceta = br.readLine();
				System.out.println("Introduce ingredientes\n");
			
				
				while(cerrojo == true) {
					System.out.println("Introduce nombre de ingrediente:\n");
					String nombreIngrediente = br.readLine();
					ingrediente.setNombreIngrediente(nombreIngrediente);
					System.out.println("Introduce cantidad\n");
					String cantidad = br.readLine();
					ingrediente.setCantidad(cantidad);
					ingredientes.add(ingrediente);
					System.out.println("Has terminado de introducir ingredientes? (0 no| 1 si)\n");
					int variable = entrada.nextInt();
					if (variable == 1) {
						break;
					}
				}
				System.out.println("Introduzca las instrucciones de la receta:\n");
				String instrucciones = br.readLine();
				Receta receta1 = new Receta(dificultad, tipo, nombreReceta, ingredientes, instrucciones);
				rec.addReceta(receta1);	
				break;
			case(10):
				System.out.println(rec);
				break;
			case(11):
				System.out.println("Saliendo del recetario");
				break;
			default:
				System.out.println("Opción no válida\n");
				break;
			
				
			}
			
			
			
		}
		entrada.close();

	}

}
