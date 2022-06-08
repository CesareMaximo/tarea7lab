package Dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class seguroDAO {

	private static final String insert = "INSERT INTO seguros(descripcion,idTipo,costoContratacion,costoAsegurado) VALUES(?, ?, ?,?)";
	private static final String delete = "delete from seguros where idSeguro = ?";
	private static final String obtenerID = "SELECT idSeguro FROM seguros ORDER BY idSeguro DESC LIMIT 1";
	private static final String listar = "SELECT S.idSeguro, S.descripcion, S.idTipo, S.costoContratacion, S.costoAsegurado, TP.descripcion AS des, TP.idTipo AS id FROM Seguros S inner join tiposeguros TP on S.IdTipo = TP.idTipo WHERE S.idTipo=?";
	private static final String readall = "SELECT S.idSeguro, S.descripcion, S.idTipo, S.costoContratacion, S.costoAsegurado, TP.descripcion AS des, TP.idTipo AS id FROM Seguros S inner join tiposeguros TP on S.IdTipo = TP.idTipo";
	

	public boolean agregarSeguro(seguro se) {

		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, se.getDescripcion());
			statement.setInt(2, se.getIdTipo().getIdTipo());
			statement.setFloat(3, se.getCostoContratacion());
			statement.setFloat(4, se.getCostoAsegurado());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isInsertExitoso;
	}

	public ArrayList<seguro> obtenerSeguros() {

		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<seguro> Seguros = new ArrayList<seguro>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Seguros.add(getSeguro(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Seguros;

	}

	private seguro getSeguro(ResultSet resultSet) throws SQLException {

		int idSeguro = resultSet.getInt("idSeguro");
		tipoSeguro tipo = new tipoSeguro();
		String descripcion = resultSet.getString("descripcion");
		tipo.setIdTipo(resultSet.getInt("idTipo"));
		float costoC = resultSet.getFloat("costoContratacion");
		float costoA = resultSet.getFloat("costoAsegurado");

		return new seguro(idSeguro, descripcion, tipo, costoC, costoA);
	}

	public int obtenerID() {

		PreparedStatement statement;
		ResultSet rs;
		int ultimoID = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(obtenerID);
			rs = statement.executeQuery();
			while (rs.next()) {

				ultimoID = rs.getInt("idSeguro");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ultimoID;

	}

	public ArrayList<seguro> obtenerTodosLosSegurosPorId(int idTipo)
	{
		
		ArrayList<seguro> lista = new ArrayList<seguro>(); 
		Conexion conexion = Conexion.getConexion();
		
		try
		{
			
			PreparedStatement statement = conexion.getSQLConexion().prepareStatement(listar);
			statement.setInt(1, idTipo);
			ResultSet rs = statement.executeQuery();

			while(rs.next())
			{
				seguro sg =new seguro();
				tipoSeguro ts = new tipoSeguro();
				sg.setIdSeguro(rs.getInt("idSeguro"));
				sg.setDescripcion(rs.getString("descripcion"));
				ts.setIdTipo(rs.getInt("id"));
				ts.setDescripcion(rs.getString("des"));
				sg.setIdTipo(ts);
				sg.setCostoContratacion(rs.getFloat("costoContratacion"));
				sg.setCostoAsegurado(rs.getFloat("costoAsegurado"));
				lista.add(sg);
			}
			 
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
		  return lista;
	}
	
	public ArrayList<seguro> obtenerTodosLosSeguros()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<seguro> lista = new ArrayList<seguro>(); 
		Conexion conexion = Conexion.getConexion();
		
		  try
		  {

			  PreparedStatement statement = conexion.getSQLConexion().prepareStatement(readall);
			 ResultSet rs = statement.executeQuery();

			while(rs.next())
			{
				seguro sg =new seguro();
				tipoSeguro ts = new tipoSeguro();
				sg.setIdSeguro(rs.getInt("idSeguro"));
				sg.setDescripcion(rs.getString("descripcion"));
				ts.setIdTipo(rs.getInt("id"));
				ts.setDescripcion(rs.getString("des"));
				sg.setIdTipo(ts);
				sg.setCostoContratacion(rs.getFloat("costoContratacion"));
				sg.setCostoAsegurado(rs.getFloat("costoAsegurado"));
				lista.add(sg);
			}
			 
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}

		  return lista;
	}
}
