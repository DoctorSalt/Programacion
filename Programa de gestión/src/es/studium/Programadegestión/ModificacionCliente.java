package es.studium.Programadegestión;

import java.awt.Button;
import java.awt.Choice;
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

public class ModificacionCliente extends Frame implements WindowListener, ActionListener{

private static final long serialVersionUID = 1L;
	
	String login = "admin";
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tiendaPractica?autoReconnect=true&useSSL=false";
	
	String password = "Studium2018;";
	String sentencia;
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	String seleccion;
	
	Choice clientes = new Choice();
	Button aceptar = new Button("Modificar");

	Frame modificarF = new Frame();

	Label nombre = new Label("Nombre:");
	Label fecha = new Label ("Fecha:");
	Label puntos = new Label ("Puntos:");
		
	TextField respuestaNombre = new TextField("Text");
	TextField respuestaFecha = new TextField("Dia/Mes/Año");
	TextField respuestaPuntos = new TextField("0");
	
	Button modificar = new Button("Modificar");
	Button limpiar = new Button("Limpiar");
	
	
	Panel panelPrincipal1= new Panel();
	Panel panelPrincipal2= new Panel();
	
	Panel panel= new Panel();
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	
	
	
	public ModificacionCliente(String string) {
		setTitle("Modificacion Cliente");
		setSize(300,150);
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panelPrincipal1.setLayout(new FlowLayout());
		panelPrincipal2.setLayout(new FlowLayout());
		add(panelPrincipal1);
		add(panelPrincipal2);
		panelPrincipal1.add(clientes);
		panelPrincipal2.add(aceptar);
		clientes.addItem("Seleccione un cliente a modificar");
		MeterDatos();
		addWindowListener(this);
		aceptar.addActionListener(this);
		setVisible(true);
	}
	private void MeterDatos() {
		sentencia="Select * from tiendapractica.clientes;";
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
				datosChoice =rs.getInt("idCliente");
				nombreChoice = rs.getString("nombreCliente");
				clientes.addItem(datosChoice+" - "+nombreChoice);
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
	public static void main(String[] args) {
		new ModificacionCliente("Modificacion Clientes");

	}
	@Override	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(aceptar)) {
			seleccion=splitSeleccion(clientes.getSelectedItem());
			if(clientes.getSelectedItem().equals("Seleccione un cliente a modificar")) 
			{
				JOptionPane.showMessageDialog (null, "El dato tenia un dato incorrecto", "Continuar", JOptionPane.INFORMATION_MESSAGE);			
			}else {	ModificarFuncion(seleccion);}
		}else if(arg0.getSource().equals(modificar)) {
				ProcesoModificacion(seleccion);
				Registro();
				JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	private void ModificarFuncion(String seleccion) {
		modificarF.setTitle("Modificar Cliente");
		modificarF.setSize(300,250);
		modificarF.setLayout(new GridLayout(4,1));
		modificarF.setLocationRelativeTo(null);
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
		panel3.add(modificar);
		modificarF.add(panel);
		modificarF.add(panel1);
		modificarF.add(panel2);
		modificarF.add(panel3);
		modificar.addActionListener(this);
		modificarF.addWindowListener(this);		
		DatosCompletos(seleccion);
		modificarF.setVisible(true);
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
		if(modificarF.isActive()) {
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
	private void Registro() {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+"Administrador"+"]"+"[UPDATE FROM CLIENTES]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}						
	}
	private void DatosCompletos(String seleccion) {
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			sentencia ="Select * from tiendapractica.clientes where idCliente = "+seleccion+" ;";
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				String nombreRespuesta = rs.getString("nombreCliente");
				String fechaNacimientoRespuesta =americanoEspanol(rs.getString("fechaNacimientoCliente"));
				int puntosRespuesta = rs.getInt("puntosCliente");
				respuestaNombre.setText(nombreRespuesta);
				respuestaFecha.setText(fechaNacimientoRespuesta);
				respuestaPuntos.setText(puntosRespuesta+"");
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL: "+sqle.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	private String americanoEspanol(String fechaV1) {
		String[] fecha = fechaV1.split("-");
		String fechaV2 =fecha[2]+"/"+fecha[1]+"/"+fecha[0];
		return fechaV2;
	}
	private String americano(String fechaV1) {
		String[] fecha = fechaV1.split("/");
		String fechaV2 =fecha[2]+"-"+fecha[1]+"-"+fecha[0];
		return fechaV2;
	}
	private void ProcesoModificacion(String seleccion2) {
		String nombreRespuesta =respuestaNombre.getText();
		String fechaNacimientoRespuesta =americano(respuestaFecha.getText());
		String puntosRespuesta = respuestaPuntos.getText();
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);			
			sentencia ="UPDATE clientes SET nombreCliente = '"+nombreRespuesta+"',"
					+ "fechaNacimientoCliente = '"+fechaNacimientoRespuesta+"',"
					+ "puntosCliente = "+puntosRespuesta+" "
					+ "WHERE idCliente="+seleccion+";";
			statement.executeUpdate(sentencia);
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL: "+sqle.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	private String splitSeleccion(String selectedItem) {
		String[] cosasElegidas = selectedItem.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
	}
}
