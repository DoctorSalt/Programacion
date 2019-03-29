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

public class ModificacionFactura extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;
	
	Choice facturas = new Choice();
	Button aceptar = new Button("Modificar");
	
	Frame modificarF = new Frame();
	
	Label fecha = new Label("Fecha de compra:");
	Label cliente = new Label ("Cliene:");
	Label trabajador = new Label ("Trabajador:");
	
	TextField fechaRespuesta = new TextField("Dia/Mes/Año");
	Choice clienteRespuesta = new Choice();
	Choice trabajadorRespuesta = new Choice();
	
	Button modificar = new Button("Modificar");
	
	Button aceptar1 = new Button("Aceptar");
	Button aceptar2 = new Button("Aceptar");
	
	Panel panelPrincipal1= new Panel();
	Panel panelPrincipal2= new Panel();
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	Panel panel4 = new Panel();
	
	public ModificacionFactura(String t) {
		setVisible(true);
		setTitle(t);
		setSize(350,200);
		setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		panelPrincipal1.setLayout(new FlowLayout());
		panelPrincipal2.setLayout(new FlowLayout());
		add(panelPrincipal1);
		add(panelPrincipal2);
		panelPrincipal1.add(facturas);
		panelPrincipal2.add(aceptar);
		facturas.addItem("factura1");
		facturas.addItem("factura2");
		facturas.addItem("factura3");
		addWindowListener(this);
		aceptar.addActionListener(this);	
		}

	public static void main(String[] args) {
		new ModificacionFactura("Modificacion Factura");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(aceptar)) {
			String seleccion=facturas.getSelectedItem();
			ModificarFuncion(seleccion);
		}else if(e.getSource().equals(modificar)) {
			//Colocar funcion que modifique cosas TRABAJA EN ESTO
			JOptionPane.showMessageDialog (null, "El dato ha sido modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	private void ModificarFuncion(String seleccion) {
		modificarF.setVisible(true);
		modificarF.setTitle("Modificacion Factura");
		modificarF.setSize(300,180);
		modificarF.setLocationRelativeTo(null);
		modificarF.setLayout(new GridLayout(4,1));
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		modificarF.add(panel1);
		panel1.add(fecha);
		panel1.add(fechaRespuesta);
		modificarF.add(panel2);
		panel2.add(cliente);
		panel2.add(clienteRespuesta);
		modificarF.add(panel3);
		panel3.add(trabajador);
		panel3.add(trabajadorRespuesta);
		modificarF.add(panel4);
		panel4.add(modificar);
		clienteRespuesta.addItem("");
		clienteRespuesta.addItem("cliente1");
		clienteRespuesta.addItem("cliente2");
		trabajadorRespuesta.addItem("");
		trabajadorRespuesta.addItem("trabajador1");
		trabajadorRespuesta.addItem("trabajador2");
		modificar.addActionListener(this);
		modificarF.addWindowListener(this);	
		
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
		if(isActive()) {
			setVisible(false);
		}
		if(modificarF.isActive()) {
			modificarF.setVisible(false);
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
