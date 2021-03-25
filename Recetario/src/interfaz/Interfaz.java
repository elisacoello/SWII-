package interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;

import pojos.Ingrediente;
import pojos.Receta;
import pojos.Recetario;
import xml.ImportarPersona;
import xml.XMLTest;
public class Interfaz {

	public static void main(String[] args) throws JAXBException, IOException, XQException {
		int opcion = 0;
		boolean cerrojo = true;
		Ingrediente ingrediente = new Ingrediente();
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner entrada;
		entrada = new Scanner(System.in);
		Recetario rec = new Recetario();
		Receta receta = new Receta();
		XMLTest xml = new XMLTest();
		while(opcion!=11) {
			System.out.println("Bienvenido a su recetario\n" + "¿Qué desea hacer?\n");
			System.out.println("1. Inicializar recetario\n");
			System.out.println("2. Importar Recetario\n");
			System.out.println("3. Exportar Recetario\n");
			System.out.println("4. Importar una receta\n");
			System.out.println("5. Exportar una receta\n");
			System.out.println("6. Validar XML con DTD\n");
			System.out.println("7. Sentencias XPath\n");
			System.out.println("8. Sentencias XQuery\n");
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
				System.out.println("Introduzca el fichero a importar\n");
				String ruta = br.readLine();
				rec = xml.importarRecetario(ruta);
				break;
			case(3):
				xml.marshalling(rec);
				System.out.println("Exportación correcta\n");
				break;
			case(4):
				System.out.println("Introduzca el fichero a importar\n");
				String ruta1 = br.readLine();
				receta = xml.importarReceta(ruta1);
				break;
			case(5):
				break;
			case(6):
				break;
			case(7):
				break;
			case(8):
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
