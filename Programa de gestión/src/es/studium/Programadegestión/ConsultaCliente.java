package es.studium.Programadegestión;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ConsultaCliente  extends Frame implements WindowListener, ActionListener{

	private static final long serialVersionUID = 1L;	

	Panel panel = new Panel();

	ArrayList<String> listaClientesTitulo = new ArrayList<>();
	ArrayList<String> listaClientesBusqueda = new ArrayList<>();
	String nombreTabla="clientes";
	JTable tablaRecogida;
	String usuario="";
	Button guardar= new Button("Guardar");

	public ConsultaCliente() {
		setSize(600,250);
		setTitle("Consulta Cliente");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		listaClientesTitulo.add("IdCliente");
		listaClientesBusqueda.add("idCliente");
		listaClientesTitulo.add("Nombre");
		listaClientesBusqueda.add("nombreCliente");
		listaClientesTitulo.add("Fecha de Nacimiento");
		listaClientesBusqueda.add("fechaNacimientoCliente");
		listaClientesTitulo.add("Puntos");
		listaClientesBusqueda.add("puntosCliente");
		//TablaConsulta clientes 
		TablaConsulta clientes=new TablaConsulta();
		tablaRecogida =clientes.TablaConsulta(listaClientesTitulo, listaClientesBusqueda,nombreTabla);
		JScrollPane tablaResultante=new JScrollPane(tablaRecogida);
		tablaResultante.setPreferredSize(new Dimension(550, 200));
		add(tablaResultante, BorderLayout.CENTER);		
		add(panel, BorderLayout.SOUTH);
		panel.add(guardar);
		guardar.addActionListener(this);
		addWindowListener(this);	
		setVisible(true);
		Cargar();
		Registro(usuario);
	}

	private void Registro(String usuario) {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+usuario+"]"+"[CONSULTA EN CLIENTES]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}
	}

	public static void main(String[] args) {
		new ConsultaCliente();

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
		if(arg0.getSource()==guardar) {
			GuardarArchivo();
			System.out.println("guardado");
		}
	}

	private void GuardarArchivo() {
		Document documento = new Document();
		try
		{
			// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
			FileOutputStream ficheroPdf = new FileOutputStream("Consulta_Clientes.pdf");
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			// Se abre el documento.
			documento.open();
			documento.addTitle("Tabla de Consulta de Clientes");
			Paragraph titulo = new Paragraph();
			titulo.setAlignment(Paragraph.ALIGN_CENTER);
			titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.BLACK));
			titulo.add("***LISTA DE CLIENTES***");
			documento.add(titulo);
			Paragraph vacio1 = new Paragraph();
			vacio1.add("\n\n");
			documento.add(vacio1);	        
			PdfPTable tabla = new PdfPTable(listaClientesTitulo.size());
			for (int i = 0; i < listaClientesTitulo.size(); i++)
			{
				Paragraph registroT = new Paragraph();
				registroT.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				registroT.setFont(FontFactory.getFont("Arial", 12, Font.BOLD));
				registroT.add(listaClientesTitulo.get(i));
				tabla.addCell(registroT);
			}
			for(int i=0;i<tablaRecogida.getRowCount();i++) 
			{
				for(int a=0; a<listaClientesTitulo.size();a++) 
				{
					System.out.println((i+1)+":"+(a+1));
					Paragraph registroC = new Paragraph();
					registroC.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					registroC.setFont(FontFactory.getFont("Arial", 12));
					registroC.add((String) tablaRecogida.getValueAt(i,a));
					tabla.addCell(registroC);
				}
			}
			documento.add(tabla);
			documento.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	private void Cargar() {
		//Como usaremos FileReader y puede lanzar una excepción
		//necesitaremos un bloque try – catch
		try
		{
			//Origen de los datos en el proyecto anterior
			FileReader fr = new FileReader("RegistroActivo.log");
			//Buffer de lectura
			BufferedReader entrada = new BufferedReader(fr);
			//Bucle para sacar la información del archivo
			usuario=entrada.readLine();
			//Cerrar el objeto entrada
			entrada.close();
			fr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Archivo NO encontrado");
		}
		catch(IOException i)
		{
			System.out.println("Se produjo un error de Archivo");
		}


	}
}
