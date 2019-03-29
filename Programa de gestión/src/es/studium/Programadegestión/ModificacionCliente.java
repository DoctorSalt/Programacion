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

public class ModificacionCliente extends Frame implements WindowListener, ActionListener{

private static final long serialVersionUID = 1L;
	
	Choice clientes = new Choice();
	Button aceptar = new Button("Modificar");

	Frame modificarF = new Frame();

	Label nombre = new Label("Nombre:");
	Label fecha = new Label ("Fecha:");
	Label puntos = new Label ("Puntos:");
		
	TextField respuestaNombre = new TextField("Text");
	TextField respuestaFecha = new TextField("Dia/Mes/Año");
	TextField respuestaPuntos = new TextField("0");
	
	Button modificar = new Button("Modificar");
	Button limpiar = new Button("Limpiar");
	
	
	Panel panelPrincipal1= new Panel();
	Panel panelPrincipal2= new Panel();
	
	Panel panel= new Panel();
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	
	public ModificacionCliente(String string) {
		setVisible(true);
		setTitle("Modificacion Cliente");
		setSize(300,150);
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panelPrincipal1.setLayout(new FlowLayout());
		panelPrincipal2.setLayout(new FlowLayout());
		add(panelPrincipal1);
		add(panelPrincipal2);
		panelPrincipal1.add(clientes);
		panelPrincipal2.add(aceptar);
		clientes.addItem("cliente1");
		clientes.addItem("cliente2");
		clientes.addItem("cliente3");
		addWindowListener(this);
		aceptar.addActionListener(this);
	}
	public static void main(String[] args) {
		new ModificacionCliente("Modificacion Clientes");

	}
	@Override	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(aceptar)) {
			String seleccion=clientes.getSelectedItem();
			ModificarFuncion(seleccion);
		}else if(arg0.getSource().equals(modificar)) {
			//Colocar funcion que modifique cosas TRABAJA EN ESTO
			JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void ModificarFuncion(String seleccion) {
		modificarF.setTitle("Modificar Cliente");
		modificarF.setVisible(true);
		modificarF.setSize(300,250);
		modificarF.setLayout(new GridLayout(4,1));
		modificarF.setLocationRelativeTo(null);
		panel.setLayout(new FlowLayout());
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel.add(nombre);
		panel.add(respuestaNombre);
		panel1.add(fecha);
		panel1.add(respuestaFecha);
		panel2.add(puntos);
		panel2.add(respuestaPuntos);
		panel3.add(modificar);
		modificarF.add(panel);
		modificarF.add(panel1);
		modificarF.add(panel2);
		modificarF.add(panel3);
		modificar.addActionListener(this);
		modificarF.addWindowListener(this);		
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
