import java.util.ArrayList;
import java.util.Scanner;

public class CarritoDeCompras {
    // Jair Sinisterra, Daisy Malagon, Cristina Samboni
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();

        while (true) {
            System.out.println("*** Bienvenido al carrito de compras***");
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Aplicar descuento");
            System.out.println("4. Finalizar Compra y generar ticket");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
               
                    System.out.print("Ingresa el nombre del producto: ");
                    String producto = scanner.nextLine();
                    System.out.print("Ingresa la cantidad: ");
                    int cantidad = scanner.nextInt();
                    if(cantidad <1){
                        System.out.println("Ingrese una cantidad valida");
                        break;
                    }else{
                        System.out.println("Cantidad Valida");
                    }
                    
                    System.out.print("Ingresa el precio del producto: ");
                    double precio = scanner.nextDouble();
                  
                    productos.add(producto);
                    cantidades.add(cantidad);
                    precios.add(precio);
                    System.out.println("Producto '" + producto + "' agregado al carrito.");
                    break;

                case 2:
                 
                    System.out.print("Ingresa el nombre del producto a eliminar: ");
                    String productoEliminar = scanner.nextLine();
                    int indexEliminar = productos.indexOf(productoEliminar);
                    if (indexEliminar != -1) {
                        productos.remove(indexEliminar);
                        cantidades.remove(indexEliminar);
                        precios.remove(indexEliminar);
                        System.out.println("Producto '" + productoEliminar + "' eliminado del carrito.");
                    } else {
                        System.out.println("El producto no se encuentra en el carrito.");
                    }
                    break;

                    case 3:
                        System.out.print("Ingresa el porcentaje de descuento: ");
                        double descuento = scanner.nextDouble();
                        boolean descuentoAplicado = false;

                    // Aplicar descuento a todos los productos
                        for (int i = 0; i < precios.size(); i++) {
                            if (cantidades.get(i) > 10) {
                                double precioOriginal = precios.get(i);
                                double precioConDescuento = precioOriginal * (1 - descuento / 100);
                                precios.set(i, precioConDescuento);
                                System.out.println("Descuento aplicado a '" + productos.get(i) + "' por ser mayor a 10 unidades.");
                                descuentoAplicado = true;
                            }
                        }

                        if (!descuentoAplicado){
                             System.out.println("No se aplico descuento a ningun producto.");
                        }
                        break;

                    case 4:
                    System.out.println();
                    System.out.println("Desea eliminar un producto? \n 1. yes \n 2. no");
                    int eliminar = scanner.nextInt();
                    if(eliminar == 1){
                      System.out.println("Regresando al menu..");
                      break;
                    }else{
                        System.out.println();
                    }
                    double total = 0;
                    System.out.println("\n--- TICKET ---");
                    for (int i = 0; i < productos.size(); i++) {
                        String prod = productos.get(i);
                        int cant = cantidades.get(i);
                        double precioFinal = precios.get(i);
                        double subtotal = cant * precioFinal;
                        total += subtotal;
                        System.out.println(prod + " | Cantidad: " + cant + " | Precio: $" + precioFinal + " | Subtotal: $" + subtotal);
                    }
                    System.out.println("Total a pagar: $" + total);
                   
                    break;

                    case 5:
               
                    System.out.println("¡Gracias por usar el carrito de compras!");
                    scanner.close();
                    return;

                    default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    
            }
 }
}
}