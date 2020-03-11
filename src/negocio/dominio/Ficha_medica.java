package negocio.dominio;

public class Ficha_medica {

	private String fecha;
	private String hora;
	private String numero_consultorio;
	private String doctor;
	private String paciente;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNumero_consultorio() {
		return numero_consultorio;
	}
	public void setNumero_consultorio(String numero_consultorio) {
		this.numero_consultorio = numero_consultorio;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor=doctor;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente=paciente;
	}
}
