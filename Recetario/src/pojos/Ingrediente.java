package pojos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ingrediente")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "nombreIngrediente", "cantidad" })
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private String nombreIngrediente;
	@XmlElement
	private String cantidad;
	
	@XmlTransient
	private Receta receta;
	
	public Ingrediente() {
		super();
	}
	

	public Ingrediente(String nombreIngrediente, String cantidad) {
		super();
		this.nombreIngrediente = nombreIngrediente;
		this.cantidad = cantidad;
	}

	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((nombreIngrediente == null) ? 0 : nombreIngrediente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (nombreIngrediente == null) {
			if (other.nombreIngrediente != null)
				return false;
		} else if (!nombreIngrediente.equals(other.nombreIngrediente))
			return false;
		return true;
	}


	public Receta getReceta() {
		return receta;
	}


	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public String getNombreIngrediente() {
		return nombreIngrediente;
	}
	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "\n\tIngrediente: [nombreIngrediente=" + nombreIngrediente + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
	
	
	
	
	
}
