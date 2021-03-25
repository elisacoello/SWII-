package pojos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "recetario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Recetario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "receta")
	private ArrayList<Receta> recetas;
	
	public Recetario() {
		super();
		recetas = new ArrayList<>();
	}

	public ArrayList<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(ArrayList<Receta> recetas) {
		this.recetas = recetas;
	}
	
	public void addReceta(Receta r) {
		if(!recetas.contains(r))
			recetas.add(r);
	}
	
	public void removeReceta(Receta r) {
		recetas.remove(r);
	}
	public Receta buscarReceta(String nombre) {
		Receta resultado = null;
		for(Receta receta: recetas) {
			if(receta.getNombreReceta().equals(nombre)) {
				resultado = receta;
				break;
			}
		}
		return resultado;
	}
	@Override
	public String toString() {
		return "Recetario:" + recetas.toString();
	}
	
	
	
}
