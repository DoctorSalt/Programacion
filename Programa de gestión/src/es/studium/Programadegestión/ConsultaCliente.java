package es.studium.Programadegestión;

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

public class ConsultaCliente  extends Frame implements WindowListener, ActionListener{

private static final long serialVersionUID = 1L;
	
	Label nombre = new Label("Nombre");
	Label fecha = new Label ("Fecha");
	Label puntos = new Label ("Puntos");
		
	Panel panelPrincipal1= new Panel();
	
	TextField respuestaNombre1 = new TextField("Miguel");
	TextField respuestaFecha1 = new TextField("5/6/2018");
	TextField respuestaPuntos1 = new TextField("10");
	
	TextField respuestaNombre2 = new TextField("Juan");
	TextField respuestaFecha2 = new TextField("17/7/2018");
	TextField respuestaPuntos2 = new TextField("20");

	TextField respuestaNombre3 = new TextField("Juan");
	TextField respuestaFecha3 = new TextField("1/2/2018");
	TextField respuestaPuntos3 = new TextField("20");
	
	TextField respuestaNombre4 = new TextField("Manuel");
	TextField respuestaFecha4 = new TextField("10/3/2018");
	TextField respuestaPuntos4 = new TextField("20");
	
	TextField respuestaNombre5 = new TextField("Pablo");
	TextField respuestaFecha5 = new TextField("21/12/2018");
	TextField respuestaPuntos5 = new TextField("20");
	
	TextField respuestaNombre6 = new TextField("Isabel");
	TextField respuestaFecha6 = new TextField("1/10/2018");
	TextField respuestaPuntos6 = new TextField("8");
	
	TextField respuestaNombre7 = new TextField("Maria");
	TextField respuestaFecha7 = new TextField("1/9/2018");
	TextField respuestaPuntos7 = new TextField("12");
	
	TextField respuestaNombre8 = new TextField("John");
	TextField respuestaFecha8 = new TextField("1/8/2018");
	TextField respuestaPuntos8 = new TextField("30");
	
	TextField respuestaNombre9 = new TextField("José");
	TextField respuestaFecha9 = new TextField("1/7/2018");
	TextField respuestaPuntos9 = new TextField("5");
	
	TextField respuestaNombre10 = new TextField("Julio");
	TextField respuestaFecha10 = new TextField("11/12/2018");
	TextField respuestaPuntos10 = new TextField("15");
	
	public ConsultaCliente(String string) {
		setSize(450,350);
		setTitle("Consulta Cliente");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		add(panelPrincipal1);
		panelPrincipal1.setLayout(new GridLayout(11,3));
		panelPrincipal1.add(nombre);	
		panelPrincipal1.add(fecha);
		panelPrincipal1.add(puntos);
		
		panelPrincipal1.add(respuestaNombre1);
		respuestaNombre1.setEditable(false);
		panelPrincipal1.add(respuestaFecha1);
		respuestaFecha1.setEditable(false);
		panelPrincipal1.add(respuestaPuntos1);
		respuestaPuntos1.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre2);
		respuestaNombre2.setEditable(false);
		panelPrincipal1.add(respuestaFecha2);
		respuestaFecha2.setEditable(false);
		panelPrincipal1.add(respuestaPuntos2);
		respuestaPuntos2.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre3);
		respuestaNombre3.setEditable(false);
		panelPrincipal1.add(respuestaFecha3);
		respuestaFecha3.setEditable(false);
		panelPrincipal1.add(respuestaPuntos3);
		respuestaPuntos3.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre4);
		respuestaNombre4.setEditable(false);
		panelPrincipal1.add(respuestaFecha4);
		respuestaFecha4.setEditable(false);
		panelPrincipal1.add(respuestaPuntos4);
		respuestaPuntos4.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre5);
		respuestaNombre5.setEditable(false);
		panelPrincipal1.add(respuestaFecha5);
		respuestaFecha5.setEditable(false);
		panelPrincipal1.add(respuestaPuntos5);
		respuestaPuntos5.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre6);
		respuestaNombre6.setEditable(false);
		panelPrincipal1.add(respuestaFecha6);
		respuestaFecha6.setEditable(false);
		panelPrincipal1.add(respuestaPuntos6);
		respuestaPuntos6.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre7);
		respuestaNombre7.setEditable(false);
		panelPrincipal1.add(respuestaFecha7);
		respuestaFecha7.setEditable(false);
		panelPrincipal1.add(respuestaPuntos7);
		respuestaPuntos7.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre8);
		respuestaNombre8.setEditable(false);
		panelPrincipal1.add(respuestaFecha8);
		respuestaFecha8.setEditable(false);
		panelPrincipal1.add(respuestaPuntos8);
		respuestaPuntos8.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre9);
		respuestaNombre9.setEditable(false);
		panelPrincipal1.add(respuestaFecha9);
		respuestaFecha9.setEditable(false);
		panelPrincipal1.add(respuestaPuntos9);
		respuestaPuntos9.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre10);
		respuestaNombre10.setEditable(false);
		panelPrincipal1.add(respuestaFecha10);
		respuestaFecha10.setEditable(false);
		panelPrincipal1.add(respuestaPuntos10);
		respuestaPuntos10.setEditable(false);
		
		addWindowListener(this);	
		setVisible(true);
	}

	public static void main(String[] args) {
		new ConsultaCliente("Consulta Clientes");

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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
