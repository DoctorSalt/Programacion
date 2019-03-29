 package es.studium.Programadegestión;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.awt.*;

public class Programa implements WindowListener, ActionListener{
	
	
	Frame login = new Frame("LOGIN");
	Dialog errorLogin = new Dialog(login, "Error login");

	Label errorLoginT = new Label("Datos de Login incorrectos");
	Button errorLoginB = new Button ("Volver a intentarlo");

	Label usuario = new Label ("Usuario:");
	Label clave = new Label ("    Clave:");
	Label logeate = new Label ("Logeate");
	
	TextField usuarioT= new TextField (20);
	TextField claveT = new TextField (20);
	Button logins = new Button ("Login");
	Button limpia = new Button ("Limpia");
	Button olvide = new Button ("Olvide la clave");

	Panel panel = new Panel(); 
	Panel panel2 = new Panel(); 
	Panel panel3 = new Panel();
	Panel panel4 = new Panel();
	Panel panel5 = new Panel();


	Programa()
	{
		login.setLocationRelativeTo(null);
		login.setLayout(new GridLayout(5,1));
		login.setSize(400, 200);
		login.setVisible(true);
		login.setResizable(false);
		panel.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		panel5.setLayout(new FlowLayout());
		panel.add(logeate);
		login.add(panel);
		panel2.add(usuario);
		panel2.add(usuarioT);
		login.add(panel2);
		panel3.add(clave);
		panel3.add(claveT);
		login.add(panel3);
		login.add(panel4);
		panel4.add(logins);
		panel4.add(limpia);
		panel5.add(olvide);
		login.add(panel5);
		claveT.setEchoChar('*');
		login.addWindowListener(this);
		logins.addActionListener(this);
		limpia.addActionListener(this);
		olvide.addActionListener(this);

		//añado ventana de error de login
		
	}
	public static void main(String[] args) {
		new Programa();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(limpia.equals(arg0.getSource())) {
			usuarioT.setText("");
			claveT.setText("");
		} else
		if(logins.equals(arg0.getSource())){
			//hay varios usuarios
			//admin = Super, Yolo = 12345
			String usuario=usuarioT.getText();
			String clave=claveT.getText();
			
			new Usuarios(usuario,clave);
			
			
			/*
			if(usuario.equals(a.getNombre())){
				if(clave.equals(a.getContraseña())) {
					registro(0);
					login.setVisible(false);
					new VentanaAdmin("Ventana de Administrador");
				}else
				{
					error();
				}
			}else if(usuario.equals(b.getNombre())) {
				if(clave.equals(b.getContraseña())) {
					registro(1);
					login.setVisible(false);
					new VentanaUsuario("Ventana de Usuario");
				}else
				{
					error();
				}
			}else 
			{
				error();
			}
		*/
		} else
		if(olvide.equals(arg0.getSource())){
			new OlvideClave(null);
		}else
		if(errorLoginB.equals(arg0.getSource())) {
			errorLogin.setVisible(false);
		}
	}
	/*
	private void registro(int i) {
		String usuario="";
		switch(i) {
		case(0):
		usuario="admin";
		break;
		case(1):
		usuario="Yolo";
		break;
		}
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+usuario+"]"+"[INSERT INTO ...]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}
	}
	*/
	private void error() {
		//Aqui llamare el dialog error
		errorLogin.setLayout(new FlowLayout());
		errorLogin.setLocationRelativeTo(null);
		errorLogin.setSize(200,100);
		errorLogin.add(errorLoginT);
		errorLogin.add(errorLoginB);
		errorLogin.setVisible(true);
		errorLogin.addWindowListener(this);
		errorLoginB.addActionListener(this);

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
		if(login.isActive()) {
			login.setVisible(false);
		}
		if(errorLogin.isActive()) {
			errorLogin.setVisible(false);
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

	}

}
