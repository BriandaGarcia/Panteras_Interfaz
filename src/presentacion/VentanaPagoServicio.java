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

import negocio.dominio.Pago;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Ventana para la generación de la solicitud de servicio
 * @author Franco Torres Isabel Estephanea
 *
 */
public class VentanaPagoServicio extends JFrame implements ActionListener {

	JPanel panel2;
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField text1,text2,text3,text4;
	JButton botonGuardar,botonCancelar;
	Choice listaServicio;
	String fech, paciente,servicio,cantidad;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private ControlSolicitudServicio control=null;
	private	ArrayList <Pago> servicios= new ArrayList<>();
	private JLabel label;
	/**
	 * Constructor de el control de solicitud de servicio
	 * @param arrayList 
	 * @param 
	 */
	public VentanaPagoServicio(ControlSolicitudServicio control, ArrayList<Pago> arrayList) throws HeadlessException {
		
		super("Solicitud de Servicio");
		this.control=control;
		setSize(523, 397);
		setLocationRelativeTo(null);
		servicios = arrayList;
		panel2=new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBorder(new LineBorder(SystemColor.activeCaption, 4, true));
		label3=new JLabel("Fecha : ");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label3.setBounds(144, 83, 64, 31);
		label4=new JLabel("ID Paciente : ");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label4.setBounds(104, 125, 104, 31);
		label5=new JLabel("Tipo de Servicio : ");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label5.setBounds(67, 167, 126, 31);
		label6=new JLabel("Costo : ");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label6.setBounds(136, 218, 57, 31);
		
		text1=new JTextField(dateFormat.format(fecha));
		text1.setBorder(new LineBorder(Color.RED, 1, true));
		text1.setHorizontalAlignment(SwingConstants.LEFT);
		text1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text1.setBounds(231, 88, 165, 20);
		text2=new JTextField(30);		
		text3=new JTextField(30);		
		text3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text3.setBorder(new LineBorder(Color.RED, 1, true));
		text3.setBounds(231, 134, 165, 20);
		text4=new JTextField(250);
		text4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text4.setBorder(new LineBorder(Color.RED, 1, true));
		text4.setBounds(231, 224, 165, 20);
		
		listaServicio=new Choice();
		listaServicio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		listaServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listaServicio.setBounds(231, 170, 165, 20);
		for (int i=0; i<servicios.size(); i++) {
			listaServicio.addItem(" "+servicios.get(i).getServicio()+"  -  $"+servicios.get(i).getCantidad());
		
		}
		panel2.setLayout(null);
		panel2.add(label3);
		panel2.add(text1);
		panel2.add(label4);
		panel2.add(text3);
		panel2.add(label5);
		panel2.add(listaServicio);
		panel2.add(label6);
		panel2.add(text4);
		getContentPane().add(panel2,BorderLayout.CENTER);
		botonCancelar=new JButton("");
		botonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonCancelar.setText("Regresar");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonCancelar.setText("");
			}
		});
		botonCancelar.setBorderPainted(false);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonCancelar.setIcon(new ImageIcon(VentanaPagoServicio.class.getResource("/imagenes/regresar_atras.png")));
		botonCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCancelar.setBounds(392, 261, 88, 79);
		panel2.add(botonCancelar);
		botonGuardar=new JButton("");
		botonGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonGuardar.setText("Imprimir");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonGuardar.setText("");
			}
		});
		botonGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonGuardar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonGuardar.setIcon(new ImageIcon(VentanaPagoServicio.class.getResource("/imagenes/imprimir.png")));
		botonGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.setBorderPainted(false);
		botonGuardar.setBounds(21, 261, 94, 79);
		panel2.add(botonGuardar);
		
		label1=new JLabel("Solicitud de Servicio");
		label1.setBounds(162, 11, 192, 27);
		panel2.add(label1);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaPagoServicio.class.getResource("/imagenes/marco.png")));
		label.setBounds(112, 276, 270, 51);
		panel2.add(label);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		
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
		if(e.getSource()==botonGuardar) {
			fech=text1.getText();
			//doctor=text2.getText();
			paciente=text3.getText();
			servicio=text4.getText();
			cantidad=listaServicio.getSelectedItem();
			control.solicitudServicio(servicio,cantidad);
		}
	}

	/**
	 * Hace visible la ventana 
	 * @param arrayList 
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
