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
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaRecepcionistaAux extends JFrame implements ActionListener{

	private ControlPrincipal control;
	
	JPanel panel2,panel3,panel4,panel5,panel6,panel7,aux;
	JLabel label1,img;
	JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel label_1;
	
	public VentanaRecepcionistaAux(ControlPrincipal control) {
		super("Recepcionista");
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		this.control=control;
		
		setSize(351, 631);
		setLocationRelativeTo(null);
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/presentacion/recep.png"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		panel2=new JPanel();
		panel2.setBounds(32, 144, 262, 101);
		panel2.setBackground(Color.WHITE);
		panel7=new JPanel();
		panel7.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
		panel7.setBackground(Color.WHITE);
		
		boton1=new JButton("        Agenda Cita       ");
		boton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton1.setBorder(new LineBorder(Color.RED, 1, true));
		boton1.setBounds(28, 11, 184, 29);
		boton1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton1.setBackground(new Color(255, 204, 204));
		boton2=new JButton("     Confirmar Cita     ");
		boton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton2.setBorder(new LineBorder(Color.RED, 1, true));
		boton2.setBounds(28, 51, 184, 29);
		boton2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton2.setBackground(new Color(255, 204, 204));
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		panel7.setLayout(null);
		panel2.setLayout(null);
		panel2.add(boton1);
		panel2.add(boton2);
		
		panel7.add(panel2);
		panel3=new JPanel();
		panel3.setBounds(10, 123, 262, 138);
		panel2.add(panel3);
		panel3.setBackground(Color.WHITE);
		
		boton3=new JButton("Nuevo Paciente");
		boton3.setBounds(42, 0, 169, 27);
		boton3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton3.setBackground(new Color(255, 204, 204));
		boton4=new JButton("Solicitud Servicio");
		boton4.setBounds(42, 51, 169, 27);
		boton4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton4.setBackground(new Color(255, 204, 204));
		boton5=new JButton("    Verifica Pago    ");
		boton5.setBounds(42, 101, 169, 27);
		boton5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton5.setBackground(new Color(255, 204, 204));
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton5.addActionListener(this);
		panel3.setLayout(null);
		panel3.add(boton3);
		panel3.add(boton4);
		panel3.add(boton5);
		getContentPane().add(panel7,BorderLayout.CENTER);
		aux=new JPanel();
		aux.setBounds(10, 11, 308, 122);
		panel7.add(aux);
		aux.setBackground(Color.WHITE);
		aux.setLayout(null);
		
		img=new JLabel();
		img.setBounds(10, 0, 100, 100);
		aux.add(img);
		img.setIcon(icones);
		
		label1=new JLabel(dateFormat.format(fecha));
		label1.setBounds(202, 90, 93, 22);
		aux.add(label1);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaRecepcionistaAux.class.getResource("/imagenes/marco.png")));
		lblNewLabel.setBounds(97, 31, 126, 48);
		aux.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaRecepcionistaAux.class.getResource("/imagenes/cruz_roja.jpg")));
		label.setBounds(231, 11, 64, 68);
		aux.add(label);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFecha.setBounds(128, 94, 64, 15);
		aux.add(lblFecha);
		panel6=new JPanel();
		panel6.setBounds(32, 414, 262, 101);
		panel7.add(panel6);
		panel6.setBackground(Color.WHITE);
		panel6.setLayout(null);
		
		boton10=new JButton("");
		boton10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				boton10.setText("Regresar");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				boton10.setText("");
			}
		});
		boton10.setVerticalTextPosition(SwingConstants.BOTTOM);
		boton10.setVerticalAlignment(SwingConstants.BOTTOM);
		boton10.setHorizontalTextPosition(SwingConstants.CENTER);
		boton10.setContentAreaFilled(false);
		boton10.setBorderPainted(false);
		boton10.setIcon(new ImageIcon(VentanaRecepcionistaAux.class.getResource("/imagenes/regresar_atras.png")));
		boton10.setBounds(91, 11, 74, 79);
		panel6.add(boton10);
		boton10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton10.setBorder(new LineBorder(Color.RED, 1, true));
		boton10.setBackground(new Color(255, 204, 204));
		boton10.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		label_1 = new JLabel("");
		label_1.setBounds(34, 526, 284, 55);
		label_1.setIcon(new ImageIcon(VentanaRecepcionistaAux.class.getResource("/imagenes/marco.png")));
		panel7.add(label_1);
		panel4=new JPanel();
		panel4.setBounds(32, 278, 262, 81);
		panel7.add(panel4);
		panel4.setBackground(Color.WHITE);
		
		boton6=new JButton("  Agrega Empleado  ");
		boton6.setBounds(0, 0, 167, 27);
		boton6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton6.setBackground(new Color(255, 204, 204));
		boton7=new JButton("  Elimina Empleado  ");
		boton7.setBounds(0, 54, 167, 27);
		boton7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton7.setBackground(new Color(255, 204, 204));
		boton6.addActionListener(this);
		boton7.addActionListener(this);
		panel4.setLayout(null);
		panel4.add(boton6);
		boton8=new JButton("Actualiza Empleado");
		boton8.setBounds(0, 27, 167, 27);
		panel4.add(boton8);
		boton8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton8.setBackground(new Color(255, 204, 204));
		boton8.addActionListener(this);
		panel4.add(boton7);
		panel5=new JPanel();
		panel5.setBounds(32, 224, 262, 55);
		panel7.add(panel5);
		panel5.setBackground(Color.WHITE);
		panel5.setLayout(null);
		
		boton9=new JButton("Reporte Financiero");
		boton9.setHorizontalTextPosition(SwingConstants.CENTER);
		boton9.setBounds(10, 0, 152, 27);
		panel5.add(boton9);
		boton9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton9.setBorder(new LineBorder(Color.RED, 1, true));
		boton9.setBackground(new Color(255, 204, 204));
		boton9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton9.addActionListener(this);
		boton10.addActionListener(this);
		img.repaint();
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
