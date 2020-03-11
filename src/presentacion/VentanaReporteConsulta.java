package presentacion;

import java.awt.BorderLayout;
import java.awt.Choice;
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
import javax.swing.JTextField;

import negocio.dominio.Ficha_medica;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

/**
 * Ventana para la generación de reporte de consulta
 * @author Brianda Garcia
 *
 */
public class VentanaReporteConsulta extends JFrame implements ActionListener {

	JPanel panel1,panel2,panel3;
	JLabel label1,label2,label3,label4,label5,label6,label7;
	JTextField text1,text2,text3,text4;
	JButton botonAceptar,botonCancelar,botonComprobar;
	Choice listaServicio,listaHora;
	String fech,doctor,paciente,servicio,descripcion,hora;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private ControlReporteConsulta control=null;
	
	/**
	 * Constructor
	 * @param control El control del reporte de consulta 
	 */
	public VentanaReporteConsulta(ControlReporteConsulta control) throws HeadlessException {
		
		super("Reporte de Consulta");
		this.control=control;
		setSize(355, 633);
		setLocationRelativeTo(null);
		panel2=new JPanel();
		panel2.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
		panel2.setBackground(Color.WHITE);
		label2=new JLabel("Fecha : ");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(74, 68, 61, 38);
		label7=new JLabel("Hora : ");
		label7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setBounds(78, 119, 57, 20);
		label3=new JLabel("Id Doctor (a) : ");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(31, 195, 97, 38);
		label4=new JLabel("Id Paciente : ");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setBounds(33, 164, 102, 20);
		label5=new JLabel("Tipo de Servicio : ");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label5.setBounds(10, 244, 129, 44);
		label6=new JLabel("Descripción : ");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label6.setBounds(33, 286, 102, 31);
		
		text1=new JTextField(dateFormat.format(fecha));
		text1.setBorder(new LineBorder(Color.RED, 1, true));
		text1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text1.setBounds(159, 77, 152, 20);
		text2=new JTextField(30);		
		text2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text2.setBorder(new LineBorder(Color.RED, 1, true));
		text2.setBounds(159, 204, 152, 20);
		text3=new JTextField(30);		
		text3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text3.setBorder(new LineBorder(Color.RED, 1, true));
		text3.setBounds(159, 164, 152, 20);
		text4=new JTextField(250);
		text4.setBorder(new LineBorder(Color.RED, 1, true));
		text4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text4.setBounds(33, 316, 278, 76);
		
		listaServicio=new Choice();
		listaServicio.setForeground(SystemColor.desktop);
		listaServicio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		listaServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listaServicio.setBounds(159, 258, 152, 24);
		listaServicio.addItem("Consulta General");
		listaServicio.addItem("Inyecion");
		listaServicio.addItem("Ortopedista");
		listaServicio.addItem("Cardiologia");
		listaServicio.addItem("Traumatología");
		listaServicio.addItem("Oftalmología");
		listaServicio.addItem("Podologia");
		
		listaHora=new Choice();
		listaHora.setForeground(SystemColor.desktop);
		listaHora.setFont(new Font("Times New Roman", Font.BOLD, 15));
		listaHora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listaHora.setBounds(159, 119, 152, 24);
		listaHora.addItem("");
		panel2.setLayout(null);
		panel2.add(label2);
		panel2.add(text1);
		panel2.add(label7);
		panel2.add(listaHora);
		panel2.add(label4);
		panel2.add(text3);
		panel2.add(label3);
		panel2.add(text2);
		panel2.add(label5);
		panel2.add(listaServicio);
		panel2.add(label6);
		panel2.add(text4);
		getContentPane().add(panel2,BorderLayout.CENTER);
		panel3=new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setBounds(10, 394, 325, 117);
		panel2.add(panel3);
		panel3.setLayout(null);
		botonCancelar=new JButton("");
		botonCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonCancelar.setBorderPainted(false);
		botonCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				botonCancelar.setText("Regresar");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonCancelar.setText("");
			}
		});
		botonCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.setIcon(new ImageIcon(VentanaReporteConsulta.class.getResource("/imagenes/regresar_atras.png")));
		botonCancelar.setBounds(212, 11, 103, 75);
		panel3.add(botonCancelar);
		
		botonAceptar=new JButton("");
		botonAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAceptar.setBorderPainted(false);
		botonAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonAceptar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonAceptar.setText("Aceptar");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonAceptar.setText("");
			}
		});
		botonAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonAceptar.setContentAreaFilled(false);
		botonAceptar.setIcon(new ImageIcon(VentanaReporteConsulta.class.getResource("/imagenes/aceptar.jpg")));
		botonAceptar.setBounds(137, 11, 83, 75);
		panel3.add(botonAceptar);
		botonComprobar=new JButton("Comprobar");
		botonComprobar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonComprobar.setBackground(new Color(255, 204, 204));
		botonComprobar.setBorder(new LineBorder(Color.RED));
		botonComprobar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		botonComprobar.setBounds(0, 52, 127, 23);
		panel3.add(botonComprobar);
		botonComprobar.addActionListener(this);
		
		botonAceptar.addActionListener(this);
		botonCancelar.addActionListener(this);
				
				panel1=new JPanel();
				panel1.setBackground(Color.WHITE);
				panel1.setBounds(10, 11, 301, 34);
				panel2.add(panel1);
				panel1.setLayout(null);
				
				label1=new JLabel("Reporte de Consulta");
				label1.setBounds(71, 0, 192, 27);
				panel1.add(label1);
				label1.setFont(new Font("Times New Roman", Font.BOLD, 22));
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(VentanaReporteConsulta.class.getResource("/imagenes/marco.png")));
				lblNewLabel.setBounds(23, 534, 278, 49);
				panel2.add(lblNewLabel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Hace invisible la ventana
		 */
		if(e.getSource()==botonCancelar) {
			setVisible(false);
		}
		/**
		 *Hace la comunicacion con el control, mandandole los parametros
		 */
		if(e.getSource()==botonAceptar) {
			fech=text1.getText();
			hora=listaHora.getSelectedItem();
			doctor=text2.getText();
			paciente=text3.getText();
			servicio=listaServicio.getSelectedItem();
			descripcion=text4.getText();
			
			control.guardaReporteConsulta(fech,hora,doctor,paciente,servicio,descripcion);
		}
		/**
		 * Recupera las horas de la cita del paciente en la fecha establecida
		 */
		if(e.getSource()==botonComprobar) {
			ArrayList<Ficha_medica> horas = new ArrayList<Ficha_medica>();
			horas=control.recuperaHoras(text1.getText(),text3.getText());
			if(horas!=null) {
				for(int i=0; i<horas.size();i++) {
					listaHora.addItem(horas.get(i).getHora());
				}
			}
			abre();
		}
	}

	/**
	 * Hace visible la ventana 
	 */
	public void abre() {
		setVisible(true);
	}
		
	/**
	 * Cierra la ventana
	 */
	public void cierra() {
		setVisible(false);
	}
	
	/**
	 * Muestra un mensaje
	 * @param mensaje el mensaje a mostrar
	 */
	public void muestraMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}