package Dominio;

public class contratacionDAO {


	private static final String insert = "INSERT INTO contratacion(idContratacion,nombreUsuario,idSeguro,costoContratacion) VALUES(?, ?, ?,?)";
	private static final String delete = "delete from contratacion where idContratacion= ?";
	private static final String readall = "SELECT * FROM contratacion";
	
	
}
