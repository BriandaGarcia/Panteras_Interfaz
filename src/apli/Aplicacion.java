package apli;

import datos.DAOCCruzRoja;

import negocio1.ServicioEmpleadoimp;
import negocio1.ServicioMedicamento;
import negocio1.ServicioMedicamentoImp;
import negocio1.ServicioPaciente;
import negocio1.ServicioUsuarioimp;
import negocio1.ServicioPacienteimp;
import negocio1.ServicioReporte;
import negocio1.ServicioReporteImp;
import negocio1.ServicioUsuario;
import negocio1.ServicioConsulta;
import negocio1.ServicioConsultaimp;
import negocio1.ServicioEmpleado;
import presentacion.*;

/***
 * @Programa: Sistema Cruz Roja
 * @Autores: Contreras Vázquez Carlos
 * 			 Ramírez Ortega Omar Daniel
 * 			 García Fernández Brianda Mariel
 * 			 Sangines Martinez Luis Fernando
 * 			 Cerón Caballero Susan Karen
 *        	 Franco Torres Isabel Estephanea   
 * @Descripcion: El sistema controla el funcionamiento de las actividades de administración de la Cruz Roja 
 * 
 */
public class Aplicacion {
	
	//Modulos de la aplicación
	private static ControlPrincipal controlPrincipal;
	private static ControlNuevoPpaciente control_nuevo_paciente;
	private static Controlagregaempleado control_agrega_empleado;
	private static ControlEliminaEmpleado control_elima_emp;
	private static ControlBusquedaPaciente controlBusquedaPaciente;
	private static ControlReporteFinanciero controlReporteFinanciero;
	private static ControlUsuario controlUsuario;
	private static ControlGeneraEspecialidad controlGeneraEspecialidad;
	private static ControlVerificacionPago controlVerificaPago;
	private static ControlFichaMedica controlFichaMedica;
	private static ControlExamenMedico controlExamenMedico;
	private static ControlReporteConsulta controlReporteConsulta;
	private static ControlAgendaCita controlAgendaCita;
	private static ControlConfirmaCita controlConfirmaCita;
	private static ControlPagoFarmacia controlPagoFarmacia;
	private static ControlSolicitudServicio controlSolicitudServicio;
	private static ControlBusquedaMedicamento controlBusquedaMedicamento;
	private static ControlAgregaMedicamento controlAgregaMedicamento;
	private static ControlActualizaMedicamento controlActualizaMedicamento;
	
	private static ServicioPaciente servicioPaciente;
	private static ServicioEmpleado servicio_empleado;
	private static ServicioReporte servicioReporte;
	private static ServicioConsulta servicioConsulta;
	private static ServicioUsuario servicioUsuario;
	private static ServicioMedicamento servicioMedicamento;

	private static DAOCCruzRoja dao;

	/**
	 * Inicia la aplicacion
	 * @param args
	 */
	public static void main(String[] args) {
		
		crea_y_conecta_modulos();
		controlPrincipal.inicia();
	}
	
	/**
	 *Conecta los modulos de la aplicación
	 */
	public static void crea_y_conecta_modulos() {
		dao=new DAOCCruzRoja();

		servicioUsuario = new ServicioUsuarioimp(dao);
		servicioPaciente=new ServicioPacienteimp(dao);
		servicio_empleado=new ServicioEmpleadoimp(dao);
		servicioReporte = new ServicioReporteImp(dao);
		servicioConsulta = new ServicioConsultaimp(dao);
		servicioMedicamento = new ServicioMedicamentoImp(dao);
		
		controlUsuario=new ControlUsuario(servicioUsuario);
		control_nuevo_paciente=new ControlNuevoPpaciente(servicioPaciente);
		control_elima_emp=new ControlEliminaEmpleado(servicio_empleado);
		control_agrega_empleado = new Controlagregaempleado(servicio_empleado);
		controlFichaMedica=new ControlFichaMedica(servicioPaciente);
		controlVerificaPago=new ControlVerificacionPago(servicioPaciente);
		controlExamenMedico=new ControlExamenMedico(servicioPaciente);
		controlBusquedaPaciente = new ControlBusquedaPaciente(servicioPaciente);
		controlGeneraEspecialidad = new ControlGeneraEspecialidad(servicioPaciente, servicioConsulta);
		controlReporteFinanciero = new ControlReporteFinanciero(servicioReporte);
		controlReporteConsulta = new ControlReporteConsulta(servicioConsulta);
		controlAgendaCita = new ControlAgendaCita(servicioConsulta);
		controlConfirmaCita = new ControlConfirmaCita(servicioConsulta);
		controlPagoFarmacia = new ControlPagoFarmacia(servicioReporte);
		controlSolicitudServicio=new ControlSolicitudServicio(servicioConsulta);
		controlBusquedaMedicamento = new ControlBusquedaMedicamento(servicioMedicamento);
		controlAgregaMedicamento = new ControlAgregaMedicamento(servicioMedicamento);
		controlActualizaMedicamento = new ControlActualizaMedicamento(servicioMedicamento);
		controlPrincipal=new ControlPrincipal(control_nuevo_paciente,control_agrega_empleado,
												control_elima_emp,controlBusquedaPaciente,controlReporteFinanciero,controlUsuario,
												controlGeneraEspecialidad,controlVerificaPago, controlFichaMedica, controlExamenMedico,
												controlReporteConsulta,controlAgendaCita,controlConfirmaCita,controlPagoFarmacia,
												controlSolicitudServicio,controlBusquedaMedicamento,controlAgregaMedicamento,
												controlActualizaMedicamento);		
		
	}
}