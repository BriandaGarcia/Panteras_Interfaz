package negocio.dominio;

public class Medicamento {

	private String id;
    private String nombre;
    private float costo;
    private int cantidad;
   
    //////set y get de id/////
    public String get_id() {
		return id;
	}
	public void set_id(String id) {
		this.id=id;
	}
	
	/////set y get de nombre///
	public String get_nombre() {
		return nombre;
	}
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	
	/////set y get de cantidad/////
	public int get_cantidad() {
		return cantidad;
	}
	public void set_cantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	////set y get de costo////
	public float get_costo() {
		return costo;
	}
	public void set_precio(float costo) {
		this.costo = costo;
	}
}