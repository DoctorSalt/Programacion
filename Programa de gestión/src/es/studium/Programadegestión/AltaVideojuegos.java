package es.studium.Programadegestión;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class AltaVideojuegos  extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;

	Label nombre = new Label("Nombre:");
	Label generos = new Label("Generos:");
	Label plataforma = new Label("Plataforma:");
	
	TextField respuestaNombre = new TextField(9);
	TextField respuestaGenero = new TextField(9);
	TextField respuestaPlataforma = new TextField(6);
	
	String usuario="";
	String nombreS;
	String generosS;
	String plataformasS;
	
	
	Button alta = new Button("Alta");
	Button limpiar = new Button("Limpiar");
	
	Dialog correcto = new Dialog(this,"Alta correcta");
	Dialog incorrecto = new Dialog(this, "Alta fallida");
	
	Label bien = new Label("Alta Correcta");
	Label mal = new Label("Se ha producido un error en la Alta");
	
	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");
	
	Panel panel1 = new Panel(new FlowLayout());
	Panel panel2 = new Panel(new FlowLayout());
	Panel panel3 = new Panel(new FlowLayout());
	Panel panel4 = new Panel(new FlowLayout());
	
	AltaVideojuegos(){
		setTitle("Alta Videojuegos");
		setLocationRelativeTo(null);
		setSize(300,200);
		setLayout(new GridLayout(4,1));
		setResizable(false);
		add(panel1);
		panel1.add(nombre);
		panel1.add(respuestaNombre);
		add(panel2);
		panel2.add(generos);
		panel2.add(respuestaGenero);
		add(panel3);
		panel3.add(plataforma);
		panel3.add(respuestaPlataforma);
		add(panel4);
		panel4.add(alta);
		panel4.add(limpiar);
		addWindowListener(this);
		alta.addActionListener(this);
		limpiar.addActionListener(this);	
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(limpiar))
		{		
			respuestaNombre.setText("");
			respuestaGenero.setText("");
			respuestaPlataforma.setText("");
		}else
		if(arg0.getSource().equals(alta))
		{
				nombreS = respuestaNombre.getText();
				generosS = respuestaGenero.getText(); 
				plataformasS = respuestaPlataforma.getText();
				if((nombreS.equals(""))||(generosS.equals(""))||(plataformasS.equals(""))) {
					Incorrecto();
				}else {
					Cargar();
					ProcesosDeRegistro();
					Correcto();
					Registro(usuario);
				}		
		}else if (arg0.getSource().equals(aceptar1)) {
			correcto.setVisible(false);
		}else if (arg0.getSource().equals(aceptar2)) {
			incorrecto.setVisible(false);
		}
	}


	private void Correcto() {
		correcto.setVisible(true);
		correcto.setLocationRelativeTo(null);
		correcto.setSize(100,100);
		correcto.setLayout(new FlowLayout());
		correcto.setResizable(false);
		correcto.add(bien);
		correcto.add(aceptar1);
		correcto.addWindowListener(this);
		aceptar1.addActionListener(this);
	}

	private void Incorrecto() {
		incorrecto.setVisible(true);
		incorrecto.setLocationRelativeTo(null);
		incorrecto.setSize(250,100);
		incorrecto.setLayout(new FlowLayout());
		incorrecto.add(mal);
		incorrecto.add(aceptar2);
		incorrecto.addWindowListener(this);
		aceptar2.addActionListener(this);
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
		if(this.isActive()) {
			setVisible(false);
		}
		if(correcto.isActive()) {
			correcto.setVisible(false);
		}
		if(incorrecto.isActive()) {
			incorrecto.setVisible(false);
		}
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void ProcesosDeRegistro() {
		String login = "";
		if(usuario=="admin") {
			login="AdminProgramacion";
		}else {
			login="Usuario";
		}
		
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
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL
						
			//select * from usuarios where nombreUsuario ='admin' and claveUsuario = 'Super';
			sentencia ="insert into tiendapractica.videojuegos values(null,'"+nombreS+"','"+generosS+"','"+plataformasS+"');";
			statement.executeUpdate(sentencia);
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

	private void Registro(String usuario2) {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+usuario2+"]"+"[INSERT INTO CLIENTES]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}
		
	}

	private void Cargar() {
		try
		{
			//Origen de los datos en el proyecto anterior
			FileReader fr = new FileReader("RegistroActivo.log");
			//Buffer de lectura
			BufferedReader entrada = new BufferedReader(fr);
			//Bucle para sacar la información del archivo
			usuario=entrada.readLine();
			//Cerrar el objeto entrada
			entrada.close();
			fr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Archivo NO encontrado");
		}
		catch(IOException i)
		{
			System.out.println("Se produjo un error de Archivo");
		}		
	}
}
