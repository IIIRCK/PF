import java.util.ArrayList;
import java.util.List;

public class Registro {
    private  static List<Registro> registro = new ArrayList<>();
    private enum tipo{
        venta,
        compra,

    }
    private int idct = 1 ;
    private int id = idct;
    private int[] id_productos;

    private Cliente cliente;
    private String fecha;

    public Registro( int[] id_productos, String fecha) {
        this.id_productos = id_productos;
        this.fecha = fecha;
        idct++;

    }
    public Registro( Cliente cliente, int[] id_productos, String fecha) {
        this.cliente = cliente;
        this.id_productos = id_productos;
        this.fecha = fecha;
        idct++;
    }

}
