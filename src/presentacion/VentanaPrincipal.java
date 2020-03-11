package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	private ControlPrincipal control;
	JPanel panel2;
	JLabel label1, label2, label3, img;
	JTextField text1,text2;
	JButton botonInicia, botonLimpia, botonSalir;
	Choice lista;
	JPasswordField pasw;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel label;
	

	public VentanaPrincipal(ControlPrincipal control) throws HeadlessException {
		super("Login");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(Color.PINK);
		this.control=control;
		
		setSize(535,452);
		setLocationRelativeTo(null);
		ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/login.png"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		panel2=new JPanel();
		panel2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel2.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
		panel2.setBackground(Color.WHITE);
		label2=new JLabel("Usuario");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(182, 155, 77, 34);
		label3=new JLabel("Contraseña");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(167, 209, 92, 49);
		
		text1=new JTextField(50);
		text1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text1.setBorder(new LineBorder(Color.RED));
		text1.setBounds(288, 155, 192, 28);
		pasw=new JPasswordField(50);
		pasw.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pasw.setBorder(new LineBorder(Color.RED));
		pasw.setBounds(288, 220, 192, 28);
		
		lista = new Choice();
		lista.add("Doctor");
		lista.add("Recepcionista");
		panel2.setLayout(null);
		panel2.add(label2);
		panel2.add(text1);
		panel2.add(label3);
		panel2.add(pasw);
		getContentPane().add(panel2,BorderLayout.CENTER);
				
				img=new JLabel();
				img.setBorder(null);
				img.setBounds(57, 158, 100, 100);
				panel2.add(img);
				img.setIcon(icones);
				
				
				label1=new JLabel(dateFormat.format(fecha));
				label1.setBounds(372, 89, 130, 34);
				panel2.add(label1);
				label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
				label1.setHorizontalAlignment(SwingConstants.CENTER);
				botonLimpia=new JButton("Limpiar");
				botonLimpia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				botonLimpia.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
				botonLimpia.setBackground(new Color(255, 204, 204));
				botonLimpia.setFont(new Font("Times New Roman", Font.BOLD, 15));
				botonLimpia.setBounds(40, 310, 100, 23);
				panel2.add(botonLimpia);
				
						botonInicia=new JButton("Iniciar Sesi\u00F3n");
						botonInicia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						botonInicia.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
						botonInicia.setBackground(new Color(255, 204, 204));
						botonInicia.setFont(new Font("Times New Roman", Font.BOLD, 15));
						botonInicia.setBounds(192, 310, 153, 23);
						panel2.add(botonInicia);
						botonSalir=new JButton("Salir");
						botonSalir.setForeground(Color.BLACK);
						botonSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						botonSalir.setBorder(new LineBorder(Color.RED, 1, true));
						botonSalir.setBackground(new Color(255, 204, 204));
						botonSalir.setFont(new Font("Times New Roman", Font.BOLD, 15));
						botonSalir.setBounds(388, 311, 92, 23);
						panel2.add(botonSalir);
						
						lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/encabezado.png")));
						lblNewLabel.setDoubleBuffered(true);
						lblNewLabel.setBounds(25, 19, 115, 79);
						panel2.add(lblNewLabel);
						
						lblNewLabel_1 = new JLabel("Sistema Administrativo\r\n");
						lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_1.setBounds(115, 11, 285, 49);
						panel2.add(lblNewLabel_1);
						
						lblNewLabel_2 = new JLabel("Cruz Roja");
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_2.setHorizontalTextPosition(SwingConstants.LEADING);
						lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
						lblNewLabel_2.setBounds(182, 56, 153, 26);
						panel2.add(lblNewLabel_2);
						
						lblNewLabel_3 = new JLabel("Fecha:");
						lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
						lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_3.setBounds(304, 95, 85, 22);
						panel2.add(lblNewLabel_3);
						
						lblNewLabel_4 = new JLabel("");
						lblNewLabel_4.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/encabezado (2).png")));
						lblNewLabel_4.setBounds(378, 19, 112, 79);
						panel2.add(lblNewLabel_4);
						
						lblNewLabel_5 = new JLabel("");
						lblNewLabel_5.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/marco.png")));
						lblNewLabel_5.setBounds(10, 353, 268, 49);
						panel2.add(lblNewLabel_5);
						
						label = new JLabel("");
						label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/marco.png")));
						label.setBounds(277, 353, 225, 49);
						panel2.add(label);
						botonSalir.addActionListener(this);
						
						botonInicia.addActionListener(this);
				botonLimpia.addActionListener(this);
				img.repaint();
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Boton para inicar la sesión
		if(e.getSource()==botonInicia) {
			//Valida que no alla campos vacios
			if (text1.getText().equals("")||pasw.getPassword().equals("")) {
				JOptionPane.showMessageDialog(this,"Tienes Campos Vacios" );
			}
			else {
				//Se comunica con el respectivo control y verifica de quien se trata un doctor o recepcionista
				String pass=new String(pasw.getPassword());
				String opt=control.login(text1.getText(),pass);
				System.out.println(opt);
				
				if(opt.equals("Doctor")) {
					setVisible(false);
					control.ventanaDoc();
				}
			
				if(opt.equals("Recepcionista")) {
					setVisible(false);
					control.ventanaRec();
				}
				
				if(opt.equals("Farmaceutica")) {
					setVisible(false);
					control.ventanaFarma();
				}
				
				//En caso de ingresar valores no validos se mostrata un mensaje de error
				if(opt.equals("ninguno"))
					JOptionPane.showMessageDialog(this,"Datos Invalidos");
				}
			
			}
		if(e.getSource()==botonLimpia) {
			text1.setText("");
			pasw.setText("");
		}
		if(e.getSource()==botonSalir) {
			control.termina();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(false);
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
