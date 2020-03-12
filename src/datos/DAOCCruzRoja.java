package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.derby.impl.sql.execute.rts.RealUpdateResultSetStatistics;

import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.Ficha_medica;
import negocio.dominio.HistorialMedico;
import negocio.dominio.Medicamento;
import negocio.dominio.Paciente;
import negocio.dominio.Pago;
import negocio.dominio.Recepcionista;
import negocio.dominio.Reporte;
import datos.ManejadorBaseDatos;

/**
 * Implementacion del dao
 * @author 
 *
 */
public class DAOCCruzRoja implements DAOCruzRoja {

	/**
	 * Constructor
	 */
	public DAOCCruzRoja() {
		// TODO Auto-generated constructor stub
	}

	@Override /* Metodo para saber si el id del Paciente existe en la base de datos*/
	public boolean recuperaIDPaciente(String idPaciente) {
		int bandera = 1; //bandera para saber si el id del paciente existe (es 0 si existe, es 1 si no)
		try{
			//crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT idPaciente FROM Paciente WHERE idPaciente= '"+idPaciente+"'");
			
			while(rs.next()) {
				if (rs.getString("idPaciente") == "NULL") { //se refiere a que no se encontro el id del paciente
					bandera=1;
				}
				else {
					bandera=0;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}	
		if(bandera==0)
			return true;
		else
			return false;
	}

	@Override /*metodo parasaber si la especialidad existe en la base de datos*/
	public boolean recuperaEspecialidad(String especialidad) {
		int bandera = 1; //bandera, es 0 si existe la especialidad, es 1 si no.
		try{
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT tipo FROM Servicio WHERE tipo= '"+especialidad+"'");
			
			while(rs.next()) {
				if (rs.getString("tipo") == "NULL") { //si la especialidad no se encuentra
					bandera=1;
				}
				else {
					bandera=0;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}	
		if(bandera==0)
			return true;
		else
			return false;
	}
	
	@Override /*metodo para recuperar el nombre completo del paciente relacionado con el id del paciente*/
	public String recuperaNombrePaciente(String idPaciente) {
		String nombreCompleto=null, nombre = null, apellido=null;
		try{
			//crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT nombre,apellido FROM Paciente WHERE idPaciente= '"+idPaciente+"'");
			
			while(rs.next())
			{
				nombre=rs.getString("nombre"); //recupera el nombre del paciente
				apellido=rs.getString("apellido"); //recupera el apellido del paciente
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		nombreCompleto = nombre.concat(" "+apellido); //concatena nombre y apellido
		return nombreCompleto; //regresa el nombre completo
	}
	
	@Override /*Metodo para recuperar el CURP de un paciente relacionado con su id*/
	public String recuperaCURPPaciente(String idPaciente) {
		String curp=null;
		try{
			//crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT curp FROM Paciente WHERE idPaciente= '"+idPaciente+"'");
			
			while(rs.next())
			{
				curp=rs.getString("curp"); //recupera curp del paciente
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return curp; //regresa el curp
	}

	@Override
	public ArrayList<Doctor> recuperaAllempleadosDoc() {
		ArrayList <Doctor> empleado = new ArrayList<Doctor>();
		Doctor emp=null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT iddoc,nombre,apellido,cedulaprofesional FROM Doctor");

			
			while(rs.next())
			{
			
				emp=new Doctor();
				emp.setId_empleado(rs.getString("iddoc"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setCedulaProfesional(rs.getString("cedulaprofesional"));
				empleado.add(emp);
				
				
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return empleado;
	}
	
	public ArrayList<Recepcionista> recuperaAllempleadosRec(){
		
		ArrayList <Recepcionista> empleado = new ArrayList<Recepcionista>();
		Recepcionista emp=null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT idrecep,nombre,apellido FROM Recepcionista");

			
			while(rs.next())
			{
			
				emp=new Recepcionista();
				emp.setId_empleado(rs.getString("idrecep"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				empleado.add(emp);
				
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return empleado;
		
	}

	@Override /*Metodo para crear un nuevo empleado (Doctor) en la base de datos*/
	public boolean crea_empleadoDoc(Empleado empleado) {
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion 
			/*Agrega al doctor a la base de datos*/
			statement.execute("INSERT INTO Doctor VALUES ('"+empleado.getId_empleado()+"','"+empleado.getNombre()+"','"+empleado.getApellido()+"','"+empleado.getFecha_ingreso()+"',"+empleado.getEdad()+",'"+empleado.getTelefono()+"','"+empleado.getEmail()+"','"+empleado.getSexo()+"','"+empleado.getCedulaProfesional()+"','"+empleado.getEspecialidad()+"','"+empleado.getHorario()+"','"+empleado.getDireccion()+"')");
			/*Crea su usuario y contraseña en la base de datos */
			statement.execute("INSERT INTO login VALUES ('"+empleado.getId_empleado()+"','"+empleado.getNombre()+"','Doctor')");
			return true;
			
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}
	
	@Override /*Metodo para crear un nuevo empleado (Recepcionista) en la base de datos*/
	public boolean crea_empleadoRecep(Empleado empleado) {
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			/*agrega los datos del recepcionista a la tabla correspondiente*/
			statement.execute("INSERT INTO Recepcionista VALUES ('"+empleado.getId_empleado()+"','"+empleado.getNombre()+"','"+empleado.getApellido()+"','"+empleado.getFecha_ingreso()+"',"+empleado.getEdad()+",'"+empleado.getTelefono()+"','"+empleado.getEmail()+"','"+empleado.getSexo()+"','"+empleado.getEscolaridad()+"','"+empleado.getDireccion()+"','"+empleado.getHorario()+"')");
			/*Crea su usaurio y contraseña del recepcionista*/
			statement.execute("INSERT INTO login VALUES ('"+empleado.getId_empleado()+"','"+empleado.getNombre()+"','Recepcionista')");
			return true;
			
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean elimina_empleado(String ID) {
		System.out.println("Empleado a eliminar: "+ID);
		
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			
			statement.execute("DELETE FROM Doctor where iddoc='"+ID+"' ");
			statement.execute("DELETE FROM Recepcionista where idrecep='"+ID+"' ");
	
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		
	}

	/**
	 * Recupera un ArrayList de tipo Historial Medico
	 * @param IDPaciente El paciente del cual se recupera su historial medico
	 * @return Devuelve una lista con el historial medico del paciente
	 */
	public ArrayList<HistorialMedico> recuperaHistorialMedico(String IDPaciente) {
		
		ArrayList<HistorialMedico> historial = new ArrayList<HistorialMedico>();
		HistorialMedico hist=null;
		
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe los resultados
			ResultSet rs = statement.executeQuery("SELECT Fecha,observaciones FROM consulta WHERE idPaciente='"+IDPaciente+"' ");
			//Guarda cada resultado en un objeto de tipo historial medico
			while(rs.next()) {
				hist= new HistorialMedico();
				hist.setFecha(rs.getString("Fecha"));
				hist.setObservaciones(rs.getString("observaciones"));
				historial.add(hist);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//Devuelve el historial medico lleno
		return historial;
	}

	@Override
	public Paciente recuperaPaciente(int idPago) {
		// TODO Auto-generated method stub
		try {
			Paciente paciente = null;
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del paciente que se encuentra en la base de datos
			ResultSet rs = statement.executeQuery("SELECT idPaciente, edad, nombre, apellido, sexo, curp FROM Paciente where idPaciente=(SELECT pacienteidpaciente FROM Pago WHERE idPago ="+idPago+")");
			
			//Va almacenando la informacion obtenida de la base de datos
			if(rs.next()) {
				paciente = new Paciente();
				paciente.setId_paciente(rs.getString("idPaciente"));
				paciente.setEdad(rs.getInt("edad"));
				paciente.setNombre(rs.getString("nombre"));
				paciente.setApellido(rs.getString("apellido"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setCURP(rs.getString("curp"));	
			}
			
			return paciente;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Paciente recuperaPaciente(String idPaciente) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Llegue al DAO " + idPaciente);
			Paciente paciente = null;
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del paciente que se encuentra en la base de datos
			ResultSet rs = statement.executeQuery("SELECT idPaciente, edad, nombre, apellido, sexo FROM Paciente where idPaciente='"+idPaciente+"'");
			
			//Va almacenando la informacion obtenida de la base de datos
			if(rs.next()) {
				paciente = new Paciente();
				paciente.setId_paciente(rs.getString("idPaciente"));
				paciente.setEdad(rs.getInt("edad"));
				paciente.setNombre(rs.getString("nombre"));
				paciente.setApellido(rs.getString("apellido"));
				paciente.setSexo(rs.getString("sexo"));
			}
			
			return paciente;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Pago recuperaPago(int idPago) {
		Pago pago = null;
		try {
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del pago de la base de datos
			ResultSet rs = statement.executeQuery("SELECT tipo FROM Servicio where idservicio=(SELECT servicioidservicio FROM Pago WHERE idPago ="+idPago+")");

			//Obtiene solamente el tipo que es el que interesa
			if(rs.next()) {
				pago = new Pago();
				pago.setServicio(rs.getString("tipo"));
			}
			
			return pago;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	

	/*
	 * Crea un nuevo paciente en la base de datos
	 * @param un objeto de paciente
	 * @return true si se registro correctamente y false si no
	 */
	public boolean crea_paciente(Paciente paciente) {
		    //System.out.println("llegue a dao: "+paciente.getNombre()+" telefono: "+paciente.getTelefono()+" Direc: "+direccion+" Email: "+email+" edad: "+edad+" naci: "+fecha_nacimiento+" sexo: "+sexo+" curp: "+curp+" idpac: "+idpaciente);
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Paciente VALUES ('"+paciente.getId_paciente()+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+paciente.getTelefono()+"','"+paciente.getDireccion()+"','"+paciente.getEmail()+"','"+paciente.getCURP()+"','"+paciente.getSexo()+"','"+paciente.getEdad()+"','"+paciente.getFecha_nacimiento()+"')");
			return true;
			
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
		
	
	}
	
	/*
	 * Recupera al tipo de empleado que correspondan el nombre y contraseña
	 * @param nombre
	 * @param contra
	 * @return Doctor o Recepcionista
	 */
	public String verificaUsuario(String nombre, String contra) {
		String tipo="ninguno";
		
		try{
			
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();
		//Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT rol FROM login WHERE usuario = '"+nombre+"'AND contraseña = '"+contra+"' ");

		while(rs.next())
		{
			tipo=rs.getString("rol");
			
		}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		return tipo;
	
	}

	@Override
	public ArrayList<Ficha_medica> recuperaCita(String idDoctor, String fecha) {
		ArrayList<Ficha_medica> consultas = new ArrayList<Ficha_medica>();
		Ficha_medica cita=null;
		
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe los resultados
			ResultSet rs = statement.executeQuery("SELECT Hora FROM Fichamedica WHERE Fecha='"+fecha+"' AND doctoriddoc='"+idDoctor+"'");
			//Guarda cada resultado en un objeto de tipo historial medico
			while(rs.next()) {
				cita= new Ficha_medica();
				cita.setHora(rs.getString("Hora"));
				consultas.add(cita);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//Devuelve el historial medico lleno
		return consultas;
	}

	@Override
	public boolean confirmaCita(String idPaciente, String fecha, String hora) {
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			
			statement.execute("DELETE FROM Fichamedica WHERE pacienteidpaciente='"+idPaciente+"' AND Fecha='"+fecha+"' AND Hora='"+hora+"'");
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Guarda el reporte de una consulta
	 * @param fech Fecha en la que el reporte se creo
	 * @param doctor Doctor que creo el reporte
	 * @param paciente Paciente del cual ha sido creado el reporte
	 * @param servicio Servicio que se ofreció en la consulta
	 * @descripcion Descripcion de la consulta
	 * @return Devuelve true si se almacenó el reporte correctamete, false en caso contrario
	 */
	public boolean guardaReporteConsulta(String fech, String doctor, String paciente, String servicio, String descripcion) {
		int idservicio=0;
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			//Recibe el id del servicio del cual es el reporte de consulta
			ResultSet rs = statement.executeQuery("SELECT idservicio FROM Servicio WHERE tipo='"+servicio+"'");
			if(rs.next()){
				idservicio=rs.getInt("idservicio");
			}
			// Ejecuta la instruccion
			statement.execute("INSERT INTO consulta VALUES ("+idservicio+",'"+paciente+"','"+fech+"','"+doctor+"','"+descripcion+"')");
			return true;
		} 
		catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean guardaCita(int idpago, String idpaciente, String iddoctor, String fech, String h) {
		try {
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del pago de la base de datos
			ResultSet rs = statement.executeQuery("SELECT servicioidservicio FROM Pago WHERE idPago="+idpago+"");
			while(rs.next()) {
				int servicio=rs.getInt("servicioidservicio");
				statement.execute("INSERT INTO Fichamedica VALUES ('"+fech+"','"+h+"','"+iddoctor+"','"+idpaciente+"',"+servicio+")");
				return true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean verificaPago(int idpago) {
		try {
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del pago de la base de datos
			ResultSet rs = statement.executeQuery("SELECT idPago FROM Pago WHERE idPago=0"+idpago+"");
			while(rs.next()) {
				if (rs.getInt("idPago") == idpago) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public ArrayList<Ficha_medica> recuperaCitas(String fecha) {
		ArrayList<Ficha_medica> citas = new ArrayList<Ficha_medica>();
		Ficha_medica cita=null;
		
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe los resultados
			ResultSet rs = statement.executeQuery("SELECT Hora,doctoriddoc,pacienteidpaciente FROM Fichamedica WHERE Fecha='"+fecha+"'");
			//Guarda cada resultado en un objeto de tipo ficha medica
			while(rs.next()) {
				cita= new Ficha_medica();
				cita.setHora(rs.getString("Hora"));
				cita.setDoctor(rs.getString("doctoriddoc"));
				cita.setPaciente(rs.getString("pacienteidpaciente"));
				citas.add(cita);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//Devuelve el historial medico lleno
		return citas;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * este metodo recupera el nombre del medicamento 
	 *@author Cerón Caballero Susan K.
	 * @param nombre del medicamento
	 *@return false si no existe, true si existe
	 */
	
	@Override
	public boolean rec_nombre_med(String nom_m) {
			int bandera = 1; //bandera para saber si el id del paciente existe (es 0 si existe, es 1 si no)
			try{
				//crea la instruccion
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();
				// Recibe los resutados
				ResultSet rs = statement.executeQuery("SELECT nombre FROM Medicamento WHERE nombre= '"+nom_m+"'");
				
				while(rs.next()) {
					if (rs.getString("nombre") == "NULL") { //se refiere a que no se encontro el id del paciente
						bandera=1;
					}
					else {
						bandera=0;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}	
			if(bandera==0)
				return true;
			else
				return false;
		}
/**
 * 
 */
	@Override
	public float precio(String nombre) {
		float precio=0;
		try {
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del pago de la base de datos
			ResultSet rs = statement.executeQuery("SELECT costo FROM Medicamento where nombre='"+nombre+"'");

			if(rs.next()) {
			    precio= rs.getFloat("costo"); //se refiere a que no se encontro el id del paciente
					
				}
			
			return precio;
			
		}
			catch(SQLException e){
				e.printStackTrace();
				return precio=0;
			}
				
			}
	/**
	 * este recupera la cantidad que tiene en medicamento en la base de datos
	 *@author Cerón Caballero Susan K.
	 * @param id del medicamento
	 * @return nueva existencia del medicamento en la base de datos si la encontro, si no regresa 0
	 */

@Override
public int recu_cantidad(String id) {
	int existencia=0;
	try {
		//Se conecta a la base de datos
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();
		//Recupera la informacion del pago de la base de datos
		ResultSet rs = statement.executeQuery("SELECT cantidad FROM Medicamento where id_medicamento='"+id+"'");

		if(rs.next()) {
		    existencia= rs.getInt("cantidad"); //se refiere a que no se encontro el id del paciente
				
			}
		
		return existencia;
		
	}
		catch(SQLException e){
			e.printStackTrace();
			return existencia=0;
		}

}
/**
 * este metodo actualiza la cantidad existente de un medicamento
 *@author Cerón Caballero Susan K.
 * @param id del medicamento y cantidad nueva
 * @return true si sw modifico, false si no
 */

@Override
public int actualiza_cantidad(String id, int cantidad_nueva) {
	String sql="UPDATE Medicamento SET cantidad="+cantidad_nueva+" WHERE id_medicamento='"+id+"' ";
	
	try{
	 System.out.println("metodo actualiza el medicamento :"+id+" con cantidad de "+cantidad_nueva);
		//Se conecta a la base de datos
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();
		statement.executeUpdate(sql);
			
		
		System.out.println("modificado");
		
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("no modificado");
		
	}
			
	return cantidad_nueva;
	   
	   
	}
/**
 * este recupera el id del medicamento
 *@author Cerón Caballero Susan K.
 * @param nombre del medicamento
 * @return id del medicamento
 */
@Override
public String recu_id(String nombre) {
	String id=null;
	try {
		//Se conecta a la base de datos
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT id_medicamento FROM Medicamento where nombre='"+nombre+"'");

		if(rs.next()) {
		    id= rs.getString("id_medicamento"); 
				
			}
		
		return id;
		
	}
		catch(SQLException e){
			e.printStackTrace();
			return id=null;
		}
}
/////////////////////////////////////////////////////////////////////////////////////
////***isabel////
@Override
public ArrayList<Pago> solicitudServicio() {
	ArrayList <Pago> servicio = new ArrayList<Pago>();
	Pago ser=null;
	
	try{
		
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();

		// Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT tipo,cantidad FROM Servicio");

		
		while(rs.next())
		{
		
			ser=new Pago();
			ser.setServicio(rs.getString("tipo"));
			ser.setCantidad(rs.getInt("cantidad"));
			servicio.add(ser);
					
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	return servicio;
}


@Override
public boolean solicitudServicio(String servicio, String cantidad) {
	try {
		//Se conecta a la base de datos
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();
		//Recupera la informacion del pago de la base de datos
		ResultSet rs = statement.executeQuery("SELECT tipo,cantidad FROM Servicio WHERE tipo='"+servicio+"' ");
		while(rs.next()){
			servicio=rs.getString("tipo de servicio");
			return true;
		}	
	}
	catch(SQLException e){
		e.printStackTrace();
		return false;
	}
	return false;
}

	//////////////////////////////////////////////////////////////////////////////////////////
	////******Brianda//
	@Override
	/**
	 * Recupera un ArrayList de tipo Reporte
	 * @param mes El mes del cual se solicita el reporte financiero
	 * @param año El año del cual se solicita el reporte financiero
	 * @return una lista con el reporte financiero del periodo
	 */
	public ArrayList<Reporte> recuperaServicio(String mes, String año) {
		ResultSet rs;
		String periodo=mes+"/"+año;
		ArrayList<Reporte> reporte = new ArrayList<Reporte>();
		Reporte report=null;
		ArrayList<Integer> id = new ArrayList<Integer>();
	
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Si solo seleccionamos reporte anual
			if(mes.equals("")) {
				//Recibe los resultados
				rs = statement.executeQuery("SELECT servicioidservicio FROM Pago WHERE fecha LIKE'%"+año+"%'");
			}
			//Si queremos un reporte mensual
			else {
				//Recibe los resultados
				rs = statement.executeQuery("SELECT servicioidservicio FROM Pago WHERE fecha LIKE'%"+periodo+"%'");
			}
			//Guarda cada id de servicio prestado en el periodo seleccionado
			while(rs.next()) {
				id.add(rs.getInt("servicioidservicio"));
			}
			try {
				for(int i=0;i<id.size();i++) {
					//Recibe los resultados
					ResultSet rs2= statement.executeQuery("SELECT tipo, cantidad FROM Servicio WHERE idservicio="+id.get(i)+"");
					//Guarda cada resultado en un objeto de tipo reporte
					while(rs2.next()) {
						report= new Reporte();
						report.setServicio(rs2.getString("tipo"));
						report.setTotal(rs2.getInt("cantidad"));
						reporte.add(report);
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
		e.printStackTrace();
		}
		//Devuelve el reporte
		return reporte;
	}

	/**
	 * Agrega un nuevo medicamento que se desea almacenar en la BD
	 * @author Brianda Garcia
	 * @param id Id del nuevo medicamento que se desea agregar a la BD
	 * @param nombre Nombre del nuevo medicamento que se desea almacenar
	 * @param costo Costo del nuevo medicamento
	 * @param cantidad Cantidad existente de medicamentos al momento de agregar a la BD
	 * @return True si se agrega el medicamento correctamente, false en caso contrario
	 */
	@Override
	public boolean agregaMedicamento(String id, String nombre, String costo, String cantidad) {
		//Convierte el costo del medicamento de string a float para poder ingresarlo a la BD
		float precio=Float.parseFloat(costo);
		//Convierte la cantidad de medicamentos de string a int para almacenarlo en le BD
		int numero=Integer.parseInt(cantidad);
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion. Inserta en la BD el nuevo medicamento
			statement.execute("INSERT INTO Medicamento VALUES ('"+id+"','"+nombre+"',"+precio+","+numero+")");
			return true;
		} catch (SQLException e) {
			// Cacha excepcion y devuelve falso, al no poder agregarse el medicamento
			e.printStackTrace();
			return false;
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 *@Descripción del método: Recupera en un array la infomación de todos los medicamentos
	 *existentes
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: Sin parametros
	 *@Regresa: Regresa una lista de todos los medicamentos con su respectiva informacion(id, nombre, costo, cantidad) 
	 *
	 */
	@Override
	public ArrayList<Medicamento> recupera_medicamentos() {
		//Se crea una lista de array para agregar todos los medicamentos
		ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
		Medicamento medicamento=null;
		
		try {
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe los resultados
			ResultSet rs = statement.executeQuery("SELECT id_medicamento,nombre,costo,cantidad From Medicamento");
			//Guarda cada resultado 
			while(rs.next()) {
				medicamento= new Medicamento();
				
				medicamento.set_id(rs.getString("id_medicamento"));
				medicamento.set_nombre(rs.getString("nombre"));
				medicamento.set_precio(rs.getFloat("costo"));
				medicamento.set_cantidad(rs.getInt("cantidad"));
				
				medicamentos.add(medicamento);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//Regresa todos los medicamentos
		return medicamentos;
	 }


	/**
	 *@Descripción del método: Hace la actualización de un medicamento, donde se le pasa el id que no es cambiado. se le pasa
	 *el nombre, costo y cantidad que probablemente fueron cambiados para su actualización.
	 *@Autor: Cerón Caballero Susan Karen.
	 *@Parametros de entrada: id del medicamento, nombre del medicamento,costo del medicamento y cantidad del medicamento
	 *@Regresa: Regresa true si la actualización tuvo exito, false si no. 
	 *
	 */
	@Override
	public boolean Actualiza_Medicamento_(String id, String nombre, float costo, int cantidad) {
	  //se declara una variable que contiene la instruccion sql para actualizar
	  String sql="UPDATE Medicamento SET nombre='"+nombre+"', costo="+costo+", cantidad="+cantidad+" WHERE id_medicamento='"+id+"' ";
		
		try{
		 System.out.println("metodo para actualizar el medicamento");
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			statement.executeUpdate(sql);
				
			System.out.println("modificado " +nombre+"   "+costo+"   "+cantidad);
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("no modificado");
			return false;
			
		}
					
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
* Recupera los datos del medicamento registrado en el dao, id, nombre, costo y cantidad
* @autor Franco Torres Isabel Estephanea
*  @return Devuelve un medicamento que esta a la venta en farmacia
*/
	public ArrayList<Medicamento> recuperaMedicamento() {
		ArrayList <Medicamento> recuperaMedi = new ArrayList<Medicamento>();
		Medicamento recu =null;

		try{
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT id_medicamento,nombre,costo,cantidad FROM Medicamento");		
			while(rs.next())
			{		
				recu=new Medicamento();
				recu.set_id(rs.getString("id_medicamento"));
				recu.set_nombre(rs.getString("nombre"));
				recu.set_precio(rs.getFloat("costo"));
				recu.set_cantidad(rs.getInt("cantidad"));
				recuperaMedi.add(recu);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		//Devuelve  la información de medicamento
		return recuperaMedi;
	}	
/**
* Recupera el nombre del medicamento cuando le pasan el nombre del medicamento que va a buscar
* @autor Franco Torrres Isabel Estephanea
*  @return Devuelve el nombre del medicamento
*/

	public ArrayList<Medicamento> recuperaMedicamento(String nombre) {
		ArrayList <Medicamento> recuperaMedi = new ArrayList<Medicamento>();
		Medicamento recu =null;

		try{
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT id_medicamento,nombre,costo,cantidad FROM Medicamento WHERE nombre='"+nombre+"'");		
			while(rs.next())
			{		
				recu=new Medicamento();
				recu.set_id(rs.getString("id_medicamento"));
				recu.set_nombre(rs.getString("nombre"));
				recu.set_precio(rs.getFloat("costo"));
				recu.set_cantidad(rs.getInt("cantidad"));
				recuperaMedi.add(recu);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		//Devuelve  la información de medicamento
		return recuperaMedi;
	}

	/**
	 * Recupera de la BD todas las horas de un paciente en la fecha establecidad
	 */
	@Override
	public ArrayList<Ficha_medica> recuperaHoras(String fecha, String paciente) {
		ArrayList<Ficha_medica> horas = new ArrayList<Ficha_medica>();
		Ficha_medica hora;
		
		try{
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT Hora FROM Fichamedica WHERE Fecha='"+fecha+"' AND pacienteidpaciente='"+paciente+"'");		
			while(rs.next())
			{		
				hora=new Ficha_medica();
				hora.setHora(rs.getString("Hora"));
				horas.add(hora);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return horas;
	}	

	
}	