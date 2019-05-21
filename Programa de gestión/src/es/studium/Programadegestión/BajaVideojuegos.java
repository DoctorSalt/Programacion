package es.studium.Programadegestión;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
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

public class BajaVideojuegos extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;

	Choice videojuego=new Choice();
	Button aceptar=new Button("Confirmamos Baja");
	Dialog muerteConfirmar = new Dialog(this, "Baja Videojuego");

	Panel panel= new Panel();
	Panel panel1 = new Panel();

	Label seguro= new Label("¿Esta seguro de eliminar este Videojuego?");
	Button seguroSi = new Button("Si");
	Button seguroNo = new Button("No");

	String login = "admin";
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tiendaPractica?autoReconnect=true&useSSL=false";

	String password = "Studium2018;";
	String sentencia;
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet rs = null;

	BajaVideojuegos(){
		setTitle("Baja Videojuego");
		setSize(270,150);
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panel.setLayout(new FlowLayout());
		panel1.setLayout(new FlowLayout());
		add(panel);
		add(panel1);
		panel.add(videojuego);
		panel1.add(aceptar);
		videojuego.addItem("Elija uno");
		MeterDatos();
		addWindowListener(this);
		aceptar.addActionListener(this);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(aceptar)) {
			if(videojuego.getSelectedItem().equals("Elija uno")) {
				System.out.println("Elija una opcion");
			}
			else {
			muerteConfirmar.setVisible(true);
			muerteConfirmar.setTitle("Baja Videojuego");
			muerteConfirmar.setSize(270,100);
			muerteConfirmar.setLocationRelativeTo(null);
			muerteConfirmar.setLayout(new FlowLayout());
			muerteConfirmar.add(seguro);
			muerteConfirmar.add(seguroSi);
			muerteConfirmar.add(seguroNo);
			muerteConfirmar.addWindowListener(this);
			seguroSi.addActionListener(this);
			seguroNo.addActionListener(this);
			}
		}else if(e.getSource().equals(seguroSi)) {
			muerteConfirmar.setVisible(false);
			ProcesoDeEliminado();
			Registro();
			ReajusteChoice();
		}else if(e.getSource().equals(seguroNo)) {
			//Vuelve
			muerteConfirmar.setVisible(false);
		}		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(this.isActive()) {
			setVisible(false);
		}
		if(muerteConfirmar.isActive()) {
			muerteConfirmar.setVisible(false);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	
	private void MeterDatos() {
		sentencia="Select * from tiendapractica.videojuegos";
		int datosChoice;
		String nombreChoice;
		try
		{
			Conectar();
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				datosChoice =rs.getInt("idVideojuego");
				nombreChoice = rs.getString("nombeVideojuego");
				videojuego.addItem(datosChoice+" - "+nombreChoice);
			}
		}
		catch (SQLException sqle)
		{
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
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}					
	}
	
	private void ReajusteChoice() {
		videojuego.remove(videojuego.getSelectedItem());
	}

	private void Registro() {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+"Administrador"+"]"+"[DELETE FROM VIDEOJUEGOS]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}						
	}

	private void ProcesoDeEliminado() {
		String seleccionado = SplitElegido(videojuego.getSelectedItem());
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL
			sentencia ="delete from tiendapractica.videojuegos where idVideojuego = "+seleccionado+";";
			System.out.println(sentencia);
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
			Desconectar();
		}		
	}

	private String SplitElegido(String elegido) {
		String[] cosasElegidas = elegido.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
	}
}
