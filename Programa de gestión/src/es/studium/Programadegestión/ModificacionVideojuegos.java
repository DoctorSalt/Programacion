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

import javax.swing.JOptionPane;

public class ModificacionVideojuegos extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	 
	Choice videojuegos = new Choice();
	Button aceptar = new Button("Modificar");
	
	Frame modificarF = new Frame();
	
	Label nombre = new Label("Nombre:");
	Label generos = new Label("Generos:");
	Label plataforma = new Label("Plataforma:");
	
	TextField respuestaNombre = new TextField("Text");
	TextField respuestaGeneros = new TextField("Text");
	TextField respuestaPlataforma = new TextField("PS4");
	
	Button modificar = new Button("Modificar");
	Button limpiar = new Button("Limpiar");
	
	
	Panel panelPrincipal1= new Panel();
	Panel panelPrincipal2= new Panel();
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	Panel panel4 = new Panel();


	public ModificacionVideojuegos(String t) {
		setVisible(true);
		setSize(350,200);
		setTitle(t);
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panelPrincipal1.setLayout(new FlowLayout());
		panelPrincipal2.setLayout(new FlowLayout());
		add(panelPrincipal1);
		add(panelPrincipal2);
		panelPrincipal1.add(videojuegos);
		panelPrincipal2.add(aceptar);
		videojuegos.addItem("videojuego1");
		videojuegos.addItem("videojuego2");
		videojuegos.addItem("videojuego3");
		addWindowListener(this);
		aceptar.addActionListener(this);
	}


	public static void main(String[] args) {
		new ModificacionVideojuegos("Modificacion Videojuegos");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(aceptar)) {
			String seleccion=videojuegos.getSelectedItem();
			ModificarFuncion(seleccion);
		}else if(arg0.getSource().equals(modificar)) {
			//Colocar funcion que modifique cosas TRABAJA EN ESTO
			JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void ModificarFuncion(String seleccion) {
		modificarF.setTitle("Modificar Videojuego");
		modificarF.setLocationRelativeTo(null);
		modificarF.setVisible(true);
		modificarF.setSize(300,200);
		modificarF.setLayout(new GridLayout(4,1));
		
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		
		modificarF.add(panel1);
		panel1.add(nombre);
		panel1.add(respuestaNombre);
		modificarF.add(panel2);
		panel2.add(generos);
		panel2.add(respuestaGeneros);
		modificarF.add(panel3);
		panel3.add(plataforma);
		panel3.add(respuestaPlataforma);
		modificarF.add(panel4);
		panel4.add(modificar);
		modificarF.setResizable(false);
		modificarF.addWindowListener(this);
		modificar.addActionListener(this);
		limpiar.addActionListener(this);		
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
		if(modificarF.isActive()) {
			modificarF.setVisible(false);
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
