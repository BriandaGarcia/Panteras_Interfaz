package negocio1;

import java.util.ArrayList;
import negocio.dominio.Ficha_medica;
import negocio.dominio.Pago;

public interface ServicioConsulta {

	public boolean verificaServicio(String especialidad);
	
	public boolean actulizaDatos(String fecha,String observaciones);
	
	public ArrayList<Ficha_medica> verificaDisponibilidad(String IdDoctor, String Fecha);
		
	public boolean confirmaCita(String IdPaciente, String Fecha, String Hora);
	
	/**
	 * Interfaz del servicio de consulta
 	 * @param fech fecha de generacion del reporte
	 * @param hora Hora de la cual es la cita de la que se crea el reporte
	 * @param doctor doctor que generó el reporte
	 * @param paciente paciente del cual se generó el reporte
	 * @param servicio servicio del cual se hizo el reporte
	 * @param descripcion descripcion general de la consulta
	 * @return True si se almaceno correctamente, false si no.
	 */
	public boolean agregaReporteconsulta(String fech, String hora, String doctor, String paciente, String servicio, String descripcion);

	public boolean almacenaCita(int idpago, String idpaciente, String iddoctor, String fech, String h);

	public boolean verificaPago(int idpago);

	public ArrayList<Ficha_medica> consultaCitas(String fecha);
	//////////////////////////////////////////////////////////////////////
	//***isabel///////
	
	
	public boolean solicitud(String servi, String cantidad);

	
	public ArrayList<Pago> solicitudServicio();
////////////////////////////////////////////////////////////////////////////////

	/**
	 * Recupera las horas
	 * @param fecha Fecha de la cual se desea recuperar las horas
	 * @param paciente Paciente del cual se desea recuperar las horas
	 * @return Devuelve un ArrayList de tipo ficha medica, con todas las horas solicitadas
	 */
	public ArrayList<Ficha_medica> consultaHoras(String fecha, String paciente);
	
	
}
