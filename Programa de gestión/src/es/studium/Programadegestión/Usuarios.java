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
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			//Aqui comprobamos si el usuario es correcto respecto a su contraseña encriptada usando MD5
			sentencia ="select * from tiendapractica.usuarios where nombreUsuario ='"+usuario+"'and claveUsuario= MD5('"+contraseña+"');";
			rs = statement.executeQuery(sentencia);
			if(rs.next())
			{
				//En caso de que de correcto continuará
				Registro(usuario);
				if(usuario.equals("Admin")) {
					Guardar(usuario);
					VentanaAdmin va = new VentanaAdmin();
				}else{
					Guardar(usuario);
					VentanaUsuario vu =new VentanaUsuario();
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
		//Manda de nuevo al inicio identificando que se ha producido un error
		new ErrorRegistro();
	}

	private void Guardar(String usuario) {
		//Aqui guardaremos el registro activo del usuario actual 
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

	private void Registro(String usuario) {
		//Aqui guardamos el registro del usuario con su hora correspondiente
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+usuario+"]"+"[LOG IN ...]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}
	}
		
}
