package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.events.EventException;
import negocio.dominio.Medicamento;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

/**
 *@Descripcion de la clase: Esta clase contiene la interfaz para hacer la actualización de medicamentos
 *@Autor: Cerón Caballero Susan Karen
 *       
 */

public class VentanaActualizaMedicamento extends JFrame {

//////Declaración de la variables globales para esta clase/////
	
	private ControlActualizaMedicamento control_a;
	private ArrayList<Medicamento> lista= new ArrayList<Medicamento>();
	private String id;
	private String nombre_med;
	private float costo;
	private int cantidad;
	int filas;
	JTable tabla_med;
	DefaultTableModel model = new DefaultTableModel();
	private JPanel contentPane;
	private JTable table;
	private JTextField textid;
	private JTextField textcosto;
	private JTextField textnombre;
	private JTextField textcantidad;
	private JTable table_1;
	
/////Métodos de la clase/////
	
	/**
	 *@Descripción del método: Constructor de la clase para llamar el metodo initcomponentesam y darle un titulo a la ventana por medio del super
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Sin parametros
	 *@Regresa: No regresa nada
	 *
	 */
	public VentanaActualizaMedicamento()
	{
		setTitle("Actualiza Medicamento");
		initComponentsam();	
	}
	
	/**
	 *@Descripción del método: Constructor que inicializa el control
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Control, para actualizar medicamento
	 *@Regresa: No regresa nada
	 *
	 */
	public VentanaActualizaMedicamento(ControlActualizaMedicamento control_act)
	{
		super("Actualiza Medicamento");
		
		initComponentsam();
		control_a=control_act;	
	}

