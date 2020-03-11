package presentacion;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

/**
 * Ventana de agregar un medicamento al sistema
 * @author Brianda Garcia
 *
 */
public class VentanaAgregaMedicamento extends JFrame implements ActionListener{

//////Declaración de la variables globales para esta clase/////
	
	JPanel panel1,panel2;
	JLabel label1,label2,label3,label4,label5;
	JTextField id,nombre,costo,cantidad;
	JButton cancelar,aceptar,limpiar;
	
	private ControlAgregaMedicamento control=null;
	private JLabel label;
	
/////Métodos de la clase//////
	
	/**
	 * Constructor de la ventana de agregar un nuevo medicamento
	 * @author Brianda Garcia
	 * @param control Control de la adicion de medicamentos
	 * @throws HeadlessException
	 */
	public VentanaAgregaMedicamento(ControlAgregaMedicamento control) throws HeadlessException{
		super("Agrega Medicamento");
		//Inicializa el control global, con el control pasado como parametro
		this.control=control;
		//Se asigna un tamaño a la ventana
		setSize(362, 500);
		setLocationRelativeTo(null);
		panel2=new JPanel();
		panel2.setBorder(new LineBorder(new Color(153, 180, 209), 3, true));
		panel2.setBackground(Color.WHITE);
		
		//Etiquetas de informacion del nuevo medicamento
		label2=new JLabel("ID Medicamento:");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(10, 100, 124, 30);
		label3=new JLabel("Nombre:");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setBounds(57, 141, 77, 20);
		label4=new JLabel("Costo:");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setHorizontalTextPosition(SwingConstants.LEADING);
		label4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label4.setBounds(69, 185, 65, 20);
		label5=new JLabel("Cantidad:");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label5.setBounds(57, 224, 77, 30);
		
		//Informacion del nuevo medicamento
		id=new JTextField(20);
		id.setBorder(new LineBorder(Color.RED, 1, true));
		id.setFont(new Font("Times New Roman", Font.BOLD, 15));
		id.setBounds(144, 105, 117, 20);
		nombre=new JTextField(25);
		nombre.setBorder(new LineBorder(Color.RED, 1, true));
		nombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		nombre.setBounds(144, 141, 117, 20);
		costo=new JTextField(10);
		costo.setBorder(new LineBorder(Color.RED, 1, true));
		costo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		costo.setBounds(144, 185, 117, 20);
		cantidad=new JTextField(20);
		cantidad.setBorder(new LineBorder(Color.RED, 1, true));
		cantidad.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cantidad.setBounds(144, 229, 117, 20);
		panel2.setLayout(null);
		panel2.add(label2);
		panel2.add(id);
		panel2.add(label3);
		panel2.add(nombre);
		panel2.add(label4);
		panel2.add(costo);
		panel2.add(label5);
		panel2.add(cantidad);
		getContentPane().add(panel2,BorderLayout.CENTER);
		
	////////Inicializacion de variables globales////////
		panel1=new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(10, 11, 310, 56);
		panel2.add(panel1);
		panel1.setLayout(null);
		
		//Titulo de la ventana
		label1=new JLabel("Nuevo Medicamento");
		label1.setBounds(74, 11, 202, 36);
		panel1.add(label1);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		limpiar=new JButton("");
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
		limpiar.setIcon(new ImageIcon(VentanaAgregaMedicamento.class.getResource("/imagenes/limpiar.png")));
		limpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		limpiar.setVerticalAlignment(SwingConstants.BOTTOM);
		limpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		limpiar.setContentAreaFilled(false);
		limpiar.setBorderPainted(false);
		limpiar.setBounds(144, 284, 77, 90);
		panel2.add(limpiar);
		
		//Botones
		aceptar=new JButton("");
		aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				aceptar.setText("Guardar");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aceptar.setText("");
			}
		});
		aceptar.setVerticalAlignment(SwingConstants.BOTTOM);
		aceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
		aceptar.setIcon(new ImageIcon(VentanaAgregaMedicamento.class.getResource("/imagenes/guardar.png")));
		aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aceptar.setContentAreaFilled(false);
		aceptar.setBorderPainted(false);
		aceptar.setBounds(28, 295, 89, 79);
		panel2.add(aceptar);
		cancelar=new JButton("");
		cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cancelar.setText("Regresar");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cancelar.setText("");
			}
		});
		cancelar.setBorderPainted(false);
		cancelar.setContentAreaFilled(false);
		cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelar.setIcon(new ImageIcon(VentanaAgregaMedicamento.class.getResource("/imagenes/regresar_atras.png")));
		cancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		cancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		cancelar.setBounds(231, 295, 97, 79);
		panel2.add(cancelar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaAgregaMedicamento.class.getResource("/imagenes/marco.png")));
		label.setBounds(28, 394, 275, 56);
		panel2.add(label);
		cancelar.addActionListener(this);
		
		aceptar.addActionListener(this);
		limpiar.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Cancela la funcionalidad
		if(e.getSource()==cancelar) {
			setVisible(false);
		}
		//Solita el almacenamiento del nuevo medicamento si todos los campos estan llenos
		if(e.getSource()==aceptar) {
			//Si algún campo esta vacio, se muestra un mensaje de campos vacios
			if(id.getText().equals("")||nombre.getText().equals("")||costo.getText().equals("")||cantidad.getText().equals("")) {
				muestraMensaje("Campos vacios");
			}
			//Si todos los campos estan llenos, se comunica con el control para almacenar el nuevo medicamento
			else {
				control.almacenaMedicamento(id.getText(),nombre.getText(),costo.getText(),cantidad.getText());
			}
		}
		//Limpia los campos de texto
		if(e.getSource()==limpiar) {
			id.setText("");
			nombre.setText("");
			costo.setText("");
			cantidad.setText("");
		}
	}
	
	/**
	 * Muestra la ventana
	 */
	public void abre() {
		setVisible(true);
	}

	/**
	 * Muestra un mensaje
	 * @param mensaje el mensaje a mostrar
	 */
	public void muestraMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		abre();
	}

	/**
	 * Cierra la ventana
	 */
	public void cierra() {
		setVisible(false);
	}
}
