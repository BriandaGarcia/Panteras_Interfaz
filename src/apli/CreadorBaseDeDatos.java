package apli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import datos.DatabaseException;
import datos.ManejadorBaseDatos;



/**
 * Esta clase crea la base de datos, solo debe ser usada 
 * cuando se crea la misma
 * 
 * @author
 *
 */
public class CreadorBaseDeDatos {
	
	// El logger
	static Logger log = Logger.getRootLogger();

	
	/**
	 * Al ejecutar este metodo se crea la base de datos. NOTA: solo se puede crear una vez.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try
	    {
			log.info("Creando base de datos");
		
			Connection connection = ManejadorBaseDatos.getConnection();
	
			Statement statement = connection.createStatement();
			
			log.info("Creando tablas de DAO Cruz Roja");          
			
			
			
			/*
			statement.execute("DROP TABLE consulta");
			statement.execute("DROP TABLE Fichamedica");
			statement.execute("DROP TABLE Pago");
			statement.execute("DROP TABLE Servicio");
			statement.execute("DROP TABLE Doctor");
			statement.execute("DROP TABLE Paciente");
			statement.execute("DROP TABLE Recepcionista");
			statement.execute("DROP TABLE Login");
			statement.execute("DROP TABLE Medicamento");
			*/
			
			/*
			statement.execute("CREATE TABLE Servicio("+
					"idservicio INT NOT NULL,"+
					"tipo VARCHAR(45) NOT NULL,"+ 
					"cantidad INT NOT NULL,"+
					"PRIMARY KEY (idservicio))");
			statement.execute("CREATE TABLE Medicamento("+
					"id_medicamento VARCHAR(10) NOT NULL,"+
					"nombre VARCHAR(60) NOT NULL,"+ 
					"costo FLOAT NOT NULL,"+
					"cantidad INT NOT NULL,"+
					"PRIMARY KEY (id_medicamento))");
			statement.execute("CREATE TABLE Recepcionista("+
					"idrecep VARCHAR(45) NOT NULL,"+
					"nombre VARCHAR(56) NOT NULL,"+
					"apellido VARCHAR(45) NOT NULL,"+
					"fechainicio VARCHAR(30) NOT NULL,"+
					"edad INT NOT NULL,"+					
					"telefono VARCHAR(45) NOT NULL,"+
					"email VARCHAR(45) NOT NULL,"+
					"sexo VARCHAR(10) NOT NULL,"+
					"escolaridad VARCHAR(45) NOT NULL,"+
					"direccion VARCHAR(45) NOT NULL,"+
					"horario VARCHAR(45) NOT NULL,"+
					"PRIMARY KEY (idrecep))");
			statement.execute("CREATE TABLE Doctor("+
					"iddoc VARCHAR(45) NOT NULL,"+
					"nombre VARCHAR(56) NOT NULL,"+
					"apellido VARCHAR(45) NOT NULL,"+
					"fechainicio VARCHAR(30) NOT NULL,"+
					"edad INT NOT NULL,"+
					"telefono VARCHAR(45) NOT NULL,"+
					"email VARCHAR(45) NOT NULL,"+
					"sexo VARCHAR(10) NOT NULL,"+
					"cedulaprofesional VARCHAR(45) NOT NULL,"+
					"especialidad VARCHAR(45) NOT NULL,"+
					"horario VARCHAR(45) NOT NULL,"+
					"direccion VARCHAR(45) NOT NULL,"+
					"PRIMARY KEY (iddoc))"
					);	
			statement.execute("CREATE TABLE Paciente("+
					"idPaciente VARCHAR(45) NOT NULL,"+
					"nombre VARCHAR(45) NOT NULL,"+
					"apellido VARCHAR(45) NOT NULL,"+
					"telefono VARCHAR(45) NOT NULL,"+
					"direccion VARCHAR(45) NOT NULL,"+
					"email VARCHAR(45) NOT NULL,"+
					"curp VARCHAR(45) NOT NULL,"+
					"sexo VARCHAR(45) NOT NULL,"+
					"edad VARCHAR(45) NOT NULL,"+
					"fechanacimiento VARCHAR(30) NOT NULL,"+
					"PRIMARY KEY (idPaciente))"
					);
			statement.execute("CREATE TABLE Login("+
					"usuario VARCHAR(45) NOT NULL,"+
					"contraseña VARCHAR(45) NOT NULL,"+
					"rol VARCHAR(45) NOT NULL,"+
					"PRIMARY KEY (Usuario))"
					);			
			statement.execute("CREATE TABLE Pago("+
					"idPago INT NOT NULL,"+
					"servicioidservicio INT NOT NULL,"+
					"pacienteidpaciente VARCHAR(45) NOT NULL,"+
					"fecha VARCHAR(30) NOT NULL,"+
					"PRIMARY KEY (idPago,Servicioidservicio, PacienteidPaciente),"+
					"CONSTRAINT fkPagoServicio1 FOREIGN KEY (Servicioidservicio) REFERENCES Servicio (idservicio),"+
					"CONSTRAINT fkPagoPaciente1 FOREIGN KEY (pacienteidpaciente) REFERENCES Paciente (idPaciente))"
					);
			statement.execute("CREATE TABLE Fichamedica("+
					"Fecha VARCHAR(30) NOT NULL,"+
					"Hora VARCHAR(30) NOT NULL,"+
					"doctoriddoc VARCHAR(45) NOT NULL,"+
					"pacienteidpaciente VARCHAR(45) NOT NULL,"+
					"servicioidservicio INT NOT NULL,"+
					"PRIMARY KEY (PacienteidPaciente,Fecha,Hora),"+
					"CONSTRAINT fkFichamedicaDoctor1 FOREIGN KEY (doctoriddoc) REFERENCES Doctor (iddoc),"+
					"CONSTRAINT fkFichamedicaPaciente1 FOREIGN KEY (pacienteidpaciente) REFERENCES Paciente (idPaciente),"+
					"CONSTRAINT fkFichamedicaServicio1 FOREIGN KEY (servicioidservicio) REFERENCES Servicio (idservicio))"+
					""
					);
			statement.execute("CREATE TABLE consulta("+
					"tipodeconsulta INT NOT NULL,"+
					"idPaciente VARCHAR(45) NOT NULL,"+
					"Fecha VARCHAR(30) NOT NULL,"+
					"doctoriddoc VARCHAR(45),"+
					"observaciones VARCHAR(250) NOT NULL,"+
					"PRIMARY KEY (observaciones),"+
					"CONSTRAINT fkconsultaPaciente1 FOREIGN KEY (idPaciente) REFERENCES Paciente (idPaciente),"+
					"CONSTRAINT fkconsultaServicio1 FOREIGN KEY (tipodeconsulta) REFERENCES Servicio (idservicio),"+
					"CONSTRAINT fkconsultadoctor1 FOREIGN KEY (doctoriddoc) REFERENCES doctor (iddoc))"
					);
			
			statement.execute("INSERT INTO Login values('456','456','Recepcionista')");
			statement.execute("INSERT INTO Login values('123','123','Doctor')");
			statement.execute("INSERT INTO Login values('789','789','Farmaceutica')");
			statement.execute("INSERT INTO doctor values ('asdsa','luis','feranndo','2019-05-30',23,'hola','qw','er','M','dsd','asdasd','marutio')");
			statement.execute("INSERT INTO doctor values ('12345','fernando','feranndo','2019-05-30',23,'hola','qw','er','M','dsd','asdasd','marutio')");
			statement.execute("INSERT INTO Recepcionista values ('987','raul','feranndo','2019-05-30',23,'hola','qw','er','M','dsd','asdasd')");
			statement.execute("INSERT INTO Servicio values (01,'Consulta General',60)");
			statement.execute("INSERT INTO Servicio values (02,'Inyeccion',30)");
			statement.execute("INSERT INTO Servicio values (03,'Ortopedista',100)");
			statement.execute("INSERT INTO Servicio values (04,'Podologia',120)");
			statement.execute("INSERT INTO Servicio values (05,'Cardologia',150)");
			statement.execute("INSERT INTO Paciente values ('a24F1','Brianda','Garcia','5539145264','bosques de argentina','brianda3195garcia@gmail.com','GARF010195','F','24','1995-01-03')");
			statement.execute("INSERT INTO Fichamedica values ('Noviembre/2019','13:00','asdsa','a24F1',01)");
			statement.execute("INSERT INTO Fichamedica values ('07/Febrero/2020','13:00','12345','a24F1',01)");
			statement.execute("INSERT INTO Fichamedica values ('06/Febrero/2020','14:00','asdsa','a24F1',01)");
			statement.execute("INSERT INTO Fichamedica values ('08/Febrero/2020','15:00','12345','a24F1',01)");
			statement.execute("INSERT INTO Fichamedica values ('06/Febrero/2020','16:00','asdsa','a24F1',01)");
			statement.execute("INSERT INTO Fichamedica values ('07/Febrero/2020','17:00','12345','a24F1',01)");
			statement.execute("INSERT INTO Fichamedica values ('08/Febrero/2020','18:00','asdsa','a24F1',01)");
			statement.execute("INSERT INTO Pago values (01,01,'a24F1','10/11/2019')");
			statement.execute("INSERT INTO Pago values (02,01,'a24F1','20/11/2019')");
			statement.execute("INSERT INTO Pago values (03,02,'a24F1','30/11/2019')");
			statement.execute("INSERT INTO Pago values (04,01,'a24F1','03/01/2020')");
			statement.execute("INSERT INTO Pago values (05,02,'a24F1','05/01/2020')");
			statement.execute("INSERT INTO Pago values (06,03,'a24F1','01/11/2019')");
			statement.execute("INSERT INTO Pago values (07,04,'a24F1','10/02/2020')");
			statement.execute("INSERT INTO Pago values (08,05,'a24F1','15/02/2020')");
			statement.execute("INSERT INTO Pago values (09,01,'a24F1','25/12/2019')");
			statement.execute("INSERT INTO Pago values (10,02,'a24F1','18/02/2020')");
			statement.execute("INSERT INTO Pago values (11,03,'a24F1','17/02/2020')");
			statement.execute("INSERT INTO Pago values (12,04,'a24F1','09/02/2020')");
			statement.execute("INSERT INTO Pago values (13,05,'a24F1','15/01/2020')");
			statement.execute("INSERT INTO Pago values (14,01,'a24F1','25/12/2019')");
			statement.execute("INSERT INTO Pago values (15,02,'a24F1','30/01/2020')");
			statement.execute("INSERT INTO Pago values (16,03,'a24F1','31/01/2020')");
			statement.execute("INSERT INTO Pago values (17,04,'a24F1','09/02/2020')");
			statement.execute("INSERT INTO Pago values (18,05,'a24F1','15/02/2020')");
			statement.execute("INSERT INTO Medicamento values ('000','paracetamol',35.20,290)");
			statement.execute("INSERT INTO Medicamento values ('001','tempra',55.00,300)");
			statement.execute("INSERT INTO Medicamento values ('002','aspirina',33.60,354)");
			statement.execute("INSERT INTO Medicamento values ('003','naproxeno',38.90,249)");
			statement.execute("INSERT INTO Medicamento values ('004','diclofenaco',45.20,198)");
			statement.execute("INSERT INTO Medicamento values ('005','treda',120.30,257)");
			*/
			
	        ManejadorBaseDatos.shutdown();
	    }
	    catch(DatabaseException ex)
	    {
	            log.error("Excepcion de la base de datos",ex.getRealException());
	    }
	    catch(SQLException e){
	    	log.error("Excepcion de la base de datos",e);
	    }	
	}
}