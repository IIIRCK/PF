import javax.swing.*;
import java.util.*;

public class Tienda {
    public static void main(String[] args) throws MyExeptions.Input_Constructor_Error, MyExeptions.Input_Setter_Error, MyExeptions.Action_to_Persona, InterruptedException {
        List<Cliente> clientes = Cliente.getClientes();
        List<Personal> personal = Personal.get_personal();
        Map<Integer, Integer> alamcen = Almacen.get_productos();
        List<Producto> catalogo = Catalogo.get_productos();
        Map<Integer, Integer> carrito = Carrito.get_productos();


        new Catalogo().fill_Catalogo();
        Iterator<Personal> personalIterator = Personal.get_personal().iterator();
        String n = "nombre";
        String[] a = {"apellido1", "apellido2"};
        String d = "calle ";
        String no = "123456789";
        String cc = "hola123_09@gmail.com";

        try {
            new Cliente(n, a, d, no, cc, "1234").add_Cliente();
            new Cliente("ssis", a, d, no, cc, "1234").add_Cliente();

        } catch (Exception e) {
            println(e.getMessage());
        }

/*
    try {
       new Personal().add_personal(new Personal(n, a, d, no, cc, "100", Personal.cargo.jefe));
    }catch (Exception e) {
        println(e.getMessage());
    }
       new Personal().modify_personal(1, p -> true, p -> p.setApellido(new String[]{"apellido1", ""}));

        new Personal().rise_salary(1,"1000");
*/

        // new Personal().remove_personal(1);


        personal.forEach(p -> println(p.toString()));


        int[] id_c = {3, 11, 13};


        int[] cantidad = {1, 2, 3};

        for (int i = 0; i < id_c.length; i++) {
            int id = id_c[i];
            int cantidadProducto = cantidad[i];
            for (Producto producto : catalogo) {
                if (producto.getId() == id) {
                    for (int j = 0; j < cantidadProducto; j++) {
                        new Almacen().add_producto(producto.getId());
                    }
                    break;
                }
            }
        }


        new Carrito().add_producto(1, 2);

        for (Producto c : catalogo) {
            for (Map.Entry<Integer, ?> entry : carrito.entrySet()) {
                if (c.getId() == entry.getKey()) {
                    System.out.println(c.getNombre() + " " + c.getImgpath());
                }
            }
        }
        alamcen.forEach((k, v) -> println(k + " " + v + " "));


        List<Pedido> pedidos = Pedido.get_pedidos();

        Object lock = new Object();
        //new Pedido().add_pedido(id_c, cantidad,1, 1);

        int[] idct = {13, 10, 9};
        int[] ct = {3, 3, 3};

        pedidos.forEach(p -> println(p.toString()));
        //new Pedido().add_pedido(idct, ct,1, 1);


        //carrito.forEach((k, v) -> println(k + " " + v));


        //alamcen.entrySet().removeIf((k) -> k.getKey().getId() == 1);

        //new Pedido().ordenarPorFecha(pedidos);//alamcen.forEach((k, v) -> println(k + " "  + v + " ") );
        pedidos.forEach(p -> println(p.toString()));
        new Catalogo().check_stock_tienda();
        //catalogo.forEach(p -> println(p.get_stock()));
        //new Almacen().mostrarProductosOrdenadosPorId();


        carrito.forEach((k, v) -> {

            catalogo.forEach(c -> {
                        if (c.getId() == k.intValue()) {
                            println(c.getNombre() + " " + c.getImgpath() + " " + k + " " + v);
                        }
                    }
            );
        });

        Scanner sc = new Scanner(System.in);
        int x = -1;
        do {
            println("1" + "2");

            x = sc.nextInt();
            switch (x) {
                case 1:
                    Producto ni = new Catalogo().getNextItem(catalogo);
                    println(ni);
                    break;
                case 2:
                    Producto c = new Catalogo().getBackItem(catalogo);
                    println(c);
                    break;
            }
        } while (x != 0);

        clientes.forEach(cliente -> println(cliente.toString()));

    }

    public static void println(String x){
        System.out.println(x);
    }
    public static void println(Boolean x){
        System.out.println(x);
    }

    public static void println(Producto x){
        System.out.println(x.toString());
    }
}
