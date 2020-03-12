package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.SystemColor;

public class VentanaFarmaceutica extends JFrame implements ActionListener {
	
	private ControlPrincipal control;
	
	JPanel panel1, panel2, panel3;
	JLabel label1,img,label_2;
	JButton boton1,boton2,boton3,boton4;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public VentanaFarmaceutica(ControlPrincipal control) throws HeadlessException {
		super("Farmaceutica");
		this.control=control;
		
		setSize(358, 595);
		setLocationRelativeTo(null);
		panel2=new JPanel();
		panel2.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
		panel2.setBackground(Color.WHITE);
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/farmaceutica.jpg"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		
		boton1=new JButton("Orden de Pago");
		boton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton1.setBounds(93, 162, 168, 65);
		boton1.setIcon(new ImageIcon(VentanaFarmaceutica.class.getResource("/imagenes/ticket.png")));
		boton1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton1.setBorder(new LineBorder(Color.RED, 1, true));
		boton1.setBackground(new Color(255, 204, 204));
		boton2=new JButton("Cat\u00E1logo");
		boton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton2.setBounds(93, 266, 168, 63);
		boton2.setIcon(new ImageIcon(VentanaFarmaceutica.class.getResource("/imagenes/catalogo.png")));
		boton2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton2.setBorder(new LineBorder(Color.RED, 1, true));
		boton2.setBackground(new Color(255, 204, 204));
		boton3=new JButton("Inventario");
		boton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton3.setBounds(93, 360, 168, 65);
		boton3.setIcon(new ImageIcon(VentanaFarmaceutica.class.getResource("/imagenes/inventario.png")));
		boton3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton3.setBorder(new LineBorder(Color.RED, 1, true));
		boton3.setBackground(new Color(255, 204, 204));
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		
		panel2.setLayout(null);
		panel2.add(boton1);
		panel2.add(boton2);
		panel2.add(boton3);

		getContentPane().add(panel2,BorderLayout.CENTER);
		
		panel1=new JPanel();
		panel1.setBounds(10, 11, 324, 124);
		panel1.setBackground(Color.WHITE);
		panel2.add(panel1);
		panel1.setLayout(null);
		img=new JLabel();
		img.setBounds(21, 21, 78, 68);
		panel1.add(img);
		img.setIcon(new ImageIcon(VentanaFarmaceutica.class.getResource("/imagenes/farmaceutica.jpg")));
		
		label1=new JLabel(dateFormat.format(fecha));
		label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label1.setBounds(230, 86, 96, 27);
		panel1.add(label1);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFecha.setBounds(142, 86, 78, 27);
		panel1.add(lblFecha);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaFarmaceutica.class.getResource("/imagenes/marco.png")));
		label.setBounds(113, 47, 130, 42);
		panel1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaFarmaceutica.class.getResource("/imagenes/cruz_roja.jpg")));
		label_1.setBounds(253, 21, 78, 58);
		panel1.add(label_1);
		panel3=new JPanel();
		panel3.setBounds(54, 453, 203, 41);
		panel2.add(panel3);
		panel3.setBackground(Color.WHITE);
		panel3.setLayout(null);
		
		boton4=new JButton("Cerrar Sesi\u00F3n");
		boton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton4.setBounds(44, 11, 138, 21);
		panel3.add(boton4);
		boton4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton4.setBorder(new LineBorder(Color.RED, 1, true));
		boton4.setBackground(new Color(255, 204, 204));
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(VentanaFarmaceutica.class.getResource("/imagenes/marco.png")));
		label_2.setBounds(25, 503, 275, 42);
		panel2.add(label_2);
		boton4.addActionListener(this);
		img.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			control.pagoFarmacia();
		}
		
		if(e.getSource()==boton2) {
			control.busquedaMedicamento();
		}
		
		//Opciones correspondientes al inventario
		if(e.getSource()==boton3) {
			control.ventanaFarmaAux(3);
		}
		
		if(e.getSource()==boton4) {
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