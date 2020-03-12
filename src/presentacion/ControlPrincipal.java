package presentacion;

import datos.ManejadorBaseDatos;
import negocio1.ServicioPaciente;
import negocio1.ServicioUsuarioimp;

public class ControlPrincipal {
	//Ventana Principal
	private VentanaPrincipal ventana;
	private VentanaDoctor ventanaDoc;
	private VentanaRecepcionista ventanaRec;
	private VentanaFarmaceutica ventanaFarma;
	private VentanaDoctorAux ventanaDocAux;
	private VentanaRecepcionistaAux ventanaRecAux;
	private VentanaFarmaceuticaAux ventanaFarmaAux;
	
	private  ControlNuevoPpaciente control_nuevo_paciente;
	private ControlEliminaEmpleado control_elimina_emp;
	private Controlagregaempleado control_agrega_empleado;
	private ControlBusquedaPaciente controlBusquedaPaciente;
	private ControlReporteFinanciero controlReporteFinanciero;
	private ControlUsuario control_Usuario;
	private ControlGeneraEspecialidad controlGeneraEspecialidad;
	private ControlVerificacionPago controlVerificaPago;
	private ControlFichaMedica controlFichaMedica;
	private ControlExamenMedico controlExamenMedico;
	private ControlReporteConsulta controlReporteConsulta;
	private ControlAgendaCita controlAgendaCita;
	private ControlConfirmaCita controlConfirmaCita;
	private ControlPagoFarmacia controlPagoFarmacia;
	private ControlSolicitudServicio controlSolicitudServicio;
	private ControlBusquedaMedicamento controlBusquedaMedicamento;
	private ControlAgregaMedicamento controlAgregaMedicamento;
	private ControlActualizaMedicamento controlActualizaMedicamento;
	
	public ControlPrincipal(ControlNuevoPpaciente control_nuevo_paciente,Controlagregaempleado control_agrega_empleado,
			ControlEliminaEmpleado control_elimina_emp,ControlBusquedaPaciente controlBusquedaPaciente,
			ControlReporteFinanciero controlReporteFinanciero, ControlUsuario control_Usuario, ControlGeneraEspecialidad controlGeneraEspecialidad,
			ControlVerificacionPago controlVerificaPago, ControlFichaMedica controlFichaMedica, ControlExamenMedico controlExamenMedico, 
			ControlReporteConsulta controlReporteConsulta,ControlAgendaCita controlAgendaCita, ControlConfirmaCita controlConfirmaCita, 
			ControlPagoFarmacia controlPagoFarmacia, ControlSolicitudServicio controlSolicitudServicio,
			ControlBusquedaMedicamento controlBusquedaMedicamento, ControlAgregaMedicamento controlAgregaMedicamento,
			ControlActualizaMedicamento controlActualizaMedicamento) {
		this.control_nuevo_paciente=control_nuevo_paciente;
		this.control_elimina_emp=control_elimina_emp;
		this.control_agrega_empleado=control_agrega_empleado;
		this.controlBusquedaPaciente=controlBusquedaPaciente;
		this.controlGeneraEspecialidad=controlGeneraEspecialidad;
		this.controlReporteFinanciero=controlReporteFinanciero;
		this.control_Usuario=control_Usuario;
		this.controlVerificaPago=controlVerificaPago;
		this.controlFichaMedica=controlFichaMedica;
		this.controlExamenMedico=controlExamenMedico;
		this.controlReporteConsulta=controlReporteConsulta;
		this.controlAgendaCita=controlAgendaCita;
		this.controlConfirmaCita=controlConfirmaCita;
		this.controlPagoFarmacia=controlPagoFarmacia;
		this.controlSolicitudServicio=controlSolicitudServicio;
		this.controlBusquedaMedicamento=controlBusquedaMedicamento;
		this.controlAgregaMedicamento=controlAgregaMedicamento;
		this.controlActualizaMedicamento=controlActualizaMedicamento;
	}
	
	/*
	 * Inicia el control principal
	 */
	public void inicia() {
		ventana=new VentanaPrincipal(this);
		ventana.abre();
	}
	
	public void cerrarsecion() {
		ventana.abre();
	}
	
	/*
	 * Inicia la historia de usuario de nuevo paciente
	 */
	public void ventanaDoc() {
		ventanaDoc=new VentanaDoctor(this);
		ventanaDoc.abre();
	}
	
	public void ventanaRec() {
		ventanaRec=new VentanaRecepcionista(this);
		ventanaRec.abre();
	}
	
	public void ventanaFarma() {
		ventanaFarma=new VentanaFarmaceutica(this);
		ventanaFarma.abre();
	}
	public void ventanaDocAux(int i) {
		ventanaDocAux=new VentanaDoctorAux(this);
		ventanaDocAux.abre(i);
	}
	
	public void ventanaRecAux(int i) {
		ventanaRecAux=new VentanaRecepcionistaAux(this);
		ventanaRecAux.abre(i);
	}
	
	public void ventanaFarmaAux(int i) {
		ventanaFarmaAux=new VentanaFarmaceuticaAux(this);
		ventanaFarmaAux.abre(i);
	}
	
	
	public String login(String nombre, String contra) {
		return control_Usuario.verificaUsuario(nombre, contra);
	}
	
	public  void nuevo_paciente() {
		control_nuevo_paciente.inicia();
	}
	public void agrega_emplado() {
		control_agrega_empleado.inicia();
	}
	public void eliminaEmpleado() {
		control_elimina_emp.inicia();
	}

	/**
	 * Inicia la historia de usuario de busqueda de paciente
	 */
	public void busquedaPaciente() {
		controlBusquedaPaciente.inicia();
	}
	
	/**
	 * Inicia la historia de usuario de reporte financiero
	 */
	public void reporteFinanciero() {
		controlReporteFinanciero.inicia();
	}
	
	public void termina() {
		ManejadorBaseDatos.shutdown();
		
	}

	public void generaPase() {
		controlGeneraEspecialidad.inicia();
		
	}
	
	public void verificaPago() {
		controlVerificaPago.inicia();
	}
	
	public void generaExamenMedico() {
		controlExamenMedico.inicia();
	}
	
	/**
	 *Inicia la historia de usuario de Reporte de consulta 
	 */
	public void reporteConsulta() {
		controlReporteConsulta.inicia();
	}
	
	public void agendaCita() {
		controlAgendaCita.inicia();
	}
	
	/**
	 * Inicia la historia de usuario de confirmar una cita
	 */
	public void confirmaCita() {
		controlConfirmaCita.inicia();
	}

	public void pagoFarmacia() {
		controlPagoFarmacia.ventana_pago_farmacia();
	}
	
	public void pagoServicio() {
		controlSolicitudServicio.inicia();
	}
	
	public void busquedaMedicamento() {
		controlBusquedaMedicamento.inicia();
	}
	
	/**
	 * Inicia la historia de usuario de agregar un nuevo medicamento
	 */
	public void agregaMedicamento() {
		controlAgregaMedicamento.inicia();
	}
	
	public void actualizaMedicamento() {
		controlActualizaMedicamento.inicia();
	}
	
}
