package Dominio;

public class usuarioDAO {

	
	private static final String insert = "INSERT INTO usuarios(nombreUsuario,pass,tipoUsuario,dni,nombre,apellido) VALUES(?, ?, ?,?,?,?)";
	private static final String delete = "delete from usuarios where nombreUsuario like  ?";
	private static final String readall = "SELECT * FROM usuarios";
}
