package presentacion;

import negocio1.ServicioConsulta;


/**
 * @autor Franco Torres Isabel Estephanea 
 * Hace la comunicacion con el servicio de consulta
 * paciente paciente del cual se solicita el servicio
 * servicio tipo de servicio ofrecido en la consulta
 * catidad costo del servicio solicitado
 * 
 */


public class ControlSolicitudServicio {

	//Servicio
	private ServicioConsulta servicio;
	//Ventana
	private VentanaPagoServicio ventana;
		
	public ControlSolicitudServicio(ServicioConsulta servicioConsulta) {
		this.servicio=servicioConsulta;
	}

	public void inicia() {
		ventana=new VentanaPagoServicio(this, servicio.solicitudServicio());
		ventana.abre();
	}
	
	public void solicitudServicio(String servicios, String cantidad) {
		/**
		 * Valida que los campos no esten vacios
		 */
		if( servicios.equals("")|| cantidad.equals("")) {
			ventana.muestraMensaje("Campos vacios");
			ventana.abre();
		}
		else {
			/**
			 * Si todos los campos están llenos se comunica con el servicio para hacer el almacenamiento del reporte
			 * Si se almaceno correctamente, muestra un mensaje de exito
			 */
			if(servicio.solicitud(servicios,cantidad)) {
				ventana.muestraMensaje("Solicitud  exitosa");
				ventana.cierra();
			}
			/**
			 * En caso de que no se almacenara el reporte, muestra un mensaje de advertencia
			 */
			else {
				ventana.muestraMensaje("imprimir");
				ventana.abre();
			}
		}
	}
}
