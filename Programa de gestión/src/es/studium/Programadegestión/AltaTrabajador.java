package es.studium.Programadegestión;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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

public class AltaTrabajador  extends Frame implements WindowListener, ActionListener{

	Label nombre = new Label ("Nombre:");
	Label apellido = new Label ("Apellido:");
	Label nomina = new Label ("Nomina:");
	Label tipoContrato = new Label ("Tipo de Contrato:");
	Label horasContrato = new Label ("Horas de Trabajo:");
	Label jefe = new Label ("¿Tiene jefe?");
	Label tienda = new Label ("Tienda a la que pertenece");

	TextField nombreRespuesta = new TextField("");
	TextField apellidoRespuesta = new TextField("");
	TextField nominaRespuesta = new TextField("");
	TextField tipoContratoRespuesta = new TextField("");
	TextField horasContratoRespuesta = new TextField(""); //se refiere a horas semanales

	CheckboxGroup jefeRespuesta = new CheckboxGroup();
	Checkbox jefeSi = new Checkbox("Si",false,jefeRespuesta);
	Checkbox jefeNo = new Checkbox("No", false, jefeRespuesta);
	Choice tiendas = new Choice();


	Button alta = new Button("Alta");
	Button limpiar = new Button("Limpiar");

	Dialog correcto = new Dialog(this,"Alta correcta");
	Dialog incorrecto = new Dialog(this, "Alta fallida");

	Label bien = new Label("Alta Correcta");
	Label mal = new Label("Se ha producido un error en la Alta");

	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tiendapractica?autoReconnect=true&useSSL=false";		
	String password = "Studium2018;";
	String login = "admin";
	String sentencia;
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;

	String usuario;	
	String jefeS;

	Panel panelNorte = new Panel();
	Panel panelCentro = new Panel();
	Panel panelDoble = new Panel();

	Panel panelCentro1 = new Panel();
	Panel panelCentro2 = new Panel();

	Dialog seleccioneJefe = new Dialog(this);
	Panel panelS=new Panel(new FlowLayout());
	Label especificar=new Label("Por favor seleccione de quien es jefe");
	Choice jefeSeleccionado =new Choice();
	Button elegido = new Button("confimo");

	String nombres;
	String nominas;
	String horas;
	String apellidos;
	String tipoContratos;
	String tiendaSeleccionada;
	
	private static final long serialVersionUID = 1L;
	
	public AltaTrabajador() {
		setTitle("Alta Trabajador");
		setVisible(true);
		setSize(900,200);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		panelNorte.setLayout(new GridLayout(3,4));
		panelCentro.setLayout(new GridLayout(2,1));
		panelDoble.setLayout(new GridLayout(1,3));
		panelCentro1.setLayout(new FlowLayout());
		panelCentro2.setLayout(new FlowLayout());

		tiendas.addItem("Elige uno");
		MeterDatos();
		add(panelNorte, "North");
		panelNorte.add(nombre);
		panelNorte.add(nombreRespuesta);
		panelNorte.add(apellido);
		panelNorte.add(apellidoRespuesta);
		panelNorte.add(nomina);
		panelNorte.add(nominaRespuesta);
		panelNorte.add(tipoContrato);
		panelNorte.add(tipoContratoRespuesta);
		panelNorte.add(horasContrato);
		panelNorte.add(horasContratoRespuesta);
		panelNorte.add(panelDoble);
		panelDoble.add(jefe);
		panelDoble.add(jefeSi);
		panelDoble.add(jefeNo);

		add(panelCentro,"Center");
		panelCentro.add(panelCentro1);
		panelCentro.add(panelCentro2);
		panelCentro1.add(tienda);
		panelCentro1.add(tiendas);
		panelCentro2.add(alta);
		panelCentro2.add(limpiar);

		alta.addActionListener(this);
		limpiar.addActionListener(this);
		this.addWindowListener(this);

	}

