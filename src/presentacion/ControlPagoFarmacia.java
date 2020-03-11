package presentacion;

import negocio1.ServicioReporte;

public class ControlPagoFarmacia {

	//Servicio
	private ServicioReporte servicio;
	//Ventana
	private VentanaPagoFarmacia ventana_pago_farmacia;

	public ControlPagoFarmacia(ServicioReporte servicioReporte) {
		this.servicio=servicioReporte;
	}
	/**
	 * metodo para iniciar la ventana del pago de farmacia
	 *@author Cerón Caballero Susan K.
	 * 
	 */

	public void ventana_pago_farmacia() {
		ventana_pago_farmacia=new VentanaPagoFarmacia(this);
		ventana_pago_farmacia.setVisible(true);
		
		
	}
	
	/**
	 * este método verifica la existencia de un medicamneto en la base de datos
	 *@author Cerón Caballero Susan K.
	 * @param nombre del medicamdento
	 * @return true si lo encontro, false no existe
	 */
	public boolean existencia(String nom_med)
	{
		if(nom_med.isEmpty() || servicio.recupera_nombre_medicamento(nom_med)==false)
		{
			ventana_pago_farmacia.muestramensaje("el campo esta vacio o no existe nombre");
			return false;
		}
		else
		{
			if(servicio.recupera_nombre_medicamento(nom_med)==true)
			{
				ventana_pago_farmacia.muestramensaje("medicamento existente");
				
			}
			return true;
		}
	  
	
	}
	
	/**
	 * este método obtiene el precio del medicamento solicitado
	 *@author Cerón Caballero Susan K.
	 * @param nombre del medicamdento
	 * @return el precio del medicamento,0 si no 
	 */
	public float obteber_precio(String nombre)
	{
		if(servicio.recupera_costo(nombre)!=0)
		{
			return servicio.recupera_costo(nombre);
		}
		else{
			return 0;
		}
			
	}
	
	/**
	 * este método recupera el id del medicamento
	 *@author Cerón Caballero Susan K.
	 * @param nombre del medicamdento
	 * @return el id del medicamento
	 */
	public String obtener_id(String nombre)
	{
		
	return servicio.recupera_id(nombre);
		
			
	}
	/***
	 * este metodo solo hace el calculo para verificar en la VentanaPagoFarmacia
	 * que si la cantidad_nueva<=0 no se puede agregar al pago de farmacia y envia un
	 * mensaje 
	 * @autor Cerón Caballero Susan K.
	 * @param id_med
	 * @param cantidad
	 * @return cantidad_nueva
	 */
	public int resta(String id_med,int cantidad){
		
		int cantidad_bd=servicio.re_cantidad_existente(id_med);
		
		int cantidad_nueva=cantidad_bd-cantidad;
		return cantidad_nueva;
		
}
	
	/**
	 * este método hace la actualización de la cantidad de un medicamento y verificaciones
	 *@author Cerón Caballero Susan K.
	 * @param id del medicamento y cantidad solicitada
	 */
	public void act_cantidad(String id,int cantidad)
	{
		servicio.actualiza_cantidad(id,cantidad);
		
	}

	/**
	 * este método llama al calculo del pago total de medicamentos solicitados
	 *@author Cerón Caballero Susan K.
	 * @param precio y cantidad solicitada
	 * @return total del medicamento
	 */
	
	public float pago_total(int cantidad,float precio)
	{
		float total;
         
		return total=servicio.pagototal(cantidad,precio);
		
	}
}
