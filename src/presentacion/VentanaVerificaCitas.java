package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.dominio.Ficha_medica;

public class VentanaVerificaCitas extends JFrame implements ActionListener {

	JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField Doctor, Fecha;
	JButton botonBuscar,botonLimpiar,botonAceptar;
	String id,fecha;
	
	ArrayList<Ficha_medica> consultas = new ArrayList<Ficha_medica>();

	private ControlAgendaCita control=null;

	public VentanaVerificaCitas(ControlAgendaCita control, ArrayList<Ficha_medica> consultas, String iddoctor, String fech) throws HeadlessException{
		super("Disponibilidad");
		this.control=control;
		this.consultas=consultas;
		this.id=iddoctor;
		this.fecha=fech;
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		
		label1=new JLabel("Citas Agendadas");
		label2=new JLabel("ID Doctor:");
		label3=new JLabel("Fecha:");	
		label4=new JLabel("ID Doctor");
		label5=new JLabel("Fecha");
		label6=new JLabel("Hora");
		
		label1.setFont(new Font("Arial Black", Font.BOLD, 25));
		label2.setFont(new Font("Arial Black", Font.BOLD, 20));
		label3.setFont(new Font("Arial Black", Font.BOLD, 20));
		label4.setFont(new Font("Arial Black", Font.BOLD, 15));
		label5.setFont(new Font("Arial Black", Font.BOLD, 15));
		label6.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		Doctor = new JTextField(25);
		Fecha=new JTextField(30);
		
		Doctor.setText(id);
		Fecha.setText(fecha);
		
		botonBuscar=new JButton("Buscar");
		botonLimpiar=new JButton("Limpiar");
		botonAceptar=new JButton("Aceptar");
	
		botonBuscar.addActionListener(this);
		botonLimpiar.addActionListener(this);
		botonAceptar.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.setLayout(new GridLayout(4,2));
		panel2.add(label2);
		panel2.add(Doctor);
		panel2.add(label3);
		panel2.add(Fecha);
		panel2.add(botonBuscar);
		panel2.add(botonLimpiar);
		
		panel3.setLayout(new GridLayout(consultas.size()+1,3));
		panel3.add(label4);
		panel3.add(label5);
		panel3.add(label6);
		for(int i=0;i<consultas.size();i++) {
			panel3.add(new JLabel(""+id));
			panel3.add(new JLabel(""+fecha));
			panel3.add(new JLabel(""+consultas.get(i).getHora()));
		}
		
		panel4.setLayout(new GridLayout(3,1));
		panel4.add(panel2);
		panel4.add(panel3);
		
		panel6.add(botonAceptar);
		
		add(panel1,BorderLayout.NORTH);
		add(panel4,BorderLayout.CENTER);
		add(panel6,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonBuscar) {
			id = Doctor.getText();
			fecha = Fecha.getText();
			if(fecha.equals("")) {
				muestraMensaje("Campos vacios");
			}
			else {
				control.verificaDisponibilidad(id,fecha);
				cierra();
			}
		}
		if(e.getSource()==botonLimpiar) {
			Fecha.setText("");
		}
		if(e.getSource()==botonAceptar) {
			cierra();
		}
	}
	
	public void abre() {
		setVisible(true);
	}

	public void muestraMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		abre();
	}

	public void cierra() {
		setVisible(false);
	}
}