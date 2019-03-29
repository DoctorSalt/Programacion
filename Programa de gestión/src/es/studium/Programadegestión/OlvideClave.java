package es.studium.Programadegestión;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;

public class OlvideClave extends Frame implements WindowListener, ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	Dialog funciono = new Dialog(this,"Funciono");
	
	Label lb= new Label("Introducir correo electrónico: ");
	TextField escrito = new TextField ("patata@gmail.com");
	Button confirma =new Button("Confirmamos");
	
	Label correcto = new Label ("El correo es correcto");
	Label incorrecto = new Label ("El correo es incorrecto");
	
	Button continuamos = new Button ("Continuamos");
	
	Dialog nofunciono= new Dialog (this,"No funciono");
	
	OlvideClave(String t){
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setSize(200,130);
		this.setLayout(new FlowLayout());
		this.add(lb);
		this.add(escrito);
		this.add(confirma);
		this.addWindowListener(this);
		
		
		
		confirma.addActionListener(this);
	}
	public static void main(String[] args) {
		new OlvideClave("Olvide la Clave");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {		
		String correo = escrito.getText();
		if (confirma.equals(arg0.getSource())) {
			if(correo.contains("@gmail.com")){
				funciona(correo);
			}else {
				nofunciona(correo);
			}
		}else if(continuamos.equals(arg0.getSource())) {
			funciono.setVisible(false);
			nofunciono.setVisible(false);
		}
	}
	private void funciona(String correo) {
		funciono.setVisible(true);
		funciono.setLocationRelativeTo(null);
		funciono.setSize(200,130);
		funciono.setLayout(new FlowLayout());
		funciono.add(correcto);
		funciono.add(continuamos);		
		continuamos.addActionListener(this);
		funciono.addWindowListener(this);
	}
	private void nofunciona(String correo) {
		nofunciono.setVisible(true);
		nofunciono.setLocationRelativeTo(null);
		nofunciono.setSize(200,130);
		nofunciono.setLayout(new FlowLayout());
		nofunciono.add(incorrecto);
		nofunciono.add(continuamos);		
		continuamos.addActionListener(this);
		nofunciono.addWindowListener(this);
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
		if(this.isActive()) {
			setVisible(false);
		}
		if(funciono.isActive()) {
			funciono.setVisible(false);
		}
		if(nofunciono.isActive()) {
			nofunciono.setVisible(false);
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
