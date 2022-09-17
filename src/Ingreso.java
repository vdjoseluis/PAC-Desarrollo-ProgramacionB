import java.text.NumberFormat;

//Esta clase hereda de Dinero

public class Ingreso extends Dinero{
	
	public Ingreso(double ingreso, String description) {	//CONSTRUCTOR
		this.dinero= ingreso;
		this.description= description;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		nf = NumberFormat.getCurrencyInstance();
		return "Ingreso [Descripción: "+ this.getDescription()+
						", Importe: "+ nf.format(this.getDinero())+ " ]";
	}
	
}
