package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Cursor;

public class VentanaRecepcionista extends JFrame implements ActionListener{

	private ControlPrincipal control;
	
	
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,aux,panelif,panel7;
	JLabel label1,label3,label4,label5,img;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8;
	JCheckBox check1,check2;
	JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10,boton11,boton12,boton13,boton14,boton15,boton16,boton17;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	

	public VentanaRecepcionista(ControlPrincipal control) throws HeadlessException {
		super("Recepcionista");
		setBackground(Color.WHITE);
		this.control=control;
		
		setSize(383, 595);
		setLocationRelativeTo(null);
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/presentacion/recep.png"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel2.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
		panel2.setBackground(Color.WHITE);
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		panel7=new JPanel();
		
		boton15=new JButton(" Citas");
		boton15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton15.setBorder(new LineBorder(Color.RED, 1, true));
		boton15.setBackground(new Color(255, 204, 204));
		boton15.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton15.setIcon(new ImageIcon(VentanaRecepcionista.class.getResource("/imagenes/citas.png")));
		boton15.setBounds(94, 165, 181, 61);
		boton10=new JButton(" Pacientes");
		boton10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton10.setBorder(new LineBorder(Color.RED, 1, true));
		boton10.setBackground(new Color(255, 204, 204));
		boton10.setIcon(new ImageIcon(VentanaRecepcionista.class.getResource("/imagenes/paciente.png")));
		boton10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton10.setBounds(94, 241, 181, 61);
		boton11=new JButton(" Empleados");
		boton11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton11.setBorder(new LineBorder(Color.RED, 1, true));
		boton11.setBackground(new Color(255, 204, 204));
		boton11.setIcon(new ImageIcon(VentanaRecepcionista.class.getResource("/imagenes/empleados.jpg")));
		boton11.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton11.setBounds(94, 313, 181, 56);
		boton12=new JButton(" Finanzas");
		boton12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton12.setIcon(new ImageIcon(VentanaRecepcionista.class.getResource("/imagenes/finanzas.jpg")));
		boton12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton12.setBorder(new LineBorder(Color.RED, 1, true));
		boton12.setBackground(new Color(255, 204, 204));
		boton12.setBounds(94, 380, 181, 61);
		
		boton17=new JButton("        Agenda Cita       ");
		boton16=new JButton("     Confirmar Cita     ");
		
		boton1=new JButton("     Nuevo Paciente   ");		
		boton3=new JButton("   Solicitud Servicio   ");
		boton4=new JButton("    Verifica Pago    ");
		
		boton6=new JButton("  Agrega Empleado  ");
		boton7=new JButton("  Elimina Empleado  ");
		boton8=new JButton("Actualiza Empleado");
		
		boton9=new JButton("Reporte Financiero");
		boton13=new JButton("Regresar");
		
		boton1.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton6.addActionListener(this);
		boton7.addActionListener(this);
		boton8.addActionListener(this);
		boton9.addActionListener(this);
		boton10.addActionListener(this);
		boton11.addActionListener(this);
		boton12.addActionListener(this);
		boton13.addActionListener(this);
		boton15.addActionListener(this);
		boton16.addActionListener(this);
		boton17.addActionListener(this);

		panel1.setLayout(new GridLayout(1,3));
		panel2.setLayout(null);
		panel2.add(boton15);
		panel2.add(boton10);
		panel2.add(boton11);
		panel2.add(boton12);
		
		//Panel de citas
		panel7.setLayout(new FlowLayout());
		panel7.add(boton17);
		panel7.add(boton16);
				
		//panel de pacientes
		panel3.setLayout(new FlowLayout());
		panel3.add(boton4);
		panel3.add(boton1);
		panel3.add(boton3);
		
		//panel de empleados
		panel4.setLayout(new FlowLayout());
		panel4.add(boton6);
		panel4.add(boton7);
		panel4.add(boton8);
		
		//panel de finansas
		panel5.setLayout(new FlowLayout());
		panel5.add(boton9);
		
		getContentPane().add(panel1,BorderLayout.NORTH);
		getContentPane().add(panel2,BorderLayout.CENTER);
		aux=new JPanel();
		aux.setBackground(Color.WHITE);
		aux.setBounds(10, 16, 347, 117);
		panel2.add(aux);
		aux.setLayout(null);
		
		img=new JLabel();
		img.setBounds(10, 0, 100, 106);
		aux.add(img);
		img.setIcon(icones);
		
		label1=new JLabel(dateFormat.format(fecha));
		label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(189, 75, 108, 31);
		aux.add(label1);
		
		lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(102, 80, 91, 21);
		aux.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaRecepcionista.class.getResource("/imagenes/marco.png")));
		lblNewLabel_1.setBounds(92, 34, 127, 43);
		aux.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaRecepcionista.class.getResource("/imagenes/cruz_roja.jpg")));
		lblNewLabel_2.setBounds(229, 11, 67, 58);
		aux.add(lblNewLabel_2);
		panelif=new JPanel();
		panelif.setBackground(Color.WHITE);
		panelif.setBounds(22, 452, 335, 48);
		panel2.add(panelif);
		panelif.setLayout(null);
		boton14=new JButton("Cerrar Sesi\u00F3n");
		boton14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton14.setBorder(new LineBorder(Color.RED, 1, true));
		boton14.setBackground(new Color(255, 204, 204));
		boton14.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton14.setBounds(89, 11, 151, 23);
		panelif.add(boton14);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(VentanaRecepcionista.class.getResource("/imagenes/marco.png")));
		lblNewLabel_3.setBounds(45, 497, 288, 53);
		panel2.add(lblNewLabel_3);
		boton14.addActionListener(this);
		img.repaint();

	}

	/*
	 *Acciones de los botones
	 */
	public void actionPerformed(ActionEvent e) {
		
		//Opciones correspondientes a las citas
		if(e.getSource()==boton15) {
			panel3.setVisible(false);
			panel2.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
			panelif.setVisible(false);
					
			getContentPane().add(panel7,BorderLayout.CENTER);
			aux.add(boton13);
			getContentPane().add(aux,BorderLayout.SOUTH);
			panel7.setVisible(true);
			aux.setVisible(true);
		}	
		
		//Opciones correspondientes a los pacientes
		if(e.getSource()==boton10) {			
			panel2.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
			panelif.setVisible(false);
			
			getContentPane().add(panel3,BorderLayout.CENTER);
			aux.add(boton13);
			getContentPane().add(aux,BorderLayout.SOUTH);
			panel3.setVisible(true);
			aux.setVisible(true);
		}
		
		//Opciones correspondientes a los empleados
		if(e.getSource()==boton11) {	
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel5.setVisible(false);
			panelif.setVisible(false);
					
			getContentPane().add(panel4,BorderLayout.CENTER);
			aux.add(boton13);
			getContentPane().add(aux,BorderLayout.SOUTH);
			panel4.setVisible(true);
			aux.setVisible(true);			
		}
		
		//Opciones correspondientes a las finazas
		if(e.getSource()==boton12) {		
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(false);
			panelif.setVisible(false);
					
			getContentPane().add(panel5,BorderLayout.CENTER);
			aux.add(boton13);
			getContentPane().add(aux,BorderLayout.SOUTH);
			panel5.setVisible(true);
			aux.setVisible(true);		
		}
		
		//Regresar
		if(e.getSource()==boton13) {
			panel7.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
			aux.setVisible(false);
			
			panel2.setVisible(true);
			panelif.setVisible(true);
		}
		
		//Boton nuevo pacinete que se comunica con su respectivo control
		if(e.getSource()==boton1) {
			control.nuevo_paciente();
		}
		
		if(e.getSource()==boton3) {
			control.pagoServicio();
		}
		
		//Boton para verificacion de pago que se comunica con su respectivo control
		if(e.getSource()==boton4) {
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
		if(e.getSource()==boton16) {
			control.confirmaCita();
		}
		
		//Boton de agendar citas que se comunica con su respectivo control
		if(e.getSource()==boton17) {
			control.agendaCita();
		}
		
		//Boton para cerra sesion y regresar a la ventana de login
		if(e.getSource()==boton14) {
			setVisible(false);
			control.inicia();
		}

	}
	
	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		setVisible(false);
	}
	
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
