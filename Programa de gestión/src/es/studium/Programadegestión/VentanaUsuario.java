package es.studium.Programadegestión;

import java.awt.*;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaUsuario extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;

	MenuBar barramenu = new MenuBar();
	
	MenuItem trabajadoresAlta = new MenuItem ("Alta");
	MenuItem clientesAlta = new MenuItem ("Alta");
	MenuItem facturasAlta = new MenuItem("Alta");
	MenuItem videojuegosAlta = new MenuItem ("Alta");
	MenuItem ayudaAlta = new MenuItem ("Ayuda a Usuario");
	
	Menu trabajadores = new Menu("Trabajadores");
	Menu clientes = new Menu("Clientes");
	Menu facturas = new Menu("Facturas");
	Menu videojuegos = new Menu("Videojuegos");
	Menu ayuda = new Menu ("Ayuda");
	
	
	VentanaUsuario()
	{
		setTitle("Ventana de Usuario");
		this.setVisible(true);
		this.setSize(500,100);
		setLocationRelativeTo(null);
		this.setMenuBar(barramenu);
		
		barramenu.add(trabajadores);
		barramenu.add(clientes);
		barramenu.add(facturas);
		barramenu.add(videojuegos);
		barramenu.add(ayuda);
		
		trabajadores.add(trabajadoresAlta);
		clientes.add(clientesAlta);
		facturas.add(facturasAlta);
		videojuegos.add(videojuegosAlta);
		ayuda.add(ayudaAlta);
		this.addWindowListener(this);
		
		trabajadoresAlta.addActionListener(this);
		clientesAlta.addActionListener(this);
		facturasAlta.addActionListener(this);
		videojuegosAlta.addActionListener(this);
		ayudaAlta.addActionListener(this);
	}
	public void windowActivated(WindowEvent arg0) {      
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
		if(this.isActive()) {
			this.setVisible(false);
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
	//Aqui solo aparecen las funcionalidades de alta, única disponible para los usuarios
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(trabajadoresAlta)){	
			new AltaTrabajador();
		}else if(arg0.getSource().equals(clientesAlta)){
			new AltaCliente();
		}else if(arg0.getSource().equals(facturasAlta)){
			new AltaFactura();
		}else if(arg0.getSource().equals(videojuegosAlta)){
			new AltaVideojuegos();
		}else if(arg0.getSource().equals(ayudaAlta)){
			new AyudaUsuario("Ayuda Usuario");
		}
		
	}

}
