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
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class ConsultaTrabajadores extends Frame implements WindowListener, ActionListener{
	
	private static final long serialVersionUID = 1L;

	Panel panel = new Panel();

	ArrayList<String> listaTrabajadoresTitulo = new ArrayList<>();
	ArrayList<String> listaTrabajadoresBusqueda = new ArrayList<>();
	String nombreTabla="trabajadores";
	JTable tablaRecogida;

	Button guardar= new Button("Guardar");
	public ConsultaTrabajadores() {
		setSize(800,250);
		setTitle("Consulta Trabajadores");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		listaTrabajadoresTitulo.add("IdTrabajador");
		listaTrabajadoresBusqueda.add("idTrabajador");
		listaTrabajadoresTitulo.add("Nombre");
		listaTrabajadoresBusqueda.add("nombreTrabajador");
		listaTrabajadoresTitulo.add("Apellidos");
		listaTrabajadoresBusqueda.add("apellidosTrabajador");
		listaTrabajadoresTitulo.add("Nomina");
		listaTrabajadoresBusqueda.add("nominaTrabajador");
		listaTrabajadoresTitulo.add("Tipo Contrato");
		listaTrabajadoresBusqueda.add("tipoContratoTrabajador");
		listaTrabajadoresTitulo.add("Horas Semanal");
		listaTrabajadoresBusqueda.add("horasTrabajador");
		listaTrabajadoresTitulo.add("IdTiendaFK1");
		listaTrabajadoresBusqueda.add("idTiendaFK1");
		listaTrabajadoresTitulo.add("JefeDeFK1");
		listaTrabajadoresBusqueda.add("jefeDeFK1");

		//TablaConsulta clientes 
		TablaConsulta trabajadores=new TablaConsulta();
		tablaRecogida =trabajadores.TablaConsulta(listaTrabajadoresTitulo, listaTrabajadoresBusqueda,nombreTabla);
		JScrollPane tablaResultante=new JScrollPane(tablaRecogida);
		tablaResultante.setPreferredSize(new Dimension(750, 200));
		add(tablaResultante, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		panel.add(guardar);
		guardar.addActionListener(this);
		//panel.add(clientes);
		addWindowListener(this);	
		setVisible(true);
	}

	public static void main(String[] args) {
		new ConsultaTrabajadores();

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
		// Se crea el documento
		Document documento = new Document();
		try
		{
			// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
			FileOutputStream ficheroPdf = new FileOutputStream("Consulta_Trabajadores.pdf");
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			// Se abre el documento.
			documento.open();
			documento.addTitle("Tabla de Consulta de Trabajadores");
			Paragraph titulo = new Paragraph();
	        titulo.setAlignment(Paragraph.ALIGN_CENTER);
	        titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.BLACK));
	        titulo.add("***LISTA DE TRABAJADORES***");
	        documento.add(titulo);
	        Paragraph vacio1 = new Paragraph();
	        vacio1.add("\n\n");
	        documento.add(vacio1);	        
			PdfPTable tabla = new PdfPTable(listaTrabajadoresTitulo.size());
			for (int i = 0; i < listaTrabajadoresTitulo.size(); i++)
			{
				Paragraph registroT = new Paragraph();
				registroT.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				registroT.setFont(FontFactory.getFont("Arial", 7, Font.BOLD));
				registroT.add(listaTrabajadoresTitulo.get(i));
				tabla.addCell(registroT);
			}
			for(int i=0;i<tablaRecogida.getRowCount();i++) 
			{
				System.out.println(listaTrabajadoresTitulo.size());
				for(int a=0; a<listaTrabajadoresTitulo.size();a++) 
				{
					System.out.println((i+1)+":"+(a+1));
					Paragraph registroC = new Paragraph();
					registroC.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					registroC.setFont(FontFactory.getFont("Arial", 7));
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
