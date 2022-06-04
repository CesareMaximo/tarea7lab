package Dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import daolmpl.Conexion;

public class seguroDAO {
	
	
	
	private static final String insert = "INSERT INTO seguros(descripcion,idTipo,costoContratacion,costoAsegurado) VALUES(?, ?, ?,?)";
	private static final String delete = "delete from seguros where idSeguro = ?";
	private static final String readall = "SELECT * FROM seguros";
	
	
	public boolean agregarSeguro(seguro se) {
		
		
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, se.getDescripcion());
			statement.setInt(2, se.getTipo().getIdTipo());
			statement.setFloat(3, se.getCostoContratacion());
			statement.setFloat(4, se.getCostoAsegurado());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	
public ArrayList<seguro> obtenerSeguros(){
		

		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<seguro> Seguros = new ArrayList<seguro>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Seguros.add(getSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Seguros;
		
	}
	
private seguro getSeguro(ResultSet resultSet) throws SQLException
{
	
	int idSeguro = resultSet.getInt("idSeguro");
	tipoSeguro tipo = new tipoSeguro();
	String descripcion = resultSet.getString("descripcion");
	tipo.setIdTipo(resultSet.getInt("idTipo"));
	float costoC = resultSet.getFloat("costoContratacion");
	float costoA = resultSet.getFloat("costoAsegurado");
	
	
	
	
	
	return new seguro(idSeguro,descripcion,tipo,costoC,costoA);
}
	
}
