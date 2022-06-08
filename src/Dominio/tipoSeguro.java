package Dominio;

public class tipoSeguro {

	private int idTipo;
	private String Descripcion;
	
	@Override
	public String toString() {
		return "tipoSeguro [idTipo=" + idTipo + ", Descripcion=" + Descripcion + "]";
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	public tipoSeguro(int idTipo, String descripcion) {
		super();
		this.idTipo = idTipo;
		Descripcion = descripcion;
	}
	
	
	
	public tipoSeguro() {}
	
}
