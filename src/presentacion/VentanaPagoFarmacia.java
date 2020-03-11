package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import negocio1.ServicioReporte;

import java.math.RoundingMode;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VentanaPagoFarmacia extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	
	
	private ControlPagoFarmacia control_f;
    float precio;
    String nombre_med;
    float total=0;
    Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String id_med;
	
	public VentanaPagoFarmacia()
	{
		
		
		initComponentsfa();
	}
	
	public VentanaPagoFarmacia(ControlPagoFarmacia controlpagofar)
	{
		super("Pago de Farmacia");
		
		initComponentsfa();
		control_f=controlpagofar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPagoFarmacia frame = new VentanaPagoFarmacia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void initComponentsfa() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 710);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblPagoDeMedicamentos = new JLabel("Pago de Medicamentos");
		lblPagoDeMedicamentos.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPagoDeMedicamentos.setBounds(120, 11, 226, 25);
		contentPane.add(lblPagoDeMedicamentos);
		
		text1 = new JTextField();
		text1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text1.setBorder(new LineBorder(Color.RED, 1, true));
		text1.setBounds(5, 84, 187, 20);
		contentPane.add(text1);
		text1.setColumns(10);
		
		JLabel lblNombreDeMedicamento = new JLabel("Nombre de Medicamento:");
		lblNombreDeMedicamento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombreDeMedicamento.setBounds(10, 47, 195, 26);
		contentPane.add(lblNombreDeMedicamento);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCantidad.setBounds(10, 137, 84, 14);
		contentPane.add(lblCantidad);
		
		text2 = new JTextField();
		text2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		text2.setBorder(new LineBorder(Color.RED, 1, true));
		text2.setBounds(89, 135, 65, 20);
		contentPane.add(text2);
		text2.setColumns(10);
		
		

		JButton btn2 = new JButton("Agregar");
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btn2.setBorder(new LineBorder(Color.RED, 1, true));
		btn2.setBackground(new Color(255, 204, 204));
		btn2.setEnabled(true);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setText("Regresar");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setText("");
			}
		});
		btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCancelar.setIcon(new ImageIcon(VentanaPagoFarmacia.class.getResource("/imagenes/regresar_atras.png")));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(306, 510, 89, 73);
		contentPane.add(btnCancelar);
		
		/**
		 * @author Cerón Caballero Susan K.
		 * lista para los medicamentos
		 */
		JList<String> list = new JList<String>();
		list.setFont(new Font("Times New Roman", Font.BOLD, 15));
		list.setModel( new DefaultListModel<String>());
		list.setBounds(80, 67, 108, 206);
		
		/**
		 * @author Cerón Caballero Susan K.
		 * lista para precios
		 */
		JList <Float>list2 = new JList<Float>();
		list2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		list2.setModel( new DefaultListModel<Float>());
		list2.setBounds(198, 67, 60, 206);
		
		/**
		 *@author Cerón Caballero Susan K.
		 *lista para cantidad 
		 */
		JList <Integer>list3 = new JList<Integer>();
		list3.setModel( new DefaultListModel<Integer>());
		list3.setBounds(268, 67, 30, 206);
		
		/**
		 * @author Cerón Caballero Susan K.
		 *lista para el codigo o id del medicamento 
		 */
		JList<String> list4 = new JList<String>();
		list4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		list4.setModel( new DefaultListModel<String>());
		list4.setBounds(10, 67, 60, 206);
		
		
		
		JButton btnmed = new JButton("Agregar");
		btnmed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnmed.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnmed.setBorder(new LineBorder(Color.RED, 1, true));
		btnmed.setBackground(new Color(255, 204, 204));
		btnmed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			     nombre_med = text1.getText();
				 precio=control_f.obteber_precio(nombre_med);
				 id_med=control_f.obtener_id(nombre_med);

				    /**
					 * se declaran para que aparecan los datos en jlist
					 *@author Cerón Caballero Susan K.
					 * 
					 */
				 DefaultListModel<String> lista=((DefaultListModel<String>)list.getModel());
				 DefaultListModel<Float> lista2=((DefaultListModel<Float>)list2.getModel());
				 DefaultListModel<String> lista4=((DefaultListModel<String>)list4.getModel());
				   /**
					 * si el nombre es verdadero aparecen los datos del medicamento
					 *@author Cerón Caballero Susan K.
					 * 
					 */
				 if(control_f.existencia(nombre_med)==true)
				 {
				   lista4.addElement(id_med);
				   lista.addElement(nombre_med);
				   lista2.addElement(precio);
				   
				   
				 }
				
			}
		});
		btnmed.setBounds(202, 83, 119, 23);
		contentPane.add(btnmed);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.RED));
		panel.setBounds(20, 162, 375, 337);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		panel.add(list);
		
		
		panel.add(list2);
		
		panel.add(list4);
		panel.add(list3);
		
		JLabel lblMedicamento = new JLabel("Medicamento");
		lblMedicamento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMedicamento.setBounds(83, 42, 105, 14);
		panel.add(lblMedicamento);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrecio.setBounds(198, 42, 60, 14);
		panel.add(lblPrecio);
		
		JLabel lblCantidad_1 = new JLabel("Cantidad");
		lblCantidad_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCantidad_1.setBounds(268, 42, 77, 14);
		panel.add(lblCantidad_1);
		
		JLabel lblTotalApagar = new JLabel("Total a pagar:");
		lblTotalApagar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalApagar.setBounds(10, 308, 99, 23);
		panel.add(lblTotalApagar);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFecha.setBounds(10, 11, 52, 14);
		panel.add(lblFecha);
		
		JLabel label_total = new JLabel("");
		label_total.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_total.setBounds(111, 308, 108, 20);
		panel.add(label_total);
		
		JLabel lblNewLabel = new JLabel(dateFormat.format(fecha));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(97, 8, 91, 20);
		panel.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCodigo.setBounds(10, 38, 60, 23);
		panel.add(lblCodigo);
		
		
		
		/***
		 * cuando se agrega la cantidad, esta se resta de la bd
		 * 
		 */
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad=0;
				String total_pago;
				String nombre_med = text1.getText();
				 DefaultListModel<Integer> lista3=((DefaultListModel<Integer>)list3.getModel());
				 DecimalFormat d = new DecimalFormat("0.00");//convierte una cantidad con dos decimales
				 
				   try
			         {
					     cantidad= Integer.parseInt(text2.getText());
					     
					     
					    	 
					    
					     if(cantidad<=0)
					     {
					    	 muestramensaje("la cantidad no puede ser 0");
					    	
					    	
					     }else{
					    	 if(control_f.resta(id_med, cantidad)<=0){
					    		 muestramensaje("sin medicamento");
					    	 }else{
					      	 
					    
					          lista3.addElement(cantidad);
					     
					          control_f.act_cantidad(id_med, cantidad);
					     
					          total=total+control_f.pago_total(cantidad,precio);
					     
					          total_pago=(d.format(total));// la cadena total_pago obtiene el valor de la variable total
					        
					          label_total.setText(total_pago);//jtextfield muestra lo que tiene la cadena total_pago
					    	 }
			            }
					    
					    
			            
			         }
			         catch(java.lang.NumberFormatException var)
			         {
				         muestramensaje("Error,campo vacio");
			         }
				   
				   
			}
		});
		btn2.setBounds(180, 134, 106, 23);
		contentPane.add(btn2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setText("Limpiar");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setText("");
			}
		});
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(VentanaPagoFarmacia.class.getResource("/imagenes/limpiar.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text1.setText("");
				text2.setText("");
			}
		});
		btnNewButton.setBounds(331, 84, 78, 67);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setText("Limpiar pago");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setText("");
			}
		});
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1.setIcon(new ImageIcon(VentanaPagoFarmacia.class.getResource("/imagenes/limpiar.png")));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(151, 510, 124, 73);
		contentPane.add(btnNewButton_1);
		
		JButton btnImprimir = new JButton("");
		btnImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnImprimir.setText("Imprimir");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnImprimir.setText("");
			}
		});
		btnImprimir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnImprimir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnImprimir.setIcon(new ImageIcon(VentanaPagoFarmacia.class.getResource("/imagenes/imprimir.png")));
		btnImprimir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setBorderPainted(false);
		btnImprimir.setBounds(22, 510, 102, 73);
		contentPane.add(btnImprimir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaPagoFarmacia.class.getResource("/imagenes/marco.png")));
		label.setBounds(62, 605, 284, 55);
		contentPane.add(label);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				muestramensaje("imprimiendo solicitud de pago");
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * limpia lo que contenga jlist
				 *@author Cerón Caballero Susan K.
				 */
				 DefaultListModel listaclear = (DefaultListModel) list.getModel();
			        listaclear.removeAllElements();
			
			     DefaultListModel listaclear2 = (DefaultListModel) list2.getModel();
			        listaclear2.removeAllElements();
			     
			     DefaultListModel listaclear3 = (DefaultListModel) list3.getModel();
			        listaclear3.removeAllElements();
			        
			     DefaultListModel listaclear4 = (DefaultListModel) list4.getModel();
			        listaclear4.removeAllElements();
			        
			        label_total.setText("");
				
				
			}
		});
	}
public void muestramensaje(String mensaje){
		
		JOptionPane.showMessageDialog(this,mensaje);
	}
}
