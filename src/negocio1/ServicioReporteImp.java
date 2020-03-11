package negocio1;


import java.util.ArrayList;

import datos.DAOCruzRoja;
import negocio.dominio.Reporte;

/**
 * Implementacion del servicio reporte
 * @author Brianda Garcia
 *
 */
public class ServicioReporteImp implements ServicioReporte{
	
	private DAOCruzRoja dao;
	
	
	/**
	 * Constructor
	 * @param dao
	 */
	public ServicioReporteImp(DAOCruzRoja dao) {
		this.dao=dao;
	}

	/**
	 * Se comunica con el DAO de servicio para recuperar los servicios prestados en el periodo establecido
	 * @param periodo El periodo que se quiere consultar
	 * @return Devuelve una lista de tipo reporte
	 */
	public ArrayList<Reporte> consultaServicio(String mes, String año) {

		ArrayList<Reporte> reporte = new ArrayList<Reporte>();
		//Recibe la lista 
		reporte=dao.recuperaServicio(mes,año);
		return reporte;
	}
///////////////////////////////////////////////////////////////////////////
	/**
	 * este método recupera el nombre del medicamento desde el dao
	 *@author Cerón Caballero susan K.
	 * @param nombre del medicamdento
	 * @return false si no lo encuentra, true si lo encuentra
	 */

	@Override
	public boolean recupera_nombre_medicamento(String nombre_m) {
		
		if(dao.rec_nombre_med(nombre_m)==true){
			
			return true;
		}
		else
			return false;
		
	}
	/**
	 * este método recupera el costo del medicamento
	 *@author Cerón Caballero susan K.
	 * @param nombre del medicamdento
	 * @return regresa precio si es distinto de 0 si no regresa 0
	 */
	@Override
	public float recupera_costo(String nombre) {
		float precio;
		if(dao.precio(nombre)!=0)
		{
			return precio=dao.precio(nombre);
		}
		else
		{
			return 0;
		}
	
	}
	/**
	 * este método regresa la cantidad que existe en la base de datos
	 *@author Cerón Caballero susan K.
	 * @param id del medicamento
	 * @return la cantidad que existe en la base de datos
	 */

	@Override
	public int re_cantidad_existente(String id) {
		int cantidad_existente;
		
		return cantidad_existente=dao.recu_cantidad(id);
	}

	/**
	 * este método hace el calculo del total de pago de farmacia de los medicamentos solicitados
	 *@author Cerón Caballero susan K.
	 * @param cantidad que se le solicitó, precio del medicamento
	 * @return total del pago 
	 */
	@Override
	public float pagototal(int cantidad, float precio) {
		
		float total;
		total=cantidad*precio;
		return total;
	}
	/**
	 * este método actualiza la cantidad existente de un medicamento en la base de datos
	 *@author Cerón Caballero susan K.
	 * @param id del mediacamento a modificar y cantidad que se solicita para la venta
	 * @return la nueva cantidad de medicamento que hay en la base de datos
	 */

	@Override
	public int actualiza_cantidad(String id, int cantidad) {
		int cantidad_en_bd=dao.recu_cantidad(id);
		int nueva_cantidad=(cantidad_en_bd-cantidad);
		
		
		if(nueva_cantidad>=0)
		{
			dao.actualiza_cantidad(id,nueva_cantidad);
		}
		
		
	return nueva_cantidad;
		
		
	}
	/**
	 * este método recupera el id del medicamento
	 *@author Cerón Caballero Susan K.
	 * @param nombre del medicamdento
	 * @return el id del medicamento
	 */

	@Override
	public String recupera_id(String nombre) {
		
		return dao.recu_id(nombre);
	}
	
}