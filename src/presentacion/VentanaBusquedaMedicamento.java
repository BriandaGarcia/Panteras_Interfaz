package presentacion;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.dominio.Medicamento;
import negocio.dominio.Pago;
import java.awt.Color;
/*
 * @autor Franco Torres Isabel Estephanea
 * La ventana donde se muestran todos los medicamentos que estan en el catalogo 
 */
public class VentanaBusquedaMedicamento extends JFrame implements ActionListener{

	private ControlBusquedaMedicamento control=null;
	
	
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9;
	JLabel label1,label2,label4,label5,label6,label7,label8;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
	JButton boton1,boton2,boton3,boton4;
	
	
	ArrayList<Medicamento> medi;
	ArrayList<Medicamento> medicamento;
	String [] id;
	String nombre;
	public VentanaBusquedaMedicamento(ControlBusquedaMedicamento control) throws HeadlessException {
		super("Catalogo");
		this.control=control;
		setSize(700,100);
		setLocationRelativeTo(null);
		int aux=100;

		medi=control.recuperaMedicamento();
		
		id=new String[medi.size()];
		
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		panel7=new JPanel();
		panel8=new JPanel();
		panel9=new JPanel();
		
		label1=new JLabel("Medicamento");
		label1.setFont(new Font("Arial Black", Font.BOLD, 25));
		//label7=new JLabel("Nombre del medicamento a buscar");
		label2=new JLabel("Nombre");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label2.setBackground(Color.WHITE);
		label4=new JLabel("Precio");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label4.setBackground(Color.WHITE);
		label6=new JLabel("Cantidad");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label6.setBackground(Color.WHITE);
		label5=new JLabel("ID");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label5.setBackground(Color.WHITE);
		
		text1=new JTextField(50);
		
		//boton4=new JButton("Limpiar");
		boton1=new JButton("Cancelar");
		boton2=new JButton("Aceptar");
			
		//boton4.addActionListener(this);
		boton1.addActionListener(this);
		boton2.addActionListener(this);
			
		panel1.add(label1);
		/*
		panel7.setLayout(new GridLayout(1,2));
		panel7.add(label7);
		panel7.add(text1);
		*/				
		//Etiquetas que corresponden a las campos a mostrar
		panel2.setLayout(new GridLayout(medi.size()+1,4));
		panel2.add(label5);
		panel2.add(label2);
		panel2.add(label4);
		panel2.add(label6);
		
		//Se llenan los datos de los empleados a mostrar en pantalla de acuerod a la cantidad de empleados recuperados
		if(medi.size()!=0) {
			
		for(int i=0;i<medi.size();i++) {
			aux+=100;
			id[i]=medi.get(i).get_id();
			panel2.add(new JLabel(""+medi.get(i).get_id()));
			panel2.add(new JLabel(""+medi.get(i).get_nombre()));
			panel2.add(new JLabel(""+medi.get(i).get_costo()));
			panel2.add(new JLabel(""+medi.get(i).get_cantidad()));
		}
		
		setSize(500,aux);
		//panel3.add(boton4);
		panel3.add(boton1);
		panel3.add(boton2);
		/*
		panel6.setLayout(new GridLayout(2,1));
		panel6.add(panel1);
		panel6.add(panel7);
		*/
		getContentPane().add(panel1,BorderLayout.NORTH);
		getContentPane().add(panel2,BorderLayout.CENTER);
		getContentPane().add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		if(e.getSource()==boton2) {
			ArrayList<Medicamento> medicamento = new ArrayList<Medicamento>();
			nombre=text1.getText();
			medicamento=control.recuperaMedicamento(nombre);
			
			if(medicamento!=null) {
				remove (panel2);
				panel9.setLayout(new GridLayout(medicamento.size()+2,4));
				panel9.add(label5);
				panel9.add(label2);
				panel9.add(label4);
				panel9.add(label6);
				//Agrega cada linea del historial medico 
				for(int i=0;i<medicamento.size();i++) {
					panel9.add(new JLabel(""+medi.get(i).get_id()));
					panel9.add(new JLabel(""+medi.get(i).get_nombre()));
					panel9.add(new JLabel(""+medi.get(i).get_costo()));
					panel9.add(new JLabel(""+medi.get(i).get_cantidad()));
				}
				//add(panel9,BorderLayout.CENTER);
				
			}
			else {
				text1.setText("");
			}
		}*/
		if(e.getSource()==boton2) {
			setVisible(false);
		}
		if(e.getSource()==boton4) {
			text1.setText(" ");
		}
		if(e.getSource()==boton1) {
			setVisible(false);
		}
	

	}


	
	public void abre() {
		setVisible(true);
	}

	

	public void muestraMensaje(String string) {
		// TODO Auto-generated method stub
		
	}
	
	public void cierra() {
		// TODO Auto-generated method stub
		setVisible(false);
	}

}
