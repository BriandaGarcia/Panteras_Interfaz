package presentacion;

import negocio1.ServicioMedicamento;

/**
 * Controla el funcionamiento de la adicion de medicamentos al sistema, haciendo la comunicacion con el servicio
 * @author Brianda Garcia
 *
 */
public class ControlAgregaMedicamento {
	
//////Declaración de la variables globales para esta clase/////
	
	//Servicio
	private ServicioMedicamento servicio;
	//Ventana para agregar medicamento 
	private VentanaAgregaMedicamento ventana;
		
/////Métodos de la clase//////
	
	/**
	 * Constructor
	 * @param servicio Servicio a utilizar en la HU
	 */
	public ControlAgregaMedicamento(ServicioMedicamento servicio) {
		//Inicializa el servicio de la clase, con el servicio recibido como parametro
		this.servicio=servicio;
	}

	/**
	 * El control inicia la ventana para la HU de agregar un nuevo medicamento al sistema
	 * @author Brianda Garcia
	 */
	public void inicia() {
		//Inicializa la ventana pasandole como parametro el control a utilizar
		ventana=new VentanaAgregaMedicamento(this);
		//Abre la ventana
		ventana.abre();
	}

	/**
	 * Hace la comunicacion con el servicio de Medicamento para agregar un nuevo medicamento al sistema
	 * @author Brianda Garcia
	 * @param id Id del nuevo medicamento que se desea agregar al sistema
	 * @param nombre Nombre del nuevo medicamento que se desea agregar
	 * @param costo Costo del nuevo medicamento
	 * @param cantidad La cantidad de medicamentos existentes al momento de agregar al sistema
	 */
	public void almacenaMedicamento(String id, String nombre, String costo, String cantidad) {
		//Llama a servicio para agregar un nuevo medicamento
	    if(servicio.registraMedicamento(id,nombre,costo,cantidad)) {
	    	ventana.muestraMensaje("Se ha agregado el medicamento exitosamente");
	    	ventana.cierra();
	    }
	    else //si hay un problema en registrar el medicamento, muestra mensaje de error
	    	ventana.muestraMensaje("No se ha podido agregar el medicamento");
	}

}