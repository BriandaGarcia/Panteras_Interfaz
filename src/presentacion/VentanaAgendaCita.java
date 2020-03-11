package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Cursor;


public class VentanaAgendaCita extends JFrame implements ActionListener {

	JPanel panel1,panel2,panel3;
	JLabel label1,label2,label3,label3_1,label4,label5,label6;
	JTextField pago,paciente,doctor,fecha,hora;
	JButton disponibilidad,cancelar,guardar,limpiar;
	String idpago,iddoctor,fech,idpaciente,h;
	int idp;
	
	private ControlAgendaCita control=null;
	private JLabel lblNewLabel;
	
	public VentanaAgendaCita(ControlAgendaCita control) throws HeadlessException {
		super("Cita");
		this.control=control;
		setSize(500, 481);
		setLocationRelativeTo(null);
		panel2=new JPanel();
		panel2.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
		panel2.setBackground(Color.WHITE);
		
		label2=new JLabel("ID Pago:");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label2.setBounds(97, 60, 84, 24);
		label3=new JLabel("ID Paciente:");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label3.setBounds(81, 95, 110, 24);
		label4=new JLabel("ID Doctor:");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label4.setBounds(91, 130, 84, 24);
		label5=new JLabel("Fecha de Cita:");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label5.setBounds(63, 165, 101, 24);
		label6=new JLabel("Hora de cita:");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label6.setBounds(70, 200, 111, 24);
				
		pago=new JTextField(25);		
		pago.setBorder(new LineBorder(Color.RED, 1, true));
		pago.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pago.setBounds(222, 60, 127, 24);
		paciente=new JTextField(25);
		paciente.setBorder(new LineBorder(Color.RED, 1, true));
		paciente.setFont(new Font("Times New Roman", Font.BOLD, 15));
		paciente.setBounds(222, 95, 127, 24);
		doctor=new JTextField(25);	
		doctor.setBorder(new LineBorder(Color.RED, 1, true));
		doctor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		doctor.setBounds(222, 130, 129, 24);
		fecha=new JTextField(30);
		fecha.setBorder(new LineBorder(Color.RED, 1, true));
		fecha.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fecha.setBounds(220, 165, 129, 24);
		hora=new JTextField(10);
		hora.setBorder(new LineBorder(Color.RED, 1, true));
		hora.setFont(new Font("Times New Roman", Font.BOLD, 15));
		hora.setBounds(222, 200, 127, 24);
		panel2.setLayout(null);
		panel2.add(label2);
		panel2.add(pago);
		panel2.add(label3);
		panel2.add(paciente);
		panel2.add(label4);
		panel2.add(doctor);
		panel2.add(label5);
		panel2.add(fecha);
		panel2.add(label6);
		panel2.add(hora);
		getContentPane().add(panel2,BorderLayout.CENTER);
		
		panel1=new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel1.setBounds(33, 11, 380, 38);
		panel2.add(panel1);
		panel1.setLayout(null);
		
		label1=new JLabel("Ficha Médica");
		label1.setBounds(143, 0, 150, 27);
		panel1.add(label1);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 22));
				panel3=new JPanel();
				panel3.setBackground(Color.WHITE);
				panel3.setBounds(28, 245, 446, 132);
				panel2.add(panel3);
				panel3.setLayout(null);
				
						cancelar=new JButton("");
						cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						cancelar.setBorderPainted(false);
						cancelar.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent arg0) {
								cancelar.setText("Regresar");
							}
							@Override
							public void mouseExited(MouseEvent arg0) {
								cancelar.setText("");
							}
						});
						cancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
						cancelar.setVerticalAlignment(SwingConstants.BOTTOM);
						cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
						cancelar.setContentAreaFilled(false);
						cancelar.setIcon(new ImageIcon(VentanaAgendaCita.class.getResource("/imagenes/regresar_atras.png")));
						cancelar.setBounds(332, 11, 93, 78);
						panel3.add(cancelar);
						guardar=new JButton("");
						guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						guardar.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								guardar.setText("Guardar");
							}
							@Override
							public void mouseExited(MouseEvent e) {
								guardar.setText("");
							}
						});
						guardar.setBorderPainted(false);
						guardar.setHorizontalTextPosition(SwingConstants.CENTER);
						guardar.setVerticalTextPosition(SwingConstants.BOTTOM);
						guardar.setVerticalAlignment(SwingConstants.BOTTOM);
						guardar.setIcon(new ImageIcon(VentanaAgendaCita.class.getResource("/imagenes/guardar.png")));
						guardar.setContentAreaFilled(false);
						guardar.setBounds(242, 11, 106, 78);
						panel3.add(guardar);
						limpiar=new JButton("");
						limpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						limpiar.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								limpiar.setText("Limpiar");
							}
							@Override
							public void mouseExited(MouseEvent e) {
								limpiar.setText("");
							}
						});
						limpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
						limpiar.setVerticalAlignment(SwingConstants.BOTTOM);
						limpiar.setHorizontalTextPosition(SwingConstants.CENTER);
						limpiar.setIcon(new ImageIcon(VentanaAgendaCita.class.getResource("/imagenes/limpiar.png")));
						limpiar.setContentAreaFilled(false);
						limpiar.setBorderPainted(false);
						limpiar.setBounds(159, 11, 93, 78);
						panel3.add(limpiar);
						disponibilidad=new JButton("Disponibilidad");
						disponibilidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						disponibilidad.setBackground(new Color(255, 204, 204));
						disponibilidad.setBorder(new LineBorder(Color.RED, 1, true));
						disponibilidad.setFont(new Font("Times New Roman", Font.BOLD, 15));
						disponibilidad.setBounds(10, 61, 139, 23);
						panel3.add(disponibilidad);
						
						lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(VentanaAgendaCita.class.getResource("/imagenes/marco.png")));
						lblNewLabel.setBounds(97, 388, 275, 43);
						panel2.add(lblNewLabel);
						disponibilidad.addActionListener(this);
						limpiar.addActionListener(this);
						guardar.addActionListener(this);
				
				cancelar.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelar) {
			setVisible(false);
		}
		if(e.getSource()==guardar) {
			idpago=pago.getText();
			idpaciente=paciente.getText();
			iddoctor=doctor.getText();
			fech=fecha.getText();
			h=hora.getText();
			if(idpago.equals("")||idpaciente.equals("")||iddoctor.equals("")||fech.equals("")||h.equals("")) {
				muestraMensaje("Campos vacios");
			}
			else {
				idp=Integer.parseInt(idpago);
				control.almacenaCita(idp,idpaciente,iddoctor,fech,h);
			}
		}
		if(e.getSource()==disponibilidad) {
			iddoctor=doctor.getText();
			fech=fecha.getText();
			control.verificaDisponibilidad(iddoctor,fech);	
		}
		if(e.getSource()==limpiar) {
			pago.setText("");
			paciente.setText("");
			doctor.setText("");
			fecha.setText("");
			hora.setText("");
		}
	}

	public void muestraMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		abre();
	}
	public void abre() {
		setVisible(true);
	}

	public void cierra() {
		setVisible(false);
	}
}