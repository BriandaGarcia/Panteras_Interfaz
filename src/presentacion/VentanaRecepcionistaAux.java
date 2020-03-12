package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class VentanaRecepcionistaAux extends JFrame implements ActionListener{

	private ControlPrincipal control;
	
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,aux;
	JLabel label1,img;
	JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public VentanaRecepcionistaAux(ControlPrincipal control) {
		super("Recepcionista");
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		this.control=control;
		
		setSize(300, 474);
		setLocationRelativeTo(null);
		
		img=new JLabel();
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/presentacion/recep.png"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		img.setIcon(icones);
		img.repaint();
		
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
		panel7=new JPanel();
		panel7.setBackground(Color.WHITE);
		aux=new JPanel();
		aux.setBackground(Color.WHITE);
		
		label1=new JLabel(dateFormat.format(fecha));
		label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		boton1=new JButton("        Agenda Cita       ");
		boton1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton1.setBackground(new Color(255, 204, 204));
		boton2=new JButton("     Confirmar Cita     ");
		boton2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton2.setBackground(new Color(255, 204, 204));
		
		boton3=new JButton("     Nuevo Paciente   ");		
		boton3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton3.setBackground(new Color(255, 204, 204));
		boton4=new JButton("   Solicitud Servicio   ");
		boton4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton4.setBackground(new Color(255, 204, 204));
		boton5=new JButton("    Verifica Pago    ");
		boton5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton5.setBackground(new Color(255, 204, 204));
		
		boton6=new JButton("  Agrega Empleado  ");
		boton6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton6.setBackground(new Color(255, 204, 204));
		boton7=new JButton("  Elimina Empleado  ");
		boton7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton7.setBackground(new Color(255, 204, 204));
		boton8=new JButton("Actualiza Empleado");
		boton8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton8.setBackground(new Color(255, 204, 204));
		
		boton9=new JButton("Reporte Financiero");
		boton9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton9.setBorder(new LineBorder(Color.RED, 1, true));
		boton9.setBackground(new Color(255, 204, 204));
		boton9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton9.setIcon(new ImageIcon(VentanaRecepcionista.class.getResource("/imagenes/citas.png")));
		boton9.setBounds(94, 165, 181, 61);
		
		boton10=new JButton("Regresar");
		boton10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton10.setBorder(new LineBorder(Color.RED, 1, true));
		boton10.setBackground(new Color(255, 204, 204));
		boton10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton10.setBounds(89, 11, 151, 23);
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton5.addActionListener(this);
		boton6.addActionListener(this);
		boton7.addActionListener(this);
		boton8.addActionListener(this);
		boton9.addActionListener(this);
		boton10.addActionListener(this);
		
		panel1.setLayout(new GridLayout(1,3));
		panel1.add(label1);
		panel1.add(aux);
		panel1.add(img);
		
		//Panel de citas
		panel2.setLayout(new GridLayout(2,1));
		panel2.add(boton1);
		panel2.add(boton2);
						
		//panel de pacientes
		panel3.setLayout(new GridLayout(3,1));
		panel3.add(boton3);
		panel3.add(boton4);
		panel3.add(boton5);
				
		//panel de empleados
		panel4.setLayout(new GridLayout(3,1));
		panel4.add(boton6);
		panel4.add(boton7);
		panel4.add(boton8);
				
		//panel de finanzas
		panel5.setLayout(new GridLayout(1,1));
		panel5.add(boton9);
		
		panel6.add(boton10);
		
		panel7.add(panel2);
		panel7.add(panel3);
		panel7.add(panel4);
		panel7.add(panel5);
		
		getContentPane().add(panel1,BorderLayout.NORTH);
		getContentPane().add(panel7,BorderLayout.CENTER);
		getContentPane().add(panel6,BorderLayout.SOUTH);
	}

	/*
	 *Acciones de los botones
	 */
	public void actionPerformed(ActionEvent e) {
		//Regresar
		if(e.getSource()==boton10) {
			cierra();
		}
		
		//Boton nuevo pacinete que se comunica con su respectivo control
		if(e.getSource()==boton3) {
			control.nuevo_paciente();
		}
		
		if(e.getSource()==boton4) {
			control.pagoServicio();
		}
		
		//Boton para verificacion de pago que se comunica con su respectivo control
		if(e.getSource()==boton5) {
			control.verificaPago();
		}
		
		//Boton nuevo empleado que se comunica con su respectivo control
		if (e.getSource()==boton6) {
			control.agrega_emplado();
		}
		
		//Boton elimina empleado que se comunica con su respectivo control
		if(e.getSource()==boton7) {
			control.eliminaEmpleado();
		}
		
		//Boton reporte financiero que se comunica con su respectivo control
		if(e.getSource()==boton9) {
			control.reporteFinanciero();
		}
		
		//Boton de confirmar citas que se comunica con su respectivo control
		if(e.getSource()==boton2) {
			control.confirmaCita();
		}
		
		//Boton de agendar citas que se comunica con su respectivo control
		if(e.getSource()==boton1) {
			control.agendaCita();
		}
	}
	
	public void abre(int i) {
		if(i == 1){
			panel7.add(panel2);
			panel7.add(panel3);
			panel7.add(panel4);
			panel7.add(panel5);
			
			panel7.remove(panel3);
			panel7.remove(panel4);
			panel7.remove(panel5);
		}
		if(i == 2){
			panel7.add(panel2);
			panel7.add(panel3);
			panel7.add(panel4);
			panel7.add(panel5);
			
			panel7.remove(panel2);
			panel7.remove(panel4);
			panel7.remove(panel5);
		}
		if(i == 3){
			panel7.add(panel2);
			panel7.add(panel3);
			panel7.add(panel4);
			panel7.add(panel5);
			
			panel7.remove(panel2);
			panel7.remove(panel3);
			panel7.remove(panel5);
		}
		if(i == 4){
			panel7.add(panel2);
			panel7.add(panel3);
			panel7.add(panel4);
			panel7.add(panel5);
			
			panel7.remove(panel2);
			panel7.remove(panel3);
			panel7.remove(panel4);
		}
		setVisible(true);
	}

	public void cierra() {
		setVisible(false);
	}
	
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
