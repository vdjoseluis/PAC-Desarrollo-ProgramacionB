import java.text.NumberFormat;

//Esta clase hereda de Dinero

public class Gasto extends Dinero{
	
	public Gasto(double gasto, String description) {	//CONSTRUCTOR
		this.dinero= gasto;
		this.description= description;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		nf = NumberFormat.getCurrencyInstance();
		return "Gasto [Descripción: "+ this.getDescription()+
				", Importe: "+ nf.format(this.getDinero())+ " ]";
	}

}
