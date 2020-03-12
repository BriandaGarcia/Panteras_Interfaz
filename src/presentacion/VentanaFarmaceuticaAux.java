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

public class VentanaFarmaceuticaAux extends JFrame implements ActionListener{

	private ControlPrincipal control;
	
	JPanel panel1, panel2, panel3,panel4;
	JLabel label1,img;
	JButton boton1,boton2,boton3,boton4;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public VentanaFarmaceuticaAux(ControlPrincipal control) {
		super("Farmaceutica");
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		this.control=control;
		
		setSize(300, 474);
		setLocationRelativeTo(null);
		
		img=new JLabel();
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/farmaceutica.jpg"));
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
		
		label1=new JLabel(dateFormat.format(fecha));
		label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		boton1=new JButton("Agregar Medicamento");
		boton1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton1.setBackground(new Color(255, 204, 204));
		boton2=new JButton("Actualizar Medicamento");
		boton2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		boton2.setBackground(new Color(255, 204, 204));
		boton3=new JButton("Eliminar Medicamento");
		boton3.setBackground(new Color(255, 204, 204));
		boton3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		boton4=new JButton("Regresar");
		boton4.setBackground(new Color(255, 204, 204));
		boton4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		
		panel1.setLayout(new GridLayout(1,3));
		panel1.add(label1);
		panel1.add(img);
		
		//panel de Inventario
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(boton1);
		panel2.add(boton2);
		panel2.add(boton3);
		
		panel3.add(panel2);
		
		panel4.add(boton4);
			
		getContentPane().add(panel1,BorderLayout.NORTH);
		getContentPane().add(panel3,BorderLayout.CENTER);
		getContentPane().add(panel4,BorderLayout.SOUTH);
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
