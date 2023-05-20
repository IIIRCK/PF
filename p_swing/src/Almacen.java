import java.util.*;

public class Almacen {
    private static Map<Integer,Integer> productos = new HashMap<>();
    private static  Set<Integer> id_p_a = new HashSet<>();

    Random rand = new Random();
    public Almacen(){}

    public void remove_producto(int id_p_a){
       productos.forEach((k,v) -> {
           if(k == id_p_a){
               productos.remove(k);
           }
       });
    }
    public void add_producto(int p){
        int rn;
        do {
            rn = rand.nextInt(1000) + 1;

        }while (id_p_a.contains(rn));
        id_p_a.add(rn);
        productos.put(rn,p);
    }

    public static Map<Integer,Integer> get_productos(){
            return productos;
    }
    public void mostrarProductosOrdenadosPorId() {
        List<Map.Entry<Integer, Integer>> listaOrdenada = new ArrayList<>(productos.entrySet());

        Collections.sort(listaOrdenada, Comparator.comparingInt(entry -> entry.getKey()));

        listaOrdenada.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

}
