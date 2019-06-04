 package es.studium.Programadegestión;

import java.awt.event.*;
import java.awt.*;

public class Programa implements WindowListener, ActionListener{
	
	Frame login = new Frame("LOGIN");
	
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
		login.add(panel5);
		claveT.setEchoChar('*');
		login.addWindowListener(this);
		logins.addActionListener(this);
		limpia.addActionListener(this);
		login.setVisible(true);
	}
	public static void main(String[] args) {
		Programa po = new Programa();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(limpia.equals(arg0.getSource())) {
			usuarioT.setText(" ");
			claveT.selectAll();
			claveT.setText("");
		} 
		if(logins.equals(arg0.getSource())){
			//hay varios usuarios
			//Admin = Super, Usuario = Suc123; 
			String usuario=usuarioT.getText();
			String clave=claveT.getText();
			login.setVisible(false);
			//Aqui hago la verificacion de la clave y el usuario
			new Usuarios(usuario,clave);
		} 
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
			System.exit(0);
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
