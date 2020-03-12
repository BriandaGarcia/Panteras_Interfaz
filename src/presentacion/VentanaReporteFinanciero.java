package presentacion;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * Ventana para la generacion del reporte financiero
 * @author Brianda Garcia
 *
 */
public class VentanaReporteFinanciero extends JFrame implements ActionListener {

	JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	JLabel label1,label2;
	JButton botonGenerar,botonCancelar,botonAño,botonMes,botonRegresar;
	Choice listaMes,listaAño;

	private ControlReporteFinanciero control=null;
	
	String seleccionMes,seleccionAño,periodo;
	
	/**
	 * Constructor
	 * @param control su control
	 */
	public VentanaReporteFinanciero(ControlReporteFinanciero control) throws HeadlessException{
		super("Reporte Financiero");
		this.control=control;
		setSize(450, 215);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel1.setBackground(Color.WHITE);
		panel2=new JPanel();
		panel2.setBackground(Color.WHITE);
		panel3=new JPanel();
		panel3.setBackground(Color.WHITE);
		panel4=new JPanel();
		panel4.setBackground(Color.WHITE);
		panel5=new JPanel();
		panel5.setBackground(Color.WHITE);
		panel6=new JPanel();
		panel6.setBackground(Color.WHITE);
		
		label1=new JLabel("Selecciona el tipo de reporte: ");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label2=new JLabel("Selecciona el periodo: ");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		listaMes=new Choice();
		listaAño=new Choice();
		listaMes.addItem("");
		listaMes.addItem("01");
		listaMes.addItem("02");
		listaMes.addItem("03");
		listaMes.addItem("04");
		listaMes.addItem("05");
		listaMes.addItem("06");
		listaMes.addItem("07");
		listaMes.addItem("08");
		listaMes.addItem("09");
		listaMes.addItem("10");
		listaMes.addItem("11");
		listaMes.addItem("12");
		listaAño.addItem("2019");
		listaAño.addItem("2020");
		listaMes.setFont(new Font("Times New Roman", Font.BOLD, 15));
		listaAño.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		botonAño=new JButton("Anual");
		botonAño.setFont(new Font("Times New Roman", Font.BOLD, 15));
		botonAño.setBackground(new Color(255, 204, 204));
		botonAño.setBounds(69, 13, 291, 27);
		botonMes=new JButton("Mensual");
		botonMes.setFont(new Font("Times New Roman", Font.BOLD, 15));
		botonMes.setBackground(new Color(255, 204, 204));
		botonMes.setBounds(69, 54, 291, 27);
		botonGenerar=new JButton("Generar");
		botonGenerar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		botonGenerar.setBackground(new Color(255, 204, 204));
		botonCancelar=new JButton("Cancelar");
		botonCancelar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		botonCancelar.setBackground(new Color(255, 204, 204));
		botonRegresar=new JButton("Cancelar");
		botonRegresar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		botonRegresar.setBackground(new Color(255, 204, 204));
		
		botonAño.addActionListener(this);
		botonMes.addActionListener(this);
		botonGenerar.addActionListener(this);
		botonCancelar.addActionListener(this);
		botonRegresar.addActionListener(this);

		panel1.add(label1);
		panel2.setLayout(null);
		panel2.add(botonAño);
		panel2.add(botonMes);

		panel3.add(botonRegresar);
		
		panel4.add(label2);
		
		panel5.setLayout(new GridLayout(1,2));
		panel5.add(listaAño);
		
		panel6.setLayout(new GridLayout(1,2));
		panel6.add(botonCancelar);
		panel6.add(botonGenerar);
		
		getContentPane().add(panel1,BorderLayout.NORTH);
		getContentPane().add(panel2,BorderLayout.CENTER);
		getContentPane().add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonRegresar) {
			setVisible(false);
		}
		if(e.getSource()==botonCancelar) {
			panel4.setVisible(false);
			panel5.setVisible(false);
			panel6.setVisible(false);
			
			panel1.setVisible(true);
			panel2.setVisible(true);
			panel3.setVisible(true);
			
			getContentPane().add(panel1,BorderLayout.NORTH);
			getContentPane().add(panel2,BorderLayout.CENTER);
			getContentPane().add(panel3,BorderLayout.SOUTH);
		}
		if(e.getSource()==botonAño) {
			panel5.remove(listaMes);
			seleccionMes="";
			
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(false);
			
			panel4.setVisible(true);
			panel5.setVisible(true);
			panel6.setVisible(true);
			
			getContentPane().add(panel4,BorderLayout.NORTH);
			getContentPane().add(panel5,BorderLayout.CENTER);
			getContentPane().add(panel6,BorderLayout.SOUTH);
		}
		if(e.getSource()==botonMes) {
			panel5.add(listaMes);
			seleccionMes="01";
			
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(false);
			
			panel4.setVisible(true);
			panel5.setVisible(true);
			panel6.setVisible(true);
			
			getContentPane().add(panel4,BorderLayout.NORTH);
			getContentPane().add(panel5,BorderLayout.CENTER);
			getContentPane().add(panel6,BorderLayout.SOUTH);
		}
		if(e.getSource()==botonGenerar) {
			//Obtiene el periodo seleccionado
			if(seleccionMes.equals("")) {
				seleccionAño=listaAño.getSelectedItem(); 
			}
			else {
				seleccionAño=listaAño.getSelectedItem(); 
				seleccionMes=listaMes.getSelectedItem();
			}
			control.consultaServicio(seleccionMes,seleccionAño);
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
	public void muestraMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		control.inicia();
	}

	/**
	 * Cierra la ventana
	 */
	public void cierra() {
		setVisible(false);
	}
}