	/**
	 *@Descripción del método: Inicializa el frame
	 *@Autor: Cerón Caballero Susan Karen.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaActualizaMedicamento frame = new VentanaActualizaMedicamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 *@Descripción del método: Contiene instrucciones de código para mostrar de forma gráfica los datos de los medicamentos para 
	 *su actualización 
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Sin parametros
	 *@Regresa: No regresa nada
	 *
	 */
	public void initComponentsam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 623);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(SystemColor.activeCaption, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActualizaMedicamento = new JLabel("Actualiza Medicamento");
		lblActualizaMedicamento.setBounds(166, 24, 233, 22);
		lblActualizaMedicamento.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contentPane.add(lblActualizaMedicamento);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		btnCancelar.setBorderPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setIcon(new ImageIcon(VentanaActualizaMedicamento.class.getResource("/imagenes/regresar_atras.png")));
		btnCancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancelar.setBounds(384, 432, 89, 70);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		contentPane.add(btnCancelar);
		
		JLabel lblIdDeMedicamento = new JLabel("ID de Medicamento");
		lblIdDeMedicamento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIdDeMedicamento.setBounds(10, 89, 138, 22);
		contentPane.add(lblIdDeMedicamento);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(243, 89, 72, 22);
		contentPane.add(lblNombre);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCosto.setBounds(96, 143, 46, 22);
		contentPane.add(lblCosto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCantidad.setBounds(243, 146, 72, 18);
		contentPane.add(lblCantidad);
		
		textid = new JTextField();
		textid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textid.setEditable(false);
		textid.setBounds(158, 91, 57, 20);
		
		textcosto = new JTextField();
		textcosto.setBorder(new LineBorder(Color.RED, 1, true));
		textcosto.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textcosto.setBounds(157, 145, 58, 20);
		
		textnombre = new JTextField();
		textnombre.setBorder(new LineBorder(Color.RED, 1, true));
		textnombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textnombre.setText("");
		textnombre.setBounds(325, 91, 148, 20);
		
		textcantidad = new JTextField();
		textcantidad.setBorder(new LineBorder(Color.RED, 1, true));
		textcantidad.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textcantidad.setBounds(325, 144, 148, 20);
		
		contentPane.add(textid);
		textid.setColumns(10);
		
		contentPane.add(textcosto);
		textcosto.setColumns(10);
		
		contentPane.add(textnombre);
		textnombre.setColumns(10);
		
		contentPane.add(textcantidad);
		textcantidad.setColumns(10);
		
		//se declara un arreglo de tipo String para darle nombre a las columnas de la tabla
		String[] columnNames = {"ID","Nombre","Costo","Cantidad"};
		model.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[model.getColumnCount()];
		
		//acciones para el boton btnMostar
		JButton btnMostrar = new JButton("");
		btnMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMostrar.setText("Mostrar Medicamentos");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMostrar.setText("");
			}
		});
		btnMostrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMostrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMostrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMostrar.setIcon(new ImageIcon(VentanaActualizaMedicamento.class.getResource("/imagenes/medicamentos.png")));
		btnMostrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMostrar.setContentAreaFilled(false);
		btnMostrar.setBorderPainted(false);
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * instrucciones para evitar que el usuario muestre la lista de medicamentos
				 * dos veces, se inicializa una variable de tipo entero de nombre cont(contador) en 0
				 * luego se incrementa, el cual entra dentro de una condicional que cumple para desactivar 
				 * el boton de mostrar datos.
				 * @author Cerón Caballero Susan Karen.
				 */
		        int cont=0;
		        cont++;
		        if(cont>0)
		        {
		        	btnMostrar.setEnabled(false);//desactivación del boton
		        }
		        
		        /*
				 * instrucciones para mostrar la informacion de los medicsmentos
				 * en la tabla
				 */
		        
				lista=control_a.rec_med();
				for (int i = 0; i < lista.size(); i++) {

				fila[0] = lista.get(i).get_id();
				fila[1] = lista.get(i).get_nombre();
				fila[2] = lista.get(i).get_costo();
				fila[3] = lista.get(i).get_cantidad();
				model.addRow(fila);
				}
                  table_1.setVisible(true);//muestra la tabla
                  table_1.setModel(model);
				 
				}
		});
		btnMostrar.setBounds(10, 432, 193, 70);
		contentPane.add(btnMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(Color.RED, 1, true));
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
	
		scrollPane.setBounds(66, 207, 407, 204);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			/*
			 * es un metodo (evento) donde si se selecciona una fila de la tabla 
			 * aparezaca en las cajas de texto(jtexfield ) los datos de esa fila
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = table_1.getSelectedRow();
				textid.setText(String.valueOf(table_1.getValueAt(seleccion,0)));
				textnombre.setText(String.valueOf(table_1.getValueAt(seleccion,1)));
				textcosto.setText(String.valueOf(table_1.getValueAt(seleccion,2)));
				textcantidad.setText(String.valueOf(table_1.getValueAt(seleccion,3)));
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre","Costo", "Cantidad"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnActualizar.setText("Actualizar");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnActualizar.setText("");
			}
		});
		btnActualizar.setBorderPainted(false);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnActualizar.setIcon(new ImageIcon(VentanaActualizaMedicamento.class.getResource("/imagenes/actualizar.jpg")));
		btnActualizar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnActualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// se obtienen los datos de tipo String
				id=textid.getText();
				nombre_med=textnombre.getText();
				
				//se implemeta un try-catch debido para que no arroje error al momento de obtener texto de tipo entero o real
				try{
				costo=Float.parseFloat(textcosto.getText());
				cantidad=Integer.parseInt(textcantidad.getText());
			    
				//se le pasan los datos obtenidos al control
				
				//primero se verifica que el texto que contiene nombre del medicamento no sea nulo, si se cumple
				//manda un mensaje al usuario
				if(nombre_med.isEmpty()){
					muestramensaje("Error,campos vacio.");
				}else{
					 //se verifica que estas variables sean distintas menor o gual a 0, si se cumple se refleja el cambio en la tabla
				     if( !(costo<=0 || cantidad<=0) )				    {
				    	//se le pasa al control los parametros para hacer la actualización
					   control_a.Actualizar(id, nombre_med,costo,cantidad);
				        ///////actualiza el dato escrito en un jtextfield a la tabla,en la fila correspondiente////
				       int num_fila= table_1.getSelectedRow();
				       model.setValueAt(textnombre.getText(),num_fila,1);
				       model.setValueAt(textcosto.getText(),num_fila,2);
				       model.setValueAt(textcantidad.getText(),num_fila,3);
				    }else{
				    	//si el costo fue menor o igual a 0 se le manda un mensaje al usuario
					    if(costo<=0)
						muestramensaje("El costo no puede ser menor o igual a 0.");
					    else
					    //la cantidad fue es menor o igual a 0 se le manda un mensaje al usuario
						muestramensaje("La cantidad no puede ser menor o igual a 0");
				         }
				 }
				    
				}catch(java.lang.NumberFormatException var){
					
					muestramensaje("Error,campos vacio");
				}
			}
		});
		btnActualizar.setBounds(235, 432, 97, 70);
		contentPane.add(btnActualizar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaActualizaMedicamento.class.getResource("/imagenes/marco.png")));
		label.setBounds(134, 525, 280, 49);
		contentPane.add(label);
		    
	}
	
	/**
	 *@Descripción del método: Este método para mostar una ventana con un mensaje
	 *@Parametros de entrada: Un mensaje
	 *@Regresa: No regresa nada
	 *
	 */
   public void muestramensaje(String mensaje)
   {
	JOptionPane.showMessageDialog(this,mensaje);
   }
}
