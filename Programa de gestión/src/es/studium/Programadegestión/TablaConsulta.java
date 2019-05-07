package es.studium.Programadegestión;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaConsulta {
	int tamano;
	ArrayList<String> listaClientesTituloR;
	ArrayList<String> listaClientesBusquedaR;
	String nombreTablaR;

	DefaultTableModel modelo = new DefaultTableModel();	

	String t;	
	public JTable TablaConsulta(ArrayList<String> listaClientesTitulo, ArrayList<String> listaClientesBusqueda, String nombreTabla) {
		tamano=listaClientesTitulo.size();
		listaClientesTituloR=listaClientesTitulo;
		listaClientesBusquedaR=listaClientesBusqueda;
		nombreTablaR=nombreTabla;

		String login = "";
		login="admin";
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tiendaPractica?autoReconnect=true&useSSL=false";
		String password = "Studium2018;";
		String sentencia;
		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet rs = null;
		try
		{
			//Cargar los controladores para el acceso a la BD
			String palabro="";
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL

			Vector columnNames=new Vector();
			
			for(int i=0;i<tamano;i++) {
				modelo.addColumn(listaClientesTituloR.get(i));
				columnNames.addElement(listaClientesTituloR.get(i));				
			}	
			modelo.setColumnIdentifiers(columnNames);
			for(int i=0; i<tamano;i++) 
			{
				if(i==0) {
				palabro=listaClientesBusquedaR.get(i);	
				}
				palabro= palabro+", "+listaClientesBusquedaR.get(i);					
			}
			sentencia = "Select "+palabro+" from tiendaPractica."+nombreTablaR+";";
			rs = statement.executeQuery (sentencia);
			while(rs.next()) {
				Object [] fila = new Object[tamano];
				for(int i=0; i<tamano;i++) {
					fila[i] = rs.getString(listaClientesBusquedaR.get(i));
				}
				modelo.addRow(fila);
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error de Clase: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL: "+sqle.getMessage());
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					rs.close();
					statement.close();
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error al cerrar SQL: "+e.getMessage());
			}
		}
		JTable tabla = new JTable(modelo);
		return tabla;
	}
}