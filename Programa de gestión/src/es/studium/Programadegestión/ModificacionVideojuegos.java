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

public class ModificacionVideojuegos extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	
	String seleccion;
	
	Choice videojuegos = new Choice();
	Button aceptar = new Button("Modificar");
	
	Frame modificarF = new Frame();
	
	Label nombre = new Label("Nombre:");
	Label generos = new Label("Generos:");
	Label plataforma = new Label("Plataforma:");
	
	TextField respuestaNombre = new TextField("Text");
	TextField respuestaGeneros = new TextField("Text");
	TextField respuestaPlataforma = new TextField("PS4");
	
	Button modificar = new Button("Modificar");
	Button limpiar = new Button("Limpiar");
	
	
	Panel panelPrincipal1= new Panel();
	Panel panelPrincipal2= new Panel();
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	Panel panel4 = new Panel();

	
	String login = "admin";
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tiendaPractica?autoReconnect=true&useSSL=false";
	
	String password = "Studium2018;";
	String sentencia;
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	public ModificacionVideojuegos() {
		setSize(350,200);
		setTitle("Modificacion Videojuegos");
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panelPrincipal1.setLayout(new FlowLayout());
		panelPrincipal2.setLayout(new FlowLayout());
		add(panelPrincipal1);
		add(panelPrincipal2);
		panelPrincipal1.add(videojuegos);
		panelPrincipal2.add(aceptar);
		videojuegos.addItem("Seleccione algun videojuego");
		MeterDatos();
		addWindowListener(this);
		aceptar.addActionListener(this);
		setVisible(true);
	}


	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(aceptar)) {
			seleccion=splitSeleccion(videojuegos.getSelectedItem());	
			if(videojuegos.getSelectedItem().equals("Seleccione algun videojuego")) 
			{
				JOptionPane.showMessageDialog (null, "El dato tenia un dato incorrecto", "Continuar", JOptionPane.INFORMATION_MESSAGE);			
			}else {
				ModificarFuncion(seleccion);
			}
		}else if(arg0.getSource().equals(modificar)) {
			ProcesoModificacion(seleccion);
			Registro();
			JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
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
	private String splitSeleccion(String selectedItem) {
		String[] cosasElegidas = selectedItem.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
	}
	private void MeterDatos() {
		sentencia="Select * from tiendapractica.videojuegos;";
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
				datosChoice =rs.getInt("idVideojuego");
				nombreChoice = rs.getString("nombeVideojuego");
				videojuegos.addItem(datosChoice+" - "+nombreChoice);
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


	private void ModificarFuncion(String seleccion) {
		modificarF.setTitle("Modificar Videojuego");
		modificarF.setLocationRelativeTo(null);
		modificarF.setSize(300,200);
		modificarF.setLayout(new GridLayout(4,1));
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		DatosCompletos(seleccion);
		modificarF.add(panel1);
		panel1.add(nombre);
		panel1.add(respuestaNombre);
		modificarF.add(panel2);
		panel2.add(generos);
		panel2.add(respuestaGeneros);
		modificarF.add(panel3);
		panel3.add(plataforma);
		panel3.add(respuestaPlataforma);
		modificarF.add(panel4);
		panel4.add(modificar);
		modificarF.setResizable(false);
		modificarF.addWindowListener(this);
		modificar.addActionListener(this);
		limpiar.addActionListener(this);
		modificarF.setVisible(true);
	}

	
	
	
	private void DatosCompletos(String seleccion) {
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			sentencia ="Select * from tiendapractica.videojuegos where idVideojuego = "+seleccion+" ;";
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{			
				String nombreRespuesta = rs.getString("nombeVideojuego");
				String generosRespuesta =rs.getString("generoVideojuego");
				String plataformaRespuesta = rs.getString("plataformaVideojuego");
				respuestaNombre.setText(nombreRespuesta);
				respuestaGeneros.setText(generosRespuesta);
				respuestaPlataforma.setText(plataformaRespuesta);
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
	
	private void ProcesoModificacion(String seleccion2) {
		String nombreRespuesta =respuestaNombre.getText();
		String generosRespuesta =respuestaGeneros.getText();
		String plataformaRespuesta = respuestaPlataforma.getText();
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);			
			sentencia ="UPDATE videojuegos SET nombeVideojuego = '"+nombreRespuesta+"',"
					+ "generoVideojuego = '"+generosRespuesta+"',"
					+ "plataformaVideojuego = '"+plataformaRespuesta+"' "
					+ "WHERE idVideojuego="+seleccion+";";
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
	private void Registro() {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+"Administrador"+"]"+"[UPDATE FROM VIDEOJUEGOS]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}						
	}

}
