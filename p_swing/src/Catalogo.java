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
            productos.add(new Producto("FIFA 21", "EA Sports", "60", new Producto.Categoria("Videojuegos"), "/src/img/manga.png",false));
            productos.add(new Producto("Call of Duty: Black Ops Cold War", "Activision", "30", new Producto.Categoria("Videojuegos"), "src/3img/manga.png",false));
            productos.add(new Producto("Overwatch", "Blizzard", "20", new Producto.Categoria("Videojuegos"), "img/overwatch.jpg",false));
            productos.add(new Producto("Batman: The Killing Joke",1,"DC Comics", "20", new Producto.Categoria("Comics"), "img/batman.jpg",false));
            productos.add(new Producto("The Walking Dead",1,"Image Comics", "20", new Producto.Categoria("Comics"), "img/walkingdead.jpg",false));
            productos.add(new Producto("Watchmen",1,"DC Comics", "20", new Producto.Categoria("Comics"), "img/watchmen.jpg", false));
            productos.add(new Producto("Dragon Ball",1,"Shueisha", "20", new Producto.Categoria("Manga"), "img/dragonball.jpg",false));
            productos.add(new Producto("One Piece",1,"Shueisha", "20", new Producto.Categoria("Manga"), "img/onepiece.jpg",false));
            productos.add(new Producto("Naruto",1,"Shueisha", "20", new Producto.Categoria("Manga"), "img/naruto.jpg",false));
            productos.add(new Producto("Funko Pop! Batman","Funko", "20", new Producto.Categoria("Funkos"), "img/funko1.jpg",false));
            productos.add( new Producto("Funko Pop! Batman","Funko", "20", new Producto.Categoria("Funkos"), "img/funko1.jpg",false));
            productos.add( new Producto("Funko Pop! Spiderman","Funko", "20", new Producto.Categoria("Funkos"), "img/funko2.jpg",false));
            productos.add( new Producto("Funko Pop! Goku","Funko", "20", new Producto.Categoria("Funkos"), "img/funko3.jpg",false));

        }catch (Exception e){
           System.out.println(e.getMessage());
        }
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
