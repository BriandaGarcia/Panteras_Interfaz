package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class VentanaFarmaceuticaAux extends JFrame implements ActionListener{

	private ControlPrincipal control;
	
	JPanel panel2, panel3,panel4;
	JLabel label1,img;
	JButton boton1,boton2,boton3,boton4;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel label;
	private JLabel label_1;
	private JLabel lblFecha;
	private JLabel label_2;
	
	public VentanaFarmaceuticaAux(ControlPrincipal control) {
		super("Farmaceutica");
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		this.control=control;
		
		setSize(372, 484);
		setLocationRelativeTo(null);
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/farmaceutica.jpg"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		panel3=new JPanel();
		panel3.setBackground(Color.WHITE);
		getContentPane().add(panel3,BorderLayout.CENTER);
		panel2=new JPanel();
		panel2.setBounds(34, 137, 284, 126);
		panel2.setBackground(Color.WHITE);
		
		boton1=new JButton("Agregar Medicamento");
		boton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton1.setBorder(new LineBorder(Color.RED, 1, true));
		boton1.setBounds(34, 11, 218, 27);
		boton1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton1.setBackground(new Color(255, 204, 204));
		boton2=new JButton("Actualizar Medicamento");
		boton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton2.setBorder(new LineBorder(Color.RED, 1, true));
		boton2.setBounds(34, 87, 218, 27);
		boton2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton2.setBackground(new Color(255, 204, 204));
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		panel2.setLayout(null);
		panel2.add(boton1);
		boton3=new JButton("Eliminar Medicamento");
		boton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton3.setBorder(new LineBorder(Color.RED, 1, true));
		boton3.setBounds(34, 49, 218, 27);
		panel2.add(boton3);
		boton3.setBackground(new Color(255, 204, 204));
		boton3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton3.addActionListener(this);
		panel3.setLayout(null);
		panel2.add(boton2);
		
		panel3.add(panel2);
		panel4=new JPanel();
		panel4.setBounds(103, 274, 155, 110);
		panel3.add(panel4);
		panel4.setBackground(Color.WHITE);
		panel4.setLayout(null);
		
		boton4=new JButton("");
		boton4.setBounds(10, 11, 118, 88);
		panel4.add(boton4);
		boton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton4.setText("Regresar");	
				}
			@Override
			public void mouseExited(MouseEvent e) {
				boton4.setText("");
			}
		});
		boton4.setVerticalTextPosition(SwingConstants.BOTTOM);
		boton4.setVerticalAlignment(SwingConstants.BOTTOM);
		boton4.setIcon(new ImageIcon(VentanaFarmaceuticaAux.class.getResource("/imagenes/regresar_atras.png")));
		boton4.setHorizontalTextPosition(SwingConstants.CENTER);
		boton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton4.setContentAreaFilled(false);
		boton4.setBorderPainted(false);
		boton4.setBackground(new Color(255, 204, 204));
		boton4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton4.addActionListener(this);
		
		label1=new JLabel(dateFormat.format(fecha));
		label1.setBounds(220, 77, 98, 28);
		panel3.add(label1);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		img=new JLabel();
		img.setBounds(10, 4, 113, 100);
		panel3.add(img);
		img.setIcon(icones);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaFarmaceuticaAux.class.getResource("/imagenes/marco.png")));
		label.setBounds(113, 44, 129, 34);
		panel3.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaFarmaceuticaAux.class.getResource("/imagenes/cruz_roja.jpg")));
		label_1.setBounds(247, 11, 71, 73);
		panel3.add(label_1);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFecha.setBounds(155, 83, 55, 19);
		panel3.add(lblFecha);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(VentanaFarmaceuticaAux.class.getResource("/imagenes/marco.png")));
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_2.setBounds(29, 395, 300, 50);
		panel3.add(label_2);
		img.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			control.agregaMedicamento();
		}
		
		if(e.getSource()==boton2) {
			control.actualizaMedicamento();
		}
		
		if(e.getSource()==boton3) {
			
		}
		if(e.getSource()==boton4) {
			cierra();
		}
	}
	
	public void abre(int i) {
		if(i == 3){
			
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
