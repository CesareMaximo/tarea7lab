package Dominio;

public class contratacion {

	private int idContratacion;
	private String nombreUsuario;
	private seguro SeguroX;
	private float costoContratacion;
	
	
	
	public int getIdContratacion() {
		return idContratacion;
	}
	public void setIdContratacion(int idContratacion) {
		this.idContratacion = idContratacion;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public seguro getSeguroX() {
		return SeguroX;
	}
	public void setSeguroX(seguro seguroX) {
		SeguroX = seguroX;
	}
	public float getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	@Override
	public String toString() {
		return "contratacion [idContratacion=" + idContratacion + ", nombreUsuario=" + nombreUsuario + ", SeguroX="
				+ SeguroX + ", costoContratacion=" + costoContratacion + "]";
	}
	
	public contratacion(int idContratacion, String nombreUsuario, seguro seguroX, float costoContratacion) {
		super();
		this.idContratacion = idContratacion;
		this.nombreUsuario = nombreUsuario;
		SeguroX = seguroX;
		this.costoContratacion = costoContratacion;
	}
	
	
	
	
}
