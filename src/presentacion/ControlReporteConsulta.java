package presentacion;

import java.util.ArrayList;

import negocio.dominio.Ficha_medica;
import negocio1.ServicioConsulta;

/**
 * Clase que controla el funcionamiento de la generacion de reportes de consulta
 * @author Brianda Garcia 
 *
 */
public class ControlReporteConsulta {

	/**
	 * Ventana
	 */
	private VentanaReporteConsulta ventana;
	/**
	 * Servicio en la capa de negocio
	 */
	private ServicioConsulta servicioConsulta;
	
	/**
	 * Constructor
	 * @param servicio Servicio de consulta
	 */
	public ControlReporteConsulta(ServicioConsulta servicio) {
		this.servicioConsulta = servicio;
	}
		
	/**
	 * El control inicia la ventana para la HU de reporte de consulta
	 */
	public void inicia() {
		//El sistema muestra la ventana de reporte de consulta
		ventana = new VentanaReporteConsulta(this);
		ventana.abre();
	}
	
	/**
	 * Hace la comunicacion con el servicio de consulta
	 * @param fech fecha en la que se creo el reporte
	 * @param hora Hora de la cual es la cita de la que se crea el reporte
	 * @param doctor doctor que creo el reporte
	 * @param paciente paciente del cual se creo el reporte
	 * @param servicio servicio ofrecido en la consulta
	 * @param descripcion desccripcion general de la consulta
	 */
	public void guardaReporteConsulta(String fech, String hora, String doctor, String paciente, String servicio, String descripcion) {
		/**
		 * Valida que los campos no esten vacios
		 */
		if(hora.equals("") || doctor.equals("") || paciente.equals("") || descripcion.equals("")) {
			ventana.muestraMensaje("Campos vacios");
			ventana.abre();
		}
		else {
			/**
			 * Si todos los campos están llenos se comunica con el servicio para hacer el almacenamiento del reporte
			 * Si se almaceno correctamente, muestra un mensaje de exito
			 */
			if(servicioConsulta.agregaReporteconsulta(fech,hora,doctor,paciente,servicio,descripcion)) {
				ventana.muestraMensaje("Reporte guardado exitosamente");
				ventana.cierra();
			}
			/**
			 * En caso de que no se almacenara el reporte, muestra un mensaje de advertencia
			 */
			else {
				ventana.muestraMensaje("No se almacenó el reporte");
				ventana.abre();
			}
		}
	}

	/**
	 * Hace la comunicacion con el servicio para recuperar las horas
	 * @param fecha La fecha de la cual se desean recuperar las horas
	 * @param paciente Paciente del cual se desea recuperar las horas
	 * @return Devuelve un ArrayList de tipo ficha medica con todas las horas 
	 */
	public ArrayList<Ficha_medica> recuperaHoras(String fecha, String paciente) {
		ArrayList<Ficha_medica> horas = new ArrayList<Ficha_medica>();
		/**
		 * Valida que los campos no esten vacios
		 */
		if(paciente.equals("")) {
			ventana.muestraMensaje("Ingrese el Id Paciente");
			ventana.abre();
		}
		else {
			/**
			 * Si todos los campos están llenos se comunica con el servicio para recuperar las horas
			 */
			horas=servicioConsulta.consultaHoras(fecha,paciente);
			
			return horas;
		}
		return null;
	}
}