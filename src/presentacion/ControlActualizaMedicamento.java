package presentacion;

import java.util.ArrayList;
import negocio.dominio.Medicamento;
import negocio1.ServicioMedicamento;

/**
 *@Descripcion de la clase: Contiene métodos que validan y regresan datos importantes para que la clase 
 *VentanaActualizaMedicamento los pueda mostrar
 *@Autor: Cerón Caballero Susan Karen
 *       
 */

public class ControlActualizaMedicamento {

//////Declaración de la variables globales para esta clase/////
	
	private ServicioMedicamento servicio_act;
	private VentanaActualizaMedicamento ventana;

/////Métodos de la clase//////
	
	/**
	 *@Descripción del método: Constructor que inicializa el servicio
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: ServicioMedicamento
	 *@Regresa: No regresa nada
	 *
	 */
	public ControlActualizaMedicamento(ServicioMedicamento servicio_act) {
		this.servicio_act=servicio_act;
	}
	
	 /**
	  *@Descripción del método: Inicia la ventana para que sea visible la ventana de actualizar medicamento
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Sin parametros
	 *@Regresa: No regresa nada
	 *
	 */
	public void inicia()
	{
		ventana=new VentanaActualizaMedicamento(this);
		ventana.setVisible(true);
	}
	
	/**
	 *@Descripción del método: Recupera todos los medicamentos existentes que obtuvo el ServicioMedicamento
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Sin parametros
	 *@Regresa: Lista de medicamentos
	 *
	 */
	public ArrayList<Medicamento> rec_med()
	{
		ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
		//Recibe la lista
		medicamentos=servicio_act.recu_med();
		return medicamentos;
	}
	
	/**
	 *@Descripción del método: Este método recupera el valor booleano de la actualización que obtuvo ServicioMedicamento
	 *si el valor update es true, entonces, se le  muestra al usuario un mensaje se que su actualización tuvo exito, 
	 *si el valor update es false, entonces, se le muestra que no se pudo hacer la actualización
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: id, nombre, costo y cantidad del medicamento
	 *@Regresa: No regresa nada
	 *
	 */
	public void Actualizar(String id,String nombre,float costo,int cantidad)
	{
	  boolean update= servicio_act.Actualiza_Medicamento(id, nombre, costo, cantidad);
	  if(update==true){
		 
		  ventana.muestramensaje("Actualizacion con exito.");
		  
	  }
	  else{
		  ventana.muestramensaje("No pudo hacer la actualizacion.");
	  }
				
	}
}

