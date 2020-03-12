package negocio1;

import java.util.ArrayList;

import datos.DAOCruzRoja;
import negocio.dominio.Ficha_medica;
import negocio.dominio.Pago;

public class ServicioConsultaimp implements ServicioConsulta{
	
	private DAOCruzRoja dao;

	public ServicioConsultaimp(DAOCruzRoja dao) {
		this.dao=dao;
	}

	@Override
	public boolean verificaServicio(String especialidad) {
		if(dao.recuperaEspecialidad(especialidad)) { //llama al DAO para verificar existencia del servicio
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean actulizaDatos(String fecha, String observaciones) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Ficha_medica> verificaDisponibilidad(String IdDoctor, String Fecha) {
		ArrayList<Ficha_medica> consulta = new ArrayList<Ficha_medica>();
		//Recibe la lista
		consulta=dao.recuperaCita(IdDoctor,Fecha);
		return consulta;
	}

	public boolean confirmaCita(String IdPaciente, String Fecha, String Hora) {
		if(dao.confirmaCita(IdPaciente,Fecha,Hora)) {
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Hace la conexion con el DAO pasandole los parametros recibidos
	 */
	@Override
	public boolean agregaReporteconsulta(String fech,String doctor, String paciente, String servicio, String descripcion) {
		if(dao.guardaReporteConsulta(fech,doctor,paciente,servicio,descripcion)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean almacenaCita(int idpago, String idpaciente, String iddoctor, String fech, String h) {
		if(dao.guardaCita(idpago,idpaciente,iddoctor,fech,h)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean verificaPago(int idpago) {
		if(dao.verificaPago(idpago)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public ArrayList<Ficha_medica> consultaCitas(String fecha) {
		ArrayList<Ficha_medica> citas = new ArrayList<Ficha_medica>();
		//Recibe la lista
		citas=dao.recuperaCitas(fecha);
		return citas;
	}
//////////////////////////////////////////////////////////////////////////
	//****isabel/////
	@Override
	public boolean solicitud(String servicios, String cantidad) {
		if(dao.solicitudServicio(servicios,cantidad)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public ArrayList<Pago> solicitudServicio() {
		ArrayList<Pago> servicio = new ArrayList<Pago>();
		//Recibe la lista
		servicio=dao.solicitudServicio();
		return servicio;
	}

	/**
	 * Recupera las horas del DAO
	 */
	@Override
	public ArrayList<Ficha_medica> consultaHoras(String fecha, String paciente) {
		ArrayList<Ficha_medica> horas = new ArrayList<Ficha_medica>();
		//Recibe la lista
		horas=dao.recuperaHoras(fecha,paciente);
		return horas;
	}

}
