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

import javax.swing.JOptionPane;

public class ModificacionTrabajador  extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	Choice trabajador=new Choice();
	Button aceptar=new Button("Aceptar");
	Frame modificarF = new Frame();

	Label nombre = new Label ("Nombre:");
	Label apellido = new Label ("Apellido:");
	Label nomina = new Label ("Nomina:");
	Label tipoContrato = new Label ("Tipo de Contrato:");
	Label horasContrato = new Label ("Horas de Trabajo:");
	Label jefe = new Label ("¿Es jefe?");
	Label tienda = new Label ("Tienda a la que pertenece");

	TextField nombreRespuesta = new TextField("Text");
	TextField apellidoRespuesta = new TextField("Text");
	TextField nominaRespuesta = new TextField("500");
	TextField tipoContratoRespuesta = new TextField("partido");
	TextField horasContratoRespuesta = new TextField("39"); //se refiere a horas semanales

	CheckboxGroup jefeRespuesta = new CheckboxGroup();
	Checkbox jefeSi = new Checkbox("Si",false,jefeRespuesta);
	Checkbox jefeNo = new Checkbox("No", false, jefeRespuesta);
	Choice tiendas = new Choice();
	Button modificar = new Button("Modificar");

	Panel panelPrincipal1= new Panel();
	Panel panelPrincipal2= new Panel();

	Panel panelNorte = new Panel();
	Panel panelCentro = new Panel();
	Panel panelDoble = new Panel();

	Panel panelCentro1 = new Panel();
	Panel panelCentro2 = new Panel();

	String seleccion;

	String login = "admin";
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tiendaPractica?autoReconnect=true&useSSL=false";

	String password = "Studium2018;";
	String sentencia;
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;

	String jefeS=null;

	Dialog seleccioneJefe = new Dialog(this);
	Panel panelS=new Panel(new FlowLayout());
	Label especificar=new Label("Por favor seleccione de quien es jefe");
	Choice jefeSeleccionado =new Choice();
	Button elegido = new Button("confimo");
	
	String nombreS;
	String nominaS;
	String horasS;
	String apellidosS;
	String tipoContratoS;
	
	String tiendaSeleccionada;

	ModificacionTrabajador(){
		setVisible(true);
		setSize(320,200);
		setTitle("Modificacion Trabajador");
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panelPrincipal1.setLayout(new FlowLayout());
		panelPrincipal2.setLayout(new FlowLayout());
		add(panelPrincipal1);
		add(panelPrincipal2);
		panelPrincipal1.add(trabajador);
		panelPrincipal2.add(aceptar);
		trabajador.addItem("Seleccione un trabajador");
		MeterDatos();
		addWindowListener(this);
		aceptar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(aceptar)) {
			seleccion=splitSeleccion(trabajador.getSelectedItem());
			if(trabajador.getSelectedItem().equals("Seleccione un trabajador")) 
			{
				JOptionPane.showMessageDialog (null, "Por favor, seleccione un Trabajador", "Continuar", JOptionPane.INFORMATION_MESSAGE);			
			}else {
				ModificarFuncion(seleccion);
			}
		}else if(arg0.getSource().equals(modificar)) {

			nombreS = nombreRespuesta.getText();
			nominaS = nominaRespuesta.getText();
			horasS = horasContratoRespuesta.getText();
			apellidosS = apellidoRespuesta.getText();
			tipoContratoS = tipoContratoRespuesta.getText();
			if(tiendas.getSelectedItem().equals("Seleccione un Tienda")) {
				JOptionPane.showMessageDialog (null, "Por favor, Seleccione una tienda", "Continuar", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				tiendaSeleccionada = splitSeleccion(tiendas.getSelectedItem());
				Boolean tieneJefe;	
				if(jefeSi.getState()==true)
				{
					tieneJefe=true;
					SeleccioneJefe();	
				}else if(jefeNo.getState()==true){
					tieneJefe=false;
					jefeS=null;
					ProcesosDeRegistro(seleccion, nombreS, apellidosS, nominaS, tipoContratoS, horasS, tiendaSeleccionada, jefeS);
					Registro();
					JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog (null, "Seleccione si tiene Jefe o no", "Volver a intentar", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}else if(arg0.getSource().equals(elegido)) {
			if(jefeSeleccionado.getSelectedItem().equals("Eliga una opcion")) {
				seleccioneJefe.setVisible(false);
				
			}else {
				jefeS=splitSeleccion(jefeSeleccionado.getSelectedItem());
				seleccioneJefe.setVisible(false);
				ProcesosDeRegistro(seleccion, nombreS, apellidosS, nominaS, tipoContratoS, horasS, tiendaSeleccionada, jefeS);
				Registro();
				JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		if(isActive()) {
			setVisible(false);
		}
		else if(modificarF.isActive()) {
			modificarF.setVisible(false);
		}	
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	private void ProcesosDeRegistro(String seleccion, String nombre, String apellidos, String nomina, String tipoContrato, String horas, String tiendaSeleccionada, String jefeX) {
		Conectar();
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);			
			sentencia ="UPDATE trabajadores SET nombreTrabajador = '"+nombre+"',"
					+ " apellidosTrabajador ='"+apellidos+"',"
					+ " nominaTrabajador = "+nomina+","
					+ " tipoContratoTrabajador ='"+tipoContrato+"',"
					+ " horasTrabajador = "+horas+","
					+ " idTiendaFK1 = '"+tiendaSeleccionada+"',"
					+ " jefeDeFK1 ="+jefeX
					+ " WHERE idTrabajador="+seleccion+";";
			System.out.println(sentencia);
			statement.executeUpdate(sentencia);
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL: "+sqle.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void ModificarFuncion(String seleccion) {
		modificarF.setVisible(true);
		modificarF.setSize(600,200);
		modificarF.setLocationRelativeTo(null);
		modificarF.setLayout(new BorderLayout());
		panelNorte.setLayout(new GridLayout(3,4));
		panelCentro.setLayout(new GridLayout(2,2));
		panelDoble.setLayout(new GridLayout(1,3));
		panelCentro1.setLayout(new FlowLayout());
		panelCentro2.setLayout(new FlowLayout());
		tiendas.addItem("Seleccione Tienda");
		MeterDatos2();
		modificarF.add(panelNorte, "North");
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
		modificarF.add(panelCentro,"Center");
		panelCentro.add(panelCentro1);
		panelCentro.add(panelCentro2);
		panelCentro1.add(tienda);
		panelCentro1.add(tiendas);
		panelCentro2.add(modificar);
		RellenarDatos(seleccion);
		modificar.addActionListener(this);	
		modificarF.addWindowListener(this);
		modificarF.setVisible(true);
	}
	private void RellenarDatos(String seleccion) {
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			sentencia ="Select * from tiendapractica.trabajadores where idTrabajador = "+seleccion+" ;";
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{			
				String respuestasNombre = rs.getString("nombreTrabajador");
				String respuestaApellido = rs.getString("apellidosTrabajador");
				String respuestaNomina =rs.getString("nominaTrabajador");
				String repuestaHorasTrabajo= rs.getInt("horasTrabajador")+"";
				String respuestaTipoContrato = rs.getString("tipoContratoTrabajador");
				int tiendaSeleccionada = rs.getInt("idTiendaFK1");
				int jefeSeleccionadoN = rs.getInt("jefeDeFK1");
				if(jefeSeleccionadoN>0){
					MeterDatos3();
					jefeSi.setState(true);
					jefeSeleccionado.select(jefeSeleccionadoN);
				}else {
					jefeNo.setState(true);
				}
				nombreRespuesta.setText(respuestasNombre);
				apellidoRespuesta.setText(respuestaApellido);
				nominaRespuesta.setText(respuestaNomina);
				tipoContratoRespuesta.setText(respuestaTipoContrato);
				horasContratoRespuesta.setText(repuestaHorasTrabajo);
				tiendas.select(tiendaSeleccionada);
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL: "+sqle.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private String splitSeleccion(String selectedItem) {
		String[] cosasElegidas = selectedItem.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
	}
	private void MeterDatos2() {
		sentencia="Select * from tiendapractica.tiendas;";
		int datosChoice;
		String nombreChoice;
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);	
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
			System.out.println("Error 2: "+sqle.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally
		{
			Desconectar();
		}			
	}

	private void MeterDatos() {
		sentencia="Select * from tiendapractica.trabajadores;";
		int datosChoice;
		String nombreChoice;
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);	
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				datosChoice =rs.getInt("idTrabajador");
				nombreChoice = rs.getString("nombreTrabajador");
				trabajador.addItem(datosChoice+" - "+nombreChoice);
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			System.out.println("Error 3: "+e.getMessage());
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
		panelS.add(elegido);
		elegido.addActionListener(this);
		seleccioneJefe.addWindowListener(this);
		seleccioneJefe.setVisible(true);
	}
	private void MeterDatos3() {
		jefeSeleccionado.addItem("Eliga un jefe");
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
			System.out.println("Error 2: "+sqle.getMessage());
		}
	}
	private void Conectar() {
		try {
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);	
		}catch(ClassNotFoundException cnfe) {
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}		
	}
	private void Registro() {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+"Administrador"+"]"+"[UPDATE FROM TRABAJADORES]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}						
	}
}
