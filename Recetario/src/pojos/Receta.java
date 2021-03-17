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
	
	@XmlElement(name="instrucciones")

	@XmlTransient
	private Recetario recetario;
	
	public Receta() {
		super();
		ingredientes = new ArrayList<>();
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
	
	
	
	
	
}
