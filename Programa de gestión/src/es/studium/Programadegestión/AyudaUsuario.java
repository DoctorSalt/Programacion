package es.studium.Programadegestión;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AyudaUsuario extends Frame implements WindowListener{

	JTextArea texto = new JTextArea("Como usuario solo puedes dar de alta: Clientes, Facturas, Trabajadores y Videojuegos."
			+ " En caso de necesitar una consulta o modificiación, por favor, contacten con el Administrador",50,40);
	JScrollPane scroll = new JScrollPane(); 
	
	private static final long serialVersionUID = 1L;

	public AyudaUsuario(String t) {
		setTitle(t);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setSize(500,100);
		this.setLayout(new FlowLayout());
		scroll.setViewportView(texto);
		texto.setLineWrap(true); 
		texto.setEditable(false);
		this.add(texto);
		this.addWindowListener(this);
	}

	public static void main(String[] args) {
		new AyudaUsuario("Ayuda");
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
