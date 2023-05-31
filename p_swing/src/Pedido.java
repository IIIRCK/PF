import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.*;

public class Pedido {

    static List<Pedido> pedidos = new ArrayList<>();
    Map<Integer,Integer> almacen = Almacen.get_productos();
    List<Producto> catalogo = Catalogo.get_productos();

    Map<Integer, Integer> carrito = Carrito.get_productos();
    private static int idct = 1;
    private int id =idct;
    private int[] id_p_a;
    private int[] id_p_c;
    private int[] ct;
    private int precio;
    private int id_cliente;
    private boolean aceptado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaAceptado ;
    private LocalDateTime fechaEntrega ;
    //Map<Producto,Integer>
    public Pedido(int[] id_p_c,int[]ct,int precio ,int id_cliente) {
        this.id = idct;
        this.id_p_c = id_p_c;
        this.id_p_a = new int[0];
        this.precio = precio;
        this.id_cliente = id_cliente;
        //this.aceptado = false;
        //this.fechaInicio = LocalDateTime.now();
        //this.fechaAceptado = null;
        idct++;
    }
    public Pedido(int id, int[] id_p_c,int[]ct,int precio ,int id_cliente) {
        this.id = id;
        this.id_p_c = id_p_c;
        this.ct = ct;
        this.precio = precio;
        this.id_cliente = id_cliente;
        //this.aceptado = false;
        //this.fechaInicio = LocalDateTime.now();
        //this.fechaAceptado = null;

    }

    public Pedido() {

    }

    public static List<Pedido> get_pedidos() {
        return pedidos;
    }

    public void add_pedido(int id ,int[] id_p_c,int[] ct,int p , int id_cliente){
            pedidos.add(new Pedido(id,id_p_c, ct,p, id_cliente));
    }

    public int getId() {
        return id;
    }

    public int[] getId_p_c() {
        return id_p_c;
    }

    public int[] getCt() {
        return ct;
    }

    public int getPrecio() {
        return precio;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", id_p_c=" + Arrays.toString(id_p_c) +
                ", ct=" + Arrays.toString(ct) +
                ", id_p_a=" + Arrays.toString(id_p_a) +
                ", id_cliente=" + id_cliente +
                ", aceptado=" + aceptado +
                ", fecha='" + fechaInicio + '\'' +
                ", fecha='" + fechaAceptado + '\'' +
                ",precio=" + precio+
                '}';
    }
    public static void ordenarPorFecha(List<Pedido> pedidos) {
        Collections.sort(pedidos, new Comparator<Pedido>() {
            @Override
            public int compare(Pedido p1, Pedido p2) {
                return p1.getFechaHora().toLocalDate().compareTo(p2.getFechaHora().toLocalDate());
            }
        });
    }

    private OffsetDateTime getFechaHora() {
        return fechaInicio.atOffset(OffsetDateTime.now().getOffset());
    }


    public void add_pedido(int anInt, Array array, Array array1, int anInt1, int anInt2) {
    }
}


