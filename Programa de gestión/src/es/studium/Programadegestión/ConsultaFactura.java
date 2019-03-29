package es.studium.Programadegestión;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ConsultaFactura extends Frame implements WindowListener{

	private static final long serialVersionUID = 1L;
	
	Label id = new Label("IdFactura");
	Label fecha = new Label("Fecha de compra");
	Label cliente = new Label ("Cliene");
	Label trabajador = new Label ("Trabajador");
	
	TextField idRespuesta1 = new TextField("1");
	TextField fechaRespuesta1 = new TextField("25/02/2018");
	TextField clienteRespuesta1 = new TextField("1");
	TextField trabajadorRespuesta1 = new TextField("1");
	
	TextField idRespuesta2 = new TextField("2");
	TextField fechaRespuesta2 = new TextField("21/04/2018");
	TextField clienteRespuesta2 = new TextField("1");
	TextField trabajadorRespuesta2 = new TextField("2");
	
	TextField idRespuesta3 = new TextField("3");
	TextField fechaRespuesta3 = new TextField("06/07/2018");
	TextField clienteRespuesta3 = new TextField("2");
	TextField trabajadorRespuesta3 = new TextField("3");
	
	TextField idRespuesta4 = new TextField("4");
	TextField fechaRespuesta4 = new TextField("12/09/2018");
	TextField clienteRespuesta4 = new TextField("3");
	TextField trabajadorRespuesta4 = new TextField("5");
	
	TextField idRespuesta5 = new TextField("5");
	TextField fechaRespuesta5 = new TextField("06/10/2018");
	TextField clienteRespuesta5 = new TextField("5");
	TextField trabajadorRespuesta5 = new TextField("5");
	
	TextField idRespuesta6 = new TextField("6");
	TextField fechaRespuesta6 = new TextField("09/10/2018");
	TextField clienteRespuesta6 = new TextField("8");
	TextField trabajadorRespuesta6 = new TextField("7");
	
	TextField idRespuesta7 = new TextField("7");
	TextField fechaRespuesta7 = new TextField("12/10/2018");
	TextField clienteRespuesta7 = new TextField("9");
	TextField trabajadorRespuesta7 = new TextField("4");
	
	TextField idRespuesta8 = new TextField("8");
	TextField fechaRespuesta8 = new TextField("08/11/2018");
	TextField clienteRespuesta8 = new TextField("6");
	TextField trabajadorRespuesta8 = new TextField("4");
	
	TextField idRespuesta9 = new TextField("9");
	TextField fechaRespuesta9 = new TextField("19/11/2018");
	TextField clienteRespuesta9 = new TextField("4");
	TextField trabajadorRespuesta9 = new TextField("2");
	
	TextField idRespuesta10 = new TextField("10");
	TextField fechaRespuesta10 = new TextField("5/12/2018");
	TextField clienteRespuesta10 = new TextField("6");
	TextField trabajadorRespuesta10 = new TextField("3");
	
	Panel panelPrincipal1= new Panel();
	
	public ConsultaFactura(String t) {
		setSize(600,350);
		setTitle("Consulta Cliente");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		panelPrincipal1.setLayout(new GridLayout(11,3));
		add(panelPrincipal1);
		panelPrincipal1.add(id);
		panelPrincipal1.add(fecha);
		panelPrincipal1.add(cliente);
		panelPrincipal1.add(trabajador);
		
		panelPrincipal1.add(idRespuesta1);
		idRespuesta1.setEditable(false);
		panelPrincipal1.add(fechaRespuesta1);
		fechaRespuesta1.setEditable(false);
		panelPrincipal1.add(clienteRespuesta1);
		clienteRespuesta1.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta1);
		trabajadorRespuesta1.setEditable(false);
		
		panelPrincipal1.add(idRespuesta2);
		idRespuesta2.setEditable(false);
		panelPrincipal1.add(fechaRespuesta2);
		fechaRespuesta2.setEditable(false);
		panelPrincipal1.add(clienteRespuesta2);
		clienteRespuesta2.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta2);
		trabajadorRespuesta2.setEditable(false);
		
		panelPrincipal1.add(idRespuesta3);
		idRespuesta3.setEditable(false);
		panelPrincipal1.add(fechaRespuesta3);
		fechaRespuesta3.setEditable(false);
		panelPrincipal1.add(clienteRespuesta3);
		clienteRespuesta3.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta3);
		trabajadorRespuesta3.setEditable(false);
		
		panelPrincipal1.add(idRespuesta4);
		idRespuesta4.setEditable(false);
		panelPrincipal1.add(fechaRespuesta4);
		fechaRespuesta4.setEditable(false);
		panelPrincipal1.add(clienteRespuesta4);
		clienteRespuesta4.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta4);
		trabajadorRespuesta4.setEditable(false);
		
		panelPrincipal1.add(idRespuesta5);
		idRespuesta5.setEditable(false);
		panelPrincipal1.add(fechaRespuesta5);
		fechaRespuesta5.setEditable(false);
		panelPrincipal1.add(clienteRespuesta5);
		clienteRespuesta5.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta5);
		trabajadorRespuesta5.setEditable(false);
		
		panelPrincipal1.add(idRespuesta6);
		idRespuesta6.setEditable(false);
		panelPrincipal1.add(fechaRespuesta6);
		fechaRespuesta6.setEditable(false);
		panelPrincipal1.add(clienteRespuesta6);
		clienteRespuesta6.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta6);
		trabajadorRespuesta6.setEditable(false);
		
		panelPrincipal1.add(idRespuesta7);
		idRespuesta7.setEditable(false);
		panelPrincipal1.add(fechaRespuesta7);
		fechaRespuesta7.setEditable(false);
		panelPrincipal1.add(clienteRespuesta7);
		clienteRespuesta7.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta7);
		trabajadorRespuesta7.setEditable(false);
		
		panelPrincipal1.add(idRespuesta8);
		idRespuesta8.setEditable(false);
		panelPrincipal1.add(fechaRespuesta8);
		fechaRespuesta8.setEditable(false);
		panelPrincipal1.add(clienteRespuesta8);
		clienteRespuesta8.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta8);
		trabajadorRespuesta8.setEditable(false);
		
		panelPrincipal1.add(idRespuesta9);
		idRespuesta9.setEditable(false);
		panelPrincipal1.add(fechaRespuesta9);
		fechaRespuesta9.setEditable(false);
		panelPrincipal1.add(clienteRespuesta9);
		clienteRespuesta9.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta9);
		trabajadorRespuesta9.setEditable(false);
		
		
		panelPrincipal1.add(idRespuesta10);
		idRespuesta10.setEditable(false);
		panelPrincipal1.add(fechaRespuesta10);
		fechaRespuesta10.setEditable(false);
		panelPrincipal1.add(clienteRespuesta10);
		clienteRespuesta10.setEditable(false);
		panelPrincipal1.add(trabajadorRespuesta10);
		trabajadorRespuesta10.setEditable(false);
		
		addWindowListener(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ConsultaFactura("Consulta Clientes");
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
