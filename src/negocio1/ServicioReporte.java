package negocio1;

import java.util.ArrayList;

import negocio.dominio.Reporte;

/**
 * Interface del servicio reporte
 * @author Brianda Garcia
 *
 */
public interface ServicioReporte {
	
	/**
	 * Consulta los servicios requeridos en un periodo determinado
	 * @param periodo el periodo en el que se requirieron los servicios
	 * @param año 
	 * @return regresa una lista de tipo Reporte con toda la informacion de los pagos realizados en el periodo solicitado
	 */

	public ArrayList<Reporte> consultaServicio(String mes, String año);

	//public ArrayList<Reporte> consultaServicio(String periodo);
	
///////////////////////////////////////////////////////////////////////////////////////////////////	
/**
 * metodos que se utilizaron para el segundo Sprint
 * @autor: Cerón caballero Susan K.
 * 
 */
	public boolean recupera_nombre_medicamento(String nombre_m);

	public float recupera_costo(String nombre);
	
	public int re_cantidad_existente(String nombre);
	
	public float pagototal(int cantidad,float precio);
	
	public int actualiza_cantidad(String id,int cantidad);
	
	public String recupera_id(String nombre);
}

