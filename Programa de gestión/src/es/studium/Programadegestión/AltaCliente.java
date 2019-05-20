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


public class AltaCliente extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	String nombreC;
	String fechaC;
	String puntosC;

	Label nombre = new Label("Nombre:");
	Label fecha = new Label ("Fecha:");
	Label puntos = new Label ("Puntos:");

	TextField respuestaNombre = new TextField(9);
	TextField respuestaFecha = new TextField("Dia/Mes/Año");
	TextField respuestaPuntos = new TextField("");

	String usuario="";

	Button alta = new Button("Alta");
	Button limpiar = new Button("Limpiar");

	Dialog correcto = new Dialog(this,"Alta correcta");
	Dialog incorrecto = new Dialog(this, "Alta fallida");

	Label bien = new Label("Alta Correcta");
	Label mal = new Label("Se ha producido un error en la Alta");

	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");

	Panel panel= new Panel();
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();

	AltaCliente(String t) {
		setTitle("Alta Cliente");
		setVisible(true);
		setSize(250,250);
		setLayout(new GridLayout(4,1));
		setLocationRelativeTo(null);
		panel.setLayout(new FlowLayout());
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());

		panel.add(nombre);
		panel.add(respuestaNombre);
		panel1.add(fecha);
		panel1.add(respuestaFecha);
		panel2.add(puntos);
		panel2.add(respuestaPuntos);
		panel3.add(alta);
		panel3.add(limpiar);
		add(panel);
		add(panel1);
		add(panel2);
		add(panel3);
		alta.addActionListener(this);
		limpiar.addActionListener(this);
		this.addWindowListener(this);
	}

	public static void main(String[] args) {
		new AltaCliente("Alta Clientes");

	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(limpiar))
		{		
			respuestaNombre.setText("");
			respuestaFecha.setText("");
			respuestaPuntos.setText("0");
		}else if(arg0.getSource().equals(alta))
		{		
			nombreC =respuestaNombre.getText();
			fechaC =respuestaFecha.getText();
			puntosC =respuestaPuntos.getText();
			try {
				if((puntosC=="")||(fechaC.equals("Dia/Mes/Año"))||(fechaC.equals("//"))||(nombreC.equals(""))) {
					Incorrecto();
				}
				else {
					//inicar algo
					fechaC=americano(fechaC);
					Cargar();
					ProcesosDeRegistro();
					Correcto();
					Registro(usuario);
				}

			}catch(NumberFormatException NFE) {
				//poner mensaje de error
				Incorrecto();

			}
		}else if(arg0.getSource().equals(aceptar2)) {
			incorrecto.setVisible(false);
		}else if(arg0.getSource().equals(aceptar1)) {
			correcto.setVisible(false);
		}
	}

	private void ProcesosDeRegistro() {
		String login = "";
		if(usuario=="admin") {
			login="AdminProgramacion";
		}else {
			login="Usuario";
		}
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/login?autoReconnect=true&useSSL=false";
		
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
			sentencia ="insert into tiendapractica.clientes values(null,"+nombreC+","+fechaC+","+puntosC+");";
			rs = statement.executeQuery(sentencia);
			if(rs.next())
			{
				System.out.println("Añadido OK");
			}
			else
			{
				Incorrecto();
				System.out.println("Error");
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

	private void Registro(String i) {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+i+"]"+"[INSERT INTO CLIENTES]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}
	}
	private String americano(String fechaV1) {
		String[] fecha = fechaV1.split("/");
		String fechaV2 =fecha[2]+"-"+fecha[1]+"-"+fecha[0];
		return fechaV2;
	}

	private void Cargar() {
		//Como usaremos FileReader y puede lanzar una excepción
		//necesitaremos un bloque try – catch
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

	private void Incorrecto() {
		incorrecto.setVisible(true);
		incorrecto.setLocationRelativeTo(null);
		incorrecto.setSize(250,100);
		incorrecto.setLayout(new FlowLayout());
		incorrecto.add(mal);
		incorrecto.add(aceptar2);
		aceptar2.addActionListener(this);
		incorrecto.addWindowListener(this);
	}
	private void Correcto() {
		correcto.setVisible(true);
		correcto.setLocationRelativeTo(null);
		correcto.setSize(100,100);
		correcto.setLayout(new FlowLayout());
		correcto.setResizable(false);
		correcto.add(bien);
		correcto.add(aceptar1);
		aceptar1.addActionListener(this);
		correcto.addWindowListener(this);
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

}
