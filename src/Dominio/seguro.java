package Dominio;

public class seguro {
	
	private int idSeguro;
	private String descripcion;
	private tipoSeguro idTipo;
	private float costoContratacion;
	private float costoAsegurado;
	
	public seguro() {
		
	}
	
	
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public tipoSeguro getTipo() {
		return idTipo;
	}
	public void setIdTipo(tipoSeguro tipo) {
		this.idTipo = tipo;
	}
	public float getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public float getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
	@Override
	public String toString() {
		return "seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", tipo=" + idTipo
				+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}
	public seguro(int idSeguro, String descripcion, tipoSeguro tipo, float costoContratacion, float costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.idTipo = tipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}

	
	
	
	
}
