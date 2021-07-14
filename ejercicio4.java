package ejerciciosunidad7;

import java.util.ArrayList;
import java.util.Enumeration;

import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class ejercicio4 {

	public static void main(String[] args) {
	
		
		Hashtable<String, Double> inventario = productos();
		
		ArrayList<Double> lista = genarraylist();
		
		menu(inventario, lista);

	}
public static void menu(Hashtable<String, Double> inventario, ArrayList<Double>lista) {
		
		String opcionbeta=(JOptionPane.showInputDialog("Escribe consultar para consultar el inventario.\nEscribe consultarprecio para consultar el precio de un articulo.\nEscrive introducir para introducir un articulo.\nEscribe pagar para pagar.").toLowerCase());
		
		do {
		
		switch (opcionbeta) {
			
			case "consultar":
				
				System.out.println("ARTICULOS A LA VENTA\n-------------------------");
				
				recorrerhashtable(inventario,lista);
				
				break;
			
			case "consultarprecio":
			
				System.out.println("CONSULTAR PRECIOS\n-----------------------");
				
				consultarprecio(inventario,lista);
				
				break;
			
			case "introducir":
			
				introducirdatos(inventario,lista);
				
				break;
				
			case "pagar":
				
				System.out.println("PAGAR\n-----------------------------");
				
				introducirdatoscompra (inventario, lista);
				
				mostrar(lista, inventario);
				
				pagar(inventario, lista);
				
				break;
	
			default:
				
				JOptionPane.showMessageDialog(null, "Introduzca una respuesta valida");
				
				menu(inventario, lista);
				
				break;
		
		
		}
		
		}while(opcionbeta!="consultarinv"||opcionbeta!="consultarprecio"||opcionbeta!="introducir"||opcionbeta!="pagar");
	}
		
	
	public static ArrayList<Double> genarraylist() {
		
		ArrayList<Double> lista = new ArrayList<>();
		
		return lista;
		
	}
	
		private static void pagar(Hashtable<String, Double> inventario, ArrayList<Double> lista) {
		
			
			String dineropagadobeta = JOptionPane.showInputDialog("Tienes a pagar " + precioconiva(lista) + "€.");
			
			double dineropagado = Double.parseDouble(dineropagadobeta);
			
			double precioconiva = precioconiva(lista); 
			
			if (dineropagado < precioconiva) {
				
				JOptionPane.showMessageDialog(null, "No tienes suficiente dinero!");
				
				pagar(inventario, lista);
				
			} else if (dineropagado >= precioconiva) {
				
				JOptionPane.showMessageDialog(null, " el cambio es de " + (dineropagado - precioconiva) + "€");
			}	
		
	}

		public static Hashtable<String, Double> productos(){
		
		Hashtable<String, Double> producto = new Hashtable<>();
		
		
		producto.put("Fideos", 0.70);
		
		producto.put("Platanos", 0.60);
		
		producto.put("Chocolate", 1.00);
		
		producto.put("Papel", 0.30);
		
		producto.put("Harina", 0.50);
		
		producto.put("Vino", 1.50);
		
		producto.put("Refresco", 1.20);
		
		producto.put("Helado", 1.60);
		
		producto.put("Ternera", 0.90);
		
		producto.put("Agua", 0.50);
		
		return producto;
		
	}
	
		public static void introducirdatos(Hashtable<String, Double> hash, ArrayList<Double>lista) {
			
			String articulo = JOptionPane.showInputDialog("Introduce el nombre del articulo");
			
			String preciobeta= JOptionPane.showInputDialog("Introduce el precio del articulo");
			
			Double precio = Double.parseDouble(preciobeta);
			
			hash.put(articulo, precio);
			
			menu(hash, lista);
			
		}
		
		public static ArrayList<Double> introducirdatoscompra (Hashtable<String, Double> hash, ArrayList<Double>lista) {
		
			String precio;
			
			do {
				
				precio = JOptionPane.showInputDialog("Que producto deseas?(Teclea 1234567890 para salir)");
				
				if (!precio.equals("1234567890")) {
					
					String cantidadbeta = JOptionPane.showInputDialog("Cuantas unidades de " + precio + " deseas?");
				
					int cantidad = Integer.parseInt(cantidadbeta);
					
					if (cantidad != 0) {
					
						for (int i = 0; i < cantidad; i++) {
						
							lista.add(hash.get(precio));
					
						}
					
					}
				
				}
			
			} while (!precio.equals("1234567890"));
			
			return lista;
			
		}
	
		
		public static void consultarprecio(Hashtable<String, Double> hash, ArrayList<Double>lista) {
		
		String articulo = JOptionPane.showInputDialog("Introduce el nombre del articulo a buscar");
		
		double precioarticulo=hash.get(articulo);
		
		System.out.println("El articulo que has seleccionado es: " + articulo +".\n Su precio es " + precioarticulo);
		
		menu(hash, lista);
		
		}
		
	public static void recorrerhashtable(Hashtable<String, Double> hash, ArrayList<Double>lista) {
		
		Enumeration<String> key = hash.keys();
		
		Enumeration<Double> valor = hash.elements();
		
		while (key.hasMoreElements()) {
			
			System.out.println(key.nextElement() + ": " + valor.nextElement());
			
		}
		
		menu(hash, lista);
		
	}
	public static double preciobruto(ArrayList<Double> lista) {
		
		
	Iterator<Double> it = lista.iterator();
	
	double precio = 0;
	
	while (it.hasNext()) {
	
	precio += it.next();
	
	}
		
		return precio;
}

	public static double precioconiva(ArrayList<Double> lista) {
		
		double preciobruto = preciobruto(lista);
	
		return preciobruto + (preciobruto * 0.21);
	
		}
	
	public static void mostrar(ArrayList<Double> lista, Hashtable<String, Double> hash) {
		
		
	double preciobruto = preciobruto(lista);
		
	double precioconiva = precioconiva(lista);
		
		int cantidadarticulos= cantidadarticulos(lista);
		
		JOptionPane.showMessageDialog(null, "!Aplicando IVA del 21%!(Presione OK para visualizar su precio)");
		
		JOptionPane.showMessageDialog(null, "Comprando " + cantidadarticulos +  " articulos , su precio sin IVA es de  " + preciobruto + "€, su precio con IVA es de " + precioconiva);
		
	}

	public static int cantidadarticulos(ArrayList<Double>lista ) {
	
	return lista.size();
	
}

	}