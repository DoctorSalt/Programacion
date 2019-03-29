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

public class BajaTrabajador extends Frame implements WindowListener, ActionListener{
	private static final long serialVersionUID = 1L;

	Choice trabajador=new Choice();
	Button aceptar=new Button("Confirmamos Baja");
	Dialog muerteConfirmar = new Dialog(this, "Baja Trabajador");

	Label seguro= new Label("¿Esta seguro de eliminar este Trabajador?");
	Button seguroSi = new Button("Si");
	Button seguroNo = new Button("No");
	
	Panel panel= new Panel();
	Panel panel1 = new Panel();
	
	BajaTrabajador(String t){
		setVisible(true);
		setTitle(t);
		setSize(300,250);
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panel.setLayout(new FlowLayout());
		panel1.setLayout(new FlowLayout());
		add(panel);
		add(panel1);
		
		panel.add(trabajador);
		panel1.add(aceptar);
		trabajador.addItem("trabajador1");
		trabajador.addItem("trabajador2");
		addWindowListener(this);
		aceptar.addActionListener(this);
	}
	public static void main (String[] args) {
		new BajaTrabajador("Baja Trabajador");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(aceptar)) {
			muerteConfirmar.setVisible(true);
			muerteConfirmar.setTitle("Baja Trabajador");
			muerteConfirmar.setLocationRelativeTo(null);
			muerteConfirmar.setSize(270,100);
			muerteConfirmar.setLayout(new FlowLayout());
			muerteConfirmar.add(seguro);
			muerteConfirmar.add(seguroSi);
			muerteConfirmar.add(seguroNo);
			muerteConfirmar.addWindowListener(this);
			seguroSi.addActionListener(this);
			seguroNo.addActionListener(this);
		}else if(e.getSource().equals(seguroSi)) {
			//Elimina
			muerteConfirmar.setVisible(false);
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
	
}
