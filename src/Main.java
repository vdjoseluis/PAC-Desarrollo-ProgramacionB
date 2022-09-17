import java.text.NumberFormat;				//PARA USAR FORMATO DINERO
import java.util.InputMismatchException;	//PARA EXCEPCIONES SI ES NUMERO
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		NumberFormat nf = NumberFormat.getInstance();
		nf = NumberFormat.getCurrencyInstance();
		
		System.out.println("Nombre de usuario: " );
		String nombre= sc.nextLine();		
				
		//Entrada de "Edad" y compruebo con el método "esEntero" si es válido.
		System.out.println("Edad: ");
		int edad;
		String sEdad;
		do {          
		    sEdad=sc.nextLine(); 
		} while(!esEntero(sEdad));
		edad = Integer.parseInt(sEdad); 
		
		
		//Entrada DNI comprobando si es válido.
		System.out.println("DNI: " );		
		Usuario usuario= new Usuario();
		String dni;		
		do {
			dni= sc.nextLine();
			if (usuario.setDNI(dni)) {
				System.out.println("Cuenta creada correctamente\n");
			}else {
				System.out.println("DNI no valido, introduce correcto:");
			}
		} while (!usuario.setDNI(dni));
		
		// Creación de nueva cuenta 
		usuario.setNombre(nombre);
		usuario.setEdad(edad);
		usuario.setDNI(dni);
		Cuenta cliente= new Cuenta(usuario);
		
		//----------------MENU PRINCIPAL---------------------
		boolean salir= false;
		int opcion;
		while (!salir) {
			System.out.println("Realiza una nueva acción");
			System.out.println("1 Introduce un nuevo gasto");
			System.out.println("2 Introduce un nuevo ingreso");
			System.out.println("3 Mostrar gastos");
			System.out.println("4 Mostrar ingresos");
			System.out.println("5 Mostrar saldo");
			System.out.println("0 Salir");
			try {
				System.out.println("Opción.............:");
				opcion= sc.nextInt();				
				sc.nextLine();
				
				switch (opcion) {
				case 1: {
					System.out.println("\nConcepto del gasto: ");
					String descripcion = sc.nextLine();
					
					System.out.println("Cantidad= ");
					double cantidad;
					String sCantidad;
					do {          
					    sCantidad=sc.nextLine(); 
					} while(!esDouble(sCantidad));
					cantidad = Double.parseDouble(sCantidad);
					
					cliente.addGastos(descripcion, cantidad);
					System.out.println("Saldo actual= "+ nf.format(cliente.getSaldo())+"\n");
					break;
				}case 2: {
					System.out.println("\nConcepto del ingreso: ");
					String descripcion = sc.nextLine();
					
					System.out.println("Cantidad= ");
					double cantidad;
					String sCantidad;
					do {          
					    sCantidad=sc.nextLine(); 
					} while(!esDouble(sCantidad));
					cantidad = Double.parseDouble(sCantidad);
					
					cliente.addIngresos(descripcion, cantidad);
					System.out.println("Saldo actual= "+ nf.format(cliente.getSaldo())+"\n");
					break;
				}case 3: {
					double tGastos=0;
					for (Gasto g : cliente.getGastos()) {
						System.out.println(g.toString());
						tGastos+= g.getDinero();
					}
					System.out.println("\nTotal gastos= "+ nf.format(tGastos)+ "\n");
					break;
				}case 4: {
					double tIngresos=0;
					for (Ingreso i : cliente.getIngresos()) {
						System.out.println(i.toString());
						tIngresos+= i.getDinero();
					}
					System.out.println("\nTotal ingresos= "+ nf.format(tIngresos)+ "\n");
					break;
				}case 5: {
					System.out.println(cliente.toString());
					System.out.println();
					break;
				}case 0:{
					salir=true;
					System.out.println();
					System.out.println("Fin del programa.");
					System.out.println("Gracias por utilizar la aplicación.");
					break;				
				}default:
					System.out.println("Opción no válida, escoge de nuevo...");
				}
			} catch (InputMismatchException e) {
				System.out.println("Opción no válida, escoge de nuevo...\n");
				sc.nextLine();
			}
		}
		
		sc.close();
	}
	
	//Método para comprobar si un string x parámetro es estero.
	public static boolean esEntero(String valor) {
	    try {
	      int v=Integer.parseInt(valor);
	      return true;
	    }catch (NumberFormatException ex) {
	    	System.out.println("Valor no válido");
	    	return false;
	    }
	}
	
	//Método para comprobar si un string x parámetro es double.
	public static boolean esDouble(String valor) {
	    try {
	      double v=Double.parseDouble(valor);
	      return true;
	    }catch (NumberFormatException ex) {
	    	System.out.println("Valor no válido");
	    	return false;
	    }
	}
}
