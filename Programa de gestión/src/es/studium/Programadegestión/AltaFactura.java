package es.studium.Programadegestión;

import java.awt.Button;
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

public class AltaFactura extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	Label fecha = new Label("Fecha de compra:");
	Label cliente = new Label ("Cliene:");
	Label trabajador = new Label ("Trabajador:");
	
	TextField fechaRespuesta = new TextField("Dia/Mes/Año");
	Choice clienteRespuesta = new Choice();
	Choice trabajadorRespuesta = new Choice();
	
	Button alta = new Button("Alta");
	Button limpiar = new Button("Limpiar");
	
	Dialog correcto = new Dialog(this,"Alta correcta");
	Dialog incorrecto = new Dialog(this, "Alta fallida");
	
	Label bien = new Label("Alta Correcta");
	Label mal = new Label("Se ha producido un error en la Alta");
	
	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	Panel panel4 = new Panel();
	
	AltaFactura(String t) {
		setTitle(t);
		this.setVisible(true);
		this.setSize(250,180);
		setLocationRelativeTo(null);
		this.setLayout(new GridLayout(4,1));
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		add(panel1);
		panel1.add(fecha);
		panel1.add(fechaRespuesta);
		add(panel2);
		panel2.add(cliente);
		panel2.add(clienteRespuesta);
		add(panel3);
		panel3.add(trabajador);
		panel3.add(trabajadorRespuesta);
		add(panel4);
		panel4.add(alta);
		panel4.add(limpiar);
		clienteRespuesta.addItem("");
		clienteRespuesta.addItem("cliente1");
		clienteRespuesta.addItem("cliente2");
		trabajadorRespuesta.addItem("");
		trabajadorRespuesta.addItem("trabajador1");
		trabajadorRespuesta.addItem("trabajador2");
		alta.addActionListener(this);
		limpiar.addActionListener(this);
		this.addWindowListener(this);
	}

	public static void main(String[] args) {
		new AltaFactura("Alta Factura");
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(limpiar))
		{		
			fechaRespuesta.setText("//");
			clienteRespuesta.select(0);
			trabajadorRespuesta.select(0);
		}
		else if(arg0.getSource().equals(alta))
		{
			String fecha=fechaRespuesta.getText();
			String cliente =clienteRespuesta.getSelectedItem();
			String trabajador=clienteRespuesta.getSelectedItem();
			if((((fecha.equals("Dia/Mes/Año"))||(fecha.equals("//")))||(cliente.equals(""))||(trabajador.equals("")))) 
			{
				incorrecto();
			}else {
				correcto();
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
	}

	private void correcto() {
		correcto.setVisible(true);
		correcto.setLocationRelativeTo(null);
		correcto.setSize(100,100);
		correcto.setLayout(new FlowLayout());
		correcto.setResizable(false);
		correcto.add(bien);
		correcto.add(aceptar1);
		
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
