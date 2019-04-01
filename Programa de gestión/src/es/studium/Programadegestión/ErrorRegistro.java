package es.studium.Programadegestión;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ErrorRegistro extends Frame implements WindowListener, ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	Label error = new Label("La contraseña no coincide con el usuario, o se ha escrito un usuario incorrecto, por favor pruebe de nuevo.");
	Button aceptar = new Button("Siguiente");
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	
	ErrorRegistro(){
		setTitle("Error");
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2,1));
		setSize(600, 200);
		add(panel1);
		panel1.add(error);
		add(panel2);
		panel1.add(aceptar);
		aceptar.addActionListener(this);
		addWindowListener(this);
		setVisible(true);
		setResizable(false);	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(aceptar.equals(arg0.getSource())) {
			setVisible(false);
			new Programa();
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
	public void windowClosing(WindowEvent e) {
		if(isActive()) {
		setVisible(false);	
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
}
