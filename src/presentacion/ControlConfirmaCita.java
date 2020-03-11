package presentacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import negocio.dominio.Ficha_medica;
import negocio1.ServicioConsulta;

/**
 * Controla el funcionamiento de la confirmacion de citas
 * @author usuario
 *
 */
public class ControlConfirmaCita {

	//Ventana que despliega las citas a confirmar
	private VentanaConfirmaCita ventana;
	//Servicio
	private ServicioConsulta servicio;
	//Todas las citas que hay agendadas en el día
	ArrayList<Ficha_medica> citas=new ArrayList<Ficha_medica>();
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Constructor
	 * @param servicio
	 */
	public ControlConfirmaCita(ServicioConsulta servicio) {
		this.servicio=servicio;
	}

	/**
	 * Inicia la ventana para la HU
	 */
	public void inicia() {
		String fech=String.valueOf(dateFormat.format(fecha));
		citas=servicio.consultaCitas(fech);
		ventana= new VentanaConfirmaCita(this,citas,fech);
		ventana.abre();
	}

	/**
	 * Hace la comunicacion con el servicio para confirmar la cita deseada
	 * @param ficha la cita a confirmar
	 */
	public void confirmaCita(Ficha_medica ficha) {
		if(servicio.confirmaCita(ficha.getPaciente(),ficha.getFecha(),ficha.getHora())) {
			ventana.muestraMensaje("La cita se confirmó con exito");
			ventana.cierra();
		}
		else {
			ventana.muestraMensaje("La cita no se pudo confirmar");
		}
		
	}

}
