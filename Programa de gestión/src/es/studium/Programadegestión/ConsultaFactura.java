package es.studium.Programadegestión;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FileDialog;
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


public class ConsultaFactura extends Frame implements WindowListener, ActionListener{

private static final long serialVersionUID = 1L;	
	
	Panel panel = new Panel();
	
	ArrayList<String> listaFacturasTitulo = new ArrayList<>();
	ArrayList<String> listaFacturasBusqueda = new ArrayList<>();
	String nombreTabla="facturas";
	JTable tablaRecogida;
	String usuario="";
	
	Button guardar= new Button("Guardar");

	public ConsultaFactura() {
		setSize(500,250);
		setTitle("Consulta Facturas");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		listaFacturasTitulo.add("IdFactura");
		listaFacturasBusqueda.add("idFactura");
		listaFacturasTitulo.add("Fecha de Compra");
		listaFacturasBusqueda.add("fechaCompra");
		listaFacturasTitulo.add("IdClienteFK2");
		listaFacturasBusqueda.add("idClienteFK2");
		//TablaConsulta clientes 
		TablaConsulta facturas=new TablaConsulta();
		tablaRecogida =facturas.tablaConsultaAplicacion(listaFacturasTitulo, listaFacturasBusqueda,nombreTabla);
		JScrollPane tablaResultante=new JScrollPane(tablaRecogida);
		tablaResultante.setPreferredSize(new Dimension(450, 200));
		add(tablaResultante, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		panel.add(guardar);
		guardar.addActionListener(this);
		addWindowListener(this);	
		setVisible(true);
		Registro();
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
		FileDialog fd = new FileDialog(this, "Indicar nombre y ubicación del archivo",FileDialog.SAVE);
		fd.setVisible(true);
		if(fd.getFile().contains(".pdf")) {
			try {
			FileOutputStream ficheroPdf = new FileOutputStream(fd.getDirectory()+fd.getFile());
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			// Se abre el documento.
			documento.open();
			documento.addTitle("Tabla de Consulta de Facturas");
			Paragraph titulo = new Paragraph();
	        titulo.setAlignment(Paragraph.ALIGN_CENTER);
	        titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.BLACK));
	        titulo.add("***LISTA DE FACTURAS***");
	        documento.add(titulo);
	        Paragraph vacio1 = new Paragraph();
	        vacio1.add("\n\n");
	        documento.add(vacio1);	        
			PdfPTable tabla = new PdfPTable(listaFacturasTitulo.size());
			for (int i = 0; i < listaFacturasTitulo.size(); i++)
			{
				Paragraph registroT = new Paragraph();
				registroT.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				registroT.setFont(FontFactory.getFont("Arial", 12, Font.BOLD));
				registroT.add(listaFacturasTitulo.get(i));
				tabla.addCell(registroT);
			}
			for(int i=0;i<tablaRecogida.getRowCount();i++) 
			{
				System.out.println(listaFacturasTitulo.size());
				for(int a=0; a<listaFacturasTitulo.size();a++) 
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
		
		}else {
			try {
				FileOutputStream ficheroPdf = new FileOutputStream(fd.getDirectory()+fd.getFile()+".pdf");
				PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
				// Se abre el documento.
				documento.open();
				documento.addTitle("Tabla de Consulta de Facturas");
				Paragraph titulo = new Paragraph();
		        titulo.setAlignment(Paragraph.ALIGN_CENTER);
		        titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.BLACK));
		        titulo.add("***LISTA DE FACTURAS***");
		        documento.add(titulo);
		        Paragraph vacio1 = new Paragraph();
		        vacio1.add("\n\n");
		        documento.add(vacio1);	        
				PdfPTable tabla = new PdfPTable(listaFacturasTitulo.size());
				for (int i = 0; i < listaFacturasTitulo.size(); i++)
				{
					Paragraph registroT = new Paragraph();
					registroT.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					registroT.setFont(FontFactory.getFont("Arial", 12, Font.BOLD));
					registroT.add(listaFacturasTitulo.get(i));
					tabla.addCell(registroT);
				}
				for(int i=0;i<tablaRecogida.getRowCount();i++) 
				{
					System.out.println(listaFacturasTitulo.size());
					for(int a=0; a<listaFacturasTitulo.size();a++) 
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

	
	}
	private void Registro() {
		Calendar fechaRegistro = Calendar.getInstance();
		Date fecha = fechaRegistro.getTime();
		try {
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println("["+fecha+"] "+"["+"Administrador"+"]"+"[CONSULTA EN FACTURAS]");
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Se produjo un error");
		}
	}
}
