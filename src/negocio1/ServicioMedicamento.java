package negocio1;

import java.util.ArrayList;

import negocio.dominio.Medicamento;

/**
 * Interfaz del servicio Medicamento. Contiene metodos abstractos
 * @author Cerón Caballero Susan Karen
 *        Franco Torres Isabel Estephanea
 *        García Fernández Brianda Mariel
 *
 */
public interface ServicioMedicamento {

/////Métodos de la clase//////
	/**
	 * Solicita agregar un nuevo medicamento a la BD
	 * @author Brianda Garcia
	 * @param id Id del nuevo medicamento que se desea agregar al sistema
	 * @param nombre Nombre del nuevo medicamento a almacenar
	 * @param costo Costo del nuevo medicamento
	 * @param cantidad Cantidad de medicamentos existentes al momento agregar al sistema
	 * @return Devuelve true si el medicamento se agregó con exito a la BD, false si no se agregó
	 */
	boolean registraMedicamento(String id, String nombre, String costo, String cantidad);
	
	/**
	 *@Descripción del método: Recupera el valor que regresa el metodo correspondiente del dao
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Sin parametros
	 *@Regresa: Regresa la lista de medicamentos 
	 *
	 */
	public ArrayList<Medicamento> recu_med();

	/**
	 *@Descripción del método: Recupera el valor que regresa el metodo correspondiente del dao
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: id del medicamento, nombre del medicamento,costo del medicamento y cantidad del medicamento
	 *@Regresa: Regresa true si la variable actualizacion tiene true, false si la variable tiene un valor false. 
	 *
	 */
	public boolean Actualiza_Medicamento(String id,String nombre,float costo,int cantidad);
	
	/*
	 * @autor Franco Torres Isabel Estephanea
	 * Se le pasa un nombre el cual se comunica con el DAO para recuperar un ArrayList de medicamentos
	 * @return ArrayList<Medicamento>
	 */
	public ArrayList<Medicamento> recuperaMedicamento(String nombre);
	/*
	 * @autor Franco Torres Isabel Estephanea
	 * Se comunica con el DAO para recuperar un ArrayList de medicamentos
	 * @return ArrayList<Medicamento>
	 */
	public ArrayList<Medicamento> recuperaMedicamento();
}
