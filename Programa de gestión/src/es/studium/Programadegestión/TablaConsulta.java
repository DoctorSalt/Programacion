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
	//Este es el atributo de TablaConsulta que medira el tamaño de la cantidad de columnas que abrán
	int tamano;
	//Un array consiste en los nombres titulo que pondremos en la tabla
	ArrayList<String> listaClientesTituloR;
	//Este otro seran otros utilizados para buscar en la base de datos
	ArrayList<String> listaClientesBusquedaR;
	//Otro atributo este sirve para identificar
	String nombreTablaR;

	DefaultTableModel modelo = new DefaultTableModel();	

	public JTable tablaConsultaAplicacion(ArrayList<String> listaClientesTitulo, ArrayList<String> listaClientesBusqueda, String nombreTabla) {
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
			String palabro="";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			Vector columnNames=new Vector();
			
			for(int i=0;i<tamano;i++) {
				modelo.addColumn(listaClientesTituloR.get(i));
				columnNames.addElement(listaClientesTituloR.get(i));				
			}	
			modelo.setColumnIdentifiers(columnNames);
			for(int i=0; i<tamano;i++) 
			{
				//Esto lo pongo para al escribir las columnas el primer registro
				//Sin coma y los siguientes con ella
				if(i==0) {
				palabro=listaClientesBusquedaR.get(i);	
				}else {
				palabro= palabro+", "+listaClientesBusquedaR.get(i);					
				}
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