	private void MeterDatos() {
		sentencia="Select * from tiendapractica.tiendas";
		int datosChoice;
		String nombreChoice;
		try
		{
			Conectar();
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				datosChoice =rs.getInt("idTienda");
				nombreChoice = rs.getString("nombreTienda");
				tiendas.addItem(datosChoice+" - "+nombreChoice);
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

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(limpiar)) {
			nombreRespuesta.setText("");
			nominaRespuesta.setText("");
			horasContratoRespuesta.setText("");
			apellidoRespuesta.setText("");
			tipoContratoRespuesta.setText("");
			jefeSi.setState(false);
			jefeNo.setState(false);
			tiendas.select(0);
		}else if(arg0.getSource().equals(alta)) {
			nombres = nombreRespuesta.getText();
			nominas = nominaRespuesta.getText();
			horas = horasContratoRespuesta.getText();
			apellidos = apellidoRespuesta.getText();
			tipoContratos = tipoContratoRespuesta.getText();
			tiendaSeleccionada = splitSeleccionada(tiendas.getSelectedItem());
			Boolean tieneJefe;
			if((nombre.equals(""))||(nomina.equals(""))||(horas.equals(""))||(apellidos.equals(""))||(tipoContrato.equals(""))) {
				incorrecto();
			}
			else {
				if(true == jefeSi.getState()) {
					tieneJefe=true;
					Cargar();
					SeleccioneJefe();					
				}else if(true ==jefeNo.getState()) {
					tieneJefe=false;
					jefeS=null;
					Cargar();
					ProcesosDeRegistro();
					Registro(usuario);
					correcto();
				}else {
					incorrecto();
				}
			}
		}
		else if(arg0.getSource().equals(elegido)) {
			if(jefeSeleccionado.getSelectedItem().equals("Eliga una opcion")) {
				seleccioneJefe.setVisible(false);
				incorrecto();
			}else {
			jefeS=splitSeleccionada(jefeSeleccionado.getSelectedItem());
			seleccioneJefe.setVisible(false);
			ProcesosDeRegistro();
			Registro(usuario);
			correcto();
			}
		}else if(arg0.getSource().equals(bien)) {
			correcto.setVisible(false);
		}
	}
	private void SeleccioneJefe() {
		//Esto es el constructor
		seleccioneJefe.setTitle("Seleccion de Jefe");
		seleccioneJefe.setSize(300,200);
		seleccioneJefe.setLocationRelativeTo(null);
		seleccioneJefe.add(panelS);
		panelS.add(especificar);
		panelS.add(jefeSeleccionado);
		jefeSeleccionado.addItem("Eliga una opcion");
		panelS.add(elegido);
		MeterDatos2();
		elegido.addActionListener(this);
		seleccioneJefe.addWindowListener(this);
		seleccioneJefe.setVisible(true);
	}

	private void MeterDatos2() {
		sentencia="Select * from tiendapractica.trabajadores";
		int datosChoice;
		String nombreChoice;
		try
		{
			Conectar();
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				datosChoice =rs.getInt("idTrabajador");
				nombreChoice = rs.getString("nombreTrabajador");
				jefeSeleccionado.addItem(datosChoice+" - "+nombreChoice);
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

	private String splitSeleccionada(String elegido) {
		String[] cosasElegidas = elegido.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
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
			sentencia ="insert into tiendapractica.trabajadores values(null, '"+nombres+"', '"+apellidos+"', "+nominas+",'"+tipoContratos+"', "+horas+", "+tiendaSeleccionada+", "+jefeS+");";
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

	private void Registro(String usuario2) {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+usuario2+"]"+"[INSERT INTO TRABAJADORES]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
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
		correcto.setVisible(true);
		correcto.setLocationRelativeTo(null);
		correcto.setSize(100,100);
		correcto.setLayout(new FlowLayout());
		correcto.setResizable(false);
		correcto.add(bien);
		correcto.add(aceptar1);
		correcto.addWindowListener(this);
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
		else if(seleccioneJefe.isActive())
		{
			seleccioneJefe.setVisible(false);
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
