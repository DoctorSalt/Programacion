package es.studium.Programadegestión;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
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

public class AltaTrabajador  extends Frame implements WindowListener, ActionListener{

	Label nombre = new Label ("Nombre:");
	Label apellido = new Label ("Apellido:");
	Label nomina = new Label ("Nomina:");
	Label tipoContrato = new Label ("Tipo de Contrato:");
	Label horasContrato = new Label ("Horas de Trabajo:");
	Label jefe = new Label ("¿Es jefe?");
	Label tienda = new Label ("Tienda a la que pertenece");

	TextField nombreRespuesta = new TextField("");
	TextField apellidoRespuesta = new TextField("");
	TextField nominaRespuesta = new TextField("");
	TextField tipoContratoRespuesta = new TextField("");
	TextField horasContratoRespuesta = new TextField(""); //se refiere a horas semanales

	CheckboxGroup jefeRespuesta = new CheckboxGroup();
	Checkbox jefeSi = new Checkbox("Si",false,jefeRespuesta);
	Checkbox jefeNo = new Checkbox("No", false, jefeRespuesta);
	Choice tiendas = new Choice();


	Button alta = new Button("Alta");
	Button limpiar = new Button("Limpiar");

	Dialog correcto = new Dialog(this,"Alta correcta");
	Dialog incorrecto = new Dialog(this, "Alta fallida");

	Label bien = new Label("Alta Correcta");
	Label mal = new Label("Se ha producido un error en la Alta");

	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");


	Panel panelNorte = new Panel();
	Panel panelCentro = new Panel();
	Panel panelDoble = new Panel();

	Panel panelCentro1 = new Panel();
	Panel panelCentro2 = new Panel();

	private static final long serialVersionUID = 1L;

	public AltaTrabajador(String t) {
		setTitle(t);
		this.setVisible(true);
		this.setSize(600,200);
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		panelNorte.setLayout(new GridLayout(3,4));
		panelCentro.setLayout(new GridLayout(2,1));
		panelDoble.setLayout(new GridLayout(1,3));
		panelCentro1.setLayout(new FlowLayout());
		panelCentro2.setLayout(new FlowLayout());

		tiendas.addItem("");
		tiendas.addItem("Tienda1");
		tiendas.addItem("Tienda2");

		add(panelNorte, "North");
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

		add(panelCentro,"Center");
		panelCentro.add(panelCentro1);
		panelCentro.add(panelCentro2);
		panelCentro1.add(tienda);
		panelCentro1.add(tiendas);
		panelCentro2.add(alta);
		panelCentro2.add(limpiar);

		alta.addActionListener(this);
		limpiar.addActionListener(this);
		this.addWindowListener(this);

	}

	//jefeSi, jefeNo
	public static void main(String[] args) {
		new AltaTrabajador("Alta Trabajador");
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(limpiar)) {
			nombreRespuesta.setText("");
			nominaRespuesta.setText("");
			horasContratoRespuesta.setText("");
			apellidoRespuesta.setText("");
			tipoContratoRespuesta.setText("");
			jefeSi.setState(false);
			jefeNo.setState(false);
			tiendas.select(0);
		}else if(arg0.getSource().equals(alta)) {
			String nombre = nombreRespuesta.getText();
			String nomina = nominaRespuesta.getText();
			String horas = horasContratoRespuesta.getText();
			String apellidos = apellidoRespuesta.getText();
			String tipoContrato = tipoContratoRespuesta.getText();
			Boolean tieneJefe;
			if((nombre.equals(""))||(nomina.equals(""))||(horas.equals(""))||(apellidos.equals(""))||(tipoContrato.equals(""))) {
				incorrecto();
			}
			else {
				if(true == jefeSi.getState()) {
					tieneJefe=true;
					correcto();
				}else if(true ==jefeNo.getState()) {
					tieneJefe=false;
					correcto();
				}else {
					incorrecto();
				}
			}
		}
	}
	private void incorrecto() {
		incorrecto.setVisible(true);
		incorrecto.setLocationRelativeTo(null);
		incorrecto.setSize(250,100);
		incorrecto.setLayout(new FlowLayout());
		incorrecto.add(mal);
		incorrecto.add(aceptar2);
		incorrecto.addWindowListener(this);
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
		else if(correcto.isActive()) {
			correcto.setVisible(false);
		}
		else if(incorrecto.isActive()) {
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
