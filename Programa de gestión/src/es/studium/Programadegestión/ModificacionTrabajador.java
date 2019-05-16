package es.studium.Programadegestión;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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

public class ModificacionTrabajador  extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	Choice trabajador=new Choice();
	Button aceptar=new Button("Aceptar");
	Frame modificarF = new Frame();
		
	Label nombre = new Label ("Nombre:");
	Label apellido = new Label ("Apellido:");
	Label nomina = new Label ("Nomina:");
	Label tipoContrato = new Label ("Tipo de Contrato:");
	Label horasContrato = new Label ("Horas de Trabajo:");
	Label jefe = new Label ("¿Es jefe?");
	Label tienda = new Label ("Tienda a la que pertenece");
	
	TextField nombreRespuesta = new TextField("Text");
	TextField apellidoRespuesta = new TextField("Text");
	TextField nominaRespuesta = new TextField("500");
	TextField tipoContratoRespuesta = new TextField("partido");
	TextField horasContratoRespuesta = new TextField("39"); //se refiere a horas semanales
	
	CheckboxGroup jefeRespuesta = new CheckboxGroup();
	Checkbox jefeSi = new Checkbox("Si",false,jefeRespuesta);
	Checkbox jefeNo = new Checkbox("No", false, jefeRespuesta);
	Choice tiendas = new Choice();
	Button modificar = new Button("Modificar");

	Panel panelPrincipal1= new Panel();
	Panel panelPrincipal2= new Panel();
	
	Panel panelNorte = new Panel();
	Panel panelCentro = new Panel();
	Panel panelDoble = new Panel();
	
	Panel panelCentro1 = new Panel();
	Panel panelCentro2 = new Panel();

	ModificacionTrabajador(String t){
		setVisible(true);
		setSize(320,200);
		setTitle(t);
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panelPrincipal1.setLayout(new FlowLayout());
		panelPrincipal2.setLayout(new FlowLayout());
		add(panelPrincipal1);
		add(panelPrincipal2);
		panelPrincipal1.add(trabajador);
		panelPrincipal2.add(aceptar);
		trabajador.addItem("trabajador1");
		trabajador.addItem("trabajador2");
		trabajador.addItem("trabajador3");
		addWindowListener(this);
		aceptar.addActionListener(this);
	}
	public static void main(String[] args) {
		new ModificacionTrabajador("Modificacion Trabajador");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(aceptar)) {
			String seleccion=trabajador.getSelectedItem();
			ModificarFuncion(seleccion);
		}else if(arg0.getSource().equals(modificar)) {
			//Colocar funcion que modifique cosas
			JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void ModificarFuncion(String seleccion) {
		modificarF.setVisible(true);
		modificarF.setVisible(true);
		modificarF.setSize(600,200);
		modificarF.setLocationRelativeTo(null);
		modificarF.setLayout(new BorderLayout());
		panelNorte.setLayout(new GridLayout(3,4));
		panelCentro.setLayout(new GridLayout(2,2));
		panelDoble.setLayout(new GridLayout(1,3));
		panelCentro1.setLayout(new FlowLayout());
		panelCentro2.setLayout(new FlowLayout());
		tiendas.addItem("Tienda1");
		tiendas.addItem("Tienda2");
		modificarF.add(panelNorte, "North");
		panelNorte.add(nombre);
		panelNorte.add(nombreRespuesta);
		panelNorte.add(apellido);
		panelNorte.add(apellidoRespuesta);
		panelNorte.add(nomina);
		panelNorte.add(nominaRespuesta);
		panelNorte.add(tipoContrato);
		panelNorte.add(tipoContratoRespuesta);
		panelNorte.add(horasContrato);
		panelNorte.add(horasContratoRespuesta);
		panelNorte.add(panelDoble);
		panelDoble.add(jefe);
		panelDoble.add(jefeSi);
		panelDoble.add(jefeNo);
		modificarF.add(panelCentro,"Center");
		panelCentro.add(panelCentro1);
		panelCentro.add(panelCentro2);
		panelCentro1.add(tienda);
		panelCentro1.add(tiendas);
		panelCentro2.add(modificar);
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
		else if(modificarF.isActive()) {
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
