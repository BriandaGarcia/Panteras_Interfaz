package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.dominio.Ficha_medica;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class VentanaConfirmaCita extends JFrame implements ActionListener  {
	JPanel panel1,panel2,panel3;
	JLabel label1,label2,label3,label4,label5,label6;
	JButton botonCancelar,botonAceptar;
	JCheckBox check1,check2,check3,check4,check5,check6,check7,check8,check9,check10;
	
	ArrayList<Ficha_medica> citas = new ArrayList<Ficha_medica>();
	String fecha;

	private ControlConfirmaCita control=null;
	private JLabel lblNewLabel;
	
	public VentanaConfirmaCita(ControlConfirmaCita control, ArrayList<Ficha_medica> citas, String fech) throws HeadlessException {
		super("Confirmar Citas");
		this.control=control;
		this.citas=citas;
		this.fecha=fech;
		setSize(500, 508);
		setLocationRelativeTo(null);
		
		ArrayList<JCheckBox> check=new ArrayList<JCheckBox>();
		
		panel1=new JPanel();
		panel1.setBackground(Color.WHITE);
		panel2=new JPanel();
		panel2.setBackground(Color.WHITE);
		panel3=new JPanel();
		panel3.setBackground(Color.WHITE);
		
		label1=new JLabel("Confirmar Citas");
		label2=new JLabel("Doctor");
		label2.setBackground(Color.WHITE);
		label3=new JLabel("Paciente");
		label3.setBackground(Color.WHITE);
		label4=new JLabel("Fecha");
		label4.setBackground(Color.WHITE);
		label5=new JLabel("Hora");
		label5.setBackground(Color.WHITE);
		label6=new JLabel("Confirmar");
		label6.setBackground(Color.WHITE);
		
		label1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		botonAceptar=new JButton("");
		botonAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		botonAceptar.setBorderPainted(false);
		botonAceptar.setContentAreaFilled(false);
		botonAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonAceptar.setIcon(new ImageIcon(VentanaConfirmaCita.class.getResource("/imagenes/aceptar.jpg")));
		botonAceptar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonAceptar.addActionListener(this);
		
		check1=new JCheckBox();
		check.add(check1);
		check2=new JCheckBox();
		check.add(check2);
		check3=new JCheckBox();
		check.add(check3);
		check4=new JCheckBox();
		check.add(check4);
		check5=new JCheckBox();
		check.add(check5);
		check6=new JCheckBox();
		check.add(check6);
		check7=new JCheckBox();
		check.add(check7);
		check8=new JCheckBox();
		check.add(check8);
		check9=new JCheckBox();
		check.add(check9);
		check10=new JCheckBox();
		check.add(check10);
		
		check1.addActionListener(this);
		check2.addActionListener(this);
		check3.addActionListener(this);
		check4.addActionListener(this);
		check5.addActionListener(this);
		check6.addActionListener(this);
		check7.addActionListener(this);
		check8.addActionListener(this);
		check9.addActionListener(this);
		check10.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.setLayout(new GridLayout(citas.size()+1,5));
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(label6);
		for(int i=0;i<citas.size();i++) {
			panel2.add(new JLabel(""+citas.get(i).getDoctor()));
			panel2.add(new JLabel(""+citas.get(i).getPaciente()));
			panel2.add(new JLabel(""+fecha));
			panel2.add(new JLabel(""+citas.get(i).getHora()));
			panel2.add(check.get(i));
		}
		panel3.add(botonAceptar);
		
		getContentPane().add(panel1,BorderLayout.NORTH);
		getContentPane().add(panel2,BorderLayout.CENTER);
		getContentPane().add(panel3,BorderLayout.SOUTH);
		
		botonCancelar=new JButton("");
		botonCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		botonCancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.setBorderPainted(false);
		botonCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonCancelar.setIcon(new ImageIcon(VentanaConfirmaCita.class.getResource("/imagenes/regresar_atras.png")));
		
			botonCancelar.addActionListener(this);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(VentanaConfirmaCita.class.getResource("/imagenes/marco.png")));
			panel3.add(lblNewLabel);
			
			panel3.add(botonCancelar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonCancelar) {
			setVisible(false);
		}
		if(e.getSource()==botonAceptar) {
			int opt=0;
			//En caso de no seleccionar algun empleado se muestra un mensaje de error
			if(check1.isSelected()==false && check2.isSelected()==false && check3.isSelected()==false && check4.isSelected()==false && check5.isSelected()==false && check6.isSelected()==false && check7.isSelected()==false && check8.isSelected()==false && check9.isSelected()==false && check10.isSelected()==false && check1.isSelected()==false )
				JOptionPane.showMessageDialog(this, "No has selecionado una cita");
			else {
				//se verifica a que empleado fue seleccionado
				if(check1.isSelected()==true )
				opt=0;
				if(check2.isSelected()==true)
				opt=1;
				if(check3.isSelected()==true)
				opt=2;
				if(check4.isSelected()==true )
				opt=3;
				if(check5.isSelected()==true )
				opt=4;
				if(check6.isSelected()==true )
				opt=5;
				if(check7.isSelected()==true )
				opt=6;
				if(check8.isSelected()==true )
				opt=7;
				if(check9.isSelected()==true )
				opt=8;
				if(check10.isSelected()==true)
				opt=9;
				control.confirmaCita(citas.get(opt));
			}
		}
	}
	
	public void abre() {
		setVisible(true);
	}

	public void cierra() {
		setVisible(false);
	}
	
	public void muestraMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		abre();
	}
}
