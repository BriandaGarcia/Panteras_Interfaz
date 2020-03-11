package presentacion;

import java.util.ArrayList;


import negocio.dominio.Medicamento;
import negocio1.ServicioMedicamento;

public class ControlBusquedaMedicamento {

	//Servicio
	private ServicioMedicamento servicio;
	//Ventana
	private VentanaBusquedaMedicamento ventana;
	//ArrayList<Medicamento> medicamento;
	
	public ControlBusquedaMedicamento(ServicioMedicamento servicio) {
		this.servicio=servicio;
	}

	public void inicia() {
		ventana=new VentanaBusquedaMedicamento(this );
		ventana.abre();
	}
	/*
	 * @autor Franco Torres Isabel Estephanea
	 * Se comunica con el servicio para recuperar un ArrayList de medicamentos
	 * @return ArrayList<Medicamento>
	 */
	public ArrayList<Medicamento> recuperaMedicamento(){
		return servicio.recuperaMedicamento();
	}
	
	/*
	 * @autor Franco Torres Isabel Estephanea
	 * Este metodo pasa el nombre del medicamento que pasa el usuario 
	 * @return ArrayList<Medicamento>
	 */
	public ArrayList<Medicamento> recuperaMedicamento(String nombre) {
		//Usuario introduce los datos del medicamento
		//Verifica primero que los datos no esten vacios
		if(nombre.equals("")) {
			ventana.muestraMensaje("Ingresa el nombre del medicamento");
		}
		else {
			ArrayList<Medicamento> medicamento = new ArrayList<Medicamento>();
			//Se recibe el historial medico del paciente
			medicamento=servicio.recuperaMedicamento(nombre);
			//Valida que sea un paciente existente
			if(medicamento.size()==0) {
				ventana.muestraMensaje("No existe ese medicamento");
			}
			else {
				return medicamento;
			}
		}
		ventana.cierra();
		return null;
	}

}
