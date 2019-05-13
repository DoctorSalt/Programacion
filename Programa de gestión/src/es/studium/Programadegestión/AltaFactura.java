package es.studium.Programadegestión;

import java.awt.Button;
import java.awt.Choice;
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

public class AltaFactura extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	Label fecha = new Label("Fecha de compra:");
	Label cliente = new Label ("Cliente:");
	
	TextField fechaRespuesta = new TextField("Dia/Mes/Año");
	Choice clienteRespuesta = new Choice();
	
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tiendapractica?autoReconnect=true&useSSL=false";		
	String password = "Studium2018;";
	String login = "admin";
	String sentencia;
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	
	String usuario="";
	
	String fechaV;
	String clienteV;
	
	Button alta = new Button("Alta");
	Button limpiar = new Button("Limpiar");
	
	Dialog correcto = new Dialog(this,"Alta correcta");
	Dialog incorrecto = new Dialog(this, "Alta fallida");
	
	Label bien = new Label("Alta Correcta");
	Label mal = new Label("Se ha producido un error en la Alta");
	
	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel4 = new Panel();
	
	AltaFactura(String t) {
		setTitle(t);
		this.setVisible(true);
		this.setSize(250,180);
		setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3,1));
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		add(panel1);
		panel1.add(fecha);
		panel1.add(fechaRespuesta);
		add(panel2);
		panel2.add(cliente);
		panel2.add(clienteRespuesta);
		clienteRespuesta.addItem("Elige uno");
		add(panel4);
		panel4.add(alta);
		panel4.add(limpiar);
		MeterDatos();
		//añadir metodo de cliente rellenar con base de datos
		alta.addActionListener(this);
		limpiar.addActionListener(this);
		this.addWindowListener(this);
	}

	private void MeterDatos() {
		sentencia="Select * from tiendapractica.clientes";
		int datosChoice;
		String nombreChoice;
		try
		{
			Conectar();
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				datosChoice =rs.getInt("idCliente");
				nombreChoice = rs.getString("nombreCliente");
				clienteRespuesta.addItem(datosChoice+" - "+nombreChoice);
			}
		}
		catch (SQLException sqle)
		{
			incorrecto();
			System.out.println("Error 2: "+sqle.getMessage());
		}
		
		finally
		{
			Desconectar();
		}					
	}

	private void Desconectar() {
		try
		{
			if(connection!=null)
			{
				connection.close();
			}
		}
		catch (SQLException e)
		{
			incorrecto();
			System.out.println("Error 3: "+e.getMessage());
		}	
		
	}

	private void Conectar() {
		try {
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);	
			}catch(ClassNotFoundException cnfe) {
				incorrecto();
				System.out.println("Error 1: "+cnfe.getMessage());
			}
			catch (SQLException sqle)
			{
				incorrecto();
				System.out.println("Error 2: "+sqle.getMessage());
			}
	}

	public static void main(String[] args) {
		new AltaFactura("Alta Factura");
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(limpiar))
		{		
			fechaRespuesta.setText("//");
			clienteRespuesta.select(0);
		}
		else if(arg0.getSource().equals(alta))
		{
			fechaV=fechaRespuesta.getText();
			clienteV =SplitElegido(clienteRespuesta.getSelectedItem());
			if((((fechaV.equals("Dia/Mes/Año"))||(fechaV.equals("//")))||(clienteV.equals("Elige uno")))) 
			{
				incorrecto();
			}else {
				Cargar();
				ProcesosDeRegistro();
				correcto();
				Registro(usuario);
			}
		}else if(arg0.getSource().equals(aceptar1)) {
			correcto.setVisible(false);
		}
		
	}

	private void Registro(String usuario2) {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+usuario2+"]"+"[INSERT INTO FACTURAS]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}
		
	}

	private void ProcesosDeRegistro() {
		String login = "";
		if(usuario=="admin") {
			login="AdminProgramacion";
		}else {
			login="Usuario";
		}	
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
			fechaV=Americanizacion(fechaV);
			sentencia ="insert into tiendapractica.facturas values(null, '"+fechaV+"',"+clienteV+");";
			System.out.println(sentencia);
			statement.executeUpdate(sentencia);
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error de Clase: "+cnfe.getMessage());
			incorrecto();
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL: "+sqle.getMessage());
			incorrecto();
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
					correcto();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error al cerrar SQL: "+e.getMessage());
			}
		}
	}

	private String Americanizacion(String fechaV1) {
		String[] fecha = fechaV1.split("/");
		String fechaV2 =fecha[2]+"-"+fecha[1]+"-"+fecha[0];
		return fechaV2;
	}

	private void Cargar() {
		try	{
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

	private void incorrecto() {
		incorrecto.setVisible(true);
		incorrecto.setLocationRelativeTo(null);
		incorrecto.setSize(250,100);
		incorrecto.setLayout(new FlowLayout());
		incorrecto.add(mal);
		incorrecto.add(aceptar2);
		incorrecto.addWindowListener(this);
	}

	private void correcto() {
		correcto.setLocationRelativeTo(null);
		correcto.setSize(100,100);
		correcto.setLayout(new FlowLayout());
		correcto.setResizable(false);
		correcto.add(bien);
		correcto.add(aceptar1);
		aceptar1.addActionListener(this);
		correcto.addWindowListener(this);
		correcto.setVisible(true);
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
		if(isActive()) {
			setVisible(false);
		}
		else if(correcto.isActive()) {
			correcto.setVisible(false);
		}
		else if(incorrecto.isActive()) {
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

	private String SplitElegido(String elegido) {
		String[] cosasElegidas = elegido.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
	}
}
