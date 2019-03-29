package es.studium.Programadegestión;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AyudaAdmin extends Frame implements WindowListener{

	JTextArea texto = new JTextArea("Como administrador puedes tanto dar de alta, baja, consultar y modificar"
			+ "cualquier campo de Clientes, Facturas, Trabajadores y Videojuegos.",50,40);
	JScrollPane scroll = new JScrollPane(); 
	
	private static final long serialVersionUID = 1L;

	public AyudaAdmin(String t) {
		setTitle(t);
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.setSize(500,100);
		
		this.setLayout(new FlowLayout());
		scroll.setViewportView(texto);
		texto.setLineWrap(true); 
		texto.setEditable(false);
		this.add(texto);
		this.addWindowListener(this);
	}

	public static void main(String[] args) {
		new AyudaAdmin("Ayuda");
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

}
