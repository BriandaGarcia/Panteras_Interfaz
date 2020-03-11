package datos;

import java.util.ArrayList;

import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.Ficha_medica;
import negocio.dominio.HistorialMedico;
import negocio.dominio.Medicamento;
import negocio.dominio.Paciente;
import negocio.dominio.Pago;
import negocio.dominio.Recepcionista;
import negocio.dominio.Reporte;

/**
 * Interfaz del dao
 * @author 
 *
 */
public interface DAOCruzRoja {
		
	public ArrayList<Doctor> recuperaAllempleadosDoc();
	
	public ArrayList<Recepcionista> recuperaAllempleadosRec();
	
	public boolean crea_empleadoDoc(Empleado empleado);
	
	public boolean crea_empleadoRecep(Empleado empleado);
	
	public boolean elimina_empleado(String ID);
	
	/**
	 * Recupera historial medico de un paciente
	 * @param IDPaciente id del paciente del cual se quiere recuperar el historial medico
	 * @return Devuelve el historial medico
	 */
    public ArrayList<HistorialMedico> recuperaHistorialMedico(String IDPaciente);
	
	public Paciente recuperaPaciente(int idPago);
	
	public Paciente recuperaPaciente(String idPaciente);
	
	public Pago recuperaPago(int Pago);

	/**
	 * Recupera los servicios prestados en un periodo deterinado
	 * @param periodo el periodo del cual se recuperan los pagos y servicios
	 * @param año  Año del cual se desea crear el reporte financiero 
	 * @param mes Mes del cual se desea crear el reporte
	 * @return Devuelve un reporte financiero
	 */
	public ArrayList<Reporte> recuperaServicio(String mes, String año);

	boolean crea_paciente(Paciente paciente);
	
	public String verificaUsuario(String nombre, String contra);

	public String recuperaNombrePaciente(String idPaciente);

	public String recuperaCURPPaciente(String idPaciente);

	boolean recuperaIDPaciente(String idPaciente);

	boolean recuperaEspecialidad(String especialidad);

	public ArrayList<Ficha_medica> recuperaCita(String idDoctor, String fecha);

	public boolean confirmaCita(String idPaciente, String fecha, String hora);

	/**
	 * Almacena los reportes de consulta
	 * @param fech Fecha de creacion del reporte
	 * @param hora Hora de la cual es la cita de la que se crea el reporte
	 * @param doctor Doctor que crea el reporte
	 * @param paciente Paciente al que pertenece el reporte
	 * @param servicio Servicio del cual se hizo el reporte de consulta
	 * @param descripcion Descripcion del reporte de consulta
	 * @return True si se almacenó correctamente el reporte, false en caso contrario
	 */
	public boolean guardaReporteConsulta(String fech, String hora, String doctor, String paciente, String servicio, String descripcion);

	public boolean guardaCita(int idpago, String idpaciente, String iddoctor, String fech, String h);

	public boolean verificaPago(int idpago);

	public ArrayList<Ficha_medica> recuperaCitas(String fecha);
	//////////////////////////////////////////////////////////////////
	public boolean rec_nombre_med(String nom_m);
	public float precio(String nombre);
	public int recu_cantidad(String nombre);
	public int actualiza_cantidad(String id,int cantidad_nueva);
	public String recu_id(String nombre);
	
	
//////////////////////////////////////////////////////////////////////////
	
	public ArrayList<Pago> solicitudServicio();
	
	public boolean solicitudServicio(String servi, String cantidad);
/////////////////////////////////////////////////////////////////////////////////

	/**
	 * Almacena un nuevo medicamento que se desea agregar a la BD
	 * @author Brianda Garcia
	 * @param id Id del nuevo medicamento que se desea agregar a la BD
	 * @param nombre Nombre del nuevo medicamento que se desea almacenar
	 * @param costo Costo del nuevo medicamento
	 * @param cantidad Cantidad existente de medicamentos al momento de agregar a la BD
	 * @return True si se agrega el medicamento correctamente, false en caso contrario
	 */
	public boolean agregaMedicamento(String id, String nombre, String costo, String cantidad);
/////////////////////////////////////////////////////////////////////////////////
	
	/**
	 *@Descripción del método: Recupera en un array la infomación de todos los medicamentos
	 *existentes
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Sin parametros
	 *@Regresa: Regresa una lista de todos los medicamentos con su respectiva informacion(id, nombre, costo, cantidad) 
	 *
	 */
	public ArrayList<Medicamento> recupera_medicamentos();
	
	/**
	 *@Descripción del método: Hace la actualización de un medicamento, donde se le pasa el id que no es cambiado. se le pasa
	 *el nombre, costo y cantidad que probablemente fueron cambiados para su actualización.
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: id del medicamento, nombre del medicamento,costo del medicamento y cantidad del medicamento
	 *@Regresa: Regresa true si la actualización tuvo exito, false si no. 
	 *
	 */
	public boolean Actualiza_Medicamento_(String id,String nombre,float costo,int cantidad);
	
/////////////////////////////////////////////////////////////////////////////////
	
	/**
	* Recupera los datos del medicamento registrado en el dao, id, nombre, costo y cantidad
	* @autor Franco Torres Isabel Estephanea
	*  @return Devuelve un medicamento que esta a la venta en farmacia
	*/

	public ArrayList<Medicamento> recuperaMedicamento();

	/**
	 * Recupera el nombre del medicamento cuando le pasan el nombre del medicamento que va a buscar
	 * @autor Franco Torrres Isabel Estephanea
	 *  @return Devuelve el nombre del medicamento
	 */
	public ArrayList<Medicamento> recuperaMedicamento(String nombre);

	/**
	 *Recupera las horas solicitadas de la BD 
	 * @param fecha Fecha de la cual se desea recuperar las horas
	 * @param paciente Paciente del cual se desean recuperar las horas 
	 * @return Devuelve un ArrayList de tipo ficha medica con todas las horas solicitadas.
	 */
	public ArrayList<Ficha_medica> recuperaHoras(String fecha, String paciente);

}