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

public class ModificacionFactura extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	
	Choice facturas = new Choice();
	Button aceptar = new Button("Modificar");
	
	Frame modificarF = new Frame();
	
	Label fecha = new Label("Fecha de compra:");
	Label cliente = new Label ("Cliene:");
	Label trabajador = new Label ("Trabajador:");
	
	TextField fechaRespuesta = new TextField("Dia/Mes/Año");
	Choice clienteRespuesta = new Choice();
	
	Button modificar = new Button("Modificar");
	
	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");
	
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
	
	String seleccion;
	
	public ModificacionFactura() {
		setTitle("Modificacion Factura");
		setSize(350,200);
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panelPrincipal1.setLayout(new FlowLayout());
		panelPrincipal2.setLayout(new FlowLayout());
		add(panelPrincipal1);
		add(panelPrincipal2);
		panelPrincipal1.add(facturas);
		panelPrincipal2.add(aceptar);
		facturas.addItem("Eliga una factura");
		MeterDatos();
		addWindowListener(this);
		aceptar.addActionListener(this);	
		setVisible(true);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(aceptar)) {
			if(facturas.getSelectedItem().equals("Eliga una factura")) {
				JOptionPane.showMessageDialog (null, "Eliga una factura", "Continuar", JOptionPane.INFORMATION_MESSAGE);
			}else {
				seleccion=splitSeleccion(facturas.getSelectedItem());
				ModificarFuncion(seleccion);
			}
			
		}else if(e.getSource().equals(modificar)) {
			//Colocar funcion que modifique cosas TRABAJA EN ESTO
			if(clienteRespuesta.getSelectedItem().equals("Eliga un Cliente")) {
				JOptionPane.showMessageDialog (null, "Eliga un cliente", "Continuar", JOptionPane.INFORMATION_MESSAGE);
			}
			ProcesoModificacion(seleccion);
			Registro();			
			JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void ProcesoModificacion(String seleccion2) {
		String fechaCompraRespuesta =americano(fechaRespuesta.getText());
		String clienteSeleccionadoRespuesta = splitSeleccion(clienteRespuesta.getSelectedItem());
		try
		{
			Conectar();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);			
			sentencia ="UPDATE facturas SET fechaCompra = '"+fechaCompraRespuesta+"',"
					+ "idClienteFK2 = "+clienteSeleccionadoRespuesta+" "
					+ "WHERE idFactura="+seleccion+";";
			statement.executeUpdate(sentencia);
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

	private void ModificarFuncion(String seleccion) {
		modificarF.setVisible(true);
		modificarF.setTitle("Modificacion Factura");
		modificarF.setSize(300,180);
		modificarF.setLocationRelativeTo(null);
		modificarF.setLayout(new GridLayout(4,1));
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		modificarF.add(panel1);
		panel1.add(fecha);
		panel1.add(fechaRespuesta);
		modificarF.add(panel2);
		panel2.add(cliente);
		panel2.add(clienteRespuesta);
		modificarF.add(panel3);
		modificarF.add(panel4);
		panel4.add(modificar);
		clienteRespuesta.addItem("Eliga un Cliente");
		MeterDatos2();
		modificar.addActionListener(this);
		modificarF.addWindowListener(this);
		RellenarDatos(seleccion);		
	}

	private void MeterDatos2() {
		sentencia="Select * from tiendapractica.clientes;";
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
			System.out.println("Error 2: "+sqle.getMessage());
		} 
		finally
		{
			Desconectar();
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
		if(isActive()) {
			setVisible(false);
		}
		if(modificarF.isActive()) {
			modificarF.setVisible(false);
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
	
	private void Registro() {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+"Administrador"+"]"+"[UPDATE FROM FACTURAS]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}						
	}
	
	private String splitSeleccion(String selectedItem) {
		String[] cosasElegidas = selectedItem.split(" - ");
		String numeroElegido = cosasElegidas[0];
		return numeroElegido;
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
	
	private void MeterDatos() {
		sentencia="Select * from tiendapractica.facturas;";
		int datosChoice;
		String nombreChoice;
		try
		{
			Conectar();
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				datosChoice =rs.getInt("idFactura");
				nombreChoice = americanoEspanol(rs.getString("fechaCompra"));
				facturas.addItem(datosChoice+" - "+nombreChoice);
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
	private void RellenarDatos(String seleccion) {
		try
		{
			Conectar();
			statement = connection.createStatement();
			sentencia ="Select * from tiendapractica.facturas where idFactura = "+seleccion+" ;";
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				String fechaCompraRespuesta =americanoEspanol(rs.getString("fechaCompra"));
				int clienteRespuestas = rs.getInt("idClienteFK2");
				fechaRespuesta.setText(fechaCompraRespuesta);
				clienteRespuesta.select(clienteRespuestas);
			}
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
	private void Conectar() {
		try {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, login, password);
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}		
	}
	
}
