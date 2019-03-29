package es.studium.Programadegestión;

import java.awt.Button;
import java.awt.Dialog;
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

public class AltaVideojuegos  extends Frame implements WindowListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Label nombre = new Label("Nombre:");
	Label generos = new Label("Generos:");
	Label plataforma = new Label("Plataforma:");
	
	TextField respuestaNombre = new TextField("");
	TextField respuestaGenero = new TextField("");
	TextField respuestaPlataforma = new TextField("");
	
	Button alta = new Button("Alta");
	Button limpiar = new Button("Limpiar");
	
	Dialog correcto = new Dialog(this,"Alta correcta");
	Dialog incorrecto = new Dialog(this, "Alta fallida");
	
	Label bien = new Label("Alta Correcta");
	Label mal = new Label("Se ha producido un error en la Alta");
	
	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");
	
	Panel panel1 = new Panel(new FlowLayout());
	Panel panel2 = new Panel(new FlowLayout());
	Panel panel3 = new Panel(new FlowLayout());
	Panel panel4 = new Panel(new FlowLayout());
	
	AltaVideojuegos(String t){
		this.setTitle(t);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(300,200);
		this.setLayout(new GridLayout(4,1));
		this.setResizable(false);
		add(panel1);
		panel1.add(nombre);
		panel1.add(respuestaNombre);
		add(panel2);
		panel2.add(generos);
		panel2.add(respuestaGenero);
		add(panel3);
		panel3.add(plataforma);
		panel3.add(respuestaPlataforma);
		add(panel4);
		panel4.add(alta);
		panel4.add(limpiar);
		addWindowListener(this);
		alta.addActionListener(this);
		limpiar.addActionListener(this);	
	}
	
	public static void main(String[] args) {
		new AltaVideojuegos("Alta Videojuegos");
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(limpiar))
		{		
			respuestaNombre.setText("");
			respuestaGenero.setText("");
			respuestaPlataforma.setText("");
		}else
		if(arg0.getSource().equals(alta))
		{
				String nombreS = respuestaNombre.getText();
				String generosS = respuestaGenero.getText(); 
				String plataformasS = respuestaPlataforma.getText();
				if((nombreS.equals(""))||(generosS.equals(""))||(plataformasS.equals(""))) {
					incorrecto();
				}else {
					correcto();
				}		
		}else if (arg0.getSource().equals(aceptar1)) {
			correcto.setVisible(false);
		}else if (arg0.getSource().equals(aceptar2)) {
			incorrecto.setVisible(false);
		}
	}
	private void correcto() {
		correcto.setVisible(true);
		correcto.setLocationRelativeTo(null);
		correcto.setSize(100,100);
		correcto.setLayout(new FlowLayout());
		correcto.setResizable(false);
		correcto.add(bien);
		correcto.add(aceptar1);
		correcto.addWindowListener(this);
		aceptar1.addActionListener(this);
	}

	private void incorrecto() {
		incorrecto.setVisible(true);
		incorrecto.setLocationRelativeTo(null);
		incorrecto.setSize(250,100);
		incorrecto.setLayout(new FlowLayout());
		incorrecto.add(mal);
		incorrecto.add(aceptar2);
		incorrecto.addWindowListener(this);
		aceptar2.addActionListener(this);
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
		if(this.isActive()) {
			setVisible(false);
		}
		if(correcto.isActive()) {
			correcto.setVisible(false);
		}
		if(incorrecto.isActive()) {
			incorrecto.setVisible(false);
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
