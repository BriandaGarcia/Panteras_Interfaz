package presentacion;

import java.util.ArrayList;

import negocio.dominio.Ficha_medica;
import negocio1.ServicioConsulta;

/**
 * Controla el funcionamiento de la agendacion de citas
 * @author usuario
 *
 */
public class ControlAgendaCita {

	//Servicio
	private ServicioConsulta servicio;
	//Ventana para agendar citas
	private VentanaAgendaCita ventana;
	//Ventana que verifica la disponibilidad de horarios
	private VentanaVerificaCitas ventana2;
	//Las consultas que hay agendadas en el día seleccionado
	ArrayList<Ficha_medica> consultas;
	
	/**
	 * Constructor
	 * @param servicio
	 */
	public ControlAgendaCita(ServicioConsulta servicio) {
		this.servicio=servicio;
	}

	/**
	 * Inicia la ventana para la HU
	 */
	public void inicia() {
		ventana=new VentanaAgendaCita(this);
		ventana.abre();
	}

	/**
	 * Hace la comunicacion con el servicio para recuperar todas las citas agendadas en el día seleccionado
	 * @param iddoctor doctor del cual queremos verificar las citas agendadas
	 * @param fech fecha en la que verificamos las citas agendadas
	 */
	public void verificaDisponibilidad(String iddoctor, String fech) {
		if(iddoctor.equals("") || fech.equals("")) {
			ventana.muestraMensaje("Campos vacios");
		}
		else {
			ArrayList<Ficha_medica> consultas = new ArrayList<Ficha_medica>();
			consultas=servicio.verificaDisponibilidad(iddoctor, fech);
			ventana2=new VentanaVerificaCitas(this, consultas, iddoctor, fech);
			if(consultas.size()==0) {
				ventana.muestraMensaje("No hay ninguna cita alacenada ese día");
			}
			else {
				ventana2.abre();
			}
		}
	}

	/**
	 * Hace la comunicacion con el servicio para guardar la cita solicitada
	 * @param idpago 
	 * @param idpaciente
	 * @param iddoctor
	 * @param fech
	 * @param h
	 */
	public void almacenaCita(int idpago, String idpaciente, String iddoctor, String fech, String h) {
		if(servicio.verificaPago(idpago)) {
			if(servicio.almacenaCita(idpago,idpaciente,iddoctor,fech,h)) {
				ventana.muestraMensaje("Cita almacenada exitosamente");
				ventana.cierra();
			}
			else {
				ventana.muestraMensaje("No se ha almacenado la cita");
				ventana.cierra();
			}
		}
		else {
			ventana.muestraMensaje("No se ha encontrado el pago por el servicio");
			ventana.cierra();
		}
	}
}
