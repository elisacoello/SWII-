package pojos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "receta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Receta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlAttribute
	private String dificultad;
	@XmlAttribute
	private String tipo;
	
	@XmlElement
	private String nombreReceta;
	
	@XmlElement(name = "ingrediente")
	@XmlElementWrapper(name = "ingredientes")
	private ArrayList<Ingrediente> ingredientes;
	
	@XmlElement
	private String instrucciones;

	@XmlTransient
	private Recetario recetario;
	
	public Receta() {
		super();
		ingredientes = new ArrayList<>();
	}

	public Receta(String dificultad, String tipo, String nombreReceta, ArrayList<Ingrediente> ingredientes,
			String instrucciones) {
		super();
		this.dificultad = dificultad;
		this.tipo = tipo;
		this.nombreReceta = nombreReceta;
		this.ingredientes = ingredientes;
		this.instrucciones = instrucciones;
	}

	public Recetario getRecetario() {
		return recetario;
	}

	public void setRecetario(Recetario recetario) {
		this.recetario = recetario;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}

	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void addIngrediente(Ingrediente i) {
		if(!ingredientes.contains(i))
			ingredientes.add(i);
	}
	
	public void removeIngrediente(Ingrediente i) {
		ingredientes.remove(i);
	}
	
	public String getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}
	
	
	@Override
	public String toString() {
		return "\n\nReceta:"+ "\n (dificultad= " + dificultad + ", tipo= " + tipo + ")" +"\n nombreReceta= " + nombreReceta
				+ "\n ingredientes:" + ingredientes + "\n instrucciones= " + instrucciones;
	}
	
	
	
}
