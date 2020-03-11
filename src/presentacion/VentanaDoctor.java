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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Cursor;
	
public class VentanaDoctor extends JFrame implements ActionListener{
	
		private ControlPrincipal control;
	
		JPanel panel1, panel2, panel3;
		JLabel label1,img;
		JButton boton1,boton2,boton4, boton5,boton3;
		Date fecha=new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_1;
		private JLabel label_1;
		private JLabel lblNewLabel_2;
		

		public VentanaDoctor(ControlPrincipal control) throws HeadlessException {
			super("Doctor");
			this.control=control;
			
			setSize(381, 651);
			setLocationRelativeTo(null);
			panel2=new JPanel();
			panel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panel2.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
			panel2.setBackground(Color.WHITE);
			ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/doctores.png"));
			Image imagen=icon.getImage();
			ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
			
			boton1=new JButton("Historial M\u00E9dico");
			boton1.setBackground(new Color(255, 204, 204));
			boton1.setBorder(new LineBorder(Color.RED, 1, true));
			boton1.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/imagenes/historial.png")));
			boton1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			boton1.setBounds(62, 171, 255, 63);
			boton2=new JButton("Ex\u00E1men M\u00E9dico");
			boton2.setBorder(new LineBorder(Color.RED, 1, true));
			boton2.setBackground(new Color(255, 204, 204));
			boton2.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/imagenes/examen.png")));
			boton2.setFont(new Font("Times New Roman", Font.BOLD, 15));
			boton2.setBounds(62, 319, 255, 63);
			boton3=new JButton("Reporte M\u00E9dico");
			boton3.setBackground(new Color(255, 204, 204));
			boton3.setBorder(new LineBorder(Color.RED, 1, true));
			boton3.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/imagenes/reporte_med1.png")));
			boton3.setFont(new Font("Times New Roman", Font.BOLD, 15));
			boton3.setBounds(62, 245, 255, 63);
			boton4=new JButton("Pase de Especialidad");
			boton4.setBackground(new Color(255, 204, 204));
			boton4.setBorder(new LineBorder(Color.RED, 1, true));
			boton4.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/imagenes/pase.png")));
			boton4.setFont(new Font("Times New Roman", Font.BOLD, 15));
			boton4.setBounds(62, 403, 255, 63);
			
			boton1.addActionListener(this);
			boton2.addActionListener(this);
			boton3.addActionListener(this);
			boton4.addActionListener(this);
			panel2.setLayout(null);
			panel2.add(boton1);
			panel2.add(boton2);
			panel2.add(boton3);
			panel2.add(boton4);
			getContentPane().add(panel2,BorderLayout.CENTER);
			
			panel1=new JPanel();
			panel1.setBackground(Color.WHITE);
			panel1.setBounds(10, 11, 345, 122);
			panel2.add(panel1);
			panel1.setLayout(null);
			img=new JLabel();
			img.setBounds(10, 11, 94, 100);
			panel1.add(img);
			img.setIcon(icones);
			
			label1=new JLabel(dateFormat.format(fecha));
			label1.setBounds(209, 77, 107, 56);
			panel1.add(label1);
			label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblNewLabel = new JLabel("Fecha:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(133, 94, 78, 22);
			panel1.add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/imagenes/marco.png")));
			lblNewLabel_1.setBounds(114, 50, 127, 38);
			panel1.add(lblNewLabel_1);
			
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/imagenes/cruz_roja.jpg")));
			lblNewLabel_2.setBounds(251, 32, 65, 56);
			panel1.add(lblNewLabel_2);
					panel3=new JPanel();
					panel3.setBackground(Color.WHITE);
					panel3.setBounds(10, 492, 345, 52);
					panel2.add(panel3);
					panel3.setLayout(null);
					
							boton5=new JButton("Cerrar Sesi\u00F3n");
							boton5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							boton5.setBorder(new LineBorder(Color.RED, 1, true));
							boton5.setBackground(new Color(255, 204, 204));
							boton5.setFont(new Font("Times New Roman", Font.BOLD, 15));
							boton5.setBounds(95, 11, 179, 23);
							panel3.add(boton5);
							
							label_1 = new JLabel("");
							label_1.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/imagenes/marco.png")));
							label_1.setBounds(41, 544, 314, 57);
							panel2.add(label_1);
					boton5.addActionListener(this);
			img.repaint();



		
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==boton1) {
				control.busquedaPaciente();
			}
			if(e.getSource()==boton2) {
				control.generaExamenMedico();
			}
			/**
			 * Se conecta con el control principal, para que inicie el control del reporte de consulta
			 */
			if(e.getSource()==boton3) {
				control.reporteConsulta();
			}
			if(e.getSource()==boton4) {
				control.generaPase();
			}
			if(e.getSource()==boton5) {
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
