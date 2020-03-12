package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import negocio.dominio.Reporte;
import java.awt.Color;

/**
 * Ventana que despliega el reporte financiero generado
 * @author Brianda Garcia
 *
 */
public class VentanaMuestraReporte extends JFrame implements ActionListener{

	JPanel panel1,panel2,panel3,panel4,panel5;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8;
	JButton botonImprimir;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	int total=0;

	private ControlReporteFinanciero control=null;
	
	/**
	 * Constructor
	 * @param control su control
	 * @param reporte reporte a desplegar
	 * @param periodo periodo del reporte generado
	 * @param año 
	 * @throws HeadlessException
	 */
	public VentanaMuestraReporte(ControlReporteFinanciero control, ArrayList<Reporte> reporte, String mes, String año) throws HeadlessException {
		super("Reporte Generado");
		setBackground(Color.WHITE);
		this.control=control;
		setSize(400, 600);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel1.setBackground(Color.WHITE);
		panel2=new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(0, 0, 382, 142);
		panel3=new JPanel();
		panel3.setBounds(0, 157, 382, 157);
		panel4=new JPanel();
		panel4.setBackground(Color.WHITE);
		panel5=new JPanel();
		panel5.setBackground(Color.WHITE);
		
		label8=new JLabel(dateFormat.format(fecha));
		label8.setBounds(22, 0, 360, 39);
		label8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label1=new JLabel("Informe Cruz Roja");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		if(mes.equals("")) {
			label2=new JLabel("Periodo:  "+año);
		}
		else {
			label2=new JLabel("Periodo:  "+mes+"/"+año);
		}
		label2.setFont(new Font("Arial Black", Font.BOLD, 15));
		label3=new JLabel("Numero de acciones:  "+reporte.size());
		label3.setBounds(22, 39, 360, 39);
		label3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label4=new JLabel("Servicios:");
		label4.setBounds(22, 78, 360, 39);
		label4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label6=new JLabel("Tipo");
		label6.setBackground(Color.WHITE);
		label6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label7=new JLabel("Costo");
		label7.setBackground(Color.WHITE);
		label7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		botonImprimir=new JButton("Imprimir");
		botonImprimir.setFont(new Font("Times New Roman", Font.BOLD, 15));
		botonImprimir.setBackground(new Color(255, 204, 204));
	
		botonImprimir.addActionListener(this);
		
		panel1.add(label1);
		panel2.setLayout(null);
		panel2.add(label8);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		
		panel3.setLayout(new GridLayout(reporte.size()+1,2));
		panel3.add(label6);
		panel3.add(label7);
		//Despliega el reporte financiero
		for(int i=0;i<reporte.size();i++) {
			panel3.add(new JLabel(""+reporte.get(i).getServicio()));
			panel3.add(new JLabel(""+reporte.get(i).getTotal()));
			total=total+reporte.get(i).getTotal();
		}
		label5=new JLabel("Total:  $"+total+".00 M/N");
		label5.setBounds(22, 314, 359, 157);
		label5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel4.setLayout(null);
		panel4.add(panel2);
		panel4.add(panel3);
		panel4.add(label5);
		
		panel5.add(botonImprimir);
		
		getContentPane().add(panel1,BorderLayout.NORTH);
		getContentPane().add(panel4,BorderLayout.CENTER);
		getContentPane().add(panel5,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonImprimir) {
			muestraMensaje();
			cierra();
		}
	}

	/**
	 * Muestra la ventana
	 */
	public void abre() {
		setVisible(true);
	}
	
	/**
	 * Muestra un mensaje
	 * @param mensaje el mensaje a mostrar
	 */
	public void muestraMensaje() {
		JOptionPane.showConfirmDialog(null,"imprimiendo","Imprimir",2);
	}

	/**
	 * Cierra la ventana
	 */
	public void cierra() {
		setVisible(false);
	}
}