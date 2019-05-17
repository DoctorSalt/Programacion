package es.studium.Programadegestión;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;


public class Usuarios {
	
	Usuarios(String usuario, String contraseña){
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tiendapractica?autoReconnect=true&useSSL=false";
		String login = "remoto";
		String password = "Studium2018;";
		String sentencia;
		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet rs = null;
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL
						
			//select * from usuarios where nombreUsuario ='admin' and claveUsuario = 'Super';
			sentencia ="select * from tiendapractica.usuarios where nombreUsuario ='"+usuario+"'and claveUsuario= MD5('"+contraseña+"');";
			rs = statement.executeQuery(sentencia);
			if(rs.next())
			{
				System.out.println("Registro OK");
				Registro(usuario);
				if(usuario.equals("Admin")) {
					Guardar(usuario);
					VentanaAdmin va = new VentanaAdmin("Ventana Administrador");
				}else{
					Guardar(usuario);
					VentanaUsuario vu =new VentanaUsuario("Ventana Usuario");
				}
			}
			else
			{
				Error();
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
	}

	private void Error() {
		new ErrorRegistro();
	}

	private void Guardar(String usuario) {
		//FileWriter también puede lanzar una excepción
		try
		{
			// Destino de los datos
			FileWriter fw = new FileWriter("RegistroActivo.log");
			// Buffer de escritura
			BufferedWriter bw = new BufferedWriter(fw);
			// Objeto para la escritura
			PrintWriter salida = new PrintWriter(bw);
			//Guardamos la primera línea
			salida.println(usuario);
			//Cerrar el objeto salida, el objeto bw y el fw
			salida.close();
			bw.close();
			fw.close();
		}
		catch(IOException i)
		{
			System.out.println("Se produjo un error de Archivo");
		}		
	}

	private void Registro(String i) {
		
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+i+"]"+"[LOG IN ...]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}
	}
		
}
