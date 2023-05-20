import java.util.HashMap;
import java.util.List;

public class Carrito {
    List<Producto> catalogo = Catalogo.get_productos();
    private  static HashMap<Integer,Integer> productos = new HashMap<>();

    public Carrito(

    ){}

    public void add_producto(int id, int cantidad){

        catalogo.forEach( c -> {
            if(c.getId() == id){
                productos.put(c.getId(),cantidad);
            }
        });
    }
    public void remove_producto(int id){
        productos.remove(id);
    }
    public  static HashMap<Integer,Integer> get_productos(){
        return productos;
    }
    public void show_productos(){
        productos.forEach((k,v) -> System.out.println(k + " " + v));
    }
}
