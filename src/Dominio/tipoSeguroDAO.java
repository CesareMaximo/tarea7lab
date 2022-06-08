package Dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class tipoSeguroDAO {

	
	
	private static final String insert = "INSERT INTO tiposeguros(idTipo,descripcion) VALUES(?, ?)";
	private static final String delete = "delete from tiposeguros where idTipo= ?";
	private static final String readall = "SELECT * FROM tiposeguros";
	
	
	public ArrayList<tipoSeguro> obtenerTipoSeguro(){
		

		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<tipoSeguro> tipoSeguros = new ArrayList<tipoSeguro>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				tipoSeguros.add(getTipoSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tipoSeguros;
		
	}
	
	private tipoSeguro getTipoSeguro(ResultSet resultSet) throws SQLException
	{
		int idTipo= resultSet.getInt("idTipo");
		String descripcion = resultSet.getString("descripcion");
		
		
		return new tipoSeguro(idTipo,descripcion);
	}
	
}
