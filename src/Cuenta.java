import java.text.NumberFormat;
import java.util.ArrayList;

public class Cuenta {
	// ATRIBUTOS
	private double saldo;
	private Usuario usuario;
	private ArrayList <Gasto> gastos;
	private ArrayList <Ingreso> ingresos;
	
	public Cuenta(Usuario usuario) {		// CONSTRUCTOR
		// TODO Auto-generated constructor stub
		this.saldo=0;
		this.usuario= usuario;		
		this.gastos= new ArrayList<>();
		this.ingresos= new ArrayList<>();
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo= saldo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario= usuario;
	}
	
	public double addIngresos(String description, double cantidad) {
		this.saldo+= cantidad;
		this.ingresos.add(new Ingreso(cantidad, description));
		return this.getSaldo();
	}
	public double addGastos(String description, double cantidad) {
		try {
			if (cantidad>saldo || saldo<0) {
				throw new GastoException();
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
		this.saldo-=cantidad;
		this.gastos.add(new Gasto(cantidad, description));
		return this.getSaldo();
	}
	
	public ArrayList<Ingreso> getIngresos(){
		return ingresos;
	}
	
	public ArrayList<Gasto> getGastos(){
		return gastos;
	}
	
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		nf = NumberFormat.getCurrencyInstance();
		return "["+ this.getUsuario()+", Saldo actual= "+ nf.format(this.getSaldo())+"]";
	}

}
