package interfaz;

import java.io.File;
import java.io.IOException;
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
		int cerrojo = 0;
		Ingrediente ingrediente = new Ingrediente();
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		
		Scanner entrada;
		entrada = new Scanner(System.in);
		Recetario rec = new Recetario();
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
				System.out.println("Introduzca la ruta del fichero a importar\n");
				String ruta = entrada.nextLine();
				rec = xml.importarRecetario(ruta);
				break;
			case(3):
				xml.exportarRecetario();
				System.out.println("Exportación correcta\n");
				break;
			case(4):
				
				System.out.println("Introduzca la receta que desea importar\n");
				System.out.println("Introduzca la dificultad de la receta:\n");
				String dificultad = entrada.nextLine();
				System.out.println("Introduzca el tipo de la receta:\n");
				String tipo = entrada.nextLine();
				System.out.println("Introduzca el nombre de la receta:\n");
				String nombreReceta = entrada.nextLine();
				System.out.println("Introduce ingredientes\n");
			
				
				while(cerrojo == 0) {
					System.out.println("Introduce nombre de ingrediente (cuando haya terminado teclee fin):\n");
					String nombreIngrediente = entrada.nextLine();
					System.out.println(nombreIngrediente + "\n");
					if(nombreIngrediente != "fin") {
						ingrediente.setNombreIngrediente(nombreIngrediente);
						System.out.println("Introduce cantidad\n");
						String cantidad = entrada.nextLine();
						ingrediente.setCantidad(cantidad);
						ingredientes.add(ingrediente);
					}
					else {
						cerrojo = 1;
					}
				}
				System.out.println("Introduzca las instrucciones de la receta:\n");
				String instrucciones = entrada.nextLine();
				Receta receta = new Receta(dificultad, tipo, nombreReceta, ingredientes, instrucciones);
				rec.addReceta(receta);
				XMLTest.marshalling(rec);	
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
				break;
			case(10):
				System.out.println(rec);
				break;
			default:
				System.out.println("Opción no válida\n");
				break;
			
				
			}
		}
		entrada.close();

	}

}
