package es.studium.Programadegestión;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaAdmin extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	
	MenuBar barramenu = new MenuBar();
	MenuItem trabajadoresAlta = new MenuItem ("Alta");
	MenuItem trabajadoresModificacion = new MenuItem ("Modificación");
	MenuItem trabajadoresBaja = new MenuItem ("Baja");
	MenuItem trabajadoresConsulta = new MenuItem ("Consulta");
	MenuItem clientesAlta = new MenuItem ("Alta");
	MenuItem clientesModificacion = new MenuItem ("Modificación");
	MenuItem clientesBaja = new MenuItem ("Baja");
	MenuItem clientesConsulta = new MenuItem ("Consulta");
	MenuItem facturasAlta = new MenuItem("Alta");
	MenuItem facturaModificacion = new MenuItem ("Modificacion");
	MenuItem facturaBaja = new MenuItem ("Baja");
	MenuItem facturaConsulta = new MenuItem ("Consulta");
	MenuItem videojuegosAlta = new MenuItem ("Alta");
	MenuItem videojuegosModificacion = new MenuItem ("Modificacion");
	MenuItem videojuegosBaja = new MenuItem ("Baja");
	MenuItem videojuegosConsulta = new MenuItem("Consulta");
	MenuItem ayudaAlta = new MenuItem ("Ayuda a Administrador");
	Menu trabajadores = new Menu("Trabajadores");
	Menu clientes = new Menu("Clientes");
	Menu facturas = new Menu("Facturas");
	Menu videojuegos = new Menu("Videojuegos");
	Menu ayuda = new Menu ("Ayuda");
	Usuario user;

	public VentanaAdmin(String t) {
		setTitle(t);
		this.setVisible(true);
		this.setSize(500,100);
		this.setLocationRelativeTo(null);
		this.setMenuBar(barramenu);
		barramenu.add(trabajadores);
		barramenu.add(clientes);
		barramenu.add(facturas);
		barramenu.add(videojuegos);
		barramenu.add(ayuda);
		trabajadores.add(trabajadoresAlta);
		trabajadores.add(trabajadoresModificacion);
		trabajadores.add(trabajadoresBaja);
		trabajadores.add(trabajadoresConsulta);
		clientes.add(clientesAlta);
		clientes.add(clientesModificacion);
		clientes.add(clientesBaja);
		clientes.add(clientesConsulta);
		facturas.add(facturasAlta);
		facturas.add(facturaModificacion);
		facturas.add(facturaBaja);
		facturas.add(facturaConsulta);
		videojuegos.add(videojuegosAlta);
		videojuegos.add(videojuegosModificacion);
		videojuegos.add(videojuegosBaja);
		videojuegos.add(videojuegosConsulta);
		ayuda.add(ayudaAlta);
		this.addWindowListener(this);
		trabajadoresAlta.addActionListener(this);
		clientesAlta.addActionListener(this);
		facturasAlta.addActionListener(this);
		videojuegosAlta.addActionListener(this);
		ayudaAlta.addActionListener(this);
		trabajadoresModificacion.addActionListener(this);
		trabajadoresBaja.addActionListener(this);
		trabajadoresConsulta.addActionListener(this);
		clientesModificacion.addActionListener(this);
		clientesBaja.addActionListener(this);
		clientesConsulta.addActionListener(this);
		facturaModificacion.addActionListener(this);
		facturaBaja.addActionListener(this);
		facturaConsulta.addActionListener(this);
		videojuegosModificacion.addActionListener(this);
		videojuegosBaja.addActionListener(this);
		videojuegosConsulta.addActionListener(this);
	}

	public static void main(String[] args) {
		VentanaAdmin va = new VentanaAdmin("Ventana Administrador");
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(trabajadoresAlta))
		{	new AltaTrabajador("Alta Trabajador");
		}else if(arg0.getSource().equals(clientesAlta)){
			new AltaCliente("Alta Cliente");
		}else if(arg0.getSource().equals(facturasAlta)){
			new AltaFactura("Alta Factura");
		}else if(arg0.getSource().equals(videojuegosAlta)){
			new AltaVideojuegos("Alta Videojuego");
		}else if(arg0.getSource().equals(ayudaAlta)){
			new AyudaAdmin("Ayuda Adminisitrador");
		}else if(arg0.getSource().equals(trabajadoresModificacion)) {
			new ModificacionTrabajador("Modificacion Trabajador");
		}else if(arg0.getSource().equals(trabajadoresBaja)) {
			new BajaTrabajador("Baja Trabajador");
		}else if(arg0.getSource().equals(trabajadoresConsulta)){
			new ConsultaTrabajador("Consulta Trabajador");
		}else if(arg0.getSource().equals(clientesModificacion)) {
			new ModificacionCliente("Modificacion Cliente");
		}else if(arg0.getSource().equals(clientesBaja)) {
			new BajaCliente("Baja Cliente");
		}else if(arg0.getSource().equals(clientesConsulta)) {
			new ConsultaCliente("Consulta Cliente");
		}else if(arg0.getSource().equals(facturaModificacion)) {
			new ModificacionFactura("Modificación Factura");
		}else if(arg0.getSource().equals(facturaBaja)) {
			new BajaFactura("Baja Factura");
		}else if(arg0.getSource().equals(facturaConsulta)) {
			new ConsultaFactura("Consulta Factura");
		}else if(arg0.getSource().equals(videojuegosModificacion)){
			new ModificacionVideojuegos("Modificacion Videojuego");
		}else if(arg0.getSource().equals(videojuegosConsulta))	{
			new ConsultaVideojuegos("Consulta Videojuego");
		}else if(arg0.getSource().equals(videojuegosBaja))	{
			new BajaVideojuegos("Baja Videojuego");
		}
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
