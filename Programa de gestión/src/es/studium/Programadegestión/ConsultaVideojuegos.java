package es.studium.Programadegestión;


import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ConsultaVideojuegos extends Frame implements WindowListener{
	private static final long serialVersionUID = 1L;
		
	Label nombre = new Label("Nombre");
	Label generos = new Label("Géneros");
	Label plataforma = new Label("Plataforma");
	
	TextField respuestaNombre1 = new TextField("Burnaout 2");
	TextField respuestaGeneros1 = new TextField("Carreras");
	TextField respuestaPlataforma1 = new TextField("PS2");
	
	TextField respuestaNombre2 = new TextField("Burnaout Paradise");
	TextField respuestaGeneros2 = new TextField("Carreras");
	TextField respuestaPlataforma2 = new TextField("PS4");
	
	TextField respuestaNombre3 = new TextField("Burnaout 2");
	TextField respuestaGeneros3 = new TextField("Carreras");
	TextField respuestaPlataforma3 = new TextField("PS4");
	
	TextField respuestaNombre4 = new TextField("Burnaout 2");
	TextField respuestaGeneros4 = new TextField("Carreras");
	TextField respuestaPlataforma4 = new TextField("PS4");
	
	TextField respuestaNombre5 = new TextField("Super Mario Odyssey");
	TextField respuestaGeneros5 = new TextField("Plataformas");
	TextField respuestaPlataforma5 = new TextField("Switch");
	
	TextField respuestaNombre6 = new TextField("Valkyria Chronicles 4");
	TextField respuestaGeneros6 = new TextField("RPG");
	TextField respuestaPlataforma6 = new TextField("Switch");
	
	TextField respuestaNombre7 = new TextField("Super Mario Odyssey");
	TextField respuestaGeneros7 = new TextField("Plataformas");
	TextField respuestaPlataforma7 = new TextField("Switch");
	
	TextField respuestaNombre8 = new TextField("Red Dead Redemption 2");
	TextField respuestaGeneros8 = new TextField("Plataformas");
	TextField respuestaPlataforma8 = new TextField("PS4");
	
	TextField respuestaNombre9 = new TextField("Forza Horizon 4");
	TextField respuestaGeneros9 = new TextField("Plataformas");
	TextField respuestaPlataforma9 = new TextField("XBOX ONE");
	
	TextField respuestaNombre10 = new TextField("Monster Hunter World");
	TextField respuestaGeneros10 = new TextField("RPG");
	TextField respuestaPlataforma10 = new TextField("PS4");
	
	Panel panelPrincipal1= new Panel();

	
	public ConsultaVideojuegos(String t) {
		setSize(600,350);
		setTitle("Consulta Cliente");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		panelPrincipal1.setLayout(new GridLayout(11,3));
		add(panelPrincipal1);
		panelPrincipal1.add(nombre);
		panelPrincipal1.add(generos);
		panelPrincipal1.add(plataforma);
		panelPrincipal1.add(respuestaNombre1);
		respuestaNombre1.setEditable(false);
		panelPrincipal1.add(respuestaGeneros1);
		respuestaGeneros1.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma1);
		respuestaPlataforma1.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre2);
		respuestaNombre2.setEditable(false);
		panelPrincipal1.add(respuestaGeneros2);
		respuestaGeneros2.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma2);
		respuestaPlataforma2.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre3);
		respuestaNombre3.setEditable(false);
		panelPrincipal1.add(respuestaGeneros3);
		respuestaGeneros3.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma3);
		respuestaPlataforma3.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre4);
		respuestaNombre4.setEditable(false);
		panelPrincipal1.add(respuestaGeneros4);
		respuestaGeneros4.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma4);
		respuestaPlataforma4.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre5);
		respuestaNombre5.setEditable(false);
		panelPrincipal1.add(respuestaGeneros5);
		respuestaGeneros5.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma5);
		respuestaPlataforma5.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre6);
		respuestaNombre6.setEditable(false);
		panelPrincipal1.add(respuestaGeneros6);
		respuestaGeneros6.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma6);
		respuestaPlataforma6.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre7);
		respuestaNombre7.setEditable(false);
		panelPrincipal1.add(respuestaGeneros7);
		respuestaGeneros7.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma7);
		respuestaPlataforma7.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre8);
		respuestaNombre8.setEditable(false);
		panelPrincipal1.add(respuestaGeneros8);
		respuestaGeneros8.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma8);
		respuestaPlataforma8.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre9);
		respuestaNombre9.setEditable(false);
		panelPrincipal1.add(respuestaGeneros9);
		respuestaGeneros9.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma9);
		respuestaPlataforma9.setEditable(false);
		
		panelPrincipal1.add(respuestaNombre10);
		respuestaNombre10.setEditable(false);
		panelPrincipal1.add(respuestaGeneros10);
		respuestaGeneros10.setEditable(false);
		panelPrincipal1.add(respuestaPlataforma10);
		respuestaPlataforma10.setEditable(false);
		
		addWindowListener(this);
		setVisible(true);
	}


	public static void main(String[] args) {
		new ConsultaVideojuegos("Consulta Videojuegos");
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
