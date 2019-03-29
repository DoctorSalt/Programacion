package es.studium.Programadegestión;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ConsultaTrabajador extends Frame implements WindowListener{
	
	private static final long serialVersionUID = 1L;
		
	Label idTrabajador = new Label ("IdTrabajador");
	Label nombre = new Label ("Nombre");
	Label apellido = new Label ("Apellido");
	Label nomina = new Label ("Nomina");
	Label tipoContrato = new Label ("Tipo de Contrato");
	Label horasContrato = new Label ("Horas de Trabajo");
	Label jefe = new Label ("¿Es jefe?");
	Label tienda = new Label ("Tienda");
	
	TextField idTrabajadorRespuesta1 = new TextField("1");
	TextField nombreRespuesta1 = new TextField("Manolo");
	TextField apellidoRespuesta1 = new TextField("Muñoz");
	TextField nominaRespuesta1 = new TextField("500");
	TextField tipoContratoRespuesta1 = new TextField("Partido");
	TextField horasContratoRespuesta1 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta1 = new TextField("Si"); 
	TextField tiendaRespuesta1 = new TextField("1"); 
	
	TextField idTrabajadorRespuesta2 = new TextField("2");
	TextField nombreRespuesta2 = new TextField("Manolo");
	TextField apellidoRespuesta2 = new TextField("Muñoz");
	TextField nominaRespuesta2 = new TextField("500");
	TextField tipoContratoRespuesta2 = new TextField("Partido");
	TextField horasContratoRespuesta2 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta2 = new TextField("Si"); 
	TextField tiendaRespuesta2 = new TextField("1"); 
	
	TextField idTrabajadorRespuesta3 = new TextField("3");
	TextField nombreRespuesta3 = new TextField("Manolo");
	TextField apellidoRespuesta3 = new TextField("Muñoz");
	TextField nominaRespuesta3 = new TextField("500");
	TextField tipoContratoRespuesta3 = new TextField("Partido");
	TextField horasContratoRespuesta3 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta3 = new TextField("Si"); 
	TextField tiendaRespuesta3 = new TextField("1"); 

	TextField idTrabajadorRespuesta4 = new TextField("4");
	TextField nombreRespuesta4 = new TextField("Manolo");
	TextField apellidoRespuesta4 = new TextField("Muñoz");
	TextField nominaRespuesta4 = new TextField("500");
	TextField tipoContratoRespuesta4 = new TextField("Partido");
	TextField horasContratoRespuesta4 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta4 = new TextField("Si"); 
	TextField tiendaRespuesta4 = new TextField("1"); 
	
	TextField idTrabajadorRespuesta5 = new TextField("5");
	TextField nombreRespuesta5 = new TextField("Manolo");
	TextField apellidoRespuesta5 = new TextField("Muñoz");
	TextField nominaRespuesta5 = new TextField("500");
	TextField tipoContratoRespuesta5 = new TextField("Partido");
	TextField horasContratoRespuesta5 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta5 = new TextField("Si"); 
	TextField tiendaRespuesta5 = new TextField("1"); 
	
	TextField idTrabajadorRespuesta6 = new TextField("6");
	TextField nombreRespuesta6 = new TextField("Manolo");
	TextField apellidoRespuesta6 = new TextField("Muñoz");
	TextField nominaRespuesta6 = new TextField("500");
	TextField tipoContratoRespuesta6 = new TextField("Partido");
	TextField horasContratoRespuesta6 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta6 = new TextField("Si"); 
	TextField tiendaRespuesta6 = new TextField("1"); 
	
	TextField idTrabajadorRespuesta7 = new TextField("7");
	TextField nombreRespuesta7 = new TextField("Manolo");
	TextField apellidoRespuesta7 = new TextField("Muñoz");
	TextField nominaRespuesta7 = new TextField("500");
	TextField tipoContratoRespuesta7 = new TextField("Partido");
	TextField horasContratoRespuesta7 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta7 = new TextField("Si"); 
	TextField tiendaRespuesta7 = new TextField("1"); 
	
	TextField idTrabajadorRespuesta8 = new TextField("8");
	TextField nombreRespuesta8 = new TextField("Manolo");
	TextField apellidoRespuesta8 = new TextField("Muñoz");
	TextField nominaRespuesta8 = new TextField("500");
	TextField tipoContratoRespuesta8 = new TextField("Partido");
	TextField horasContratoRespuesta8 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta8 = new TextField("Si"); 
	TextField tiendaRespuesta8 = new TextField("1"); 
	
	TextField idTrabajadorRespuesta9 = new TextField("9");
	TextField nombreRespuesta9 = new TextField("Manolo");
	TextField apellidoRespuesta9 = new TextField("Muñoz");
	TextField nominaRespuesta9 = new TextField("500");
	TextField tipoContratoRespuesta9 = new TextField("Partido");
	TextField horasContratoRespuesta9 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta9 = new TextField("Si"); 
	TextField tiendaRespuesta9 = new TextField("1"); 
	
	TextField idTrabajadorRespuesta10 = new TextField("10");
	TextField nombreRespuesta10 = new TextField("Manolo");
	TextField apellidoRespuesta10 = new TextField("Muñoz");
	TextField nominaRespuesta10 = new TextField("500");
	TextField tipoContratoRespuesta10 = new TextField("Partido");
	TextField horasContratoRespuesta10 = new TextField("39"); //se refiere a horas semanales
	TextField jefeRespuesta10 = new TextField("Si"); 
	TextField tiendaRespuesta10 = new TextField("2"); 
	
	Panel panelPrincipal1= new Panel();
	
	ConsultaTrabajador(String t){
		setSize(940,350);
		setTitle("Consulta Trabajador");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		panelPrincipal1.setLayout(new GridLayout(11,8));
		add(panelPrincipal1);
		panelPrincipal1.add(idTrabajador);
		panelPrincipal1.add(nombre);
		panelPrincipal1.add(apellido);
		panelPrincipal1.add(nomina);
		panelPrincipal1.add(tipoContrato);
		panelPrincipal1.add(horasContrato);
		panelPrincipal1.add(jefe);
		panelPrincipal1.add(tienda);
	

		panelPrincipal1.add(idTrabajadorRespuesta1);
		idTrabajadorRespuesta1.setEditable(false);
		panelPrincipal1.add(nombreRespuesta1);
		nombreRespuesta1.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta1);
		apellidoRespuesta1.setEditable(false);
		panelPrincipal1.add(nominaRespuesta1);
		nominaRespuesta1.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta1);
		tipoContratoRespuesta1.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta1);
		horasContratoRespuesta1.setEditable(false);
		panelPrincipal1.add(jefeRespuesta1);
		jefeRespuesta1.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta1);
		tiendaRespuesta1.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta2);
		idTrabajadorRespuesta2.setEditable(false);
		panelPrincipal1.add(nombreRespuesta2);
		nombreRespuesta2.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta2);
		apellidoRespuesta2.setEditable(false);
		panelPrincipal1.add(nominaRespuesta2);
		nominaRespuesta2.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta2);
		tipoContratoRespuesta2.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta2);
		horasContratoRespuesta2.setEditable(false);
		panelPrincipal1.add(jefeRespuesta2);
		jefeRespuesta2.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta2);
		tiendaRespuesta2.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta3);
		idTrabajadorRespuesta3.setEditable(false);
		panelPrincipal1.add(nombreRespuesta3);
		nombreRespuesta3.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta3);
		apellidoRespuesta3.setEditable(false);
		panelPrincipal1.add(nominaRespuesta3);
		nominaRespuesta3.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta3);
		tipoContratoRespuesta3.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta3);
		horasContratoRespuesta3.setEditable(false);
		panelPrincipal1.add(jefeRespuesta3);
		jefeRespuesta3.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta3);
		tiendaRespuesta3.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta4);
		idTrabajadorRespuesta4.setEditable(false);
		panelPrincipal1.add(nombreRespuesta4);
		nombreRespuesta4.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta4);
		apellidoRespuesta4.setEditable(false);
		panelPrincipal1.add(nominaRespuesta4);
		nominaRespuesta4.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta4);
		tipoContratoRespuesta4.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta4);
		horasContratoRespuesta4.setEditable(false);
		panelPrincipal1.add(jefeRespuesta4);
		jefeRespuesta4.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta4);
		tiendaRespuesta4.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta5);
		idTrabajadorRespuesta5.setEditable(false);
		panelPrincipal1.add(nombreRespuesta5);
		nombreRespuesta5.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta5);
		apellidoRespuesta5.setEditable(false);
		panelPrincipal1.add(nominaRespuesta5);
		nominaRespuesta5.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta5);
		tipoContratoRespuesta5.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta5);
		horasContratoRespuesta5.setEditable(false);
		panelPrincipal1.add(jefeRespuesta5);
		jefeRespuesta5.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta5);
		tiendaRespuesta5.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta6);
		idTrabajadorRespuesta6.setEditable(false);
		panelPrincipal1.add(nombreRespuesta6);
		nombreRespuesta6.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta6);
		apellidoRespuesta6.setEditable(false);
		panelPrincipal1.add(nominaRespuesta6);
		nominaRespuesta6.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta6);
		tipoContratoRespuesta6.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta6);
		horasContratoRespuesta6.setEditable(false);
		panelPrincipal1.add(jefeRespuesta6);
		jefeRespuesta6.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta6);
		tiendaRespuesta6.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta7);
		idTrabajadorRespuesta7.setEditable(false);
		panelPrincipal1.add(nombreRespuesta7);
		nombreRespuesta7.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta7);
		apellidoRespuesta7.setEditable(false);
		panelPrincipal1.add(nominaRespuesta7);
		nominaRespuesta7.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta7);
		tipoContratoRespuesta7.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta7);
		horasContratoRespuesta7.setEditable(false);
		panelPrincipal1.add(jefeRespuesta7);
		jefeRespuesta7.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta7);
		tiendaRespuesta7.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta8);
		idTrabajadorRespuesta8.setEditable(false);
		panelPrincipal1.add(nombreRespuesta8);
		nombreRespuesta8.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta8);
		apellidoRespuesta8.setEditable(false);
		panelPrincipal1.add(nominaRespuesta8);
		nominaRespuesta8.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta8);
		tipoContratoRespuesta8.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta8);
		horasContratoRespuesta8.setEditable(false);
		panelPrincipal1.add(jefeRespuesta8);
		jefeRespuesta8.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta8);
		tiendaRespuesta8.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta9);
		idTrabajadorRespuesta9.setEditable(false);
		panelPrincipal1.add(nombreRespuesta9);
		nombreRespuesta9.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta9);
		apellidoRespuesta9.setEditable(false);
		panelPrincipal1.add(nominaRespuesta9);
		nominaRespuesta9.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta9);
		tipoContratoRespuesta9.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta9);
		horasContratoRespuesta9.setEditable(false);
		panelPrincipal1.add(jefeRespuesta9);
		jefeRespuesta9.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta9);
		tiendaRespuesta9.setEditable(false);
		
		panelPrincipal1.add(idTrabajadorRespuesta10);
		idTrabajadorRespuesta10.setEditable(false);
		panelPrincipal1.add(nombreRespuesta10);
		nombreRespuesta10.setEditable(false);
		panelPrincipal1.add(apellidoRespuesta10);
		apellidoRespuesta10.setEditable(false);
		panelPrincipal1.add(nominaRespuesta10);
		nominaRespuesta10.setEditable(false);
		panelPrincipal1.add(tipoContratoRespuesta10);
		tipoContratoRespuesta10.setEditable(false);
		panelPrincipal1.add(horasContratoRespuesta10);
		horasContratoRespuesta10.setEditable(false);
		panelPrincipal1.add(jefeRespuesta10);
		jefeRespuesta10.setEditable(false);
		panelPrincipal1.add(tiendaRespuesta10);
		tiendaRespuesta10.setEditable(false);
		addWindowListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ConsultaTrabajador("Consulta Trabajador");
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
