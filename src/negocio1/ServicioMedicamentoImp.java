package negocio1;

import java.util.ArrayList;

import datos.DAOCruzRoja;
import negocio.dominio.Medicamento;

/**
 *Implementacion del servicio Medicamento.Esta clase contiene metodos para recuperar resultados que arrojan los metodos del dao
 *@Autor: Cerón Caballero Susan Karen
 *        Franco Torres Isabel Estephanea
 *        García Fernández Brianda Mariel 
 *
 */
public class ServicioMedicamentoImp implements ServicioMedicamento {

//////Declaración de la variables globales para esta clase/////
	private DAOCruzRoja dao;
	
/////Métodos de la clase//////
	
	/**
	 * Constructor del servicio
	 * @param dao Dao a utilizar
	 */
	public ServicioMedicamentoImp(DAOCruzRoja dao) {
		//Inicializa el dao global, con el dao recibido como parametro
		this.dao=dao;
	}

	/**
	 * Se comunica con el DAO para agregar un nuevo medicamento al sistema
	 * @author Brianda Garcia
	 * @param id Id del nuevo medicamento que se desea agregar al sistema
	 * @param nombre Nombre del nuevo medicamento a almacenar
	 * @param costo Costo del nuevo medicamento
	 * @param cantidad Cantidad de medicamentos existentes al momento agregar al sistema
	 * @return Devuelve true si el medicamento se agregó con exito a la BD, false si no se agregó
	 */
	@Override
	public boolean registraMedicamento(String id, String nombre, String costo, String cantidad) {
		//Llama a Dao para agregar un nuevo medicamento, si se agrega correctamente devuelve true
	    if(dao.agregaMedicamento(id,nombre,costo,cantidad)) {
	    	return true;
	    }
	    else //si hay un problema en registrar el medicamento devuelve false
	    	return false;
	}

	/**
	 *@Descripción del método: Recupera el valor que regresa el metodo correspondiente del dao
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Sin parametros
	 *@Regresa: Regresa la lista de medicamentos 
	 *
	 */
   @Override
   public ArrayList<Medicamento> recu_med()
   {
    ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    //Guarda la lista
	medicamentos=dao.recupera_medicamentos();
	
	return medicamentos;		
   }
   
   /**
    *@Descripción del método: Recupera el valor que regresa el metodo correspondiente del dao
    *@Autor: Cerón Caballero Susan Karen.
    *@Parametros de entrada: id del medicamento, nombre del medicamento,costo del medicamento y cantidad del medicamento
    *@Regresa: Regresa true si la variable actualizacion tiene true, false si la variable tiene un valor false. 
    *
    */
   @Override
   public boolean Actualiza_Medicamento(String id, String nombre, float costo, int cantidad)
   {
	//La varaible actualizacion guarda true o false
    boolean actualizacion =dao.Actualiza_Medicamento_(id, nombre, costo, cantidad);
	if(actualizacion==true)
	{
		return true;
	}
	else{
		return false;
	}
		
  }
   
   /*
	 * @autor Franco Torres Isabel Estephanea
	 * Se comunica con el DAO para recuperar un ArrayList de medicamentos
	 * @return ArrayList<Medicamento>
	 */
	public ArrayList<Medicamento> recuperaMedicamento(){
		return dao.recuperaMedicamento();
	}
	/*
	 * @autor Franco Torres Isabel Estephanea
	 * Se le pasa un nombre el cual se comunica con el DAO para recuperar un ArrayList de medicamentos
	 * @return ArrayList<Medicamento>
	 */
	public ArrayList<Medicamento> recuperaMedicamento(String nombre){
		ArrayList<Medicamento> nombreMedicamento = new ArrayList<Medicamento>();
		nombreMedicamento=dao.recuperaMedicamento(nombre);
		return nombreMedicamento;
	}

}
