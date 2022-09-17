import java.util.regex.*;

public class Usuario {

	private String nombre;
	private int edad;
	private String DNI; 
	
	public Usuario() {			//CONSTRUCTOR
		// TODO Auto-generated constructor stub
		this.nombre= getNombre();
		this.edad= getEdad();
		this.DNI= getDNI();
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	public int getEdad() {
		return this.edad;
	}
	public void setEdad(int edad) {
		this.edad= edad;
	}
	public String getDNI() {
		return this.DNI;
	}
	
	// COMPROBACION DNI CON PATRON, usando todas las librerias de java.util.regex
	public boolean setDNI(String DNI) {		
		String regex= "^[0-9]{8}-?[a-zA-Z]{1}$";
		Pattern patron= Pattern.compile(regex);
		if (patron.matcher(DNI).matches()) {
			this.DNI= DNI;
		}
		return patron.matcher(DNI).matches();
	}
	
	@Override
	public String toString() {
		return "Usuario: "+ this.nombre+
				", Edad: "+ this.edad+
				", DNI: "+ this.DNI;
	}


}
