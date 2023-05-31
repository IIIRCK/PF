import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Catalogo {
    private static List<Producto> productos = new ArrayList<>();
    Map<Integer, Integer> prodcutos_tienda = Almacen.get_productos();

    private static int currentIndex = -1;
    private static int previousIndex= -1;

    public Catalogo(){
    }
    public void fill_Catalogo(){
        try {
            productos.add(new Producto("Overwatch", "Blizzard", "20", new Producto.Categoria("Videojuegos")));
            productos.add(new Producto("Watchmen","DC Comics", "20", new Producto.Categoria("Comics")));
            productos.add(new Producto("Naruto","Shueisha", "20", new Producto.Categoria("Manga")));
            productos.add(new Producto("Funko Pop! Batman","Funko", "20", new Producto.Categoria("Funkos")));

        }catch (Exception e){
           System.out.println(e.getMessage());
        }
    }



    public void fill_from_db(){
    //new DBConn()
    }
    public static List<Producto> get_productos(){
        return productos;
    }
    public void remove_producto(Producto p){
        productos.remove(p);
    }
    public void add_producto(Producto p){
        productos.add(p);
    }


    public void check_stock_tienda(){
        prodcutos_tienda.forEach((k,v)->{
            productos.forEach(  p -> {
                if(p.getId() == v){
                    p.set_stock(true);
                }
            });
        });
    }


    public <T> T getNextItem(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("La lista está vacía");
        }

        int listSize = list.size();

        // Lógica para obtener el siguiente elemento
        currentIndex = (currentIndex + 1) % listSize;

        return list.get(currentIndex);
    }

    public <T> T getBackItem(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("La lista está vacía");
        }

        int listSize = list.size();

        previousIndex = currentIndex;
        currentIndex = (currentIndex - 1) % listSize;

        if (currentIndex < 0) {
            currentIndex = listSize - 1;
        }

        return list.get(currentIndex);
    }

    class PrecioComparator implements Comparator<Producto> {
        @Override
        public int compare(Producto p1, Producto p2) {
            if (p1.getPrecio() < p2.getPrecio()) {
                return -1;
            } else if (p1.getPrecio() > p2.getPrecio()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
